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
public class Position {
    private long x;
    private long y;
    
    public Position(long x, long y){
        this.y = x;
        this.y = y;
    }
    
    public Position(){
        
    }
    
    public Position(JSONObject obj){
        //ints
        x = (long) obj.get("x");
        y = (long) obj.get("y");
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
    
    
}
