package gym.gymServer.Security.Configuracion;

import gym.gymServer.Classes.*;
import gym.gymServer.Repository.InscripcionesActividadesRepository;
import gym.gymServer.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
public class PagosConfiguration {

    @Autowired
    PagoRepository pagoRepository;

    @Autowired
    InscripcionesActividadesRepository inscripcionesActividadesRepository;

    @Scheduled(cron = "0 0 */12 * * *")
    @Bean
    @Transactional
    public void cobrar(){
        List<InscripcionesActividades> inscripcionesActividades = (List<InscripcionesActividades>) inscripcionesActividadesRepository.findAll();
        for (int i = 0; i < inscripcionesActividades.size(); i++) {
            InscripcionesActividades inscripcionActividad_i = inscripcionesActividades.get(i);

            Empleado empleado_i = inscripcionActividad_i.getEmpleado();
            Empresas empresa_i=inscripcionActividad_i.getEmpleado().getEmpresa();
            CentrosDeportivos centro_deportivo_i=inscripcionActividad_i.getActividad().getCentroDeportivo();
            Actividad actividad_i=inscripcionActividad_i.getActividad();



            Period period=Period.between(LocalDate.now(),actividad_i.getDia());

            Integer daysBetween=period.getDays();

            if(((inscripcionActividad_i.getTipoReserva().equals("RESERVAR") &&  daysBetween<=0) || inscripcionActividad_i.isAsistencia()) && !inscripcionActividad_i.getTipoReserva().equals("PAGO")){
                Integer monto_a_cobrar_i=actividad_i.getCosto();
                empleado_i.setSaldoDisponible(empleado_i.getSaldoDisponible() - actividad_i.getCosto());
                Pago pago_empresa_centro_i=pagoRepository.findOneByEmpresaAndCentro(empresa_i.getMail(),centro_deportivo_i.getMail());
                if(pago_empresa_centro_i != null){
                    pago_empresa_centro_i.setMonto(pago_empresa_centro_i.getMonto() + monto_a_cobrar_i);
                } else{
                    pago_empresa_centro_i = new Pago(empresa_i.getMail(),centro_deportivo_i.getMail(),monto_a_cobrar_i);
                    pagoRepository.save(pago_empresa_centro_i);
                }
                inscripcionActividad_i.setTipoReserva("PAGO");
            }
        }

    }



}
