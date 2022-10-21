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

    public String getRole(String mail) throws Exception {
        UserLogin user = userLoginRepository.findOneByMail(mail);
        if (user == null) {
            return null;
            //throw new Exception("Usuario no encontrado");
        }
        System.out.println("Encontrado");
        return user.getTipoDeUsuario();
    }

    public void registrarLogin(UserLogin nuevoUserLogin) throws Exception {
        if (userLoginRepository.findOneByMail(nuevoUserLogin.getMail()) != null) {
            throw new Exception("Entidad ya existe");
        }
        String encodedPassword = this.passwordEncoder.encode(nuevoUserLogin.getContrasena());
        nuevoUserLogin.setContrasena(encodedPassword);
        userLoginRepository.save(nuevoUserLogin);
        System.out.println("Login creado");
    }

    public String entrar(UserLogin usuarioAIngresar) throws Exception {
        UserLogin usuarioTmpl = userLoginRepository.findOneByMail(usuarioAIngresar.getMail());
        if (usuarioTmpl == null) {
            throw new Exception("Entidad no existe");
        }
        return usuarioTmpl.getTipoDeUsuario();
    }

    public Boolean confirmPassword(String mail, String password) throws Exception {
        UserLogin userLogin = userLoginRepository.findOneByMail(mail);
        if (userLogin == null) {
            return null;
        }
        return this.passwordEncoder.matches(password, userLogin.getContrasena());
    }
}
