package gym.gymServer.Service;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Classes.UserLoginRole;
import gym.gymServer.Classes.UserRegistro;
import gym.gymServer.Repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;
    private ValidadorMail validadorMail;

    public UserLoginService() {}

    public UserLoginService(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    public UserLoginRole getRole(String mail) throws Exception {
        UserLogin user = userLoginRepository.findOneByMail(mail);
        if (user == null) {
            throw new Exception();
        }

        return user.getTipoDeUsuario();
    }

    public void registrarLogin (UserRegistro nuevoUserLogin) throws Exception {
        if (userLoginRepository.findOneByMail(nuevoUserLogin.getMail()) != null) {
            throw new Exception();
        }
        boolean esValidoMail = validadorMail.test(nuevoUserLogin.getMail());
        if (!esValidoMail) {
            throw new IllegalStateException("mail no valido");
        }
        UserLogin nuevoUsuario = new UserLogin(nuevoUserLogin.getMail(), nuevoUserLogin.getContrasena(), UserLoginRole.USUARIO, false, true);
        userLoginRepository.save(nuevoUsuario);
        System.out.println("Login creado");
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return userLoginRepository.findOneByMail(mail);
    }

    public String singUpUser(UserLogin userLogin){
        return "";
    }
}
