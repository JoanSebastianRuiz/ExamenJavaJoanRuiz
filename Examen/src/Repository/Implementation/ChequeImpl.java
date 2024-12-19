package Repository.Implementation;

import Model.Cheque;
import Repository.DAO.ChequeDAO;
import Utils.Conexion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChequeImpl implements ChequeDAO {
    @Override
    public boolean addCheque(Cheque cheque) {
        String sql =
                """
                INSERT INTO `Cheques`(numero_cheque, id_cuenta, beneficiario, monto, monto_letras, prioridad, firma_digital, estado, fecha_emision, fecha_proceso, cobrado, cuenta_saldo_momento)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try(Connection connection = Conexion.getConexion();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, cheque.getNumero_cheque());
            stmt.setInt(2, cheque.getId_cuenta());
            stmt.setString(3, cheque.getBeneficiario());
            stmt.setDouble(4, cheque.getMonto());
            stmt.setString(5, cheque.getMonto_letras());
            stmt.setString(6, cheque.getPrioridad());
            stmt.setString(7, cheque.getFirma_digital());
            stmt.setString(8, cheque.getEstado());
            stmt.setDate(9, Date.valueOf(LocalDate.now()));
            stmt.setTimestamp(10, cheque.getFecha_proceso());
            stmt.setInt(11, cheque.getCobrado());
            stmt.setDouble(12, cheque.getCuenta_saldo_momento());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public List<Map<String,Object>> getInformacionCheques() {
        List<Map<String,Object>> cheques = new ArrayList<>();
        String sql =
                """
                SELECT c.identificacion, c.nombre, c.apellido, ch.beneficiario, ch.monto, ch.prioridad \s
                FROM `Cheques` ch
                JOIN `Cuentas` cu ON cu.id=ch.id_cuenta
                JOIN `Clientes` c ON c.id=cu.id_cliente;
                """;

        try(Connection connection = Conexion.getConexion();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                Map<String, Object> cheque = new HashMap<>();
                cheque.put("Identificacion", rs.getString("identificacion"));
                cheque.put("Nombre", rs.getString("nombre"));
                cheque.put("Apellido", rs.getString("apellido"));
                cheque.put("Beneficiario", rs.getString("beneficiario"));
                cheque.put("Monto", rs.getDouble("monto"));
                cheque.put("Prioridad", rs.getString("prioridad"));
                cheques.add(cheque);
            }

            return cheques;

        } catch (SQLException e){
            System.out.println(e);
            return cheques;
        }
    }
}
