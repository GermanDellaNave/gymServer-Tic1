package gym.gymServer.Controller;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/allEmpleados")
    public List<Empleado> todosLosEmpleados () {
        return empleadoService.todosLosEmpleados();
    }

    @GetMapping("/empleadoMail/{mail}")
    public Empleado getEmpleado(@PathVariable("mail") String mail){
        return empleadoService.getEmpleado(mail);
    }

    @GetMapping("/similarEmpleado/{mailEmpresa}/{like}")
    public List<Empleado> getEmpleadosLike(@PathVariable("mailEmpresa") String empresa, @PathVariable("like") String search) {
        return empleadoService.getEmpleadosLike(empresa, search);
    }

    @GetMapping("/empleadosEmpresa/{mailEmpresa}")
    public List<Empleado> getEmpleadosByEmpresa(@PathVariable("mailEmpresa") String mail) {
        return empleadoService.getEmpleadosByEmpresa(mail);
    }

    @GetMapping("/nuevosEmpleadosEmpresa/{mailEmpresa}")
    public List<Empleado> getNuevosEmpleadosByEmpresa(@PathVariable("mailEmpresa") String mail) {
        return empleadoService.getNuevosEmpleadosByEmpresa(mail);
    }

    @GetMapping("/empleadosConDeuda/{mailEmpresa}")
    public List<Empleado> getEmpleadosConDeuda(@PathVariable("mailEmpresa") String mail){
        return empleadoService.getEmpleadosConDeuda(mail);
    }

    @GetMapping("/cantidadEmpleados")
    Integer getNumeroEmpleados () {
        return empleadoService.getCantidadEmpleados();
    }

    @DeleteMapping(path = "/deleteEmpleado/{mailEmpleado}")
    public void deleteEmpleado(@PathVariable("mailEmpleado") String mail) {
        empleadoService.deleteEmpleado(mail);
    }

    @PutMapping(path = "/actualizar/{mailEmpleado}")
    public void actualizarEmpleado(@PathVariable("mailEmpleado") String mailEmpleado,@RequestBody Empleado empleado) {
        empleadoService.actualizarEmpleado(mailEmpleado,empleado);
    }

}
