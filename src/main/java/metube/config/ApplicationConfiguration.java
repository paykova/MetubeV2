package metube.config;

import org.modelmapper.ModelMapper;

import javax.ejb.Local;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;

@Local
public class ApplicationConfiguration {

    @Produces
    @Default
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Produces
    public EntityManager entityManager(){
        return Persistence
                .createEntityManagerFactory("metube")
                .createEntityManager();
    }
}
