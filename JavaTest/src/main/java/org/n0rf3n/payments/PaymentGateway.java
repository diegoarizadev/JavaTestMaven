package org.n0rf3n.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
