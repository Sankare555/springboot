package hello.service;

/**
 * Created by sankarge on 05-Aug-16.
 */

import hello.entity.Person;

import java.util.List;

public interface PersonService {

    void save(Person p);

    List<Person> list();

}