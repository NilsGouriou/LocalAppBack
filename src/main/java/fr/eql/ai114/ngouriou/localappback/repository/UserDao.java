package fr.eql.ai114.ngouriou.localappback.repository;

import fr.eql.ai114.ngouriou.localappback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    User findById(long id);
    User findByLogin(String login);
    @Query("SELECT o FROM User o WHERE o.id != :id")
    List<User> findAllButSelf(@Param("id") long id);
}
