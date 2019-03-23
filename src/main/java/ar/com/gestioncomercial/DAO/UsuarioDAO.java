package ar.com.gestioncomercial.DAO;

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

    public Usuario findByEmailAndPassword(String email, String password){
        Query query = em.createNamedQuery("Usuario.findByEmailAndPassword");
        query.setParameter("email",email);
        query.setParameter("password", password);
        Usuario user = null;
        try{
            user = (Usuario) query.getSingleResult();
        }catch(NoResultException nre){
            System.out.println(nre.getMessage());
        }
        return user;
    }

    public List getAllUsers(){
        return getAll();
    }

    @Override
    protected List<Usuario> getAll() {
        Query query =  em.createNamedQuery("Usuario.getAll");
        return   query.getResultList();
    }
}
