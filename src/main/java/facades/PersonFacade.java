package facades;

import entities.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonFacade {

    @PersistenceContext
    public EntityManager em;


    public void addPerson(Person p){
        //em.merge(p); nachträgliche s änderung merge bei vorhandener person persist bei neuer person (flüchtigkeitsfehler)
        em.persist(p);
    }

    public Person getPerson(String email){

        return (Person)em.createQuery("select p from Person p where p.email LIKE :email").setParameter("email", email).getSingleResult();
    }

}
