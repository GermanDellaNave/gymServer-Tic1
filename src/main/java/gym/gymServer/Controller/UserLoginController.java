package gym.gymServer.Controller;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Classes.UserLoginRole;
import gym.gymServer.Classes.UserRegistro;
import gym.gymServer.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/login")
public class UserLoginController {

    @Autowired
    public UserLoginService userLoginService;

    public UserLoginController() {
    }

    @PostMapping
    public void registrarLogin(@RequestBody UserRegistro nuevoUserLogin) throws Exception {
        System.out.println(nuevoUserLogin.getContrasena());
        System.out.println(nuevoUserLogin.getMail());
        userLoginService.registrarLogin(nuevoUserLogin);
    }

    @GetMapping
    public UserLoginRole getRole(UserLogin nuevoUserLogin) throws Exception{
        return userLoginService.getRole(nuevoUserLogin.getTipoDeUsuario().toString());
    }
}
