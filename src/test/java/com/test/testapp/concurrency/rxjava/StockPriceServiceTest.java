package com.test.testapp.concurrency.rxjava;

import io.reactivex.rxjava3.core.Flowable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

class StockPriceServiceTest {
    private static final Logger log = LogManager.getLogger(StockPriceServiceTest.class);
    private final StockPriceService service = new StockPriceService();

    @Test
    void shouldGetStockPricesOneAfterAnother() {
        Flowable<StockPrice> amzn = service.rxStockPrice("AMZN");
        Flowable<StockPrice> nflx = service.rxStockPrice("NFLX");

        Flowable.merge(amzn, nflx)
                .subscribe(stockPrice -> log.error("Stock {} with price: {}", stockPrice.getCode(), stockPrice.getPrice()));
    }

    @Test
    void shouldGetStockPricesAsynchronically() throws InterruptedException {
        Flowable<StockPrice> amzn = service.rxStockPriceAsync("AMZN");
        Flowable<StockPrice> nflx = service.rxStockPriceAsync("NFLX");

        Flowable.merge(amzn, nflx)
                .subscribe(stockPrice -> log.error("Stock {} with price: {}", stockPrice.getCode(), stockPrice.getPrice()));

        sleep(Duration.ofSeconds(5).toMillis());
    }
}