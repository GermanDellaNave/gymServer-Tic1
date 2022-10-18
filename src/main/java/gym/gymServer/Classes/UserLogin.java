package gym.gymServer.Classes;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "Login")
@Component
public class UserLogin implements UserDetails {

    @Column(name = "mail")
    private @Id String mail;

    private String contrasena;

    @Enumerated(EnumType.STRING)
    private UserLoginRole tipoDeUsuario;

    private Boolean bloqueada;

    private Boolean enabled;

    public UserLogin() {
    }

    public UserLogin(String mail, String contrasena, UserLoginRole tipoDeUsuario, Boolean bloqueada, Boolean enabled) {
        this.mail = mail;
        this.contrasena = contrasena;
        this.tipoDeUsuario = tipoDeUsuario;
        this.bloqueada = bloqueada;
        this.enabled = enabled;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UserLoginRole getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(UserLoginRole tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Boolean getBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(Boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(tipoDeUsuario.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !bloqueada;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
