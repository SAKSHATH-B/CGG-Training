package aap.demo.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import aap.demo.repo.PersonRepo;
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

	@Mock
	private PersonRepo personRepo;
	
	private PersonService personService;
	
	@BeforeEach
	public void setUp() {
		personService=new PersonService(personRepo);
	}
	
	@Test
	void testGetAllPerson() {
		personService.getAllPerson();
		verify(personRepo).findAll();
	}

}
