/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialbyfire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author user
 */
public class TrialByFire {

    public static boolean calling_API;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GetMatchInfo match = new GetMatchInfo("1907183118");
        Thread th = new Thread(match);
        th.start();
    }
    
   /**
    * Takes a match and extracts useful information
    * @param match LoL match to be handled
    */
    public static void HandleMatch(Match match){
        //Get mercanary buys for each team
        int[] mercanaryCount = new int[8];
        int winner = -1;
        winner = match.getTeams().get(0).isWinner() ? 1 : 2;
        ArrayList<Frame> frames = match.getTimeline().getFrames();
        for(Frame frame : frames){
            ArrayList<Event> events = frame.getEvents();
            for(Event event : events){
                if(event.getEventType().equals("ITEM_PURCHASED")){
                    if(event.getItemId() == 3612){
                        if(event.getParticipantId() < 6){
                            mercanaryCount[0] ++;
                        }
                        else{
                            mercanaryCount[4] ++;
                        }
                    }
                    else if(event.getItemId() == 3611){
                        if(event.getParticipantId() < 6){
                            mercanaryCount[1] ++;
                        }
                        else{
                            mercanaryCount[5] ++;
                        }
                    }
                    else if(event.getItemId() == 3613){
                        if(event.getParticipantId() < 6){
                            mercanaryCount[2] ++;
                        }
                        else{
                            mercanaryCount[6] ++;
                        }
                    }
                    else if(event.getItemId() == 3614){
                        if(event.getParticipantId() < 6){
                            mercanaryCount[3] ++;
                        }
                        else{
                            mercanaryCount[7] ++;
                        }
                    }
                }
            }
        }
        
        System.out.println("START_MATCH");
        System.out.println("MATCH_ID " + match.getMatchId());
        System.out.println("START_TEAM_1");
        System.out.println("WIN " + ((winner== 1) ? 1 : 0));
        System.out.printf("IRONBACK %d\nRAZORFIN %d\nPLUNDERCRAB %d\nOCKLEPOD %d\n", mercanaryCount[0], mercanaryCount[1], mercanaryCount[2], mercanaryCount[3]);
        System.out.println("END_TEAM_1");
        System.out.println("START_TEAM_2");
        System.out.println("WIN " + ((winner== 2) ? 1 : 0));
        System.out.printf("IRONBACK %d\nRAZORFIN %d\nPLUNDERCRAB %d\nOCKLEPOD %d\n", mercanaryCount[4], mercanaryCount[5], mercanaryCount[6], mercanaryCount[7]);
        System.out.println("END_TEAM_2");
        System.out.println("END_MATCH");
    }
    
     static class GetMatchInfo implements Runnable{
        
        /**
         * URL to retrieve information from
        */
        public URL url;
        
        /**
         * @param matchId The Match ID to retrieve the Match Info from
         */
        public GetMatchInfo(String matchId){
            try {
                this.url = new URL("https://na.api.pvp.net/api/lol/na/v2.2/match/" + matchId + "?includeTimeline=true&api_key=" + ApiKey.API_KEY);
            } catch (MalformedURLException ex) {
                    
            }
        }
        
        /**
         * Retrieves and Parses a Match from the Riot API
         * Uses url declared from the constructor
         */
        @Override
        public void run() {
            calling_API = true;
            HttpsURLConnection con = null;
            try {
                //Open the connection
                con = (HttpsURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();
                int statusCode = con.getResponseCode();
                
                if(statusCode == HttpsURLConnection.HTTP_OK){
                    //Read in the result into a StringBuilder
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                            sb.append(line);
                    }
                    //Call callback on main (JavaFX) thread
                    HandleMatch(JSONUtils.MatchParser.parseMatch(sb.toString()));
                }
            } catch (IOException e) {
                //If it fails (no internet connet/bad id, ect)
                calling_API = false;
                         
            }
            finally{
                //Make sure to disconnect when done
                if(con != null){
                    con.disconnect();
                }
            }
        }
    }    
}


