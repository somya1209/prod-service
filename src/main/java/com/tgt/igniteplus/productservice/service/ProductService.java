package com.tgt.igniteplus.productservice.service;

import com.tgt.igniteplus.productservice.entity.CategoryEntity;
import com.tgt.igniteplus.productservice.entity.GroupEntity;
import com.tgt.igniteplus.productservice.entity.ItemEntity;
import com.tgt.igniteplus.productservice.exception.ItemNotFoundException;
import com.tgt.igniteplus.productservice.repository.CategoryRepo;
import com.tgt.igniteplus.productservice.repository.GroupRepo;
import com.tgt.igniteplus.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepo categoryRepo;
    private GroupRepo groupRepo;

    public ProductService(ProductRepository productRepository, CategoryRepo categoryRepo, GroupRepo groupRepo) {
        this.productRepository = productRepository;
        this.categoryRepo = categoryRepo;
        this.groupRepo = groupRepo;
    }

    //getAllItems
    public List<ItemEntity> getAllItems(){
        return productRepository.findAll();
    }

    //create item
    public ItemEntity createItem(ItemEntity itemEntity){
        return productRepository.save(itemEntity);
    }

    //getItemEntityByID
    public Optional<ItemEntity> getItemById(String id) throws ItemNotFoundException {
        Optional<ItemEntity> item=productRepository.findById(id);
        if(!item.isPresent())
            throw new ItemNotFoundException("item not found");
        return item;
    }

    //updateUserById
    public ItemEntity updateItemById( String id,ItemEntity item)throws ItemNotFoundException{

        if(!productRepository.findById(id).isPresent()) {
            throw new ItemNotFoundException("item not found");
        }
        return productRepository.save(item);

    }

    //deleteItemById
    public void deleteItemById(String id){
        Optional<ItemEntity> itemEntity=productRepository.findById(id);
        if(!itemEntity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"item not found in repo,enter correct details");
        }
        productRepository.deleteById(id);
    }

    //**********************************************************************************************************************************************

//    //getAll groups
//    public List<GroupEntity> getAllGroups(){
//        return groupRepo.findAll();
//    }

//    //create group
//    public GroupEntity createGroup(GroupEntity groupEntity){
//        return groupRepo.save(groupEntity);
//    }
//
//    //getItemEntityByID
//    public Optional<GroupEntity> getGroupById(String id) throws ItemNotFoundException {
//        Optional<GroupEntity> groupEntity=groupRepo.findById(id);
//        if(!groupEntity.isPresent())
//            throw new ItemNotFoundException("group not found");
//        return groupEntity;
//    }
//
//    //updateUserById
//    public GroupEntity updateGroupById( String id,GroupEntity groupEntity)throws ItemNotFoundException{
//        if(!groupRepo.findById(id).isPresent()) {
//            throw new ItemNotFoundException("group not found");
//        }
//        return groupRepo.save(groupEntity);
//    }
//
//    //deleteItemById
//    public void deleteGroupById(String id){
//        Optional<GroupEntity> groupEntity=groupRepo.findById(id);
//        if(!groupEntity.isPresent()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"group not found in repo,enter correct details");
//        }
//        groupRepo.deleteById(id);
//    }

}
