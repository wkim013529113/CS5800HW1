package com.example.payables;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Driver program:
 * - builds a list of Payable (2+ freelancers, 2+ vendor invoices),
 * - calls each object's print(),
 * - sums total payout for the period and displays it.
 */
public class PayablesDriver {
    public static void main(String[] args) {
        List<Payable> payables = new ArrayList<>();

        // At least two Freelancers
        payables.add(new Freelancer("Alex", "Kim", 40.00, 38));
        payables.add(new Freelancer("Priya", "Singh", 55.00, 46)); // includes overtime

        // At least two VendorInvoices
        payables.add(new VendorInvoice("Acme Supplies", "INV-1027", 1299.99));
        payables.add(new VendorInvoice("Studio Lights Co.", "SL-5581", 450.00));

        double total = 0.0;
        for (Payable p : payables) {
            // Call each class's print() (requires instanceof & cast, since Payable has only 2 methods)
            if (p instanceof Freelancer f) {
                f.print();
            } else if (p instanceof VendorInvoice v) {
                v.print();
            }

            // Accumulate payout via the interface method
            total += p.calculatePayment();
        }

        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("---------------------------------------------------------");
        System.out.println("Total payout for the period: " + money.format(total));
    }
}
