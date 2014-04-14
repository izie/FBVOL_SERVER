package com.capstone.fbvol.controller;

import com.capstone.fbvol.model.Character;
import com.capstone.fbvol.model.Msg;
import com.capstone.fbvol.model.User;
import com.capstone.fbvol.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping(value = "/User/")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    ArrayList<Character> users = new ArrayList<Character>();

    private final UserService userService;

    private final Map<DeferredResult<List<Character>>, Integer> userRequests =
            new ConcurrentHashMap<DeferredResult<List<Character>>, Integer>();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "Init", method = RequestMethod.GET)
    public @ResponseBody Msg setDefault() {
        Msg msg = new Msg("1000","Done");
        List<User> user3 = userService.getUsers();
        logger.debug("user 1's toke : "+user3.get(0).getToken());

        Character user = new Character();

        user.setX(100);
        user.setY(100);
        user.setName("Matthew");
        user.setId("izie");
        users.add(user);

        Character user2 = new Character();

        user2.setX(300);
        user2.setY(100);
        user2.setName("SangTae");
        user2.setId("prugio");
        users.add(user2);

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

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public void postUsers(@RequestParam String x, @RequestParam String y, @RequestParam String id) {
        Character chr = new Character();
        chr.setX(Integer.parseInt(x));
        chr.setY(Integer.parseInt(y));
        chr.setId(id);
        this.userService.setUsers(chr);

        // Update all chat requests as part of the POST request
        // See Redis branch for a more sophisticated, non-blocking approach

        for (Map.Entry<DeferredResult<List<Character>>, Integer> entry : this.userRequests.entrySet()) {
            List<Character> messages = this.userService.getUsers(entry.getValue());
            entry.getKey().setResult(messages);
        }
    }

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Character> getUser() {

        return users;
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