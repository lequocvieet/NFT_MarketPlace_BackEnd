package com.nft.marketplace.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveNFTRequest {
    private long id;
    private String nftName;
    private String description;
    private String owner;
    private String contractAddress;
    private String imageUri;


}
