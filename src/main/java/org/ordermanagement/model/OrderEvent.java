package org.ordermanagement.model;

public class OrderEvent {
    private String orderId;
    private String eventType; // e.g., "NEW", "PARTIAL_FILL", "FILLED", "CANCELLED", "REJECTED"
    private double leavesQty; // Remaining quantity after the event
    private double filledQty; // Quantity filled in this event
    private double cumQty; // Cumulative quantity filled so far


}
