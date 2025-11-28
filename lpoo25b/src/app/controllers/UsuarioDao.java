package app.controllers;

import app.models.Usuario;

public interface UsuarioDao {
    public abstract Usuario validarUsuario(String login, String password);
}
