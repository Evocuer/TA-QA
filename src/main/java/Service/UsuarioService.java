package Service;

import Entity.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    ArrayList <Usuario> userList = new ArrayList();

    public void crearAdmin() {

        Usuario ua = new Usuario("admin", "admin1234", true);
        userList.add(ua);

    }

    public void crearUsuario(String user, String password) {

        Usuario u = new Usuario(user, password, false);
        userList.add(u);
        System.out.println("Usuario creado correctamente");
    }

    public Usuario login (String user, String password) {

        for (Usuario aux: userList) {
            aux.
        }


    }

}
