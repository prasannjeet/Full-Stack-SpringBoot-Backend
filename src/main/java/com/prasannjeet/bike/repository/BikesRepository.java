package com.prasannjeet.bike.repository;

import com.prasannjeet.bike.models.Bike;
import com.prasannjeet.bike.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;

public interface BikesRepository extends MongoRepository<Bike, String> {
    public Bike findOneByPurchasePrice(BigDecimal purchasePrice);
    public Bike findOneByNameAndEmail(String name, String email);
    public Bike findOneByName(String name);
}
