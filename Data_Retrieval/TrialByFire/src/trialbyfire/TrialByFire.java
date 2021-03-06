/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialbyfire;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author user
 */
public class TrialByFire {

    public static boolean calling_API;
    public static int totalMatches = 0;
    public static int totalKrakensSpent = 0;
    public static int totalKrakensSpentWinner = 0;
    public static int totalKrakensSpentLoser = 0;
    public static double averageKrakensSpent = 0;
    public static double averageKrakensSpentWinner = 0;
    public static double averageKrakensSpentLoser = 0;
    public static final String regions[] = {"euw", "kr", "lan", "las", "oce", "ru", "tr"};
    public static String currentRegion;
    public static PrintWriter writer;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //GetMatchInfo match = new GetMatchInfo("1907183118");
        
        for(String region : regions){
            currentRegion = region;
            System.out.println(region);
            String fileName = currentRegion.toUpperCase() + ".json";
            BufferedReader reader = null;
            try {
                writer = new PrintWriter("DATA" + currentRegion.toUpperCase() + ".data", "UTF-8");
                reader = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = reader.readLine()) != null){
                    if(!line.equals("[") && !line.equals("]")){
                        line = line.replaceAll(",| ", "");
                        GetMatchInfo match = new GetMatchInfo(line);
                        Thread th = new Thread(match);
                        th.start();
                        while(th.isAlive()){}
                    }
                }
            } catch (FileNotFoundException ex) {
                //Logger.getLogger(TrialByFire.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("File Not Found");
                System.exit(0);
            } catch (IOException ex) {
                //Logger.getLogger(TrialByFire.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("IO Exception");
                System.exit(0);
            }
            finally{
                if(reader != null){
                    try {
                        reader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(TrialByFire.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            averageKrakensSpent = ((double) totalKrakensSpent) / totalMatches;
            averageKrakensSpentWinner = ((double) totalKrakensSpentWinner) / totalMatches;
            averageKrakensSpentLoser = ((double) totalKrakensSpentLoser) / totalMatches;
            writer.printf("TS %d\nTSW %d\nTSL %d\n", totalKrakensSpent, totalKrakensSpentWinner, totalKrakensSpentLoser);
            writer.printf("AS %f\nASW %f\nASL %f\n", averageKrakensSpent, averageKrakensSpentWinner, averageKrakensSpentLoser);
            writer.close();
        }
    }
    
   /**
    * Takes a match and extracts useful information
    * @param match LoL match to be handled
    */
    public static void HandleMatch(Match match){
        //Get mercanary buys for each team
        int[] mercanaryCount = new int[8];
        int[] spentKrakens = new int[2];
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
                            spentKrakens[0] += 5;
                        }
                        else{
                            mercanaryCount[4] ++;
                            spentKrakens[1] += 5;
                        }
                    }
                    else if(event.getItemId() == 3611){
                        if(event.getParticipantId() < 6){
                            mercanaryCount[1] ++;
                            spentKrakens[0] += 5;
                        }
                        else{
                            mercanaryCount[5] ++;
                            spentKrakens[1] += 5;
                        }
                    }
                    else if(event.getItemId() == 3613){
                        if(event.getParticipantId() < 6){
                            mercanaryCount[2] ++;
                            spentKrakens[0] += 5;
                        }
                        else{
                            mercanaryCount[6] ++;
                            spentKrakens[1] += 5;
                        }
                    }
                    else if(event.getItemId() == 3614){
                        if(event.getParticipantId() < 6){
                            mercanaryCount[3] ++;
                            spentKrakens[0] += 5;
                        }
                        else{
                            mercanaryCount[7] ++;
                            spentKrakens[1] += 5;
                        }
                    }
                    else if(event.getItemId() == 3615){
                        if(event.getParticipantId() < 6){
                            spentKrakens[0] += 5;
                        }
                        else{
                            spentKrakens[1] += 5;
                        }
                    }
                    else if(event.getItemId() == 3616){
                        if(event.getParticipantId() < 6){
                           spentKrakens[0] += 10;
                        }
                        else{
                            spentKrakens[1] += 10;
                        }
                    }
                    else if(event.getItemId() == 3617){
                        if(event.getParticipantId() < 6){
                            spentKrakens[0] += 20;
                        }
                        else{
                            spentKrakens[1] += 20;
                        }
                    }
                }
            }
        }
        totalKrakensSpent += spentKrakens[0] + spentKrakens[1];
        totalKrakensSpentWinner += ((winner== 1) ? spentKrakens[0] : spentKrakens[1]);
        totalKrakensSpentLoser += ((winner== 2) ? spentKrakens[0] : spentKrakens[1]);
        /*System.out.println("SM");
        System.out.println("MID " + match.getMatchId());
        System.out.println("S1");
        System.out.printf("I %d\nR %d\nP %d\nO %d\n", mercanaryCount[0], mercanaryCount[1], mercanaryCount[2], mercanaryCount[3]);
        System.out.println("WIN " + ((winner== 1) ? 1 : 0));
        System.out.println("ET");
        System.out.println("S2");
        System.out.printf("I %d\nR %d\nP %d\nO %d\n", mercanaryCount[4], mercanaryCount[5], mercanaryCount[6], mercanaryCount[7]);
        System.out.println("WIN " + ((winner== 2) ? 1 : 0));
        System.out.println("ET");
        System.out.println("EM");
        */
        writer.printf("%d%d%d%d", mercanaryCount[0], mercanaryCount[1], mercanaryCount[2], mercanaryCount[3]);
        writer.printf("%d%d%d%d", mercanaryCount[4], mercanaryCount[5], mercanaryCount[6], mercanaryCount[7]);
        writer.println(((winner== 1) ? 1 : 2));        
        totalMatches += 1;
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
                this.url = new URL("https://na.api.pvp.net/api/lol/" + currentRegion + "/v2.2/match/" + matchId + "?includeTimeline=true&api_key=" + ApiKey.API_KEY);
            } catch (MalformedURLException ex) {
                    
            }
        }
        
        /**
         * Retrieves and Parses a Match from the Riot API
         * Uses url declared from the constructor
         */
        @Override
        public void run() {
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
                else if(statusCode == 429){
                    //Read in the result into a StringBuilder
                   con.disconnect();
                   System.out.println("Rate Limit Exceeded");
                   Thread.sleep(5000);
                   run();
                }
                else if(statusCode == 403){
                    //Read in the result into a StringBuilder
                   con.disconnect();
                   System.out.println("Black");
                   System.exit(0);
                }
            } catch (IOException e) {
                //If it fails (no internet connet/bad id, ect)
            } catch (InterruptedException ex) {
                Logger.getLogger(TrialByFire.class.getName()).log(Level.SEVERE, null, ex);
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


