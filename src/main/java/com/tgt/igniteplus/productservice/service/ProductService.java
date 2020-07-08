package com.tgt.igniteplus.productservice.service;

import com.tgt.igniteplus.productservice.entity.ItemEntity;
import com.tgt.igniteplus.productservice.exception.ItemNotFoundException;
import com.tgt.igniteplus.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //getAllItems
    public List<ItemEntity> getAllItems(){
        return productRepository.findAll();
    }

    //create item
    public ItemEntity createItem(ItemEntity itemEntity){
        return productRepository.save(itemEntity);
    }

    //getItemEntityByID
    public Optional<ItemEntity> getItemById(int id) throws ItemNotFoundException {
        Optional<ItemEntity> item=productRepository.findById(id);
        if(!item.isPresent())
            throw new ItemNotFoundException("item not found");
        return item;
    }

    //updateUserById
    public ItemEntity updateItemById( int id,ItemEntity item)throws ItemNotFoundException{

        if(!productRepository.findById(id).isPresent()) {
            throw new ItemNotFoundException("employee not found");
        }
        return productRepository.save(item);

    }

    //deleteItemById
    public void deleteItemById(int id){
        Optional<ItemEntity> itemEntity=productRepository.findById(id);
        if(!itemEntity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"item not found in repo,enter correct details");
        }
        productRepository.deleteById(id);
    }

}
