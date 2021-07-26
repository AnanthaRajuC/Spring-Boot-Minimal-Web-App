package io.github.anantharajuc.sbmwa.api.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.service.impl.BookServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="BookQueryController", description = "Set of public APIs, for querying Books.")
@RestController
@RequestMapping(value="/api")
public class BookQueryController 
{
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@GetMapping(value = "/book", produces = "application/json")
	public List<Books> getAllBooks()
	{
		return bookServiceImpl.findAllBooks();
	}
}
