package com.mzapl.voucher.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Voucher {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long amount;
    private boolean active;
    public LocalDate activation_date;

    public Voucher(){}

    public Voucher(Long amount, boolean active) {
//        this.store = store;
        this.amount = amount;
        this.active = active;
        this.activation_date = LocalDate.now();
    }

    public void topUp(Long topUpAmount){
        this.amount = amount + topUpAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getactivation_date() {
        return activation_date;
    }

    public void setactivation_date(LocalDate activation_date) {
        this.activation_date = activation_date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
