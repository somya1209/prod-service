package com.tgt.igniteplus.productservice.repository;

import com.tgt.igniteplus.productservice.entity.CategoryEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CassandraRepository<CategoryEntity,String> {
}
