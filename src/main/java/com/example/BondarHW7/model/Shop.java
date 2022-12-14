package com.example.BondarHW7.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop {
    public Shop() {
    }

    public Shop(String city, String street, String shopName, int amountWorkers, boolean existSite) {
        this.city = city;
        this.street = street;
        this.shopName = shopName;
        this.amountWorkers = amountWorkers;
        this.existSite = existSite;
    }

    int id;
    String city;
    String street;
    String shopName;
    int amountWorkers;
    boolean existSite;

    public Shop(int id, String city, String street, String shopName, int amountWorkers, boolean existSite) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.shopName = shopName;
        this.amountWorkers = amountWorkers;
        this.existSite = existSite;
    }
}