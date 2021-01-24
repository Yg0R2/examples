package yg0r2.examples.jpa.one_to_many.repository;

import org.springframework.stereotype.Repository;

import yg0r2.examples.jpa.one_to_many.model.ParentEntity;

@Repository
public interface ParentRepository extends yg0r2.examples.jpa.ParentRepository<ParentEntity> {

}
