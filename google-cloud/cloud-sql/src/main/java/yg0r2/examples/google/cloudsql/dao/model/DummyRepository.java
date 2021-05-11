package yg0r2.examples.google.cloudsql.dao.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface DummyRepository extends CrudRepository<DummyEntity, Long> {

    Optional<DummyEntity> getEntityByName(String name);

}
