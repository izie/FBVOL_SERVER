package com.capstone.fbvol.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: SangTaeLee
 * Date: 14. 4. 13
 * Time: 오후 10:20
 * To change this template use File | Settings | File Templates.
 */
public class Channel {
    private ArrayList<Room> rooms;
    private int channelNum;

    public int getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(int channelNum) {
        this.channelNum = channelNum;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void createNewRoom(){

    }


}
