package yg0r2.examples.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository<C extends Child> extends JpaRepository<C, Long> {

}
