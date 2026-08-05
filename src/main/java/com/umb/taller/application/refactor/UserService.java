package com.umb.taller.application.refactor;

public class UserService {
    public void createUser(String name, String email) {
        // lógica de creación de usuario
    }
    public boolean validateEmail(String email) {
        return email != null && email.contains("@");
    }
}