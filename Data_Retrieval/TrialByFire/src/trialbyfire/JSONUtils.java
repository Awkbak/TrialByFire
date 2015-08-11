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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Used in order to Parse JSON files into Java Objects
 * @author Awkbak BR, Bobjrsenior
 */
public class JSONUtils {

    /**
     * Used to Parse an input string into a Match
     */
    public static class MatchParser{
        /**
         * Parses JSON into a Match object
         * @param in JSON to convert into a Match
         * @return A Match Object containing the data from the in param
         */
        public static Match parseMatch(String in){
            try {
                JSONObject obj = (JSONObject) new JSONParser().parse(in);
                return new Match(obj); //Match and its inner classes all have a constructor for a JSONObject
                //return new Match(obj);
            } catch (ParseException ex) {
                Logger.getLogger(JSONUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return null;
        }
        /**
         * Parses an array in String form into an ArrayList
         * @param in String containing the array of ids
         * @return ArrayList containing the ids from the in param
         */
        public static ArrayList<Long> parseIds(String in){
            ArrayList<Long> ids = new ArrayList<>();
            //Split the returned (non-json) list into just spaces and longs
            String[] arr = in.split("[ |,|\n|\\[|\\]]"); //Split by ' ', '\n', '[', ']'
            //Add all longs into the ids ArrayList
            for(String e : arr){
                if(e.length() > 0){ //Make sure not to add spaces to the list
                    ids.add(new Long(e));
                }
            }
            return ids;
            
        }
    }
}
