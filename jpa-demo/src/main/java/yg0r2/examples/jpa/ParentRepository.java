package yg0r2.examples.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository<P extends Parent> extends JpaRepository<P, Long> {

}
