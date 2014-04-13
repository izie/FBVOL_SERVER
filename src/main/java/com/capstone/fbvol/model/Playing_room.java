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
public class Playing_room {

    private Character master;
    private Character rival;
    private ArrayList<Character> observers;
    private String room_id;
    private String room_title;
    private boolean isLock;
    private String password;
    private int runningtime;
    private int master_score;
    private int guest_score;

    ObjectMapper om = new ObjectMapper();

    public void setFromJSON2(String jsonStr) {
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

            this.master.setFromJSON2(m.get("MASTER"));
            //this.isLock = m.get("ISLOCK");  // boolean
            this.room_id = m.get("ROOM_ID");
            this.room_title = m.get("ROOM_TITLE");
            this.password = m.get("PASSWORD");

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
    public void joinObserverFromJSON2(String jsonStr) {
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});
            Character observer = new Character();
            observer.setFromJSON2(m.get("OBSERVER"));
            this.observers.add(observer);

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
    public void joinRivalFromJSON2(String jsonStr) {
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});
            rival.setFromJSON2(m.get("RIVAL"));

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

    public Character getRival() {
        return rival;
    }

    public void setRival(Character rival) {
        this.rival = rival;
    }
    public Character getMaster() {
        return master;
    }

    public void setMaster(Character master) {
        this.master = master;
    }

    public ArrayList<Character> getObserver() {
        return observers;
    }

    public void setObserver(ArrayList<Character> observer) {
        this.observers = observer;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_title;
    }

    public void setRoom_name(String room_title) {
        this.room_title = room_title;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPlaytime() {
        return runningtime;
    }

    public void setPlaytime(int runningtime) {
        this.runningtime = runningtime;
    }

    public int getMaster_score() {
        return master_score;
    }

    public void setMaster_score(int master_score) {
        this.master_score = master_score;
    }

    public int getGuest_score() {
        return guest_score;
    }

    public void setGuest_score(int guest_score) {
        this.guest_score = guest_score;
    }



}
