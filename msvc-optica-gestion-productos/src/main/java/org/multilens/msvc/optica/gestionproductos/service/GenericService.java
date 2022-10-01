package org.multilens.msvc.optica.gestionproductos.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T>{
    List<T> findByLike(T t);

    Optional<T> findById(Long id);
}
