package com.capstone.fbvol.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: SangTaeLee
 * Date: 14. 4. 13
 * Time: 오후 9:15
 * To change this template use File | Settings | File Templates.
 */
public class Robby {
    private ArrayList<Room> play_rooms;
    private ArrayList<Character> friends_activities;
    private Character my_info;


    public ArrayList<Room> getPlay_rooms() {
        return play_rooms;
    }

    public void setPlay_rooms(ArrayList<Room> play_rooms) {
        this.play_rooms = play_rooms;
    }

    public ArrayList<Character> getFriends_activities() {
        return friends_activities;
    }

    public void setFriends_activities(ArrayList<Character> friends_activities) {
        this.friends_activities = friends_activities;
    }

    public Character getMy_info() {
        return my_info;
    }

    public void setMy_info(Character my_info) {
        this.my_info = my_info;
    }
}
