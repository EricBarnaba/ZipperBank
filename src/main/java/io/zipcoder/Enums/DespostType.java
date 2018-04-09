package io.zipcoder.Enums;

public enum DespostType {
    P2P("P2P"),
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal");

    private String name;

    DespostType(String name){
        this.name = name;
    }
}
