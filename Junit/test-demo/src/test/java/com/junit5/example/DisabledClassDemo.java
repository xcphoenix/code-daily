package com.junit5.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author      xuanc
 * @date        2019/8/24 上午9:49
 * @version     1.0
 */
@Disabled("Disabled until bug #99 has been fixed")
public class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
        fail("test will fail");
    }

    @Test
    void testWillBeExecuted() {
    }

}
