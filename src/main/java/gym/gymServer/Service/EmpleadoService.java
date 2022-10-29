package gym.gymServer.Service;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empleado;
import gym.gymServer.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Empleado empleado=empleadoRepository.findOneByMail(mail);
        return empleado;
    }
}
