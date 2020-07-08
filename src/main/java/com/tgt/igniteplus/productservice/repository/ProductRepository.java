package com.tgt.igniteplus.productservice.repository;

import com.tgt.igniteplus.productservice.entity.ItemEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CassandraRepository<ItemEntity,Integer> {
}
