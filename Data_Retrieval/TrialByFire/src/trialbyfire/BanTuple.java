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
 * Gets the championIDs and the turn they were picked from the JSON object
 * @author Awkbak BR, Bobjrsenior
 */
public class BanTuple {
    private final long championId;
    private final long pickTurn;

    /**
     * Constructor using the JSON Object.
     * @param obj 
     */
    public BanTuple(JSONObject obj){
        championId = (long) obj.get("championId");
        pickTurn = (long) obj.get("pickTurn");
    }

    public long getChampionId() {
        return championId;
    }

    public long getPickTurn() {
        return pickTurn;
    }
}
