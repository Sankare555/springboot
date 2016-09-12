package hello.service;

import hello.Application;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sankarge on 11-Aug-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class PersonServiceImplTest {

    @Autowired
    private PersonService personService;

    @Test
    public void testList() {
        Assert.assertTrue(personService.list().size() > 0);
    }

}