package io.github.anantharajuc.sbmwa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.repository.BooksRepository;
import io.github.anantharajuc.sbmwa.service.BookService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BooksRepository booksRepository;
	
	@Override
	public List<Books> findAllBooks() 
	{
		log.info("-----> findAllBooks service");
		
		return booksRepository.findAll();
	}
}
