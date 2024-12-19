package Model;

import java.sql.Timestamp;

public class Cuenta {
    private int id, id_cliente;
    private String tipo, estado;
    private double saldo, limite_saldo;
    private Timestamp fecha_apertura;

    public Cuenta(int id, int id_cliente, String tipo, String estado, double saldo, double limite_saldo, Timestamp fecha_apertura) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.tipo = tipo;
        this.estado = estado;
        this.saldo = saldo;
        this.limite_saldo = limite_saldo;
        this.fecha_apertura = fecha_apertura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite_saldo() {
        return limite_saldo;
    }

    public void setLimite_saldo(double limite_saldo) {
        this.limite_saldo = limite_saldo;
    }

    public Timestamp getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(Timestamp fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }
}
