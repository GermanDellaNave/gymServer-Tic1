package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.Pago;
import gym.gymServer.Service.InscripcionesActividadesService;
import gym.gymServer.Service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/pagos")
@RestController
public class PagoController {

    @Autowired
    PagoService pagoService;

    public PagoController() {
    }

    @GetMapping("/allPagos")
    public List<Pago> getPagos() {
        return pagoService.getPagos();
    }

    @PostMapping
    public void registrarPago(@RequestBody Pago pago) {
        pagoService.registrarPago(pago);
    }

    @GetMapping("/allPagosCentro/{mailCentro}")
    public List<Pago> getPagosCentro(@PathVariable("mailCentro") String mail) {
        return pagoService.getPagosCentro(mail);
    }

    @GetMapping("/pagosByCentroAndSearch/{mailCentro}/{input}")
    public List<Pago> findByCentroAndSearch(@PathVariable("mailCentro") String mailCentro,@PathVariable("input")String input) {
        return pagoService.findByCentroAndSearch(mailCentro,input);
    }


}
