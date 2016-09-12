package hello;

import hello.dao.PersonDAO;
import hello.entity.Person;
import hello.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    PersonService personService;

    @RequestMapping("/test")
    public List<Person> index() {
        System.out.println("HelloController");
        return getPersonList();
    }

    public List<Person> getPersonList() {
        Person person = new Person();
        person.setName("Messi");
        person.setCountry("India");

        List<Person> list = personService.list();
        for (Person p : list) {
            System.out.println("Person List::" + p);
        }
        return list;
    }

}