package gym.gymServer.Service;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserLoginService() {
    }

    public UserLoginService(UserLoginRepository userLoginRepository, PasswordEncoder passwordEncoder) {
        this.userLoginRepository = userLoginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String getRole(String mail)  {
        UserLogin user = userLoginRepository.findOneByMail(mail);
        if (user == null) {
            return null;
        }
        return user.getTipoDeUsuario();
    }

    public void registrarLogin(UserLogin nuevoUserLogin) {
        if (userLoginRepository.findOneByMail(nuevoUserLogin.getMail()) != null) {

        } else {
            String encodedPassword = this.passwordEncoder.encode(nuevoUserLogin.getContrasena());
            nuevoUserLogin.setContrasena(encodedPassword);
            userLoginRepository.save(nuevoUserLogin);
        }
    }

    public String entrar(UserLogin usuarioAIngresar)  {
        UserLogin usuarioTmpl = userLoginRepository.findOneByMail(usuarioAIngresar.getMail());
        if (usuarioTmpl == null) {
            return null;
        }
        return usuarioTmpl.getTipoDeUsuario();
    }

    public Boolean confirmPassword(String mail, String password) {
        UserLogin userLogin = userLoginRepository.findOneByMail(mail);
        if (userLogin == null) {
            return null;
        }
        return this.passwordEncoder.matches(password, userLogin.getContrasena());
    }
}
