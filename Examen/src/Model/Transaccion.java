package Model;

import java.sql.Timestamp;

public class Transaccion {
    private int id, id_cuenta;
    private String tipo, referencia, estado;
    private double monto, saldo_anterior, saldo_nuevo;
    private Timestamp fecha;

    public Transaccion(int id, int id_cuenta, String tipo, String referencia, String estado, double monto, double saldo_anterior, double saldo_nuevo, Timestamp fecha) {
        this.id = id;
        this.id_cuenta = id_cuenta;
        this.tipo = tipo;
        this.referencia = referencia;
        this.estado = estado;
        this.monto = monto;
        this.saldo_anterior = saldo_anterior;
        this.saldo_nuevo = saldo_nuevo;
        this.fecha = fecha;
    }

    public Transaccion(int id_cuenta, String tipo, String referencia, String estado, double monto, double saldo_anterior, double saldo_nuevo, Timestamp fecha) {
        this.id_cuenta = id_cuenta;
        this.tipo = tipo;
        this.referencia = referencia;
        this.estado = estado;
        this.monto = monto;
        this.saldo_anterior = saldo_anterior;
        this.saldo_nuevo = saldo_nuevo;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setSaldo_anterior(double saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    public double getSaldo_nuevo() {
        return saldo_nuevo;
    }

    public void setSaldo_nuevo(double saldo_nuevo) {
        this.saldo_nuevo = saldo_nuevo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
