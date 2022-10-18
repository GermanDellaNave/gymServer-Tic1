package gym.gymServer.Service;


import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.CentroDeportivoNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        empresasRepository.save(nuevaEmpresa);
        System.out.println("RegistroEmpresa");
    }

    public void borrarEmpresa(String mailId) throws EmpresaNoExiste{
        if (empresasRepository.findOneByMail(mailId) == null) {
            throw new EmpresaNoExiste();
        }

        empresasRepository.deleteById(mailId);
    }

    public void actualizarDatosEmpresa(String mailId, String nombre, String contrasena) throws EmpresaNoExiste {
        Empresas empresaActualizable = empresasRepository.findOneByMail(mailId);

        if (empresaActualizable == null) {
            throw new EmpresaNoExiste();
        }

        empresaActualizable.setNombre(nombre);

        empresasRepository.save(empresaActualizable);
    }

    public Empresas getEmpresa(String mail) throws EmpresaNoExiste {
        System.out.println("Buscando");
        Empresas empresa = empresasRepository.findOneByMail(mail);
        if (empresa == null) {
            System.out.println("ERROR");
            throw new EmpresaNoExiste();
        }
        System.out.println("Busqueda Empresa");
        return empresa;
    }
}
