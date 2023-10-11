package Entity;

import lombok.Data;



@Data
public class Cuenta {

    private Usuario usuario;
    private String idCuenta;
    private Double balance;

    private static int ID1_CUENTA = 1000;
    private static int ID2_CUENTA = 0;

    public Cuenta() {
        this.idCuenta = genIdCuenta();
        this.balance = 0d;
    }

    public Cuenta(Usuario usuario) {
        this.usuario = usuario;
        this.idCuenta = genIdCuenta();
        this.balance = 0d;
    }

    public String genIdCuenta() {
        if (ID2_CUENTA == 99) {
            ID2_CUENTA = 0;
            ID1_CUENTA++;
        } else {
            ID2_CUENTA++;
        }

        return idCuenta = "%d-%02d".formatted(ID1_CUENTA, ID2_CUENTA);
    }


}
