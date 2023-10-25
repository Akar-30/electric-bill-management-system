package models;

import java.sql.Date;

public class PaymentRecord {
    private int paymentID;      // Unique identifier for the payment record
    private int customerID;     // ID of the customer associated with this payment
    private Date paymentDate;   // Date of the payment
    private double amount;      // Payment amount
    private String paymentMethod; // Payment method (e.g., cash, check)
    private String proofCertificate; // Reference to a proof certificate (file path or link)
}
