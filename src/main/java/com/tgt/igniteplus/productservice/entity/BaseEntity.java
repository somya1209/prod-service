package com.tgt.igniteplus.productservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.UUID;

@Setter
@Getter
public class BaseEntity {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();
    private String imageUrl;
    private String name;

}
