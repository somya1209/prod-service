package com.tgt.igniteplus.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Map;
import java.util.Set;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @PrimaryKey
    private int id;
    private String group;
    private String category;
    private String brand;
    private String title;
    private String publisher;
    private Set<String> color;
    private Set<String> size;
    private Float price;
    private Boolean inStock;
    private String imageUrl;
    private Map<String,String> description;


}
