package com.nft.marketplace.Controller;


import com.nft.marketplace.DTO.SaveAccountRequest;
import com.nft.marketplace.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/account")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AccountController {

    private final AccountService accountService;


    @PostMapping("save_account")
    public ResponseEntity<?> createNFT(@RequestBody SaveAccountRequest saveAccountRequest) throws Exception {

        return ResponseEntity.ok(accountService.saveAccount(saveAccountRequest));

    }

}
