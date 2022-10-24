package gym.gymServer.Classes;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pagoEmpresaCentro")
@IdClass(PagoId.class)
public class Pago {

    @Id
        private String empresaMailPago;

        @Id
        private String centroMailPago;

        private Integer monto;

        @ManyToOne
        @JoinColumn(name = "empresa_mail_pago", referencedColumnName = "mailEmpresa", insertable = false, updatable = false)
        private Empresas empresa;

        @ManyToOne
        @JoinColumn(name = "centro_mail_pago", referencedColumnName = "mailCentro", insertable = false, updatable = false)
        private CentrosDeportivos centroDeportivo;

    public Pago() {
        }

    public Pago(String empresaMailPago, String centroMailPago, Integer monto) {
            this.empresaMailPago = empresaMailPago;
            this.centroMailPago = centroMailPago;
            this.monto = monto;
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

        public Integer getMonto() {
            return monto;
        }

        public void setMonto(Integer monto) {
            this.monto = monto;
        }

        public Empresas getEmpresa() {
            return empresa;
        }

        public void setEmpresa(Empresas empresa) {
            this.empresa = empresa;
        }

        public CentrosDeportivos getCentroDeportivo() {
            return centroDeportivo;
        }

        public void setCentrosDeportivos(CentrosDeportivos centrosDeportivos) {
            this.centroDeportivo = centrosDeportivos;
        }

        @Override
        public String toString() {
            return "Pago{" +
                    "empresaMailPago='" + empresaMailPago + '\'' +
                    ", centroMailPago='" + centroMailPago + '\'' +
                    ", monto=" + monto +
                    ", empresa=" + empresa +
                    ", centrosDeportivos=" + centroDeportivo +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pago pago = (Pago) o;
            return Objects.equals(empresaMailPago, pago.empresaMailPago) && Objects.equals(centroMailPago, pago.centroMailPago) && Objects.equals(monto, pago.monto) && Objects.equals(empresa, pago.empresa) && Objects.equals(centroDeportivo, pago.centroDeportivo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(empresaMailPago, centroMailPago, monto, empresa, centroDeportivo);
    }
}
