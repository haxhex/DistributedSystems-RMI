import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.List;

/**
 * The client application for interacting with the remote calendar service.
 */
public class CalendarClient {

    /**
     * The main method that connects to the remote calendar service and performs sample tests.
     *
     * @param args Command-line arguments (host name of the server, if provided)
     */
    public static void main(String[] args) {
        // If the host is not provided as a command-line argument, set it to null
        String host = (args.length < 1) ? null : args[0];
        try {
            // Connect to the RMI Registry running on localhost and on the default port 1099
            Registry registry = LocateRegistry.getRegistry(host);

            // Lookup the remote object by name in the RMI registry and cast it to the CalendarInterface type
            CalendarInterface calendar = (CalendarInterface) registry.lookup("CalendarService");

            // Sample Test 1: Add an event
            Event event1 = new Event("Meeting", LocalDateTime.of(2023, 12, 5, 5, 30), 60, "Business", "Discuss project", "Office");
            calendar.addEvent(event1);

            // Sample Test 2: Try to add an event with the same name (should print an error message)
            Event duplicateEvent = new Event("Meeting", LocalDateTime.of(2023, 12, 6, 8, 30), 90, "Business", "Another discussion", "Coffee Shop");
            calendar.addEvent(duplicateEvent);

            // Sample Test 3: Add another event
            Event event2 = new Event("Conference", LocalDateTime.now().plusDays(1), 120, "Tech", "Annual tech conference", "Conference Hall");
            calendar.addEvent(event2);

            // Sample Test 4: Get events by name
            List<Event> eventsByName = calendar.getEventsByName("Meeting");
            System.out.println("Events with name 'Meeting': " + eventsByName);

            // Sample Test 5: Get events by type
            List<Event> eventsByType = calendar.getEventsByType("Tech");
            System.out.println("Events with type 'Tech': " + eventsByType);

            // Sample Test 6: Get events by date
            List<Event> eventsByDate = calendar.getEventsByDate(LocalDateTime.of(2023, 12, 5, 5, 30));
            System.out.println("Events on the specific day: " + eventsByDate);

            // Sample Test 7: Get events by location
            List<Event> eventsByLocation = calendar.getEventsByLocation("Conference Hall");
            System.out.println("Events at 'Conference Hall': " + eventsByLocation);
            Thread.sleep(5000);
            // Sample Test 8: Get events for a specific month
            List<Event> eventsForMonth = calendar.getEventsForMonth(2023, 12);
            System.out.println("Events for December 2023: " + eventsForMonth);

            // Sample Test 9: Remove the first added event
            calendar.removeEvent("Meeting");
            System.out.println("Event 'Meeting' removed.");

            // Print all events
            System.out.println("All events: ");
            System.out.println(calendar.getEvents());

        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}
