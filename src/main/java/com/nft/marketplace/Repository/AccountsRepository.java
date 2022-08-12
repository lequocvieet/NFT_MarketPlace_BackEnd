package com.nft.marketplace.Repository;

import com.nft.marketplace.Entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
 Accounts findByid(long id);
 Optional<Accounts> findAccountsByAddress(String address);


}