package gym.gymServer.Controller;

import gym.gymServer.Classes.Usuarios;
import gym.gymServer.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    public UsuariosController() {}

    @PostMapping
    public void registrarUsuario(@RequestBody Usuarios usuario ) throws Exception {
        usuariosService.registrarUsuario(usuario);
    }


}
