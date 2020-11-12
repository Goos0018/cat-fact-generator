package be.vdab.catfactgenerator.controllers;

import be.vdab.catfactgenerator.services.CatFactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatFactController {

    private final CatFactService catFactService;

    public CatFactController(CatFactService catFactService){
        this.catFactService = catFactService;
    }

    @RequestMapping({"", "/"})
    public String showFact(Model model){

        model.addAttribute("fact", catFactService.getFact());

        return "index";
    }

}
