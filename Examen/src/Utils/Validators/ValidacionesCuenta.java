package Utils.Validators;

import Model.Cliente;
import Model.Cuenta;
import Repository.Implementation.ClienteImpl;
import Repository.Implementation.CuentaImpl;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ValidacionesCuenta {
    private static CuentaImpl cuentaImpl = new CuentaImpl();
    private static ClienteImpl clienteImpl = new ClienteImpl();
    public static boolean cuentaActivaCliente(String identificacion, int id){
        ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) cuentaImpl.getCuentas();
        Cliente cliente = clienteImpl.getCliente(identificacion);

        int cantidad =cuentas.stream().filter(cuenta -> cuenta.getId_cliente()==cliente.getId() && cuenta.getEstado().equals("Activa") && cuenta.getId()==id)
                .collect(Collectors.toList())
                .size();

        if(cantidad==0 ){
            System.out.println("Cuenta invalida");
        }
        return cantidad!=0;
    }
}
