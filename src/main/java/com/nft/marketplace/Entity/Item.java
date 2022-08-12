package com.nft.marketplace.Entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "item", schema = "public", catalog = "tsdb")
public class Item {

    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "img_uri")
    private String imgUri;
    @Basic
    @Column(name = "owner_id")
    private Long ownerId;


    @Basic
    @Column(name = "contract_address")
    private String contractAddress;

    @Basic
    @Column(name = "payment_symbol")
    private String paymentSymbol;



}
