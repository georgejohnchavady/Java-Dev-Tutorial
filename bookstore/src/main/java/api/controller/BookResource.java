package api.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.model.Book;
import api.repository.BookNotFoundException;
import api.repository.BookRepository;

@RestController
public class BookResource {
	
	@Autowired
	BookRepository repo;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
				
		List<Book> books= (List<Book>) repo.findAll();		
		
		return books;
	
	}
	@PostMapping("/books")
	  Book newEmployee(@RequestBody Book newBook) {
	    return repo.save(newBook);
	  }

	  // Single item

	  @GetMapping("/books/{id}")
	  Book getBookById(@PathVariable Long id) {
		System.out.println(repo.findById(id));
	    return repo.findById(id).orElseThrow(() -> new BookNotFoundException(id));
	  }

	  @PutMapping("/books/{id}")
	  Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
		
	    return repo.findById(id)
	      .map(book -> {
	        book.setName(newBook.getName());
	        book.setAuthor(newBook.getAuthor());
	        book.setPublishdate(newBook.getPublishdate());
	        return repo.save(book);
	      })
	      .orElseGet(() -> {
	        newBook.setId(id);
	        return repo.save(newBook);
	      });
	  }

	  @DeleteMapping("/books/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    repo.deleteById(id);
	  }
	
	
	
	

}
