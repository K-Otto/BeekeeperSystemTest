package com.otto.beekeepersystemtest.Service.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.otto.beekeepersystemtest.Conf.Util.App;
import com.otto.beekeepersystemtest.Domain.Person;
import com.otto.beekeepersystemtest.Repository.Impl.PersonRepositoryImpl;
import com.otto.beekeepersystemtest.Repository.PersonRepository;
import com.otto.beekeepersystemtest.Service.PersonService;

import java.util.Set;

/**
 * Created by 212026992 on 6/3/2016.
 */
public class PersonServiceImpl extends Service implements PersonService {

    final private PersonRepository personRepository;

    private static PersonServiceImpl service = null;

    public static PersonServiceImpl getInstance() {
        if (service == null)
            service = new PersonServiceImpl();
        return service;
    }

    private final IBinder localBinder = new ActivateServiceLocalBinder();


    @Override
    public IBinder onBind(Intent intent) {
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public PersonServiceImpl getService() {
            return PersonServiceImpl.this;

        }

    }

    public PersonServiceImpl()
    {

        personRepository = new PersonRepositoryImpl(App.getAppContext());


    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.update(person);
    }

    @Override
    public Person getPerson(Long personID) {
        return personRepository.findById(personID);
    }

    @Override
    public Set<Person> getAll() {
        Set<Person> ram;
        ram = personRepository.findAll();
        return ram;
    }

    @Override
    public Person deletePerson(Person person) {
        return personRepository.delete(person);
    }


}