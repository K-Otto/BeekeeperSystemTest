package com.otto.beekeepersystemtest.Repository;

import java.util.Set;

/**
 * Created by 212026992 on 6/3/2016.
 */
public interface Repository<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}

