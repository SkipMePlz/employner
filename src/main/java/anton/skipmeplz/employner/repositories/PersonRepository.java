package anton.skipmeplz.employner.repositories;

import anton.skipmeplz.employner.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person,Integer> {

}
