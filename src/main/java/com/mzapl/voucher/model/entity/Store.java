package com.mzapl.voucher.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Store {

    public Store(){}

        public Store(String store_id, String name) {
        this.store_id = store_id;
        this.name = name;
    }

    public Store(String store_id, String name, String adress) {
        this.store_id = store_id;
        this.name = name;
        this.adress = adress;
    }

    @Id
    private String store_id;
    private String name;
    private String adress;

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
//    private List<Voucher> vouchers = new ArrayList<>();

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
