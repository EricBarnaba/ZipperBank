package io.zipcoder.domain;


import io.zipcoder.Enums.DespostType;
import io.zipcoder.Enums.Medium;
import io.zipcoder.Enums.Status;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Deposit {

    @Id
    private long id;
    private DespostType type;
    private String transaction_date;
    private Status status;
    private long payee_id;
    private Medium medium;
    private double amount;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DespostType getType() {
        return type;
    }

    public void setType(DespostType type) {
        this.type = type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getPayee_id() {
        return payee_id;
    }

    public void setPayee_id(long payee_id) {
        this.payee_id = payee_id;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
