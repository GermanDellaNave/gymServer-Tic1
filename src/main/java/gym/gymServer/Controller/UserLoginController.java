package gym.gymServer.Controller;

import gym.gymServer.Classes.UserLogin;
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
    public void registrarLogin(@RequestBody UserLogin nuevoUserLogin) throws Exception {
        userLoginService.registrarLogin(nuevoUserLogin);
    }

    @GetMapping(path = "/role/{mail}")
    public String getRole(@PathVariable("mail") String mail) throws Exception{
        return userLoginService.getRole(mail);
    }

    @GetMapping(path = "/password/{mail}/{contrasenaUsuario}")
    public Boolean confirmPassword(@PathVariable("mail") String mail, @PathVariable("contrasenaUsuario") String password) {
        return userLoginService.confirmPassword(mail, password);
    }
}
