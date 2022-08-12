package com.nft.marketplace.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "transactions", schema = "public", catalog = "tsdb")
public class Transactions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "event")
    private String event;
    @Basic
    @Column(name = "from_account_id")
    private Long fromAccountId;
    @Basic
    @Column(name = "to_account_id")
    private Long toAccountId;
    @Basic
    @Column(name = "time")
    private String time;
    @Basic
    @Column(name = "current_price")
    private Double currentPrice;

    @Basic
    @Column(name = "item_id")
    private Long itemId;




}
