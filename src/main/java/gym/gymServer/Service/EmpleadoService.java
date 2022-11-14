package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empleado;
import gym.gymServer.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService() {
    }

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public void registrarEmpleado(Empleado empleado) throws Exception {
        if(empleadoRepository.findOneByMail(empleado.getMail())!=null){
            throw new Exception();
        }
        empleadoRepository.save(empleado);
        System.out.println("Registro empleado");
    }


    public List<Empleado> todosLosEmpleados() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    public Empleado getEmpleado(String mail){
        Empleado empleado = empleadoRepository.findOneByMail(mail);
        System.out.println(empleado);
        return empleado;
    }

    public List<Empleado> getEmpleadosLike(String empresa, String search) {
        return empleadoRepository.findBySearchAndEmpresa(search, empresa);
    }

    public List<Empleado> getEmpleadosByEmpresa(String mailEmpresa) {
        return empleadoRepository.findAllByEmpresa(mailEmpresa);
    }

    public List<Empleado> getNuevosEmpleadosByEmpresa(String mailEmpresa) {
        return empleadoRepository.findTopNewestEmpresa(mailEmpresa);
    }

    public List<Empleado> getEmpleadosConDeuda(String mailEmpresa) {
        return empleadoRepository.getDeudoresPorEmpresa(mailEmpresa);
    }

    public void deleteEmpleado(String mail) {
        System.out.println("Entro delete empleado");
        System.out.println(mail);
        //if (empleadoRepository.findOneByMail(mail) != null) {
            System.out.println("Entro if");
            empleadoRepository.deleteById(mail);
            //empleadoRepository.borrarEmpleadoEmail(mail);
        //}
    }

    @Transactional
    public void actualizarEmpleado(String mailEmpleado,Empleado empleado) {
        Empleado empleadoActualizable = empleadoRepository.findOneByMail(mailEmpleado);

        empleadoActualizable.setApellido(empleado.getApellido());
        empleadoActualizable.setNombre(empleado.getNombre());
        empleadoActualizable.setSaldoDisponible(empleado.getSaldoDisponible());
        empleadoActualizable.setDeuda(empleado.getDeuda());
        empleadoActualizable.setTelefono(empleado.getTelefono());
        empleadoActualizable.setImagen(empleado.getImagen());
    }
}
