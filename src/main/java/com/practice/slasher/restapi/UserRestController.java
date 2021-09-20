package com.practice.slasher.restapi;

import com.practice.slasher.model.User;
import com.practice.slasher.service.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest controller que nos da una capa en la cual podemos
 * únicamente ejecutar y tratar el happy case del consumo de
 * los diferentes EndPoints gracias al desacoplamiento de código
 * en el nivel de servicio.
 */
@RestController
@RequestMapping(path = "/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user),
                HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{clave}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "clave") int clave) {
        userService.deleteUserByClave(clave);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user),
                HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "successful"),
            @ApiResponse(code = 404, message = "user was not found")
    })
    @GetMapping(path = "/get/{clave}")
    public ResponseEntity<User> getUserByClave(@PathVariable(value = "clave") int clave) {
        User user = userService.getUserByClave(clave);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
