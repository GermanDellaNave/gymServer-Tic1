package gym.gymServer.Controller;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Classes.Login;
import gym.gymServer.Service.LoginUsuariosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/login")
public class LoginUsuariosController {

    LoginUsuariosService loginUsuariosService;

    public LoginUsuariosController() {
    }

    @PostMapping
    public void registrarLogin(@RequestBody Login nuevoLogin) throws Exception {
        System.out.println(nuevoLogin.getContrasena());
        System.out.println(nuevoLogin.getMail());
        System.out.println(nuevoLogin.getTipoDeUsuario());
        loginUsuariosService.registrarLogin(nuevoLogin);
    }

    @GetMapping
    public String getRole(Login nuevoLogin) throws Exception{
        return loginUsuariosService.getRole(nuevoLogin.getTipoDeUsuario());
    }
}
