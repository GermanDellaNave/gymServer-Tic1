package gym.gymServer.Security.Configuracion;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Repository.EmpleadoRepository;
import org.hibernate.type.LocalDateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class SaldoConfiguration {

    /*
    LocalDate lastUpdate;
    LocalDate date = LocalDate.now();

    @Autowired
    EmpleadoRepository empleadoRepository;

    public SaldoConfiguration(LocalDate lastUpdate, LocalDate date) {
        this.lastUpdate = lastUpdate;
        this.date = date;
    }

    @Bean
    public void checkDate(LocalDate now, LocalDate before) {
        if (now.getMonth() != before.getMonth()) {
            actualizarSaldoDisponible();
        }
        this.lastUpdate = this.date;
    }

    public void actualizarSaldoDisponible () {
        List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado_i = empleados.get(i);
            if(empleado_i.getSaldoDisponible() < 0) {
                empleado_i.setDeuda(empleado_i.getSaldoDisponible());
            }
            empleado_i.setSaldoDisponible(empleados.get(i).getEmpresa().getBono());
        }
        empleadoRepository.saveAll(empleados);

    }*/

}
