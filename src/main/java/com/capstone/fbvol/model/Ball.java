package com.capstone.fbvol.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: SangTaeLee
 * Date: 14. 4. 4
 * Time: 오후 3:12
 * To change this template use File | Settings | File Templates.
 */
public class Ball {
    private int x;
    private int y;

    ObjectMapper om = new ObjectMapper();

    public void setMoveDataFromJson(String jsonStr){
        HashMap<String, String> m;
        try {
            m = om.readValue(jsonStr, new TypeReference<HashMap<String, String>>(){});

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
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
