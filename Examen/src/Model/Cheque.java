package Model;

import java.time.LocalDate;
import java.util.Date;
import java.sql.Timestamp;

public class Cheque {
    private int id, id_cuenta, cobrado;
    private String numero_cheque, beneficiario, monto_letras, prioridad, firma_digital, estado, razon_rechazo, usuario_modificacion;
    private double monto, cuenta_saldo_momento;
    private LocalDate fecha_emision;
    private Timestamp fecha_proceso, fecha_modificacion;


    public Cheque(int id, int id_cuenta, int cobrado, String numero_cheque, String beneficiario, String monto_letras, String prioridad, String firma_digital, String estado, String razon_rechazo, String usuario_modificacion, double monto, double cuenta_saldo_momento, LocalDate fecha_emision, Timestamp fecha_proceso, Timestamp fecha_modificacion) {
        this.id = id;
        this.id_cuenta = id_cuenta;
        this.cobrado = cobrado;
        this.numero_cheque = numero_cheque;
        this.beneficiario = beneficiario;
        this.monto_letras = monto_letras;
        this.prioridad = prioridad;
        this.firma_digital = firma_digital;
        this.estado = estado;
        this.razon_rechazo = razon_rechazo;
        this.usuario_modificacion = usuario_modificacion;
        this.monto = monto;
        this.cuenta_saldo_momento = cuenta_saldo_momento;
        this.fecha_emision = fecha_emision;
        this.fecha_proceso = fecha_proceso;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Cheque(int id_cuenta, int cobrado, String numero_cheque, String beneficiario, String monto_letras, String prioridad, String firma_digital, String estado, double monto, double cuenta_saldo_momento, LocalDate fecha_emision, Timestamp fecha_proceso) {
        this.id_cuenta = id_cuenta;
        this.cobrado = cobrado;
        this.numero_cheque = numero_cheque;
        this.beneficiario = beneficiario;
        this.monto_letras = monto_letras;
        this.prioridad = prioridad;
        this.firma_digital = firma_digital;
        this.estado = estado;
        this.monto = monto;
        this.cuenta_saldo_momento = cuenta_saldo_momento;
        this.fecha_emision = fecha_emision;
        this.fecha_proceso = fecha_proceso;
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

    public int getCobrado() {
        return cobrado;
    }

    public void setCobrado(int cobrado) {
        this.cobrado = cobrado;
    }

    public String getNumero_cheque() {
        return numero_cheque;
    }

    public void setNumero_cheque(String numero_cheque) {
        this.numero_cheque = numero_cheque;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getMonto_letras() {
        return monto_letras;
    }

    public void setMonto_letras(String monto_letras) {
        this.monto_letras = monto_letras;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getFirma_digital() {
        return firma_digital;
    }

    public void setFirma_digital(String firma_digital) {
        this.firma_digital = firma_digital;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRazon_rechazo() {
        return razon_rechazo;
    }

    public void setRazon_rechazo(String razon_rechazo) {
        this.razon_rechazo = razon_rechazo;
    }

    public String getUsuario_modificacion() {
        return usuario_modificacion;
    }

    public void setUsuario_modificacion(String usuario_modificacion) {
        this.usuario_modificacion = usuario_modificacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCuenta_saldo_momento() {
        return cuenta_saldo_momento;
    }

    public void setCuenta_saldo_momento(double cuenta_saldo_momento) {
        this.cuenta_saldo_momento = cuenta_saldo_momento;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Timestamp getFecha_proceso() {
        return fecha_proceso;
    }

    public void setFecha_proceso(Timestamp fecha_proceso) {
        this.fecha_proceso = fecha_proceso;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public void imprimirCheque(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("BANCO UNION S.A.");
        System.out.println("Cheque No: "+this.numero_cheque);
        System.out.println("Fecha: "+this.fecha_emision);
        System.out.println("");
        System.out.println("PAGUESE A: "+this.beneficiario);
        System.out.println("LA SUMA DE: "+this.monto_letras);
        System.out.println("");
        System.out.println("VALOR: $"+this.monto);
        System.out.println("FIRMA DIGITAL: "+this.firma_digital);
        System.out.println("-----------------------------------------------------------");
    }
}


