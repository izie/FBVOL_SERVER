package com.capstone.fbvol.model;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: SangTaeLee
 * Date: 14. 4. 4
 * Time: 오후 2:49
 * To change this template use File | Settings | File Templates.
 */
public class Room {

    private Character master;
    private Character guest;
    private ArrayList<Character> observer;
    private int room_id;
    private String room_nmae;
    private boolean isLock;
    private String password;
    private int playtime;
    private int master_score;
    private int guest_score;

    public Character getMaster() {
        return master;
    }

    public void setMaster(Character master) {
        this.master = master;
    }

    public Character getGuest() {
        return guest;
    }

    public void setGuest(Character guest) {
        this.guest = guest;
    }

    public ArrayList<Character> getObserver() {
        return observer;
    }

    public void setObserver(ArrayList<Character> observer) {
        this.observer = observer;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_nmae() {
        return room_nmae;
    }

    public void setRoom_nmae(String room_nmae) {
        this.room_nmae = room_nmae;
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
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
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
