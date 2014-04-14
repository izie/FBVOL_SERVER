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

    private User master;
    private User rival;
    private ArrayList<User> observers;
    private String room_id;
    private String room_title;
    private boolean isLock;
    private String password;
    private int runningTime;
    private boolean roomState; // waiting or playing


    ObjectMapper om = new ObjectMapper();

    public void setFromJSON2(String jsonStr) {
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

            //this.master.setFromJSON2(m.get("MASTER"));
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
            User observer = new User();
            //observer.setFromJSON2(m.get("OBSERVER"));
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
            //rival.setFromJSON2(m.get("RIVAL"));

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
    public boolean isRoomState() {
        return roomState;
    }

    public void setRoomState(boolean roomState) {
        this.roomState = roomState;
    }
    public User getRival() {
        return rival;
    }

    public void setRival(User rival) {
        this.rival = rival;
    }
    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public ArrayList<User> getObserver() {
        return observers;
    }

    public void setObserver(ArrayList<User> observer) {
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

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

}
