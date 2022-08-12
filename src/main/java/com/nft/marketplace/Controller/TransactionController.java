package com.nft.marketplace.Controller;


import com.nft.marketplace.DTO.SaveAccountRequest;
import com.nft.marketplace.DTO.SaveTransactionRequest;
import com.nft.marketplace.Service.AccountService;
import com.nft.marketplace.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/transaction")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TransactionController {

    private final TransactionService transactionService;


    @PostMapping("save_transaction")
    public ResponseEntity<?> saveTransaction(@RequestBody SaveTransactionRequest saveTransactionRequest) throws Exception {

        return ResponseEntity.ok(transactionService.saveTransaction(saveTransactionRequest));

    }

    @GetMapping("get_transaction")
    public ResponseEntity<?> getTransaction(@RequestParam Long itemId)  {

        return ResponseEntity.ok(transactionService.findByItemId(itemId));

    }



}
