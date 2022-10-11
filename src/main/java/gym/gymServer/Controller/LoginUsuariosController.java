package gym.gymServer.Controller;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Classes.Login;
import gym.gymServer.Service.LoginUsuariosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/login")
public class LoginUsuariosController {

    LoginUsuariosService loginUsuariosService;

    public LoginUsuariosController() {
    }

    @GetMapping
    public String getRole(@RequestBody Login nuevoLogin) throws Exception{
        return loginUsuariosService.getRole(nuevoLogin.getTipoDeUsuario());
    }
}
