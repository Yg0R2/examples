package yg0r2.examples.jpa.one_to_many.repository;

import org.springframework.stereotype.Repository;

import yg0r2.examples.jpa.one_to_many.model.ChildEntity;

@Repository
public interface ChildRepository extends yg0r2.examples.jpa.ChildRepository<ChildEntity> {

}
