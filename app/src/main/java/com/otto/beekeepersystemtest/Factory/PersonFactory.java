package com.otto.beekeepersystemtest.Factory;

import com.otto.beekeepersystemtest.Domain.Person;

/**
 * Created by 212026992 on 6/3/2016.
 */
public class PersonFactory {
    public static Person create(String firstName, String lastName, String email){
        Person persons = new Person.Builder()
                .lastName(lastName)
                .firstName(firstName)
                .email(email)
                .build();
        return persons ;
    }
}
