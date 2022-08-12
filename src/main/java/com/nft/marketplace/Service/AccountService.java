package com.nft.marketplace.Service;

import com.nft.marketplace.DTO.SaveAccountRequest;
import com.nft.marketplace.Entity.Accounts;
import com.nft.marketplace.Repository.AccountsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountsRepository accountsRepository;


    public long saveAccount(SaveAccountRequest saveAccountRequest) {
        Optional<Accounts> accounts=accountsRepository.findAccountsByAddress(saveAccountRequest.getAddress());
        if (accounts.isPresent()){
            return accounts.get().getId();
        }
        else{
            Accounts account =new Accounts();
            account.setAddress(saveAccountRequest.getAddress());
            account.setUserName(null);
            accountsRepository.save(account);
            return  accountsRepository.findAccountsByAddress(saveAccountRequest.getAddress()).get().getId();

        }

    }
}