import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The Event class represents an event in the calendar.
 * It implements the Serializable interface to allow objects to be serialized for RMI communication.
 */
public class Event implements Serializable {

    // serialVersionUID is required for Serializable classes and should not change across different versions
    private static final long serialVersionUID = 1L;

    private String name;            // Name of the event
    private LocalDateTime dateTime; // Date and time of the event
    private int durationMinutes;    // Duration of event in minutes
    private String type;            // Type of the event (e.g., meeting, birthday)
    private String description;     // Description of the event
    private String location;        // Location of the event

    /**
     * Constructor to initialize the Event object.
     *
     * @param name            Name of the event
     * @param dateTime        Date and time of the event
     * @param durationMinutes Duration of event in minutes
     * @param type            Type of the event (e.g., meeting, birthday)
     * @param description     Description of the event
     * @param location        Location of the event
     */
    public Event(String name, LocalDateTime dateTime, int durationMinutes, String type, String description, String location) {
        this.name = name;
        this.dateTime = dateTime;
        this.durationMinutes = durationMinutes;
        this.type = type;
        this.description = description;
        this.location = location;
    }

    /**
     * Getter for the name of the event.
     *
     * @return Name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the date and time of the event.
     *
     * @return Date and time of the event
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Getter for the duration of the event in minutes.
     *
     * @return Duration of the event in minutes
     */
    public int getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Getter for the type of the event.
     *
     * @return Type of the event
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for the description of the event.
     *
     * @return Description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the location of the event.
     *
     * @return Location of the event
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for the name of the event.
     *
     * @param name New name for the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the date and time of the event.
     *
     * @param dateTime New date and time for the event
     */
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Setter for the duration of the event in minutes.
     *
     * @param durationMinutes New duration for the event in minutes
     */
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    /**
     * Setter for the type of the event.
     *
     * @param type New type for the event
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Setter for the description of the event.
     *
     * @param description New description for the event
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for the location of the event.
     *
     * @param location New location for the event
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * toString method for displaying event details.
     *
     * @return A string representation of the event
     */
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", durationMinutes=" + durationMinutes +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

}
