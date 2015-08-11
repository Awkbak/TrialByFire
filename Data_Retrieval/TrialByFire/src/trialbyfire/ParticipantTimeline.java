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
public class ParticipantTimeline {
    
    private String lane;
    private String role;
    private ParticipantTimelineTuple creepsPerMinDeltas;
    private ParticipantTimelineTuple csDiffPerMinDeltas;
    private ParticipantTimelineTuple damageTakenDiffPerMinDeltas;
    private ParticipantTimelineTuple damageTakenPerMinDeltas;
    private ParticipantTimelineTuple goldPerMinDeltas;
    private ParticipantTimelineTuple xpDiffPerMinDeltas;
    private ParticipantTimelineTuple xpPerMinDeltas;
    
    public ParticipantTimeline(){
        
    }
    
    public ParticipantTimeline(JSONObject obj){
        //Strings
        lane = (String) obj.get("lane");
        role = (String) obj.get("role");
        //Objects
        if(obj.containsKey("creepsPerMinDeltas")){
            creepsPerMinDeltas = new ParticipantTimelineTuple((JSONObject) obj.get("creepsPerMinDeltas"));
        }
        if(obj.containsKey("csDiffPerMinDeltas")){
            csDiffPerMinDeltas = new ParticipantTimelineTuple((JSONObject) obj.get("csDiffPerMinDeltas"));
        }
        if(obj.containsKey("damageTakenDiffPerMinDeltas")){
            damageTakenDiffPerMinDeltas = new ParticipantTimelineTuple((JSONObject) obj.get("damageTakenDiffPerMinDeltas"));
        }
        if(obj.containsKey("damageTakenPerMinDeltas")){
            damageTakenPerMinDeltas = new ParticipantTimelineTuple((JSONObject) obj.get("damageTakenPerMinDeltas"));
        }
        if(obj.containsKey("goldPerMinDeltas")){
            goldPerMinDeltas = new ParticipantTimelineTuple((JSONObject) obj.get("goldPerMinDeltas"));
        }
        if(obj.containsKey("xpDiffPerMinDeltas")){
            xpDiffPerMinDeltas = new ParticipantTimelineTuple((JSONObject) obj.get("xpDiffPerMinDeltas"));
        }
        if(obj.containsKey("xpPerMinDeltas")){
            xpPerMinDeltas = new ParticipantTimelineTuple((JSONObject) obj.get("xpPerMinDeltas"));
        }
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ParticipantTimelineTuple getCreepsPerMinDeltas() {
        return creepsPerMinDeltas;
    }

    public void setCreepsPerMinDeltas(ParticipantTimelineTuple creepsPerMinDeltas) {
        this.creepsPerMinDeltas = creepsPerMinDeltas;
    }

    public ParticipantTimelineTuple getCsDiffPerMinDeltas() {
        return csDiffPerMinDeltas;
    }

    public void setCsDiffPerMinDeltas(ParticipantTimelineTuple csDiffPerMinDeltas) {
        this.csDiffPerMinDeltas = csDiffPerMinDeltas;
    }

    public ParticipantTimelineTuple getDamageTakenDiffPerMinDeltas() {
        return damageTakenDiffPerMinDeltas;
    }

    public void setDamageTakenDiffPerMinDeltas(ParticipantTimelineTuple damageTakenDiffPerMinDeltas) {
        this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
    }

    public ParticipantTimelineTuple getDamageTakenPerMinDeltas() {
        return damageTakenPerMinDeltas;
    }

    public void setDamageTakenPerMinDeltas(ParticipantTimelineTuple damageTakenPerMinDeltas) {
        this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
    }

    public ParticipantTimelineTuple getGoldPerMinDeltas() {
        return goldPerMinDeltas;
    }

    public void setGoldPerMinDeltas(ParticipantTimelineTuple goldPerMinDeltas) {
        this.goldPerMinDeltas = goldPerMinDeltas;
    }

    public ParticipantTimelineTuple getXpDiffPerMinDeltas() {
        return xpDiffPerMinDeltas;
    }

    public void setXpDiffPerMinDeltas(ParticipantTimelineTuple xpDiffPerMinDeltas) {
        this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
    }

    public ParticipantTimelineTuple getXpPerMinDeltas() {
        return xpPerMinDeltas;
    }

    public void setXpPerMinDeltas(ParticipantTimelineTuple xpPerMinDeltas) {
        this.xpPerMinDeltas = xpPerMinDeltas;
    }
    
    
    
}
