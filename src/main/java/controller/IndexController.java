package controller;

import entities.Event;
import entities.Person;
import entities.Registration;
import enums.Participating;
import facades.EventFacade;
import facades.PersonFacade;
import facades.RegistrationFacade;
import org.primefaces.context.RequestContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

@Named
@ApplicationScoped
public class IndexController {


    List<Event> events;
    Person toAdd;
    Event selected;
    List<Registration> registrations;


    Participating part;
    @Inject
    PersonFacade personFacade;

    @Inject
    EventFacade eventFacade;

    @Inject
    RegistrationFacade registrationFacade;


    public IndexController() {
        this.toAdd = new Person();
        this.selected = new Event();
    }

    public Participating getPart() {
        return part;
    }

    public void setPart(Participating part) {
        this.part = part;
    }

    public Person getToAdd() {
        return toAdd;
    }

    public void setToAdd(Person toAdd) {
        this.toAdd = toAdd;
    }

    public void createPerson(){
        if (toAdd.getFirstName().equals("") && toAdd.getLastName().equals("") && toAdd.getEmail() != null)
        {
            Person p = personFacade.getPerson(toAdd.getEmail());
            toAdd = p;
            RequestContext.getCurrentInstance().update("form_insert");
            return;
        }
        personFacade.addPerson(toAdd);
        toAdd = new Person();
    }

    public List<Event> loadList(){
        return events;
    }

    public List<Event> getEvents() {
        return eventFacade.getEventList();
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Event getSelected() {
        return selected;
    }

    public void setSelected(Event selected) {
        this.selected = selected;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public void saveRegistration(){
        Registration re = new Registration();
        re.setIsAttending(part);
        re.setEvent(eventFacade.findById(selected.getId()));
        re.setPerson(toAdd);
        registrationFacade.createRegistration(re);
        registrations = registrationFacade.getRegistartion(toAdd);
        selected = new Event();
        toAdd = new Person();

    }

}
