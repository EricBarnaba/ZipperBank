package io.zipcoder.Enums;

public enum AccountType {
    SAVINGS("Savings"),
    CHECKING("Checking"),
    CREDIT("Credit");

    private String name;

    AccountType(String name){
        this.name = name;
    }
}
