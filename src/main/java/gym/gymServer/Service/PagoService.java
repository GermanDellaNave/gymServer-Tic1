package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.Pago;
import gym.gymServer.Repository.PagoRepository;
import gym.gymServer.Repository.TipoActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    public PagoService() {
    }

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> getPagos() {
        return (List<Pago>) pagoRepository.findAll();
    }

    public void registrarPago(Pago pago) {
        pagoRepository.save(pago);
    }

    public List<Pago> getPagosCentro(String mail) {
        return (List<Pago>) pagoRepository.findOneByCentro(mail);
    }

    public List<Pago> findByCentroAndSearch(String mailCentro,String input){
        return pagoRepository.findByCentroAndSearch(mailCentro,input);
    }
}
