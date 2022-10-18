package gym.gymServer.Service;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    public UserLoginService() {
    }

    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public String getRole(String mail) throws Exception {
        UserLogin user = userLoginRepository.findOneByMail(mail);
        if (user == null) {
            throw new Exception();
        }
        System.out.println("Encontrado");
        return user.getTipoDeUsuario();
    }

    public void registrarLogin(UserLogin nuevoUserLogin) throws Exception {
        if (userLoginRepository.findOneByMail(nuevoUserLogin.getMail()) != null) {
            throw new Exception("Entidad ya existe");
        }
        UserLogin nuevoUsuario = new UserLogin(nuevoUserLogin.getMail(), nuevoUserLogin.getContrasena(), nuevoUserLogin.getTipoDeUsuario());
        userLoginRepository.save(nuevoUsuario);
        System.out.println("Login creado");
    }

    public String entrar(UserLogin usuarioAIngresar) throws Exception {
        UserLogin usuarioTmpl = userLoginRepository.findOneByMail(usuarioAIngresar.getMail());
        if (usuarioTmpl == null) {
            throw new Exception("Entidad no existe");
        }
        return usuarioTmpl.getTipoDeUsuario();
    }
}
