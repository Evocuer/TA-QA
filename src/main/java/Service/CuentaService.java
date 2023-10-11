package Service;

import Entity.Cuenta;
import Entity.Usuario;

import java.util.HashMap;
import java.util.Map;

public class CuentaService {

    private Map<String, Cuenta> cuentaMap;

    public CuentaService() {
        this.cuentaMap = new HashMap<>();
    }

    public void crearCuenta(Usuario user) {

        Cuenta c = new Cuenta();
        user.getCuentas().add(c);
        cuentaMap.put(c.getIdCuenta(), c);
        System.out.println("Cuenta Nro " + c.getIdCuenta() + " creada exitosamente");

    }

    public void depositoCuenta(String idCuenta, Double monto) throws Exception {

        if(!cuentaMap.containsKey(idCuenta)) {
            throw new Exception("Cuenta destino no existe");
        }

        Cuenta cOut = cuentaMap.get(idCuenta);
        cOut.setBalance(cOut.getBalance()+monto);
        System.out.println("Transaccion exitosa");

    }

    public void retiroCuenta(Usuario user, String idCuenta, Double monto) throws Exception {

        for (Cuenta c : user.getCuentas()) {
            if (c.getIdCuenta().equals(idCuenta)){
               if (c.getBalance() < monto ) {
                   throw new Exception("Monto insuficiente para completar transaccion");
               }
               c.setBalance(c.getBalance()-monto);
               System.out.println("Transaccion exitosa");
               return;
            }
        }
        throw new Exception("Cuenta origen no existe");

    }

    public void transferCuenta(Usuario user, String cuentaOrigen, String cuentaDestino, Double monto) throws Exception {

        if(!cuentaMap.containsKey(cuentaDestino)) {
            throw new Exception("Cuenta destino no existe");
        }

        retiroCuenta(user, cuentaOrigen, monto);
        depositoCuenta(cuentaDestino, monto);

    }



}
