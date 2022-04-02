package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;


@Controller
@AllArgsConstructor
public class HomeController {
    private final InstitutionServiceImpl institutionService;
  //  private final DonationServiceImpl donationService;
    private final DonationRepository donationRepository;


    @GetMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donationsCount", donationRepository.countAll());
        model.addAttribute("quantitySum", donationRepository.quantitySum());
        return "index";
    }
}
