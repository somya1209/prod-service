package com.tgt.igniteplus.productservice.controller;

import com.tgt.igniteplus.productservice.entity.CategoryEntity;
import com.tgt.igniteplus.productservice.entity.GroupEntity;
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

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


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
    public Optional<ItemEntity> getItemBYId( @PathVariable("id") String id){
        try {
            return productService.getItemById(id);
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    //updateItemById
    @PutMapping("/item/{id}")
    public ItemEntity updateItemById(@PathVariable String id,@RequestBody ItemEntity item){
        try {
            return productService.updateItemById(id,item);
        } catch (ItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    //Item
    @DeleteMapping("/item/{id}")
    public void deleteItemById(@PathVariable("id") String id)throws ItemNotFoundException{
        productService.deleteItemById(id);
    }

    //**********************************************************************************************************

//    //getAll groups
//    @GetMapping("/group")
//    public List<GroupEntity> getAllGroups(){
//        return productService.getAllGroups();
//
//    }
//
//    //create group
//    @PostMapping("/group")
//    public GroupEntity createGroup(@RequestBody GroupEntity groupEntity){
//        return productService.createGroup(groupEntity);
//    }
//
//    //get groups by id
//    @GetMapping("/group/{id}")
//    public Optional<GroupEntity> getGroupBYId( @PathVariable("id") String id){
//        try {
//            return productService.getGroupById(id);
//        } catch (ItemNotFoundException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
//        }
//    }
//
//    //update group by id
//    @PutMapping("/group/{id}")
//    public GroupEntity updateGroupById(@PathVariable String id,@RequestBody GroupEntity groupEntity){
//        try {
//            return productService.updateGroupById(id,groupEntity);
//        } catch (ItemNotFoundException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
//        }
//    }
//
//    //delete group_category mapping by id
//    @DeleteMapping("group/{id}")
//    public void deleteGroupById(@PathVariable("id") String id)throws ItemNotFoundException{
//        productService.deleteGroupById(id);
//    }
//


}
