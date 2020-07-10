package com.tgt.igniteplus.productservice.entity;

import com.datastax.oss.driver.api.core.type.DataType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.*;


import java.util.Map;
import java.util.Set;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@UserDefinedType(value = "item")
public class ItemEntity {

    @PrimaryKey
    private String uuid = UUID.randomUUID().toString();
    private String imageUrl;
    private String group;
    private String category;
    private String brand;
    private String bookTitle;
    private String publisher;
    private String color;
    private Set<String> size;
    private Float price;
    private Boolean inStock;
    private Map<String,String> description;

}
