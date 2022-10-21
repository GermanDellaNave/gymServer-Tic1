package gym.gymServer.Controller;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Classes.UserRegistro;
import gym.gymServer.Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;

@RestController
@RequestMapping(path = "/api/login")
public class UserLoginController {

    @Autowired
    public UserLoginService userLoginService;

    public UserLoginController() {
    }

    /*@GetMapping(path = "/rol")
    public String entrar(@PathVariable String mail) throws Exception {
        return userLoginService.entrar(mail);
    }*/

    @PostMapping
    public void registrarLogin(@RequestBody UserLogin nuevoUserLogin) throws Exception {
        System.out.println(nuevoUserLogin.getContrasena());
        System.out.println(nuevoUserLogin.getMail());
        userLoginService.registrarLogin(nuevoUserLogin);
    }

    @GetMapping(path = "/role/{mail}")
    public String getRole(@PathVariable("mail") String mail) throws Exception{
        return userLoginService.getRole(mail);
    }

    @GetMapping(path = "/password/{mail}/{password}")
    public Boolean confirmPassword(@PathVariable("mail") String mail, @PathVariable("password") String password) throws Exception {
        return userLoginService.confirmPassword(mail, password);
    }
}
