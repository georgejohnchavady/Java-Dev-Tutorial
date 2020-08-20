package api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import api.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	
}
