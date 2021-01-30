package anton.skipmeplz.employner.services;

import anton.skipmeplz.employner.entities.Person;
import anton.skipmeplz.employner.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;
    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(int id){
        return personRepository.getOne(id);
    }

    public void deletePersonById(int id){
         personRepository.deleteById(id);
    }
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }

    public void createNewPerson(Person person) {

        personRepository.saveAndFlush(person);

    }


}
