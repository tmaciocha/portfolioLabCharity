package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionServiceImpl;


@Controller
@AllArgsConstructor
public class HomeController {
    private final InstitutionServiceImpl institutionService;


    @GetMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        return "index";
    }
}
