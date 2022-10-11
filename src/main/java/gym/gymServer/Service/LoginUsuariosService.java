package gym.gymServer.Service;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Classes.Login;
import gym.gymServer.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginUsuariosService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginUsuariosService() {}

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

    public void registrarLogin (Login nuevoLogin) throws Exception {
        if (loginRepository.findOneByMail(nuevoLogin.getMail()) != null) {
            throw new Exception();
        }
        loginRepository.save(nuevoLogin);
        System.out.println("Login creado");
    }
}
