package com.nft.marketplace.Controller;


import com.nft.marketplace.DTO.SaveNFTRequest;
import com.nft.marketplace.DTO.Response;
import com.nft.marketplace.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/item")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ItemController {
    private final ItemService itemService;

    private Response response;

    @PostMapping("save_NFT")
    public ResponseEntity<?> saveNFT(@RequestBody SaveNFTRequest saveNFTRequest) throws Exception {
        return  ResponseEntity.ok( itemService.saveNFT(saveNFTRequest));

    }




}
