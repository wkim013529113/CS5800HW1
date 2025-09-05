package com.example.payables;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A vendor invoice to be paid.
 */
public class VendorInvoice implements Payable {
    private String vendorName;
    private String invoiceNumber;
    private double amountDue;  // >= 0

    public VendorInvoice(String vendorName, String invoiceNumber, double amountDue) {
        this.vendorName = vendorName;
        this.invoiceNumber = invoiceNumber;
        setAmountDue(amountDue);
    }

    // Getters
    public String getVendorName()    { return vendorName; }
    public String getInvoiceNumber() { return invoiceNumber; }
    public double getAmountDue()     { return amountDue; }

    // Setters with validation
    public void setVendorName(String vendorName)       { this.vendorName = vendorName; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }
    public void setAmountDue(double amountDue) {
        if (amountDue < 0) throw new IllegalArgumentException("amountDue must be >= 0");
        this.amountDue = amountDue;
    }

    @Override
    public double calculatePayment() {
        return amountDue;
    }

    @Override
    public String getPayeeName() {
        return vendorName;
    }

    /** Prints the vendor name, invoice number, and calculated payment. */
    public void print() {
        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.printf("Vendor: %-22s | Invoice: %-10s | Payment: %s%n",
                vendorName, invoiceNumber, money.format(calculatePayment()));
    }
}
