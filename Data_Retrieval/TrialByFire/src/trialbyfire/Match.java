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
 * Holds all of the data for a particular League Match
 * @author Awkbak BR, Bobjrsenior
 */
public class Match {
    private long mapId;
    private long matchCreation;
    private long matchDuration;
    private long matchId;
    private String matchMode;
    private String matchType;
    private String matchVersion;
    private ArrayList<Participant> participants;
    private String platformId;
    private String queueType;
    private String region;
    private String season;
    private ArrayList<Team> teams;
    private MatchTimeline timeline;
   
    public Match(){
        //Initialize ArrayLists
        teams = new ArrayList<>();
        participants = new ArrayList<>();
    }
    
    /**
     * Receives a JSONObject containing all Match Information and Parses it
     * By initializing the Match class variables and calling
     * The JSONObject Constructor on all linked classes
     * @param obj The JSONObject containing Match Data
     */
    public Match(JSONObject obj){
        //Initialize ArrayLists
        teams = new ArrayList<>();
        participants = new ArrayList<>();
        //longs
        matchDuration = (long) obj.get("matchDuration");
        mapId = (long) obj.get("mapId");
        matchCreation = (long) obj.get("matchCreation");
        matchId = (long) obj.get("matchId");
        //String
        matchMode = (String) obj.get("matchMode");
        matchType = (String) obj.get("matchType");
        matchVersion = (String) obj.get("matchVersion");
        platformId = (String) obj.get("platformId");
        queueType = (String) obj.get("queueType");
        region = (String) obj.get("region");
        season = (String) obj.get("season");
        //Objects
        timeline = new MatchTimeline((JSONObject) obj.get("timeline"));
        //Arrays
        JSONArray arr = (JSONArray) obj.get("participants");
        for (Object arr1 : arr) {
            participants.add(new Participant((JSONObject) arr1));
        }
        
        arr = (JSONArray) obj.get("teams");
        for (Object arr1 : arr) {
            teams.add(new Team((JSONObject) arr1));
        }
    }
    
    /**
     * Retrieve all events in the match
     * @return An ArrayList of every Event in the match 
     */
    public ArrayList<Event> getEventList(){
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Frame> frames = timeline.getFrames();
        frames.stream().forEach((frame) -> {
            events.addAll(frame.getEvents());
        });
        return events;
    }
    
    /**
     * Returns the Champion Id associated with a particular summoner
     * @param participantId The participantId of the 
     * @return The Champion Id of the summoners champion
     */
    public int getChampionId(int participantId){
        return (int) participants.get(participantId).getChampionId();
    }
    
    /**
     * Retrieves the champion id of all champions in the match
     * @return An ArrayLIst of champion Ids index corresponds to the Summoners in Participants list
     */
    public ArrayList<Integer> getChampionIds(){
        ArrayList<Integer> ids = new ArrayList<>();
        participants.stream().forEach((e) -> {
            ids.add((int) e.getChampionId());
        });
        return ids;
    }

    
    //Getters and Setters
    public long getMapId() {
        return mapId;
    }

    public void setMapId(long mapId) {
        this.mapId = mapId;
    }

    public long getMatchCreation() {
        return matchCreation;
    }

    public void setMatchCreation(long matchCreation) {
        this.matchCreation = matchCreation;
    }

    public long getMatchDuration() {
        return matchDuration;
    }

    public void setMatchDuration(long matchDuration) {
        this.matchDuration = matchDuration;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchVersion() {
        return matchVersion;
    }

    public void setMatchVersion(String matchVersion) {
        this.matchVersion = matchVersion;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public MatchTimeline getTimeline() {
        return timeline;
    }

    public void setTimeline(MatchTimeline timeline) {
        this.timeline = timeline;
    }
    
    public void addParticipant(Participant participant){
        participants.add(participant);
    }
    
    public void addTeam(Team team){
        teams.add(team);
    }
}
