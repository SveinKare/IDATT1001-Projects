/**
 * This class represents an event, with attributes containing information about the event. 
 */
public class Event{
    private String name;
    private int number;
    private String location;
    private String organizer;
    private String type;
    private double timeAndDate;

    /**
     * Constructor for the event class. 
     * 
     * @param name (String) Name of the event
     * @param number (int) A unique number used to differentiate the events. 
     * @param location (String) The location of the event.
     * @param organizer (String) The individual/organization behind the event. 
     * @param type (String) What type of event it is. 
     * @param timeAndDate (double) The time and date of the event. Given in the format YYYYMMDDTTTT (year, month, date, time)
     */
    Event(String name, int number, String location, String organizer, String type, double timeAndDate){
        this.number = number;
        this.name = name;
        this.location = location;
        this.organizer = organizer;
        this.type = type;
        this.timeAndDate = timeAndDate;
    }

    /**
     * Get-method for the name attribute
     * 
     * @return name (String)
     */
    String getName(){
        return name;
    }

    /**
     * Get-method for number
     * 
     * @return number (int)
     */
    int getNumber(){
        return number;
    }

    /**
     * Get-method for location
     * 
     * @return location (String)
     */
    String getLocation(){
        return location;
    }

    /**
     * Get-method for organizer
     * 
     * @return organizer (String)
     */
    String getOrganizer(){
        return organizer;
    }

    /**
     * Get-method for type
     * 
     * @return type (String)
     */
    String getType(){
        return type;
    }

    /**
     * Get-method for timeAndDate
     * 
     * @return timeAndDate (double)
     */
    double getTimeAndPlace(){
        return timeAndDate;
    }

    /**
     * To-string method. Returns a string with all the info for the event listed on separate lines. 
     */
    @Override
    public String toString() {
        String parsed = String.format("%.1f", timeAndDate);
        String timeAndDateFormatted = 
            parsed.substring(0,4) + "/" +
            parsed.substring(4, 6) + "/" +
            parsed.substring(6,8) + " " +
            parsed.substring(8,10) + ":" +
            parsed.substring(10, 12);

        return String.format(
            "Name: %s \nNumber: %d \nLocation: %s \nOrganizer: %s \nType: %s \nTime and date: %s", 
            name, number, location, organizer, type, timeAndDateFormatted);
    }
}