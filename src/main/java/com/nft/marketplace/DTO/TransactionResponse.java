package com.nft.marketplace.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private Long id;
    private String event;
    private String fromAccount;
    private String toAccount;
    private String time;
    private Double currentPrice;
}
