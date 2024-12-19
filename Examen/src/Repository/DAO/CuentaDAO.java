package Repository.DAO;

import Model.Cuenta;

import java.util.List;

public interface CuentaDAO {
    List<Cuenta> getCuentas();
    Cuenta getCuenta(int id);
    boolean updateSaldoCuenta(Double saldo, int idCuenta);
}
