package facades;

import entities.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EventFacade {
    @PersistenceContext
    public EntityManager em;

    public List<Event> getEventList(){
        return em.createQuery("select e from Event e").getResultList();
    }

    public void createEvent(Event e){
        em.merge(e);
    }

    public Event findById(Long id){
        System.out.println("ID ==================");
        System.out.println(id);
        return (Event)em.createQuery("select p from Event p where p.id = :id").setParameter("id",id).getSingleResult();
    }
}
