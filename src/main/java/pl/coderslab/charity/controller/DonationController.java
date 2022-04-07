package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class DonationController {
    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;
    private final DonationRepository donationRepository;

    private static final Logger logger = LoggerFactory.getLogger(DonationController.class);

    @GetMapping("form")
    public String add(Model model){
        model.addAttribute("categories", categoryService.categories());
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donation", new Donation());
        logger.info(categoryService.categories().toString() + "CATEGORIES!!!!!");
        return "form";
    }

    @PostMapping("form")
    public String save(@Valid Donation donation, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form";
        }
        donationRepository.save(donation);
        return "redirect:/form-confirmation";
    }

    @GetMapping("form-confirmation")
    public String confirm(){
        return "form-confirmation";
    }
}
