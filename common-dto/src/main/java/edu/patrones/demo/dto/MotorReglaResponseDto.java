package edu.patrones.demo.dto;

public class MotorReglaResponseDto {
    private String numeroSolicitud;
    private long valorAprobado;
    private int codeRespuesta;
    private String mensajeS;
    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }
    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }
    public long getValorAprobado() {
        return valorAprobado;
    }
    public void setValorAprobado(long valorAprobado) {
        this.valorAprobado = valorAprobado;
    }
    public int getCodeRespuesta() {
        return codeRespuesta;
    }
    public void setCodeRespuesta(int codeRespuesta) {
        this.codeRespuesta = codeRespuesta;
    }
    public String getMensajeS() {
        return mensajeS;
    }
    public void setMensajeS(String mensajeS) {
        this.mensajeS = mensajeS;
    }
}
