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

import org.json.simple.JSONObject;

/**
 *
 * @author Awkbak BR, Bobjrsenior
 */
public class ParticipantFrame {
    
    private long participantId;
    private long currentGold;
    private long dominionScore;
    private long jungleMinionsKilled;
    private long level;
    private long minionsKilled;
    private Position position;
    private long teamScore;
    private long totalGold;
    private long xp;
    
    public ParticipantFrame(){
        
    }
    
    public ParticipantFrame(JSONObject obj){
        //longs
        participantId = (long) obj.get("participantId");
        currentGold = (long) obj.get("currentGold");
        dominionScore = (long) obj.get("dominionScore");
        jungleMinionsKilled = (long) obj.get("jungleMinionsKilled");
        level = (long) obj.get("level");
        minionsKilled = (long) obj.get("minionsKilled");
        teamScore = (long) obj.get("teamScore");
        totalGold = (long) obj.get("totalGold");
        xp = (long) obj.get("xp");
        //Objects
        if(obj.containsKey("position")){
            position = new Position((JSONObject) obj.get("position"));
        }
       }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long ParticipantId) {
        this.participantId = ParticipantId;
    }

    public long getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(long currentGold) {
        this.currentGold = currentGold;
    }

    public long getDominionScore() {
        return dominionScore;
    }

    public void setDominionScore(long dominionScore) {
        this.dominionScore = dominionScore;
    }

    public long getJungleMinionsKilled() {
        return jungleMinionsKilled;
    }

    public void setJungleMinionsKilled(long jungleMinionsKilled) {
        this.jungleMinionsKilled = jungleMinionsKilled;
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }

    public long getMinionsKilled() {
        return minionsKilled;
    }

    public void setMinionsKilled(long minionsKilled) {
        this.minionsKilled = minionsKilled;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public long getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(long teamScore) {
        this.teamScore = teamScore;
    }

    public long getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(long totalGold) {
        this.totalGold = totalGold;
    }

    public long getXp() {
        return xp;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }
    
    
    
}
