package pe.edu.upao.books.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upao.books.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
