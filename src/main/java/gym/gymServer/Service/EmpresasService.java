package gym.gymServer.Service;


import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.CentroDeportivoNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class EmpresasService {

    @Autowired(required = true)
    private EmpresasRepository empresasRepository;

    public EmpresasService() {
    }

    public EmpresasService(EmpresasRepository empresasRepository) {
        this.empresasRepository = empresasRepository;
    }

    public List<Empresas> getEmpresas() {
        return (List<Empresas>) empresasRepository.findAll();
    }

    public void registrarEmpresa (Empresas nuevaEmpresa) throws EmpresaYaExiste {
        if (empresasRepository.findOneByMail(nuevaEmpresa.getMail()) != null) {
            throw new EmpresaYaExiste();
        }
        System.out.println("Definicion empresa service");
        System.out.println(nuevaEmpresa);
        empresasRepository.save(nuevaEmpresa);
        System.out.println("RegistroEmpresa");
    }

    public void borrarEmpresa(String mailId) {
        if (empresasRepository.findOneByMail(mailId) != null) {
            empresasRepository.deleteById(mailId);
        }
    }

    public void actualizarDatosEmpresa(String mailId, String nombre, String contrasena) throws EmpresaNoExiste {
        Empresas empresaActualizable = empresasRepository.findOneByMail(mailId);

        if (empresaActualizable == null) {
            throw new EmpresaNoExiste();
        }

        empresaActualizable.setNombre(nombre);

        empresasRepository.save(empresaActualizable);
    }

    public Empresas getEmpresa(String mail) {
        System.out.println("Buscando");
        Empresas empresa = empresasRepository.findOneByMail(mail);
        if (empresa == null) {
            System.out.println("ERROR");
            return null;
        }
        System.out.println("Busqueda Empresa");
        return empresa;
    }

    public List<Empresas> getEmpresasLike(String search) {

        return empresasRepository.findBySearch(search);
    }

    @Transactional
    public void actualizarEmpresa(String mailEmpresa,Empresas empresa) {
        Empresas empresaActualizable = empresasRepository.findOneByMail(mailEmpresa);
        empresaActualizable.setNombre(empresa.getNombre());
        empresaActualizable.setBono(empresa.getBono());
        empresaActualizable.setImagen(empresa.getImagen());
    }
}
