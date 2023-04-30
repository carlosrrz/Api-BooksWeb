package pe.edu.upao.books.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.repositories.BookRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

        private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
            this.bookRepository = bookRepository;
        }
        @Override
        public Book createBook(String title, String author, String description, MultipartFile image) {
            Book book = new Book(title,author,description,"", LocalDateTime.now(), LocalDateTime.now());
            return bookRepository.save(book);
        }
        @Override
        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        @Override
        public Book getBookById(Long id) {
            return bookRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
                    "El libro con id "+id+" no se ha encontrado"
            ));
        }

        @Override
        public Book updateBook(Long id, String title, String author, String description, MultipartFile image) {
            Book book = getBookById(id);
            book.setTitle(title);
            book.setAuthor(author);
            book.setDescription(description);
            book.setImageUrl("");
            book.setUpdatedAt(LocalDateTime.now());
            return bookRepository.save(book);
        }

        @Override
        public void deleteBook(Long id) {
            bookRepository.delete(getBookById(id));
        }

    }
