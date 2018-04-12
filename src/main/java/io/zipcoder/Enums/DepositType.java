package io.zipcoder.Enums;

public enum DepositType {
    P2P("P2P"),
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal");

    private String name;

    DepositType(String name){
        this.name = name;
    }
}
