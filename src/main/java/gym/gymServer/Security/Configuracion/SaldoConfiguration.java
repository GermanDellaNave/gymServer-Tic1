package gym.gymServer.Security.Configuracion;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.util.List;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
public class SaldoConfiguration {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @Scheduled(cron = "0 0 1 1 * ?")
    //@Bean
    @Transactional
    public void actualizarSaldoDisponible () {
        List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado_i = empleados.get(i);
            if(empleado_i.getSaldoDisponible() < 0) {
                Integer deuda = Math.abs(empleado_i.getSaldoDisponible() + empleado_i.getDeuda());
                empleado_i.setDeuda(deuda);
            }
            empleado_i.setSaldoDisponible(empleados.get(i).getEmpresa().getBono());
        }
    }

}
