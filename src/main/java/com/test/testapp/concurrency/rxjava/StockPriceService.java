package com.test.testapp.concurrency.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class StockPriceService {
    private static final Logger log = LogManager.getLogger(StockPriceService.class);

    public StockPrice traditionalStockPrice(final String code) throws InterruptedException {
        log.error("Getting stock price for {}", code);
        sleep(Duration.ofSeconds(1).toMillis());
        return StockPrice.builder()
                .code(code)
                .price(584)
                .build();
    }

    public Flowable<StockPrice> rxStockPrice(final String code) {
        return Flowable
                .fromCallable(() -> traditionalStockPrice(code));
    }

    public Flowable<StockPrice> rxStockPriceAsync(final String code) {
        return Flowable
                .fromCallable(() -> traditionalStockPrice(code))
                .subscribeOn(scheduler(2));
    }

    private Scheduler scheduler(int n) {
        return Schedulers.from(Executors.newFixedThreadPool(n));
    }
}
