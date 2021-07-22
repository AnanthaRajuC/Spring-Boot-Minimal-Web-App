package io.github.anantharajuc.sbmwa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.anantharajuc.sbmwa.domain.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
	
}