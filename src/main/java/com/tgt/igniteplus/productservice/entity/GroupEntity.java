package com.tgt.igniteplus.productservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


import java.util.*;

@Table(value = "group_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupEntity {


    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();
    private String imageUrl;
    private String name;
    private List<CategoryEntity> categories=new ArrayList<>();

}