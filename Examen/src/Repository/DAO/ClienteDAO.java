package Repository.DAO;

import Model.Cliente;

public interface ClienteDAO {
    Cliente getCliente(String documento);
}
