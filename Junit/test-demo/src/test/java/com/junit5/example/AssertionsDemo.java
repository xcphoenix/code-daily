package com.junit5.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * @author      xuanc
 * @date        2019/8/24 上午9:11
 * @version     1.0
 */ 
public class AssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        // if assumption is false, throw TestAbortedException with (String)message.get
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    assertEquals(4, calculator.divide(4, 2));
                });
        assertEquals(42, calculator.multiply(6, 7));
    }

}
