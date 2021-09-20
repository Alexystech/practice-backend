package com.practice.slasher.repository;

import com.practice.slasher.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio el cual cumplirá con la función de ejecutar e
 * interpretar las instrucciones SQL de un CRUD.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
