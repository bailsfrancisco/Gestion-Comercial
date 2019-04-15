package ar.com.gestioncomercial.DAO;

import ar.com.gestioncomercial.model.AbstractPersona;
import ar.com.gestioncomercial.model.Usuario;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario>{

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public Usuario findByNombreAndPassword(String nombreUsuario, String password){
        Query query = em.createNamedQuery("Usuario.findByNombreAndPassword");
        query.setParameter("nombreUsuario",nombreUsuario);
        query.setParameter("password", password);
        Usuario user = null;
        try{
            user = (Usuario) query.getSingleResult();
        }catch(NoResultException nre){
            System.out.println(nre.getMessage());
        }
        return user;
    }

    public List<Usuario> getAllUsers(){
        return getAll();
    }

    @Override
    protected List<Usuario> getAll() {
        Query query =  em.createNamedQuery("Usuario.getAll");
        return   query.getResultList();
    }

    public Usuario getByPersona(AbstractPersona persona){
        Query query = em.createNamedQuery("Usuario.getByPersona");
        query.setParameter("persona",persona);
        Usuario user = null;
        try{
            user = (Usuario) query.getSingleResult();
        }catch(NoResultException nre){
            System.out.println(nre.getMessage());
        }
        return user;
    }
}
