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
public class Participant {
    
    private long participantId;
    private long championId;
    private long teamId;
    private String highestTeir;
    private ArrayList<RuneMastery> masteries;
    private ArrayList<RuneMastery> runes;
    private long spell1Id;
    private long spell2Id;
    private ParticipantTimeline timeline;
    private Stats stats;
    
    
    public Participant(){
        masteries = new ArrayList<>();
        runes = new ArrayList<>();
    }

    public Participant(JSONObject obj){
        //Initialize ArrayLists
        masteries = new ArrayList<>();
        runes = new ArrayList<>();
        //ints
        participantId = (long) obj.get("participantId");
        championId = (long) obj.get("championId");
        teamId = (long) obj.get("teamId");
        spell1Id = (long) obj.get("spell1Id");
        spell2Id = (long) obj.get("spell2Id");
        //Objects
        timeline = new ParticipantTimeline((JSONObject) obj.get("timeline"));
        //Arrays
        JSONArray arr;
        if(obj.containsKey("masteries")){
            arr = (JSONArray) obj.get("masteries");
            for (Object arr1 : arr) {
                masteries.add(new RuneMastery((JSONObject) arr1, "Mastery"));
            }
        }
        if(obj.containsKey("runes")){
            arr = (JSONArray) obj.get("runes");
            for (Object arr1 : arr) {
                runes.add(new RuneMastery((JSONObject) arr1, "Rune"));
            }
        }
    }
    
    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String getHighestTeir() {
        return highestTeir;
    }

    public void setHighestTeir(String highestTeir) {
        this.highestTeir = highestTeir;
    }

    public ArrayList<RuneMastery> getMasteries() {
        return masteries;
    }

    public void setMasteries(ArrayList<RuneMastery> masteries) {
        this.masteries = masteries;
    }

    public ArrayList<RuneMastery> getRunes() {
        return runes;
    }

    public void setRunes(ArrayList<RuneMastery> runes) {
        this.runes = runes;
    }

    public long getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(long spell1Id) {
        this.spell1Id = spell1Id;
    }

    public long getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(long spell2Id) {
        this.spell2Id = spell2Id;
    }
    
    public void addMastery(RuneMastery mastery){
        masteries.add(mastery);
    }
    
    public void addRune(RuneMastery rune){
        runes.add(rune);
    }

    public ParticipantTimeline getTimeline() {
        return timeline;
    }

    public void setTimeline(ParticipantTimeline timeline) {
        this.timeline = timeline;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
    
    
}
