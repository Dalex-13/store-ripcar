package com.api.repository;

import com.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //query Methods
    public List<Product> findByType(String type);

    //JPQL
    @Query("SELECT t.type FROM Product t")
    public List<String> findByName();


}
