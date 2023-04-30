package pe.edu.upao.books.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "favorite_books")

public class FavoriteBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public FavoriteBook(LocalDateTime createdAt, LocalDateTime updatedAt, Book book, User user) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.book = book;
        this.user = user;
    }
}
