package io.github.anantharajuc.sbmwa.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.anantharajuc.sbmwa.domain.model.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, JpaSpecificationExecutor<Person>
{
	@Query(value = "SELECT * FROM person WHERE address_id = :address_id",nativeQuery = true) 
	@Transactional(readOnly=true)
	Person findPersonByAddressId(@Param("address_id") Long address_id);
}