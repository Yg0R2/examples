package yg0r2.examples.user.dao.repository;

import yg0r2.examples.user.dao.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Transactional
    Optional<UserEntity> findByUserName(String userName);

}
