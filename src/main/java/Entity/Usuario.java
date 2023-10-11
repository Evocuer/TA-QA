package Entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Usuario {
    private String username;
    private Boolean tipo;
    private List<Cuenta> cuentas;

    public Usuario() {
    }

    public Usuario(String username, Boolean tipo) {
        this.username = username;
        this.tipo = tipo; //True: admin / false: regular user
        this.cuentas = new ArrayList<>();
    }


}
