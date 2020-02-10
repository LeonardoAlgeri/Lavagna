package com.lavagna.lavagna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String messaggio) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setMessaggio(messaggio);
        userRepository.save(n);
        return "Saved";
    }

    @CrossOrigin
    @GetMapping(path="/reset") // Map ONLY POST Requests
    public @ResponseBody String reset (@RequestParam String pwd) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if(!pwd.equals("pinguino"))
            return "Password errata";
        else{
            userRepository.deleteAll();
            return "Cancellazione completata";
        }
    }

    @CrossOrigin
//    @CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}