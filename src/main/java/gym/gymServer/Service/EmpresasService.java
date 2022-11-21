package gym.gymServer.Service;


import gym.gymServer.Classes.Empresas;
import gym.gymServer.Repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return empresasRepository.findAllByOrderByMailAsc();
    }

    public List<Empresas> getNuevasEmpresas() {
        return empresasRepository.findTopNewest();
    }

    public void registrarEmpresa (Empresas nuevaEmpresa)  {
        empresasRepository.save(nuevaEmpresa);
    }

    public void borrarEmpresa(String mailId) {
        if (empresasRepository.findOneByMail(mailId) != null) {
            empresasRepository.deleteById(mailId);
        }
    }

    public void actualizarDatosEmpresa(String mailId, String nombre, String contrasena) {
        Empresas empresaActualizable = empresasRepository.findOneByMail(mailId);

        empresaActualizable.setNombre(nombre);

        empresasRepository.save(empresaActualizable);
    }

    public Empresas getEmpresa(String mail) {
        Empresas empresa = empresasRepository.findOneByMail(mail);
        if (empresa == null) {
            return null;
        }
        return empresa;
    }

    public List<Empresas> getEmpresasLike(String search) {

        return empresasRepository.findBySearch(search);
    }

    public int getCantidadEmpresas(){
        return empresasRepository.getNumeroEmpresas();
    }

    @Transactional
    public void actualizarEmpresa(String mailEmpresa,Empresas empresa) {
        Empresas empresaActualizable = empresasRepository.findOneByMail(mailEmpresa);
        empresaActualizable.setNombre(empresa.getNombre());
        empresaActualizable.setBono(empresa.getBono());
        empresaActualizable.setImagen(empresa.getImagen());
    }
}
