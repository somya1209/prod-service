package com.tgt.igniteplus.productservice.repository;
import com.tgt.igniteplus.productservice.entity.GroupEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface GroupRepo extends CassandraRepository<GroupEntity,String> {
}
