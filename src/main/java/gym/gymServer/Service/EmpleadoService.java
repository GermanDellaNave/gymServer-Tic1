package gym.gymServer.Service;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService() {
    }

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public void registrarUsuario(Empleado usuario) throws Exception {
        if(empleadoRepository.findOneByMail(usuario.getMail())!=null){
            throw new Exception();
        }
        empleadoRepository.save(usuario);
        System.out.println("Registro usuario");
    }
}
