package com.nft.marketplace.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "accounts", schema = "public", catalog = "tsdb")
public class Accounts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "address")
    private String address;




}
