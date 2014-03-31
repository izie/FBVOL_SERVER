package com.capstone.fbvol.controller;

import com.capstone.fbvol.model.*;
import com.capstone.fbvol.model.Character;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/Character/")
public class CharacterController {
    ArrayList<Character> users = new ArrayList<Character>();

    @RequestMapping(value = "Init", method = RequestMethod.GET)
    public @ResponseBody Msg setDefault() {
        Msg msg = new Msg("1000","Done");
        Character user = new Character();

        user.setX(100);
        user.setY(100);
        user.setName("Matthew");
        user.setId("izie");
        users.add(user);

        Character user2 = new Character();

        user2.setX(100);
        user2.setY(100);
        user2.setName("SangTae");
        user2.setId("prugio");
        users.add(user2);

        return msg;
    }

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Character> getUser() {

        return users;
    }

    @RequestMapping(value = "Move/{Query}", method = RequestMethod.GET)
    public @ResponseBody Msg setCharacterXYInJSON(@PathVariable String Query) {
        int flag = 0;
        Character tchr = new Character();
        Msg msg = new Msg("1000","Done");
        tchr.setMoveDataFromJson(Query);
        Iterator<Character> itr = users.iterator();
        while (itr.hasNext()) {
            Character element = itr.next();
            if(element.getId().equals(tchr.getId())){
                flag = 1;
                element.setX(tchr.getX());
                element.setY(tchr.getY());
            }
        }

        if(flag == 0){
            msg.setMsg("Error!!");
        }

        return msg;
    }

}