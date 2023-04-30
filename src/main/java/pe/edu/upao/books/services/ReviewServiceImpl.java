package pe.edu.upao.books.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upao.books.models.Book;
import pe.edu.upao.books.models.Review;
import pe.edu.upao.books.models.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, UserRepository userRepository, BookRepository bookRepository){
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Review createReview(String title, String comment, Integer rating, Long bookId, Long userId) {
        Book book = bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException(
                "Libro no encontrado"
        ));
        User user = userRepository.findById(userId).orElseThrow(()->new EntityNotFoundException(
                "Usuario no encontrado"
        ));
        Review review = new Review(title,comment,rating, LocalDateTime.now(),LocalDateTime.now(),book,user);
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, String title, String comment, Integer rating) {
        Review review = getReviewById(id);
        review.setTitle(title);
        review.setComment(comment);
        review.setRating(rating);
        review.setUpdatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }
    @Override
    public void deleteReview(Long id) {
        reviewRepository.delete(getReviewById(id));
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }


    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
                "La review con id "+id+" no se encontro."
        ));
    }
}
