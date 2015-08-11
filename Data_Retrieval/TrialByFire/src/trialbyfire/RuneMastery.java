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
public class RuneMastery {
    private long id;
    private long rank;
    
    public RuneMastery(){
        
    }
    
    public RuneMastery(JSONObject obj, String type){
        //ints
        rank = (long) obj.get("rank");
        //Make surte to find the right variable (class controls Runes and Masteries)
        if(type.equals("Rune")){
            id = (long) obj.get("runeId");
        }
        else{
            id = (long) obj.get("masteryId");
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }
    
    
}
