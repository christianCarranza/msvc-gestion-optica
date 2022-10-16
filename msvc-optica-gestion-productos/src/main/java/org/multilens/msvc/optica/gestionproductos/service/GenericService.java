package org.multilens.msvc.optica.gestionproductos.service;

import java.util.List;
import java.util.UUID;

public interface GenericService<T>{
    List<T> findAll();

    T findById(UUID id);

    T save(T t);

    T update(UUID id, T t);

    Boolean delete (UUID id, T t);
}
