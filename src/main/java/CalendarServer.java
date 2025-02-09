import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * The CalendarServer class represents the server for the Calendar application.
 * It creates and initializes the Calendar implementation and binds it to the RMI registry.
 */
public class CalendarServer {

    /**
     * Constructor for CalendarServer.
     * It creates the remote object implementation and binds it to the RMI registry.
     */
    public CalendarServer() {
        try {
            // Create the remote object implementation
            CalendarInterface calendar = new CalendarImpl();

            // Ideally, you should create the registry within this program itself
            // Starting RMI registry on the default port of 1099
            Registry registry = LocateRegistry.getRegistry();

            // Bind the remote object's stub in the registry under the name "CalendarService"
            registry.rebind("CalendarService", calendar);

            // Print a status message indicating that the server is ready
            System.out.println("Calendar server is ready.");
        } catch (RemoteException re) {
            // Print an error message if there is an exception
            System.out.println("Exception in CalendarServer constructor: " + re);
        }
    }

    /**
     * The main method creates an instance of CalendarServer.
     *
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Create an instance of CalendarServer when the program is executed
        new CalendarServer();
    }
}
