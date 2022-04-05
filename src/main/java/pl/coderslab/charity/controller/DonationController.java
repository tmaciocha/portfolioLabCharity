package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

@Controller
@RequiredArgsConstructor
@RequestMapping("/form")
public class DonationController {
    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;

    private static final Logger logger = LoggerFactory.getLogger(DonationController.class);

    @GetMapping("/")
    public String form1(Model model){
        model.addAttribute("categories", categoryService.categories());
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donation", new Donation());
        logger.info(categoryService.categories().toString() + "CATEGORIES!!!!!");
        return "form";
    }

}
