package com.example.BondarHW7.service.impl;

import com.example.BondarHW7.model.Shop;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class ServiceImpl {

    private final ArrayList<Shop> shopCollection = new ArrayList<>();

    public Shop create(Shop shop) {
        int lastId = 0;
        if (shopCollection.size() > 0) {
            lastId = shopCollection.get(shopCollection.size() - 1).getId();
        }
        Shop newShop = new Shop(lastId + 1, shop.getCity(), shop.getStreet(), shop.getShopName(), shop.getAmountWorkers(), shop.isExistSite());
        shopCollection.add(newShop);
        return newShop;
    }

    public void delete(int id) {
        int position = getPositionShopById(id);
        if (position != -1) {
            shopCollection.remove(position);
        }
    }

    public ArrayList<Shop> getAll() {
        return shopCollection;
    }

    public Shop getById(int id) {
        int position = getPositionShopById(id);
        if (position != -1) return shopCollection.get(position);
        else return null;
    }

    public Shop update(int id, Shop newShop) {
        int position = getPositionShopById(id);
        Shop resultShop = new Shop(id, newShop.getCity(), newShop.getStreet(), newShop.getShopName(), newShop.getAmountWorkers(), newShop.isExistSite());
        shopCollection.set(position, resultShop);
        return resultShop;
    }

    private int getPositionShopById(int id) {
        int positionShop = -1;
        for (int i = 0; i < shopCollection.size(); i++) {
            if (shopCollection.get(i).getId() == id) {
                positionShop = i;
                break;
            }
        }
        return positionShop;
    }

}