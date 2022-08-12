package com.nft.marketplace.Service;


import com.nft.marketplace.DTO.SaveNFTRequest;


import com.nft.marketplace.Entity.Accounts;
import com.nft.marketplace.Entity.Item;
import com.nft.marketplace.Repository.AccountsRepository;
import com.nft.marketplace.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    private final AccountsRepository accountsRepository;

    public Long saveNFT(SaveNFTRequest saveNFTRequest) {
    //todo : check exist address
        Item item= new Item();
        item.setId(saveNFTRequest.getId());
        item.setName(saveNFTRequest.getNftName());
        item.setDescription(saveNFTRequest.getDescription());
        item.setImgUri(saveNFTRequest.getImageUri());
        item.setPaymentSymbol("ETH");
        item.setContractAddress(saveNFTRequest.getContractAddress());
        Optional<Accounts> owner=accountsRepository.findAccountsByAddress(saveNFTRequest.getOwner());
        item.setOwnerId(owner.get().getId());

        return itemRepository.save(item).getId();
  }



}
