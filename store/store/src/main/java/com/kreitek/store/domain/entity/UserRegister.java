package com.kreitek.store.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "users")
public class UserRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String nick;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String apellidos;

    @Column(length = 9, nullable = false, unique = true)
    private Number telefono;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    public UserRegister(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Number getTelefono() {
        return telefono;
    }

    public void setTelefono(Number telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
