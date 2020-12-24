package yg0r2.examples.jpa.one_to_one.repository;

import org.springframework.stereotype.Repository;

import yg0r2.examples.jpa.one_to_one.model.ParentEntity;

@Repository
public interface ParentRepository extends yg0r2.examples.jpa.ParentRepository<ParentEntity> {

}
