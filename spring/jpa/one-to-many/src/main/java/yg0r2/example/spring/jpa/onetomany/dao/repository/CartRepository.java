package yg0r2.example.spring.jpa.onetomany.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yg0r2.example.spring.jpa.onetomany.dao.model.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
