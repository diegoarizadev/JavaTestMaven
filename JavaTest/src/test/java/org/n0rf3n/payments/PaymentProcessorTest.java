package org.n0rf3n.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {

    private PaymentGateway pg;
    private PaymentProcessor paymentProcessor;

    @Before //con esta etiqueta se le indica a Junit que debe ejecutar este metodo antes de cada test
    public void setup(){
         pg = Mockito.mock(PaymentGateway.class); //Se simula la clase.
         paymentProcessor = new PaymentProcessor(pg);
    }

    @Test
    public void payment_is_correct(){

        Mockito.when(this.pg.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));
        boolean resul = paymentProcessor.makePayment(1000);
        assertTrue(resul);

    }

    @Test
    public void payment_is_wrong(){

        Mockito.when(this.pg.requestPayment(Mockito.any())).thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));
        assertFalse(paymentProcessor.makePayment(1000));

    }

}