package com.tgt.igniteplus.productservice.controller;

import com.tgt.igniteplus.productservice.entity.ItemEntity;

import com.tgt.igniteplus.productservice.exception.ItemNotFoundException;
import com.tgt.igniteplus.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //getAllItems
    @GetMapping("/items")
    public List<ItemEntity> getAllItems(){
        return productService.getAllItems();

    }

    //create item
    @PostMapping("/items")
    public ItemEntity createItem(@RequestBody ItemEntity item){
        return productService.createItem(item);
    }

    //get item by id
    @GetMapping("/item/{id}")
    public Optional<ItemEntity> getItemBYId( @PathVariable("id") int id){
        try {
            return productService.getItemById(id);
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    //updateItemById
    @PutMapping("/item/{id}")
    public ItemEntity updateItemById(@PathVariable int id,@RequestBody ItemEntity item){
        try {
            return productService.updateItemById(id,item);
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //Item
    @DeleteMapping("/item/{id}")
    public void deleteItemById(@PathVariable("id") int id)throws ItemNotFoundException{
        productService.deleteItemById(id);
    }


}
