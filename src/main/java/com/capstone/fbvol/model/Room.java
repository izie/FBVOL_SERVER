package com.capstone.fbvol.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: SangTaeLee
 * Date: 14. 4. 4
 * Time: 오후 2:49
 * To change this template use File | Settings | File Templates.
 */
public class Room {

    private String master;
    private String rival;
    private String master_isReady;
    private String rival_isReady;

    private ArrayList<String> observers;
    private String room_id;
    private String room_title;
    private String isLock;
    private String password;
    private String runningTime;
    private String isPlaying; // waiting or playing

    ObjectMapper om = new ObjectMapper();

    public void setRoomFromJSON2(String jsonStr) {
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

            this.master = m.get("MASTER"); //token 값으로 사용
            this.room_id = m.get("ROOM_ID");   // 고유값
            this.room_title = m.get("ROOM_TITLE");

            this.isLock = m.get("ISLOCK");
            this.password = m.get("PASSWORD");

            this.runningTime = m.get("TIME");        //플레이시간

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void joinRoomFromJSON2(String jsonStr) { //{"GUEST": RIVAL or OBSERVER , "TOKEN":토큰값 }   guest
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

            if(m.get("GUEST").equals("RIVAL") ){
                this.rival = m.get("RIVAL"); //token 값 사용
            }
            else{
                this.observers.add(m.get("OBSERVER")); //token 값 사용
            }
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void ReadyFromJSON2(String jsonStr) {         // {"TOKEN" : 토큰값 ,  "ISREADY": TRUE or FALSE}
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

            if(this.master.equals(m.get("TOKEN")))
                    master_isReady = m.get("ISREADY");
            else
                rival_isReady = m.get("ISREADY");


            if( master_isReady.equals("TRUE") && rival_isReady.equals("TRUE")){
                isPlaying = "TRUE";
                master_isReady = "FALSE";
                rival_isReady = "FALSE";
            }


        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
