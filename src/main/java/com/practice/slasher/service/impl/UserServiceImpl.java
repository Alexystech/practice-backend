package com.practice.slasher.service.impl;

import com.practice.slasher.model.User;
import com.practice.slasher.repository.UserRepository;
import com.practice.slasher.service.UserService;
import com.practice.slasher.service.exception.UserIsNullException;
import com.practice.slasher.service.exception.UserNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del {@link UserService} en cual trae
 * la capa de abstracción de un CRUD.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Crea un {@code User}, en caso de mandarse un usuario
     * null se retorna un {@link UserIsNullException}.
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {

        if ( user == null ) {
            throw UserIsNullException.of();
        }

        return userRepository.save(user);
    }

    /**
     * Elimina un {@code User} en caso de que la
     * clave sea menor a 1 se retorna un {@link UserIsNullException},
     * en caso de que no se encuentre el usuario se retorna un
     * {@link UserNotFoundException}.
     *
     * @see Try
     * @param clave
     */
    @Override
    public void deleteUserByClave(int clave) {

        if ( clave < 1 ) {
            throw UserIsNullException.of();
        }

        Try.of( () -> getUserByClave(clave) ).onFailure( (exception) -> {
            throw UserNotFoundException.of(clave);
        });

        userRepository.deleteById(clave);
    }

    /**
     * Actualiza un {@code User} en caso de mandarse un
     * usuario null se retorna un {@link UserIsNullException}.
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {

        if ( user == null ) {
            throw UserIsNullException.of();
        }

        return userRepository.save(user);
    }

    /**
     * Se busca un {@code User} por medio de la clave
     * pero en caso de que no se encuentre se retorna
     * un {@link UserNotFoundException}.
     * @param clave
     * @return
     */
    @Override
    public User getUserByClave(int clave) {
        return userRepository.findById(clave)
                .orElseThrow(() -> UserNotFoundException.of(clave));
    }

    /**
     * Se retorna una {@link List} de {@code User}.
     * @return
     */
    @Override
    public List<User> getAllUsers() {
        return ((List<User>) userRepository.findAll());
    }
}
