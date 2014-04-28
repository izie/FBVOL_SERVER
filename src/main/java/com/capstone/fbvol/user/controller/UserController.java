package com.capstone.fbvol.user.controller;

/*
 * File : UserController.java
 * Description :
 *
 */

import com.capstone.fbvol.model.Msg;
import com.capstone.fbvol.model.User;
import com.capstone.fbvol.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping(value = "/User/")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    List<User> users = new ArrayList<User>();

    private final UserService userService;

    private final Map<DeferredResult<List<Character>>, Integer> userRequests =
            new ConcurrentHashMap<DeferredResult<List<Character>>, Integer>();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.users = userService.getUsers();

        // Test Data
        users.get(0).setX(100);
        users.get(0).setY(400);

        users.get(1).setX(600);
        users.get(1).setY(400);
    }

    @RequestMapping(value = "Init", method = RequestMethod.GET)
    public @ResponseBody Msg setDefault() {
        Msg msg = new Msg("1000","Done");

        // Test Data
        users.get(0).setX(100);
        users.get(0).setY(100);

        users.get(1).setX(300);
        users.get(1).setY(100);

        return msg;
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public DeferredResult<List<Character>> getMessages(@RequestParam int messageIndex) {

        final DeferredResult<List<Character>> deferredResult = new DeferredResult<List<Character>>(null, Collections.emptyList());
        this.userRequests.put(deferredResult, messageIndex);

        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                userRequests.remove(deferredResult);
            }
        });

        List<Character> messages = this.userService.getUsers(messageIndex);
        if (!messages.isEmpty()) {
            deferredResult.setResult(messages);
        }

        return deferredResult;
    }

    @RequestMapping(value = "printUser", method = RequestMethod.GET)
    public String printWelcome2(ModelMap model) {
        model.addAttribute("users", users);
        return "printUser";
    }

    @RequestMapping(value = "printUser", method = RequestMethod.POST)
    public String printWelcome3(ModelMap model) {
        model.addAttribute("users", users);
        return "printUser";
    }

    @RequestMapping(value = "Move/{Query}", method = RequestMethod.GET)
    public @ResponseBody Msg setCharacterXYInJSON(@PathVariable String Query) {
        int flag = 0;
        User tuser = new User();
        Msg msg = new Msg("1000","Done");
        tuser.setMoveDataFromJson(Query);
        for(User usr : users){
            if(usr.getId().equals(tuser.getId())){
                flag = 1;
                usr.setX(usr.getX() + tuser.getX());
                usr.setY(usr.getY() + tuser.getY());
            }
        }

        if(flag == 0){
            msg.setMsg("Error!!");
        }

        return msg;
    }
    @RequestMapping(value = "Move/Shoot/{Query}", method = RequestMethod.GET)  // query: ID,SHOOT
    public @ResponseBody Msg shootingBallJSON(@PathVariable String Query) {
        int flag = 0;
        User tuser = new User();
        Msg msg = new Msg("1000","Done");
        tuser.setShootingDataFromJson(Query);
        for(User usr : users){
            if(usr.getId().equals(tuser.getId())){
                flag = 1;
                usr.setShoot(tuser.getShoot());
            }
        }

        if(flag == 0){
            msg.setMsg("Error!!");
        }

        return msg;
    }
    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public @ResponseBody List<User> getUser() {
        //logger.info("UserController - getUser");
        return users;
    }
}