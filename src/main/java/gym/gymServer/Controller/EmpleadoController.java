package gym.gymServer.Controller;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/usuarios")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController() {}

    @PostMapping
    public void registrarEmpleado (@RequestBody Empleado empleado) throws Exception {
        empleadoService.registrarEmpleado(empleado);
    }


}
