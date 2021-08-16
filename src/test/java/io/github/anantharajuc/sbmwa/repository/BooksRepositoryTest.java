package io.github.anantharajuc.sbmwa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import io.github.anantharajuc.sbmwa.domain.model.Books;

import static org.assertj.core.api.BDDAssertions.*;

@DataJpaTest
public class BooksRepositoryTest 
{
	@Autowired
	private BooksRepository booksRepository;
	
	@Test
	void testGetBookByTitle_returnsBookDetails()
	{
		//given
		Books savedBook = booksRepository.save(new Books("test-title"));
		
		//when
		Books books = booksRepository.getBookByTitle("test-title");
		
		//then
		then(savedBook.getId()).isNotNull();
		then(books.getTitle()).isEqualTo(books.getTitle());
	}
}
