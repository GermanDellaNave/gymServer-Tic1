package gym.gymServer.Classes;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class PagoId implements Serializable {

    @Column(name = "empresa_mail_pago")
    private String empresaMailPago;

    @Column(name = "centro_mail_pago")
    private String centroMailPago;

    public PagoId() {
    }

    public PagoId(String empresaMailPago, String centroMailPago) {
        this.empresaMailPago = empresaMailPago;
        this.centroMailPago = centroMailPago;
    }

    public String getEmpresaMailPago() {
        return empresaMailPago;
    }

    public void setEmpresaMailPago(String empresaMailPago) {
        this.empresaMailPago = empresaMailPago;
    }

    public String getCentroMailPago() {
        return centroMailPago;
    }

    public void setCentroMailPago(String centroMailPago) {
        this.centroMailPago = centroMailPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagoId pagoId = (PagoId) o;
        return Objects.equals(empresaMailPago, pagoId.empresaMailPago) && Objects.equals(centroMailPago, pagoId.centroMailPago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresaMailPago, centroMailPago);
    }

    @Override
    public String toString() {
        return "PagoId{" +
                "empresaMailPago='" + empresaMailPago + '\'' +
                ", centroMailPago='" + centroMailPago + '\'' +
                '}';
    }
}
