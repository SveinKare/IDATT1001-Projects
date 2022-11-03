import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
/**
 * This class creates a register of events. 
 */
public class EventRegister {
    private ArrayList<Event> eventRegister;

    public EventRegister(){
        eventRegister = new ArrayList<Event>();
    }

    /**
     * Method for registering a new event. Throws exception if the given number is already registered. 
     *  
     * @param name (String) Name of the event.
     * @param location (String) Place of the event.
     * @param organizer (String) The individual/organization behind the event. 
     * @param type (String) What type of event it is. 
     * @param timeAndDate (double) Time and date of the event. Given in the format YYYYMMDDTTTT (year, month, day, time).
     */
    public void regEvent(String name, String location, String organizer, String type, double timeAndDate){
        int number = eventRegister.size() + 1;
        eventRegister.add(new Event(name, number, location, organizer, type, timeAndDate));
    }
    
    /**
     * Method for finding all the events planned for a certain location. 
     * 
     * @param location (String) The location of the event. 
     * @return A string listing all the events taking location at the location given. 
     */
    public String eventsAtPlace(String location){
        String eventList = "";
        for(Event event:eventRegister){
            if(event.getLocation().equalsIgnoreCase(location)){
                eventList += "\n" + event + "\n";
            }
        }
        return eventList;
    }

    /**
     * Method for finding all the events taking location at a certain date. Sorts by time.
     * 
     * @param date (int) 
     * @return A string listing all the events taking location at a certain date. 
     */
    public String eventsOnDate(int date){
        String listOfEvents = "";
        ArrayList<Event> events = new ArrayList<>();

        for (Event event:eventRegister){
            double tempDate = event.getTimeAndPlace()/10000;
            if ((int)tempDate == date) {
                events.add(event);
            }
        }
        Collections.sort(events, new Comparator<Event>() {
            public int compare(Event a, Event b) {
                return (int)(a.getTimeAndPlace() - b.getTimeAndPlace());
            }
        });
        for (Event event:events) {
            listOfEvents += "\n" + event + "\n";
        }
        return listOfEvents;
    }

    /**
     * A method for finding all events in a certain timeframe. 
     * 
     * @param fromDate (int)
     * @param toDate (int)
     * @return A string listing all the events taking location, sorted by time. 
     */
    public String eventsFromToDate(int fromDate, int toDate) {
        String eventList = "";
        HashSet<Integer> dates = new HashSet<Integer>();

        for (Event event:eventRegister) {
            double tempDate = event.getTimeAndPlace()/10000;
            if (tempDate >= fromDate && tempDate <= toDate) {
                dates.add((int)tempDate);
            }
        }
        ArrayList<Integer> dateList = new ArrayList<Integer>(dates);
        Collections.sort(dateList);
        for (int date:dateList) {
            eventList += eventsOnDate(date);
        }
        return eventList;
    }

    /**
     * Method to list all events by location in alfabetical order. 
     * 
     * @return A string listing all the events. 
     */
    public String sortByLocation() {
        ArrayList<Event> tempList = new ArrayList<>(eventRegister);
        String eventList = "";
        Collections.sort(tempList, new Comparator<Event>(){
            public int compare(Event a, Event b) {
                return a.getLocation().toLowerCase().compareTo(b.getLocation().toLowerCase());
            }
        });
        for (Event event:tempList) {
            eventList += "\n" + event + "\n";
        }
        return eventList;
    }

    /**
     * Method to sort all events by type. 
     * 
     * @return A string listing all events by type in alfabetical order. 
     */
    public String sortByType() {
        ArrayList<Event> tempList = new ArrayList<>(eventRegister);
        String eventList = "";
        Collections.sort(tempList, new Comparator<Event>(){
            public int compare(Event a, Event b) {
                return a.getType().toLowerCase().compareTo(b.getType().toLowerCase());
            }
        });
        for (Event event:tempList) {
            eventList += "\n" + event + "\n";
        }
        return eventList;
    }

    /**
     * Method to sort all events by date and time. 
     * 
     * @return A string listing all the events sorted by time. 
     */
    public String sortByDate() {
        ArrayList<Event> tempList = new ArrayList<>(eventRegister);
        String eventList = "";
        Collections.sort(tempList, new Comparator<Event>(){
            public int compare(Event a, Event b) {
                return (int)(a.getTimeAndPlace() - b.getTimeAndPlace());
            }
        });
        for (Event event:tempList) {
            eventList += "\n" + event + "\n";
        }
        return eventList;
    }

    
}
