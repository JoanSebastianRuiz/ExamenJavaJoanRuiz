package Utils.Validators;

import Model.Cliente;
import Repository.Implementation.ClienteImpl;

public class ValidacionesCliente {
    private static ClienteImpl clienteImpl = new ClienteImpl();
    public static boolean clienteActivo(String identificacion){
        Cliente cliente = clienteImpl.getCliente(identificacion);

        if(cliente==null || cliente.getEstado().equals("Inactivo")){
            System.out.println("Cliente invalido");
        }
        return  cliente!= null && cliente.getEstado().equals("Activo");
    }
}
