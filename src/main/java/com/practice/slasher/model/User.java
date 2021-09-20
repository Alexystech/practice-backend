package com.practice.slasher.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Creación de un POJO en el que se definen los atributos
 * constructores, getters y setters.
 */
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;

    @Column(length = 20, nullable = false)
    private String nombre;

    @Column(length = 10)
    private String numero;

    @Column(length = 50, unique = true, nullable = false)
    private String correo;

    public User(String nombre, String numero, String correo) {
        super();
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
    }

}
