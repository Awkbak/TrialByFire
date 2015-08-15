/**©Awkbak BR, Bobjrsenior
 * º⌐⌐º
 * 
 * Trial By Fire
 * Goal:  
 * Description: 
 * 
 * Start Date: 8/11/2015
 * End Date: 
 */
package trialbyfire;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Awkbak BR, Bobjrsenior
 */
public class Frame {
    
    private ArrayList<Event> events;
    private ArrayList<ParticipantFrame> participantFrames;
    private long timeStamp;

    public Frame(){
        events = new ArrayList<>();
        //participantFrames = new ArrayList<>();
    }
    
    public Frame(JSONObject obj){
        //Initialize ArrayLists
        events = new ArrayList<>();
        //participantFrames = new ArrayList<>();
        
        //ints
        //timeStamp = (long) obj.get("timestamp");
        //Arrays
        
        JSONArray arr;// = (JSONArray) obj.get("participantFrames");
        /*JSONObject obj2 = (JSONObject) obj.get("participantFrames");
        //System.out.println("G: " + (arr == null));
        for(int e = 1; e <= 10; e ++){
            participantFrames.add(new ParticipantFrame((JSONObject) obj2.get(e + "")));
        }*/
        //for (Object arr1 : arr) {
        //    participantFrames.add(new ParticipantFrame((JSONObject) arr1));
        //}
        if(obj.containsKey("events"))
        {
            arr = (JSONArray) obj.get("events");
            arr.stream().forEach((arr1) -> {
                events.add(new Event((JSONObject) arr1));
            });
        }
    }
    
    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public ArrayList<ParticipantFrame> getParticipantFrames() {
        return participantFrames;
    }

    public void setParticipantFrames(ArrayList<ParticipantFrame> participantFrames) {
        this.participantFrames = participantFrames;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    public void addEvent(Event event){
        events.add(event);
    }
    
    public void addParticipantFrame(ParticipantFrame participantFrame){
        participantFrames.add(participantFrame);
    }
    
}
