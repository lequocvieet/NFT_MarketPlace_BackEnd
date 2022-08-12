package com.nft.marketplace.Repository;

import com.nft.marketplace.Entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    List<Transactions> findByItemId(Long itemId);

}