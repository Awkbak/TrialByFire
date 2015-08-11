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
 * @author Awkbak BR, Bobjersnior
 */
public class Team {
    
    private long teamId;
    private ArrayList<BanTuple> bans;
    private long baronKills;
    private long dominionVictoryScore;
    private long dragonKills;
    private boolean firstBaron;
    private boolean firstBlood;
    private boolean firstDragon;
    private boolean firstInhibitor;
    private boolean firstTower;
    private long inhibitorKills;
    private long towerKills;
    private long vilemawKills;
    private boolean winner;
    
    public Team(){
        bans = new ArrayList<>();        
    }
    
    public Team(JSONObject obj){
        //Initialize ArrayLists
        bans = new ArrayList<>();
        
        //ints
        teamId = (long) obj.get("teamId");
        baronKills = (long) obj.get("baronKills");
        dominionVictoryScore = (long) obj.get("dominionVictoryScore");       
        dragonKills = (long) obj.get("dragonKills");
        inhibitorKills = (long) obj.get("inhibitorKills");
        towerKills = (long) obj.get("towerKills");
        vilemawKills = (long) obj.get("vilemawKills");
        //booleans
        winner = (boolean) obj.get("winner");
        firstBaron = (boolean) obj.get("firstBaron");
        firstBlood = (boolean) obj.get("firstBlood");
        firstDragon = (boolean) obj.get("firstDragon");
        firstInhibitor = (boolean) obj.get("firstInhibitor");
        firstTower = (boolean) obj.get("firstTower");
        //arrays
        JSONArray arr = (JSONArray) obj.get("bans");
        arr.stream().forEach((arr1) -> {
            bans.add(new BanTuple((JSONObject) arr1));
        });
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public ArrayList<BanTuple> getBans() {
        return bans;
    }

    public void setBans(ArrayList<BanTuple> bans) {
        this.bans = bans;
    }

    public long getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(long baronKills) {
        this.baronKills = baronKills;
    }

    public long getDominionVictoryScore() {
        return dominionVictoryScore;
    }

    public void setDominionVictoryScore(long dominionVictoryScore) {
        this.dominionVictoryScore = dominionVictoryScore;
    }

    public long getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(long dragonKills) {
        this.dragonKills = dragonKills;
    }

    public boolean isFirstBaron() {
        return firstBaron;
    }

    public void setFirstBaron(boolean firstBaron) {
        this.firstBaron = firstBaron;
    }

    public boolean isFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood(boolean firstBlood) {
        this.firstBlood = firstBlood;
    }

    public boolean isFirstDragon() {
        return firstDragon;
    }

    public void setFirstDragon(boolean firstDragon) {
        this.firstDragon = firstDragon;
    }

    public boolean isFirstInhibitor() {
        return firstInhibitor;
    }

    public void setFirstInhibitor(boolean firstInhibitor) {
        this.firstInhibitor = firstInhibitor;
    }

    public boolean isFirstTower() {
        return firstTower;
    }

    public void setFirstTower(boolean firstTower) {
        this.firstTower = firstTower;
    }

    public long getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(long inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public long getTowerKills() {
        return towerKills;
    }

    public void setTowerKills(long towerKills) {
        this.towerKills = towerKills;
    }

    public long getVilemawKills() {
        return vilemawKills;
    }

    public void setVilemawKills(long vilemawKills) {
        this.vilemawKills = vilemawKills;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
    
    public void addBan(BanTuple ban){
        bans.add(ban);
    }
}
