package hu.fisherRaceFront.controllers;

import hu.fisherRaceFront.config.Counter;
import hu.fisherRaceFront.domain.CatchList;
import hu.fisherRaceFront.domain.Competition;
import hu.fisherRaceFront.domain.FishList;
import hu.fisherRaceFront.services.FishService;
import hu.fisherRaceFront.services.FisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private FisherService service;
    @Autowired
    private FishService fishService;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("activemenu", 1);
        return "index";
    }

    @GetMapping("c-fishes")
    public String getFishList(Model model){
        List<FishList> fishList = fishService.getFishList();
        if(fishList.size()>0) {
            model.addAttribute("counter", new Counter());
            model.addAttribute("fishlist", fishList);
            model.addAttribute("firstRace", fishList.get(0).getId());
        }
        model.addAttribute("activemenu", "2");
        return "fishlist";
    }


    @GetMapping("/c-fishers")
    public String fishers(Model model){
        model.addAttribute("fishers", service.getFishers());
        model.addAttribute("activemenu", 3);
        return "fishers";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("c-catchlist/{id}")
    public String getCatchList(@PathVariable("id") int startNumber,
                               Model model){
        List<CatchList> catches = service.getCatchList(startNumber);
        model.addAttribute("catches", catches);
        model.addAttribute("activemenu", 3);
        return "catchlist";
    }

    @GetMapping("c-comp")
    public String getComp(Model model){
        List<Competition> comps = service.getCompetition();
        model.addAttribute("comps", comps);
        model.addAttribute("activemenu", 4);
        return "competition";
    }


}
