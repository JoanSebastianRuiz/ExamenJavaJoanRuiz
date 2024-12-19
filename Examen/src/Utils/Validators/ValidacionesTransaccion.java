package Utils.Validators;

import Model.Cuenta;
import Repository.Implementation.CuentaImpl;

public class ValidacionesTransaccion {
    private static CuentaImpl cuentaImpl = new CuentaImpl();

    public static boolean depositoValido(int id, double monto){
        Cuenta cuenta = cuentaImpl.getCuenta(id);

        if(cuenta.getTipo().equals("Personal")){
            return cuenta.getSaldo() + monto <= cuenta.getLimite_saldo();
        } else if (cuenta.getTipo().equals("Empresarial")) {
            return true;
        }
        return false;
    }

    public static boolean retiroValido(int id, double monto){
        Cuenta cuenta = cuentaImpl.getCuenta(id);

        if(cuenta.getSaldo()<monto){
            System.out.println("Saldo insuficiente");
        }

        return cuenta.getSaldo()>=monto;
    }

}
