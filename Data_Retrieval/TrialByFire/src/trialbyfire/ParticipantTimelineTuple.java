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
public class ParticipantTimelineTuple {
    private double tenToTwenty;
    private double zeroToTen;
    
    public ParticipantTimelineTuple(){
        
    }
    
    public ParticipantTimelineTuple(JSONObject obj){
        //doubles
        if(obj.containsKey("tenToTwenty")){
            tenToTwenty = (double) obj.get("tenToTwenty");
        }
        if(obj.containsKey("zeroToTen")){
            zeroToTen = (double) obj.get("zeroToTen");
        }
    }

    public double getTenToTwenty() {
        return tenToTwenty;
    }

    public void setTenToTwenty(double tenToTwenty) {
        this.tenToTwenty = tenToTwenty;
    }

    public double getZeroToTen() {
        return zeroToTen;
    }

    public void setZeroToTen(double zeroToTen) {
        this.zeroToTen = zeroToTen;
    }
    
    
}
