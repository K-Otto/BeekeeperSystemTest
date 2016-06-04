package com.otto.beekeepersystemtest.Service;

import com.otto.beekeepersystemtest.Domain.Person;

import java.util.Set;

/**
 * Created by 212026992 on 6/3/2016.
 */
public interface PersonService {



    Person addPerson(Person person);

    Person updatePerson(Person person);

    Person getPerson(Long personID);

    Set<Person> getAll();

    Person deletePerson(Person person);



}
