package pe.edu.upao.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.books.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
