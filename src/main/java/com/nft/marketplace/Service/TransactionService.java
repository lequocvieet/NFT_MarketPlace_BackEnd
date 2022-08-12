package com.nft.marketplace.Service;


import com.nft.marketplace.DTO.Response;
import com.nft.marketplace.DTO.SaveTransactionRequest;
import com.nft.marketplace.DTO.TransactionResponse;
import com.nft.marketplace.Entity.Accounts;
import com.nft.marketplace.Entity.Item;
import com.nft.marketplace.Entity.Transactions;
import com.nft.marketplace.Repository.AccountsRepository;
import com.nft.marketplace.Repository.ItemRepository;
import com.nft.marketplace.Repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionsRepository transactionsRepository;

    private final AccountsRepository accountsRepository;

    private final ItemRepository itemRepository;

    private Response response=new Response();



    public Response saveTransaction(SaveTransactionRequest saveTransactionRequest) {

        Transactions transaction= new Transactions();
        transaction.setCurrentPrice(saveTransactionRequest.getCurrentPrice());
        transaction.setTime(saveTransactionRequest.getTime());
        transaction.setItemId(saveTransactionRequest.getItemId());
        Optional<Accounts> fromAccount=accountsRepository.findAccountsByAddress(saveTransactionRequest.getFromAccount());
        transaction.setFromAccountId(fromAccount.get().getId());
        if(saveTransactionRequest.getEvent().equals("mint")){
            //in case mint event do not have receiver account
            transaction.setToAccountId(null);
            transaction.setEvent(saveTransactionRequest.getEvent());
            transactionsRepository.save(transaction);
            response.setResult(0,"Save transaction success");
            return  response;

        }
        Optional<Accounts> receiver=accountsRepository.findAccountsByAddress(saveTransactionRequest.getToAccount());
        if( saveTransactionRequest.getEvent().equals("buy") || saveTransactionRequest.getEvent().equals("gift") ){
            //if buy or gift event => update item's owner
            Optional<Item> item=itemRepository.findById(saveTransactionRequest.getItemId());
            if(!(receiver.isPresent())){
                //in case gift to an address that not in database
                Accounts newReceiver= new Accounts();
                newReceiver.setUserName(null);
                newReceiver.setAddress(saveTransactionRequest.getToAccount());
                accountsRepository.save(newReceiver);
                receiver=accountsRepository.findAccountsByAddress(saveTransactionRequest.getToAccount());
            }
            item.get().setOwnerId(receiver.get().getId());
            itemRepository.save(item.get());
        }
        transaction.setEvent(saveTransactionRequest.getEvent());
        transaction.setToAccountId(receiver.get().getId());
        transactionsRepository.save(transaction);
        response.setResult(0,"Save transaction success");
        return  response;
    }


    public List<TransactionResponse> findByItemId(Long itemId){
        List<Transactions> transactions=transactionsRepository.findByItemId(itemId);
        List<TransactionResponse> transactionResponses=new ArrayList<>();
        for(int i=0;i<transactions.size();i++){
            TransactionResponse transactionResponse=new TransactionResponse();
            transactionResponse.setEvent(transactions.get(i).getEvent());
            transactionResponse.setId(transactions.get(i).getId());
            transactionResponse.setTime(transactions.get(i).getTime());
            transactionResponse.setCurrentPrice(transactions.get(i).getCurrentPrice());
            Accounts fromAccount=accountsRepository.findByid(transactions.get(i).getFromAccountId());
            transactionResponse.setFromAccount(fromAccount.getAddress());
            if(transactions.get(i).getToAccountId()==null){
                // in case mint event
                transactionResponse.setToAccount(null);
            }
            else {
                Accounts toAccount=accountsRepository.findByid(transactions.get(i).getToAccountId());
                transactionResponse.setToAccount(toAccount.getAddress());
            }

         transactionResponses.add(transactionResponse);
        }
        return  transactionResponses;
    }
}
