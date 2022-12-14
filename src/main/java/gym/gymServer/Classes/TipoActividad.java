package gym.gymServer.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tipo_actividades")
public class TipoActividad implements Serializable {

    private @Id String tipo;

    public TipoActividad(String tipo) {
        this.tipo = tipo;
    }

    public TipoActividad() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoActividad that = (TipoActividad) o;
        return Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo);
    }

    @Override
    public String toString() {
        return "TipoActividad{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
