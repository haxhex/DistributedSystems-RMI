import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The remote interface representing the Calendar functionality.
 */
public interface CalendarInterface extends Remote {

    /**
     * Adds an event to the calendar.
     *
     * @param event the event to be added
     * @throws RemoteException if there is an issue with remote communication
     */
    void addEvent(Event event) throws RemoteException;

    /**
     * Removes an event from the calendar by its unique name.
     *
     * @param eventName the unique name of the event to be removed
     * @throws RemoteException if there is an issue with remote communication
     */
    void removeEvent(String eventName) throws RemoteException;

    /**
     * Retrieves a list of all events for a given month and year.
     *
     * @param year  the year for which events are retrieved
     * @param month the month for which events are retrieved
     * @return the list of events for the specified month and year
     * @throws RemoteException if there is an issue with remote communication
     */
    List<Event> getEventsForMonth(int year, int month) throws RemoteException;

    /**
     * Retrieves a list of events with a specific name.
     *
     * @param name the name of the events to be retrieved
     * @return the list of events with the specified name
     * @throws RemoteException if there is an issue with remote communication
     */
    List<Event> getEventsByName(String name) throws RemoteException;

    /**
     * Retrieves a list of events with a specific type.
     *
     * @param type the type of the events to be retrieved
     * @return the list of events with the specified type
     * @throws RemoteException if there is an issue with remote communication
     */
    List<Event> getEventsByType(String type) throws RemoteException;

    /**
     * Retrieves a list of events for a specific date.
     *
     * @param date the date for which events are retrieved
     * @return the list of events for the specified date
     * @throws RemoteException if there is an issue with remote communication
     */
    List<Event> getEventsByDate(LocalDateTime date) throws RemoteException;

    /**
     * Retrieves a list of events at a specific location.
     *
     * @param location the location for which events are retrieved
     * @return the list of events at the specified location
     * @throws RemoteException if there is an issue with remote communication
     */
    List<Event> getEventsByLocation(String location) throws RemoteException;

    /**
     * Retrieves a ConcurrentHashMap containing all events.
     *
     * @return the ConcurrentHashMap containing all events
     * @throws RemoteException if there is an issue with remote communication
     */
    ConcurrentHashMap<String, Event> getEvents() throws RemoteException;
}
