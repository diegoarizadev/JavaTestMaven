package org.n0rf3n.payments;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {

    @Test
    public void payment_is_correct(){
        PaymentGateway pg = Mockito.mock(PaymentGateway.class); //Se simula la clase.

        Mockito.when(pg.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        PaymentProcessor paymentProcessor = new PaymentProcessor(pg);

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_wrong(){
        PaymentGateway pg = Mockito.mock(PaymentGateway.class);

        Mockito.when(pg.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        PaymentProcessor paymentProcessor = new PaymentProcessor(pg);

        assertFalse(paymentProcessor.makePayment(1000));
    }

}