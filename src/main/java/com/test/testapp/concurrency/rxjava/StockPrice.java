package com.test.testapp.concurrency.rxjava;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class StockPrice {
    private String code;
    private int price;

}
