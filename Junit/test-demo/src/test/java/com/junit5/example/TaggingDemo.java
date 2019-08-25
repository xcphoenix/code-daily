package com.junit5.example;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author      xuanc
 * @date        2019/8/25 上午9:28
 * @version     1.0
 */
@Tag("fast")
@Tag("model")
public class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
    }

}
