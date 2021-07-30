package io.github.anantharajuc.sbmwa.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.anantharajuc.sbmwa.domain.model.Address;
import io.github.anantharajuc.sbmwa.domain.model.Books;
import io.github.anantharajuc.sbmwa.domain.model.Movie;
import io.github.anantharajuc.sbmwa.domain.model.Person;
import io.github.anantharajuc.sbmwa.infra.exception.ResourceNotFoundException;
import io.github.anantharajuc.sbmwa.repository.AddressRepository;
import io.github.anantharajuc.sbmwa.repository.BooksRepository;
import io.github.anantharajuc.sbmwa.repository.MovieRepository;
import io.github.anantharajuc.sbmwa.repository.PersonRepository;
import io.github.anantharajuc.sbmwa.service.PersonService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PersonServiceImpl implements PersonService
{
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	BooksRepository booksRepository;
	
	public List<Person> getAllPersons() 
	{
		log.info("-----> getAllPersons service");
		
		return personRepository.findAll();
    }
	
	public Person getPersonById(Long id) 
	{
		log.info("-----> getPersonById service");
		
		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
    }
	
	public Person savePerson(Person person) 
	{
		log.info("-----> saveOrUpdate service"+person);

        return personRepository.save(person);
    }
	
	public ResponseEntity<?> delete(Long id) 
	{
		log.info("-----> delete service");
		
		Person person = personRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		
		personRepository.delete(person); 
		
		return ResponseEntity
				.ok()
				.build();
    }

	@Override
	public Person updatePerson(Long id, Person personDetails) 
	{
		log.info("-----> updatePerson service");
		
		Person person = personRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));
		
		person.setName(personDetails.getName());
		person.setEmail(personDetails.getEmail()); 
		person.setMobileNumber(personDetails.getMobileNumber()); 	
		
		Address address = addressRepository.findById(person.getAddress().getId())
				            .orElseThrow(() -> new ResourceNotFoundException("Address", "id", id));
		
		address.setCity(personDetails.getAddress().getCity());
		address.setZipcode(personDetails.getAddress().getZipcode());

		addressRepository.save(address);
		
		List<Books> booksNew = personDetails.getBooks();
			
		if(!booksNew.isEmpty())
		{
			log.info("-----> new books count : "+booksNew.size());
			
			for(int i = 0; i< booksNew.size();i++)
			{
				log.info("-----> book ID : "+booksNew.get(i).getId()+" -----> book title : "+booksNew.get(i).getTitle());
			}			
		}
		
		return personRepository.save(person);
	}

	@Override
	public List<Books> findPersonsBooks(Long id) 
	{
		log.info("-----> findPersonsBooks service");
		
		return booksRepository.getBooksByPersonId(id); 
	}

	@Override
	public List<Movie> findPersonMovies(Long id) 
	{
		log.info("-----> findPersonMovies service");
		
		return movieRepository.getMoviesByPersonId(id); 
	}

	@Override
	public Address findPersonsAddress(Long id) 
	{
		log.info("-----> findPersonsAddress service");

		return personRepository.getById(id).getAddress();
	}
}