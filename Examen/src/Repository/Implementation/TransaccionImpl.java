package Repository.Implementation;

import Model.Transaccion;
import Repository.DAO.TransaccionDAO;
import Utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransaccionImpl implements TransaccionDAO {

    @Override
    public boolean addTransaccion(Transaccion transaccion) {
        String sql =
                """
                INSERT INTO `Transacciones`(id_cuenta, tipo, monto, fecha, referencia, saldo_anterior, saldo_nuevo, estado)
                VALUES(?,?,?,?,?,?,?,?);
                """;

        try(Connection connection = Conexion.getConexion();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, transaccion.getId_cuenta());
            stmt.setString(2, transaccion.getTipo());
            stmt.setDouble(3, transaccion.getMonto());
            stmt.setTimestamp(4, transaccion.getFecha());
            stmt.setString(5,transaccion.getReferencia());
            stmt.setDouble(6,transaccion.getSaldo_anterior());
            stmt.setDouble(7, transaccion.getSaldo_nuevo());
            stmt.setString(8, transaccion.getEstado());
            stmt.executeUpdate();

            return true;
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
}
