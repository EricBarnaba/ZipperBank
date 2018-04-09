package io.zipcoder.Enums;

public enum Status {
    PENDING("Pending"),
    CANCELLED("Cancelled"),
    COMPLETED("Completed"),
    RECURRING("Recurring");

    private String name;

    Status(String name){
        this.name = name;
    }
}
