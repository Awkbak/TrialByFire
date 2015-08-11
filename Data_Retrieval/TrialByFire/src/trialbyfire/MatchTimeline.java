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
public class MatchTimeline {
    
    private long frameInterval;
    private ArrayList<Frame> frames;
    
    public MatchTimeline(){
        frames = new ArrayList<>();
    }
    
    public MatchTimeline(JSONObject obj){
        //Initializing ArrayLists
        frames = new ArrayList<>();
        //ints
        frameInterval = (long) obj.get("frameInterval");
        //Arrays
        JSONArray arr = (JSONArray) obj.get("frames");
        arr.stream().forEach((arr1) -> {
            frames.add(new Frame((JSONObject) arr1));
        });
    }

    public long getFrameInterval() {
        return frameInterval;
    }

    public void setFrameInterval(long frameInterval) {
        this.frameInterval = frameInterval;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }

    public void setFrames(ArrayList<Frame> frames) {
        this.frames = frames;
    }  
    
    public void addFrame(Frame frame){
        frames.add(frame);
    }
}
