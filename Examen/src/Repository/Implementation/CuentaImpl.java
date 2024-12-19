package Repository.Implementation;

import Model.Cuenta;
import Repository.DAO.CuentaDAO;
import Utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaImpl implements CuentaDAO {
    @Override
    public List<Cuenta> getCuentas() {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        String sql = "SELECT * FROM Cuentas;";

        try(Connection connection = Conexion.getConexion();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                cuentas.add(new Cuenta(rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("tipo"),
                        rs.getString("estado"),
                        rs.getDouble("saldo"),
                        rs.getDouble("limite_saldo"),
                        rs.getTimestamp("fecha_apertura")));
            }
            return cuentas;
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Cuenta getCuenta(int id) {
        String sql = "SELECT * FROM Cuentas WHERE id=?;";

        try(Connection connection = Conexion.getConexion();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return new Cuenta(rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getString("tipo"),
                        rs.getString("estado"),
                        rs.getDouble("saldo"),
                        rs.getDouble("limite_saldo"),
                        rs.getTimestamp("fecha_apertura"));
            } else{
                return null;
            }

        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean updateSaldoCuenta(Double saldo, int idCuenta) {
        String sql = "UPDATE `Cuentas` SET saldo=? WHERE id=?;";

        try(Connection connection = Conexion.getConexion();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setDouble(1, saldo);
            stmt.setInt(2, idCuenta);
            stmt.executeUpdate();

            return true;

        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
}
