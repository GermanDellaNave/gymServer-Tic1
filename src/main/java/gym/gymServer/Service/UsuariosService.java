package gym.gymServer.Service;

import gym.gymServer.Classes.Usuarios;
import gym.gymServer.Repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public UsuariosService() {
    }

    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    public void registrarUsuario(Usuarios usuario) throws Exception {
        if(usuariosRepository.findOneByMail(usuario.getMail())!=null){
            throw new Exception();
        }
        usuariosRepository.save(usuario);
        System.out.println("Registro usuario");
    }
}
