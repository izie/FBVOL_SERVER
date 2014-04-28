package com.capstone.fbvol.game.controller;

/*
 * File : UserController.java
 * Description :
 *
 */

import com.capstone.fbvol.game.repository.GameRepository;
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
@RequestMapping(value = "/Game")
public class GameController {
    private static final Logger logger = LoggerFactory.getLogger(GameController.class);
    List<User> users = new ArrayList<User>();

    private final UserService userService;

    private final GameRepository gameRepository;

    @Autowired
    public GameController(UserService userService, GameRepository gameRepository) {
        this.userService = userService;
        this.gameRepository = gameRepository;
        this.users = userService.getUsers();

        // Test Data
        users.get(0).setX(100);
        users.get(0).setY(400);

        users.get(1).setX(600);
        users.get(1).setY(400);
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET,RequestMethod.POST})
    public String game(ModelMap model, HttpServletRequest req) {
        String url = req.getRequestURI();
        System.out.print("url : "+url);
        if(url.indexOf("FBVOL_SERVER") != -1){
            model.addAttribute("url", "/FBVOL_SERVER");
        }else{
            model.addAttribute("url", "");
        }
        return "Game";
    }
/*

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public DeferredResult<List<String>> getMessages(@RequestParam int messageIndex) {

        final DeferredResult<List<String>> deferredResult = new DeferredResult<List<String>>(null, Collections.emptyList());
        this.gameRequest.put(deferredResult, messageIndex);

        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                gameRequest.remove(deferredResult);
            }
        });

        List<String> messages = this.gameRepository.getMessages(messageIndex);
        if (!messages.isEmpty()) {
            deferredResult.setResult(messages);
        }

        return deferredResult;
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public void postMessage(@RequestParam String message) {

        this.gameRepository.addMessage(message);

        // Update all chat requests as part of the POST request
        // See Redis branch for a more sophisticated, non-blocking approach

        for (Map.Entry<DeferredResult<List<String>>, Integer> entry : this.gameRequest.entrySet()) {
            List<String> messages = this.gameRepository.getMessages(entry.getValue());
            entry.getKey().setResult(messages);
        }
    }
*/

}