package business;

import entities.Event;
import facades.EventFacade;
import facades.PersonFacade;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class InitBean {

    @Inject
    PersonFacade personFacade;

    @Inject
    EventFacade eventFacade;


    @PostConstruct
    public void init(){

        Event e = new Event();
        e.setLocation("lolo");
        e.setDetails("comon detail");
        e.setTitle("hallo");
        e.setSpeaker("felix hofmann");
        e.setLocation("ort");

        eventFacade.createEvent(e);
    }
}
