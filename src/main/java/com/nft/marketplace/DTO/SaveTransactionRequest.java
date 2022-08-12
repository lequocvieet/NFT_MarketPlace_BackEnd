package com.nft.marketplace.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveTransactionRequest {
    private String event;
    private String fromAccount;
    private String toAccount;
    private String time;
    private Double currentPrice;
    private Long itemId;

}
