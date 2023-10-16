package org.n0rf3n.discounts;


import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.n0rf3n.payments.PaymentGateway;
import org.n0rf3n.payments.PaymentProcessor;

import static org.hamcrest.MatcherAssert.*;

public class PriceCalculatorShould {

    private PriceCalculator pc;

    @Before
    public void setup(){
        pc = new PriceCalculator();
    }

    @Test
    public void total_zero_when_there_are_prices(){

        assertThat(pc.getTotal(), CoreMatchers.is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices(){

        pc.addPrice(10.2);
        pc.addPrice(15.5);
        assertThat(pc.getTotal(), CoreMatchers.is(25.7));
    }


    @Test
    public void apply_discount_to_prices(){

        pc.addPrice(12.5);
        pc.addPrice(17.5);
        pc.setDiscount(50);
        assertThat(pc.getTotal(), CoreMatchers.is(15.0));
    }

}