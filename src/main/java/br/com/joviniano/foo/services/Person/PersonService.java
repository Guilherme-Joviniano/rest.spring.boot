package br.com.joviniano.foo.services.Person;

import br.com.joviniano.foo.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    // Simulate an db id

    public Person create(Person person){
        return person;
    }

    public Person update(Person person){
        return person;
    }

    public Person delete(String id) {
        // delete in the DB
        // Simulate something here
        Person person = findById(id);
        return person;
    }
    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Guilherme");
        person.setLastName("Joviniano");
        person.setAddress("Rua São Pedro n°146 Osasco São Paulo Brasil");
        person.setGender("Male");
        return person;
    }
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; ++i) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Person lastname" + i);
        person.setAddress("Person address" + i);
        person.setGender("Person genre" + i);
        return person;
    }


}
