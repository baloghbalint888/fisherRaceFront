package hu.fisherRaceFront.controllers;

import hu.fisherRaceFront.domain.Fisher;
import hu.fisherRaceFront.services.FisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private FisherService service;

    @GetMapping("/adminfisher") // menüpontból navigál
    public String newFisher(Model model){
        model.addAttribute("fishers", service.getFishers());
        return "adminfisher";
    }

    @PostMapping("/addfisher") // űrlapon Add gombot megnyom
    public String addFisher(@RequestParam("startnumber") int startNumber,
                            @RequestParam("name") String name,
                            @RequestParam("country") String country,
                            Model model){
        int statusCode = service.addFisher(startNumber, name, country);
        model.addAttribute("status", statusCode);
        model.addAttribute("fishers", service.getFishers());
        return "adminfisher";
    }

    @PostMapping("updatefisher") // menüpontból navigál
    public String updatingFisher(@RequestParam("startNumber") int startNumber, Model model){
        Fisher fisher = service.getFisher(startNumber);
        model.addAttribute("fisher", fisher);
        return "updatefisher";
    }

    @PostMapping("/update-country") // országot cserél
    public String updateFisher(@RequestParam("startnumber") int startNumber,
                               @RequestParam("country") String country,
                               Model model){
        int status = service.updateFisher(startNumber, country);
        model.addAttribute("status", status);
        model.addAttribute("fishers", service.getFishers());
        return "adminfisher";
    }

    @PostMapping("/delete-fisher")
    public String deleteFisher(@RequestParam("startnumber") int startnumber, Model model){
        System.out.println("@DeleteMapping: "+startnumber);
        int status = service.deleteFisher(startnumber);
        System.out.println("status code: "+status);
        model.addAttribute("status", status);
        model.addAttribute("fishers", service.getFishers());
        return "adminfisher";
    }

}
