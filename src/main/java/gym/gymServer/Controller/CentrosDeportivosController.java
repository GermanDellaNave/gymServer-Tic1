package gym.gymServer.Controller;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Service.CentrosDeportivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/api/centroDeportivo")
public class CentrosDeportivosController {

    @Autowired
    private CentrosDeportivosService centrosDeportivosService;

    public CentrosDeportivosController() {
    }

    @GetMapping("/centros")
    public List<CentrosDeportivos> getCentrosDeportivos() {
        return centrosDeportivosService.getCentrosDeportivos();
    }

    @GetMapping("/nuevosCentros")
    public List<CentrosDeportivos> getNuevosCentros() {
        return centrosDeportivosService.getNuevosCentros();
    }

    @GetMapping("/centrosMail/{mail}")
    public CentrosDeportivos getCentroDeportivo(@PathVariable("mail") String mail) {
        return centrosDeportivosService.getCentroDeportivo(mail);
    }

    @GetMapping(path = "/nombreCentro/{mail}")
    public String getNombreCentro(@PathVariable("mail") String mail) {
        return centrosDeportivosService.getCentroDeportivoNombre(mail);
    }

    @GetMapping("/similarCentroDeportivo/{like}")
    public List<CentrosDeportivos> getCentrosDeportivosLike(@PathVariable("like") String search) {
        return centrosDeportivosService.getCentrosDeportivosLike(search);
    }

    @GetMapping("/numberCentros")
    public Integer getCantidadCentros(){
        return centrosDeportivosService.getCantidadCentros();
    }

    @PostMapping
    public void registrarCentroDeportivo(@RequestBody CentrosDeportivos nuevoCentroDeportivo) {
        centrosDeportivosService.registrarCentroDeportivo(nuevoCentroDeportivo);
    }

    @DeleteMapping (path = {"/delete/{centroDeportivoId}"})
    public void borrarCentroDeportivo(@PathVariable("centroDeportivoId") String mailId) {
        centrosDeportivosService.borrarCentroDeportivo(mailId);
    }

    @PutMapping(path = "/updateCentro/{mail}")
    public void modificarDatoEmpresa(@PathVariable("centroDeportivoId") String mailId, String nombre, String contrasena) {
        centrosDeportivosService.actualizarDatosCD(mailId, nombre, contrasena);
    }

    @PutMapping(path = "/actualizar/{mailCentro}")
    public void actualizarCentroDeportivo(@PathVariable("mailCentro") String mailCentro ,@RequestBody  CentrosDeportivos centrosDeportivos) {
        centrosDeportivosService.actualizarCentroDeportivo(mailCentro,centrosDeportivos);
    }

}
