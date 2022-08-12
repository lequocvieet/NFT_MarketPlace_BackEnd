package com.nft.marketplace.Repository;


import com.nft.marketplace.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}