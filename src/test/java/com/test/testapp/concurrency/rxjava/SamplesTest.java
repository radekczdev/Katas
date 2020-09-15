package com.test.testapp.concurrency.rxjava;

import io.reactivex.rxjava3.core.Observable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

class SamplesTest {
    private static final Logger log = LogManager.getLogger(SamplesTest.class);

    @Test
    void shouldEmitSomeNumbers() {
        Observable
                .range(1,50)
                .filter(i -> i % 2 == 0)
                .map(i -> i * 10)
                .subscribe(i -> log.error(i.toString()));
    }

    @Test
    void shouldCreateOwnObservable() {
        Observable<Integer> myObservable = Observable.create(emitter -> {
            AtomicInteger counter = new AtomicInteger(100);
            while(true) {
                int current = counter.getAndIncrement();
                if(current > 200) {
                    emitter.onComplete();
                } else {
                    emitter.onNext(current);
                    sleep(Duration.ofMillis(100).toMillis());
                }
            }
        });

        myObservable
                .map(Object::toString)
                .subscribe(text -> log.error(text));
    }
}