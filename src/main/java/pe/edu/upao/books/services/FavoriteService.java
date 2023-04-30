package pe.edu.upao.books.services;

import org.springframework.stereotype.Service;
import pe.edu.upao.books.models.FavoriteBook;


@Service
public interface FavoriteService {
    FavoriteBook createFavorite(Long bookId, Long userId);
    void deleteFavoriteBook(Long id);
    FavoriteBook getFavoriteById(Long id);
}

