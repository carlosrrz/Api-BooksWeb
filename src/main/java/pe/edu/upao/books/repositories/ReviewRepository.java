package pe.edu.upao.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.books.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
