package gym.gymServer.Service;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Classes.Login;
import gym.gymServer.Repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUsuariosService {

    LoginRepository loginRepository;

    public LoginUsuariosService() {
    }

    public LoginUsuariosService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public String getRole(String mail) throws Exception {
        Login user = loginRepository.findOneByMail(mail);
        if (user == null) {
            throw new Exception();
        }
        return user.getTipoDeUsuario();
    }
}
