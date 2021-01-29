package anton.skipmeplz.employner.services;

import anton.skipmeplz.employner.entities.Person;
import anton.skipmeplz.employner.repositories.PersonRepository;
import anton.skipmeplz.employner.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public void createNewPerson(Person person) {
        personRepository.saveAndFlush(person);
    }


}
