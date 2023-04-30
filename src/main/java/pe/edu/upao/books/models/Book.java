package pe.edu.upao.books.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="books")
@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor


public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Column(name = "create_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
    public Book(String title, String author, String description, String imageUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

