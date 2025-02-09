import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class represents the implementation of the CalendarInterface.
 * It allows remote clients to perform various operations on a calendar of events.
 */
public class CalendarImpl extends UnicastRemoteObject implements CalendarInterface {

    // Thread-safe collection to hold events
    private ConcurrentHashMap<String, Event> events;

    /**
     * Constructor for the CalendarImpl class.
     * Initializes the thread-safe collection to store events.
     *
     * @throws RemoteException if there is an issue with remote communication
     */
    public CalendarImpl() throws RemoteException {
        super(); // Call the constructor of UnicastRemoteObject
        events = new ConcurrentHashMap<>(); // Instantiate the ConcurrentHashMap
    }

    /**
     * Adds an event to the calendar.
     *
     * @param event The event to be added.
     * @throws RemoteException if there is an issue with remote communication
     */
    @Override
    public void addEvent(Event event) throws RemoteException {
        // Ensure uniqueness of event names during addition
        if (events.putIfAbsent(event.getName(), event) == null) {
            System.out.println("Event added: " + event);
        } else {
            System.out.println("Event with the same name already exists. Event not added.");
        }
    }

    /**
     * Removes an event from the calendar by its unique name.
     *
     * @param eventName The unique name of the event to be removed.
     * @throws RemoteException if there is an issue with remote communication
     */
    @Override
    public void removeEvent(String eventName) throws RemoteException {
        // Remove the event and print appropriate status messages
        if (events.remove(eventName) != null) {
            System.out.println("Event removed: " + eventName);
        } else {
            System.out.println("Event not found: " + eventName + ". Nothing removed.");
        }
    }

    /**
     * Retrieves a list of all events for a given month and year.
     *
     * @param year  The year of the events.
     * @param month The month of the events.
     * @return A list of events for the specified month and year.
     * @throws RemoteException if there is an issue with remote communication
     */
    @Override
    public List<Event> getEventsForMonth(int year, int month) throws RemoteException {
        List<Event> eventsForMonth = new ArrayList<>();

        for (Event event : events.values()) {
            LocalDateTime dateTime = event.getDateTime();
            // Check if the event matches the given month and year
            if (dateTime.getYear() == year && dateTime.getMonthValue() == month) {
                eventsForMonth.add(event);
            }
        }

        System.out.println("Events for " + month + "/" + year + ": " + eventsForMonth.size());
        printEvents(eventsForMonth);
        return eventsForMonth;
    }

    /**
     * Retrieves a list of events with a matching name.
     *
     * @param name The name to match.
     * @return A list of events with the specified name.
     */
    @Override
    public List<Event> getEventsByName(String name) {
        List<Event> matchingEvents = new ArrayList<>();
        for (Event event : events.values()) {
            if (name == null || event.getName().equals(name)) {
                matchingEvents.add(event);
            }
        }
        System.out.println("Events with name '" + name + "': " + matchingEvents.size());
        printEvents(matchingEvents);
        return matchingEvents;
    }

    /**
     * Retrieves a list of events with a matching type.
     *
     * @param type The type to match.
     * @return A list of events with the specified type.
     */
    @Override
    public List<Event> getEventsByType(String type) {
        List<Event> matchingEvents = new ArrayList<>();
        for (Event event : events.values()) {
            if (type == null || event.getType().equals(type)) {
                matchingEvents.add(event);
            }
        }
        System.out.println("Events with type '" + type + "': " + matchingEvents.size());
        printEvents(matchingEvents);
        return matchingEvents;
    }

    /**
     * Retrieves a list of events with a matching date.
     *
     * @param date The date to match.
     * @return A list of events with the specified date.
     */
    @Override
    public List<Event> getEventsByDate(LocalDateTime date) {
        List<Event> matchingEvents = new ArrayList<>();
        for (Event event : events.values()) {
            if (date == null || event.getDateTime().equals(date)) {
                matchingEvents.add(event);
            }
        }
        System.out.println("Events on " + date + ": " + matchingEvents.size());
        printEvents(matchingEvents);
        return matchingEvents;
    }

    /**
     * Retrieves a list of events with a matching location.
     *
     * @param location The location to match.
     * @return A list of events with the specified location.
     */
    @Override
    public List<Event> getEventsByLocation(String location) {
        List<Event> matchingEvents = new ArrayList<>();
        for (Event event : events.values()) {
            if (location == null || event.getLocation().equals(location)) {
                matchingEvents.add(event);
            }
        }
        System.out.println("Events at '" + location + "': " + matchingEvents.size());
        printEvents(matchingEvents);
        return matchingEvents;
    }

    /**
     * Retrieves a ConcurrentHashMap containing all events.
     *
     * @return The ConcurrentHashMap containing all events.
     * @throws RemoteException if there is an issue with remote communication
     */
    @Override
    public ConcurrentHashMap<String, Event> getEvents() throws RemoteException {
        printEvents(new ArrayList<>(events.values()));
        return events;
    }

    /**
     * Print events to the console.
     *
     * @param eventsToPrint The list of events to print.
     */
    private void printEvents(List<Event> eventsToPrint) {
        if (!eventsToPrint.isEmpty()) {
            System.out.println("List of events:");
            for (Event event : eventsToPrint) {
                System.out.println(event);
            }
        } else {
            System.out.println("No events available.");
        }
    }
}
