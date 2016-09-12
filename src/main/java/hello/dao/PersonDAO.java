package hello.dao;

/**
 * Created by sankarge on 05-Aug-16.
 */

import hello.entity.Person;

import java.util.List;

public interface PersonDAO {

    void save(Person p);

    List<Person> list();

}