package com.otto.beekeepersystemtest.FactoryTest;

import com.otto.beekeepersystemtest.Domain.Person;
import com.otto.beekeepersystemtest.Factory.PersonFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 212026992 on 6/3/2016.
 */
public class PersonFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Person role = PersonFactory.create("Karl","Piet", "Karl@gmail.com");
        Assert.assertEquals(role.getFirstName(), "Karl");
    }

    @Test
    public void testUpdate() throws Exception {
        Person role = PersonFactory.create("Karl", "Otto", "Karl@gmail.com");
        Assert.assertEquals("Karl@gmail.com", role.getEmail());
        Person newBeekeeper = new Person
                .Builder()
                .copy(role)
                .email("piet@gmail.com")
                .build();
        Assert.assertEquals("piet@gmail.com", newBeekeeper.getEmail());


    }
}
