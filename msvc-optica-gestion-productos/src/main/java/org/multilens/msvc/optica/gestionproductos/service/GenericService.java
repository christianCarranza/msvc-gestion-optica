package org.multilens.msvc.optica.gestionproductos.service.service;

import org.multilens.msvc.optica.gestionproductos.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GenericService<T>{
    List<T> findByLike(T t) throws ServiceException;

    Optional<T> findById(Long id) throws ServiceException;
}
