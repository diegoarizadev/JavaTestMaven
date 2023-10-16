package org.n0rf3n.Utils;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class DateUtilLeapYearShould {

    @Test
    public void return_true_when_is_divisible_by_400(){

        assertThat(DateUtil.isLeapYear(1600), CoreMatchers.is(true));
        assertThat(DateUtil.isLeapYear(2000), CoreMatchers.is(true));
        assertThat(DateUtil.isLeapYear(2400), CoreMatchers.is(true));

    }
    @Test
    public void return_true_when_is_divisible_by_100_but_not_by_400(){
        assertThat(DateUtil.isLeapYear(1700), CoreMatchers.is(false));
        assertThat(DateUtil.isLeapYear(1800), CoreMatchers.is(false));
        assertThat(DateUtil.isLeapYear(1900), CoreMatchers.is(false));

    }

    @Test
    public void return_true_when_is_divisible_by_4_but_not_by_100(){
        assertThat(DateUtil.isLeapYear(1996), CoreMatchers.is(true));
        assertThat(DateUtil.isLeapYear(2004), CoreMatchers.is(true));
        assertThat(DateUtil.isLeapYear(2008), CoreMatchers.is(true));

    }

    @Test
    public void return_true_when_is_not_divisible_4(){
        assertThat(DateUtil.isLeapYear(2017), CoreMatchers.is(false));
        assertThat(DateUtil.isLeapYear(2018), CoreMatchers.is(false));
        assertThat(DateUtil.isLeapYear(2019), CoreMatchers.is(false));

    }
}