package com.company;

import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    @Test
    public void isCurrentMember() {

        Instant now = Instant.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("YYYYMMdd").withZone(ZoneId.systemDefault());

        int daysSincePayment370 = Integer.parseInt(formatter.format(now.minus(370, ChronoUnit.DAYS)));
        int today = Integer.parseInt(formatter.format(now));
        int daysSincePayment1320 = Integer.parseInt(formatter.format(now.minus(1320, ChronoUnit.DAYS)));
        int daysSincePayment183 = Integer.parseInt(formatter.format(now.minus(183, ChronoUnit.DAYS)));

        Customer c1 = new Customer("0000000000", "Foo Bar", daysSincePayment370);
        Customer c2 = new Customer("0000000000", "Foo Bar", today);
        Customer c3 = new Customer("0000000000", "Foo Bar", daysSincePayment1320);
        Customer c4 = new Customer("0000000000", "Foo Bar", daysSincePayment183);
        assertFalse(c1.isCurrentMember());
        assertTrue(c2.isCurrentMember());
        assertFalse(c3.isCurrentMember());
        assertTrue(c4.isCurrentMember());
    }

}