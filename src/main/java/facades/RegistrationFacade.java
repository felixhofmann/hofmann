package facades;

        import entities.Event;
        import entities.Person;
        import entities.Registration;

        import javax.ejb.Stateless;
        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import java.util.List;

@Stateless
public class RegistrationFacade {

    @PersistenceContext
    EntityManager em;


    public List<Registration> getRegistartion(Person p){
        return em.createQuery("select r from Registration r where r.person.id = :id").setParameter("id",p.getId()).getResultList();


    }

    public void createRegistration(Registration registration) {
        em.persist(registration);
    }

}
