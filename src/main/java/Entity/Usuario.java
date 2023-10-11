package Entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Usuario {
    private String username;
    private String password;
    private Boolean tipo;

    public Usuario() {
    }

    public Usuario(String username, String password, Boolean tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo; //True: admin / false: regular user
    }


}
