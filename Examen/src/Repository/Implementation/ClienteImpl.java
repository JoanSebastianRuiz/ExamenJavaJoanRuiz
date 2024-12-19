package Repository.Implementation;

import Repository.DAO.ClienteDAO;
import Model.Cliente;
import Utils.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteImpl implements ClienteDAO {

    @Override
    public Cliente getCliente(String identificacion) {
        String sql = "SELECT * FROM Clientes WHERE identificacion=?";

        try(Connection connection = Conexion.getConexion();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,identificacion);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                return new Cliente(
                        rs.getInt("id"),
                        rs.getString("identificacion"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("estado"),
                        rs.getTimestamp("fecha_registro"),
                        rs.getTimestamp("ultima_actividad"));
            }
            return null;
        } catch (SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
