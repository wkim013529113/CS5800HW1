package com.example.payables;

/**
 * Contract for anything that needs to be paid this period.
 */
public interface Payable {
    /** @return amount to be paid this period */
    double calculatePayment();

    /** @return the payee's display name (person or vendor) */
    String getPayeeName();
}
