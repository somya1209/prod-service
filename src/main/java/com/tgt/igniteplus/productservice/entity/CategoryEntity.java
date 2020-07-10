package com.tgt.igniteplus.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@UserDefinedType(value = "category_item")
public class CategoryEntity {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();
    private String imageUrl;
    private String name;
    private List<ItemEntity> items;


}