

import Model.Cheque;
import Model.Cliente;
import Model.Cuenta;
import Model.Transaccion;
import Repository.Implementation.ChequeImpl;
import Repository.Implementation.ClienteImpl;
import Repository.Implementation.CuentaImpl;
import Repository.Implementation.TransaccionImpl;
import Utils.Conexion;
import Utils.Validators.ValidacionesCliente;
import Utils.Validators.ValidacionesCuenta;
import Utils.Validators.ValidacionesNumero;
import Utils.Validators.ValidacionesTransaccion;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CuentaImpl cuentaImpl = new CuentaImpl();
        ClienteImpl clienteImpl = new ClienteImpl();
        TransaccionImpl transaccionImpl = new TransaccionImpl();
        ChequeImpl chequeImpl = new ChequeImpl();
        Cuenta cuenta;
        Cliente cliente;
        Cheque cheque;

        Conexion.setDatabase("banco_union");
        Conexion.setUser("campus2023");
        Conexion.setPassword("campus2023");
        Scanner scanner = new Scanner(System.in);

        menuPrincipal: while(true){
            System.out.println(
        """
        Bienvenido, seleccione la opcion que desea realizar:
        1. Realizar deposito
        2. Realizar retiro
        3. Emitir cheque
        4. Generar reporte cheques emitidos
        5. Salir
        """);
            String opcion= scanner.nextLine();

            while(true){
                if(opcion.equals("1")){
                    System.out.println("Ingrese la identificacion del cliente:");
                    String identificacion = scanner.nextLine();

                    if(!ValidacionesCliente.clienteActivo(identificacion)){
                        break;
                    };

                    cliente = clienteImpl.getCliente(identificacion);

                    System.out.println("Ingrese la cuenta del cliente:");
                    String idCuenta = scanner.nextLine();

                    if(!ValidacionesNumero.numeroValido(idCuenta)){
                        break;
                    }

                    if(!ValidacionesCuenta.cuentaActivaCliente(identificacion, cliente.getId())){
                        break;
                    }

                    cuenta = cuentaImpl.getCuenta(Integer.parseInt(idCuenta));

                    System.out.println("Ingrese el monto a depositar:");
                    String monto = scanner.nextLine();

                    if(!ValidacionesNumero.numeroValido(monto)){
                        break;
                    }

                    if(!ValidacionesTransaccion.depositoValido(cuenta.getId(), Double.parseDouble(monto))){
                        break;
                    }

                    System.out.println("Ingrese la referencia:");
                    String referencia = scanner.nextLine();

                    double saldo_anterior = cuenta.getSaldo();
                    double saldo_nuevo = cuenta.getSaldo()+Double.parseDouble(monto);


                    Transaccion transaccion = new Transaccion(cuenta.getId(),"Deposito",referencia,"Exitosa", Double.parseDouble(monto), saldo_anterior, saldo_nuevo,Timestamp.from(Instant.now()));
                    if(transaccionImpl.addTransaccion(transaccion)){
                        cuentaImpl.updateSaldoCuenta(saldo_nuevo, cuenta.getId());
                        System.out.println("Transaccion exitosa");
                    } else {
                        System.out.println("Transaccion erronea");
                    }

                    break;
                    
                    
                } else if (opcion.equals("2")) {
                    System.out.println("Ingrese la identificacion del cliente:");
                    String identificacion = scanner.nextLine();

                    if(!ValidacionesCliente.clienteActivo(identificacion)){
                        break;
                    };

                    cliente = clienteImpl.getCliente(identificacion);

                    System.out.println("Ingrese la cuenta del cliente:");
                    String idCuenta = scanner.nextLine();

                    if(!ValidacionesNumero.numeroValido(idCuenta)){
                        break;
                    }

                    if(!ValidacionesCuenta.cuentaActivaCliente(identificacion, cliente.getId())){
                        break;
                    }

                    cuenta = cuentaImpl.getCuenta(Integer.parseInt(idCuenta));

                    System.out.println("Ingrese el monto a depositar:");
                    String monto = scanner.nextLine();

                    if(!ValidacionesNumero.numeroValido(monto)){
                        break;
                    }

                    if(!ValidacionesTransaccion.retiroValido(cuenta.getId(), Double.parseDouble(monto))){
                        break;
                    }

                    System.out.println("Ingrese la referencia:");
                    String referencia = scanner.nextLine();

                    double saldo_anterior = cuenta.getSaldo();
                    double saldo_nuevo = cuenta.getSaldo()-Double.parseDouble(monto);


                    Transaccion transaccion = new Transaccion(cuenta.getId(),"Retiro",referencia,"Exitosa", Double.parseDouble(monto), saldo_anterior, saldo_nuevo,Timestamp.from(Instant.now()));
                    if(transaccionImpl.addTransaccion(transaccion)){
                        cuentaImpl.updateSaldoCuenta(saldo_nuevo, cuenta.getId());
                        System.out.println("Transaccion exitosa");
                    } else {
                        System.out.println("Transaccion erronea");
                    }

                    break;


                } else if (opcion.equals("3")) {

                    System.out.println("Ingrese la identificacion del cliente:");
                    String identificacion = scanner.nextLine();

                    if(!ValidacionesCliente.clienteActivo(identificacion)){
                        break;
                    };

                    cliente = clienteImpl.getCliente(identificacion);

                    System.out.println("Ingrese la cuenta del cliente:");
                    String idCuenta = scanner.nextLine();

                    if(!ValidacionesNumero.numeroValido(idCuenta)){
                        break;
                    }

                    if(!ValidacionesCuenta.cuentaActivaCliente(identificacion, cliente.getId())){
                        break;
                    }

                    cuenta = cuentaImpl.getCuenta(Integer.parseInt(idCuenta));

                    System.out.println("Ingrese el monto del cheque:");
                    String monto = scanner.nextLine();

                    if(!ValidacionesNumero.numeroValido(monto)){
                        break;
                    }

                    if(!ValidacionesTransaccion.retiroValido(cuenta.getId(), Double.parseDouble(monto))){
                        break;
                    }
                    System.out.println("Ingrese el monto en letras:");
                    String monto_letras = scanner.nextLine();

                    System.out.println("Ingrese el numero del cheque:");
                    String numero_cheque = scanner.nextLine();

                    System.out.println("Ingrese el nombre del beneficiario:");
                    String beneficiario = scanner.nextLine();

                    String prioridad="";

                    while (true){
                        System.out.println("Ingrese la prioridad(Alta, Media o Baja):");
                        prioridad = scanner.nextLine();

                        if(prioridad.equals("Alta") || prioridad.equals("Media") || prioridad.equals("Baja")){
                            break;
                        } else {
                            System.out.println("Prioridad invalida");
                        }
                    }

                    System.out.println("Ingrese la firma digital:");
                    String firma_digital = scanner.nextLine();


                    cheque = new Cheque(cuenta.getId(),0,numero_cheque, beneficiario, monto_letras, prioridad, firma_digital,"Procesado", Double.parseDouble(monto), cuenta.getSaldo(), LocalDate.now(), Timestamp.from(Instant.now()));
                    if(chequeImpl.addCheque(cheque)){
                        System.out.println("Cheque emitido correctamente");
                        cheque.imprimirCheque();
                    } else {
                        System.out.println("El cheque no pudo ser emitido");
                    }
                    break ;

                } else if (opcion.equals("4")) {
                    List<Map<String, Object>> cheques = chequeImpl.getInformacionCheques();

                    File file = new File("/home/camper/Descargas/ExamenJavaJoanRuiz/Examen/cheques_emitidos.txt");
                    try(FileWriter fileWriter = new FileWriter(file)){
                        for(Map<String, Object> chequeReporte: cheques){
                            fileWriter.write("-----------------------------------------------------------\n");
                            fileWriter.write("BANCO UNION S.A.\n");
                            fileWriter.write("Identificacion cliente emisor: "+chequeReporte.get("Identificacion")+"\n");
                            fileWriter.write("Cliente emisor: "+chequeReporte.get("Nombre")+" "+chequeReporte.get("Apellido")+"\n");
                            fileWriter.write("Beneficiario: "+chequeReporte.get("Beneficiario")+"\n");
                            fileWriter.write("Monto: "+chequeReporte.get("Monto")+"\n");
                            fileWriter.write("Prioridad: "+chequeReporte.get("Prioridad")+"\n");
                            fileWriter.write("-----------------------------------------------------------"+"\n");
                            fileWriter.write("\n");
                        }
                        System.out.println("Reporte emitido correctamente");
                    } catch (Exception e){
                        System.out.println(e);
                    }
                    break ;
                }
                else if (opcion.equals("5")) {
                    break menuPrincipal;
                }
            }

        }
    }
}