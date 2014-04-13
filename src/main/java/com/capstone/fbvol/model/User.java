package com.capstone.fbvol.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by changmatthew on 2014. 3. 31..
 */
public class User {
    private int x;
    private int y;
    private String name;
    private String id;
    private int total_playtime;
    private int record_win;
    private int record_lose;

    ObjectMapper om = new ObjectMapper();

    public int getRecord_lose() {
        return record_lose;
    }

    public void setRecord_lose(int record_lose) {
        this.record_lose = record_lose;
    }

    public int getTotal_playtime() {
        return total_playtime;
    }

    public void setTotal_playtime(int total_playtime) {
        this.total_playtime = total_playtime;
    }

    public int getRecord_win() {
        return record_win;
    }

    public void setRecord_win(int record_win) {
        this.record_win = record_win;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFromJSON2(String jsonStr) {
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

            this.name = m.get("NAME");
            this.id = m.get("ID");
            this.x = Integer.parseInt(m.get("X"));
            this.y = Integer.parseInt(m.get("Y"));

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

    public void setMoveDataFromJson(String jsonStr){
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

            this.id = m.get("ID");
            this.x = Integer.parseInt(m.get("X"));
            this.y = Integer.parseInt(m.get("Y"));

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
