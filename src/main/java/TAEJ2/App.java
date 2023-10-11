package TAEJ2;

import Entity.Usuario;
import Service.CuentaService;
import Service.UsuarioService;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) {

        CuentaService cs = new CuentaService();
        UsuarioService us = new UsuarioService(cs);
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        us.crearAdmin();

        do {
            System.out.println("============================");
            System.out.println("========= WELCOME ==========");
            System.out.println("============================");
            System.out.println("Ingrese usuario");
            String user = leer.next();
            System.out.println("Ingrese Contraseña");
            String pass = leer.next();

            try {
                Usuario u = us.login(user, pass);

            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        } while ();


    }





}
