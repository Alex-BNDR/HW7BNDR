package com.example.BondarHW7.rest;


import com.example.BondarHW7.model.Shop;
import com.example.BondarHW7.service.impl.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import java.util.ArrayList;

@RestController
public class Controller {

    @Autowired
    private ServiceImpl serviceImpl;

    public Controller(ServiceImpl serviceImpl) {
        this.serviceImpl = serviceImpl;
    }

    @GetMapping("/getShop/{shopId}")
    public ResponseEntity getShopById(@PathVariable int shopId) {
        Shop resShop = serviceImpl.getById(shopId);
        if (resShop == null) {
            return ResponseEntity.status(HttpStatus.valueOf(404)).body("Shop with this Id doesn't exist");
        }
        return new ResponseEntity<>(resShop, HttpStatus.OK);
    }

    @GetMapping("/deleteShop/{shopId}")
    public String deleteShopById(@PathVariable int shopId) {
        serviceImpl.delete(shopId);
        return "Shop was deleted";
    }

    @GetMapping("/allShops")
    public ArrayList<Shop> getAllShop() {
        return serviceImpl.getAll();
    }

    @PostMapping(value = "/modifyShop/{shopId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop modifyShop(@PathVariable int shopId, @RequestBody Shop shop) {
        return serviceImpl.update(shopId, shop);
    }

    @PostMapping(value = "/addShop", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
        return new ResponseEntity<>(serviceImpl.create(shop), HttpStatus.valueOf(201));
    }
}