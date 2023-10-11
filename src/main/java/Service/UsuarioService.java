package Service;

import Entity.Password;
import Entity.Usuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UsuarioService {
    CuentaService cs;
    Map<Usuario,Password> passwordMap;
    Map<String, Usuario> usuarioMap;

    public UsuarioService(CuentaService cs) {
        this.cs = cs;
        this.passwordMap = new HashMap<>();
        this.usuarioMap = new HashMap<>();
    }

    public void crearAdmin() {

        Usuario ua = new Usuario("admin", true);
        Password p = new Password("admin1234");
        usuarioMap.put(ua.getUsername(), ua);
        passwordMap.put(ua, p);

    }

    public void crearUsuario(String user, String password) {

        Usuario u = new Usuario(user,false);
        Password p = new Password(password);
        usuarioMap.put(u.getUsername(), u);
        passwordMap.put(u, p);
        System.out.println("Usuario creado correctamente");
        cs.crearCuenta(u);

    }

    public Usuario login(String user, String password) throws Exception {

        if(!usuarioMap.containsKey(user)) {
            throw new Exception("Usuario no existe");
        }

        Usuario us = usuarioMap.get(user);

        if (!Objects.equals(passwordMap.get(us), password)) {
            throw new Exception("Contraseña incorrecta");
        }
        return us;
    }

}
