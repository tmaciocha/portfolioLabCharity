package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.SQLInsert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.*;

import javax.validation.Valid;
import java.util.Collections;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final InstitutionServiceImpl institutionService;
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @GetMapping("")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donationsCount", donationRepository.countAll());
        model.addAttribute("quantitySum", donationRepository.quantitySum());
        if(roleRepository.findAll().size() < 1){
            roleRepository.save(new Role("ROLE_ADMIN"));
            roleRepository.save(new Role("ROLE_USER"));
        }

        if(institutionService.findAll().size()<1){
            institutionService.saveInstitution(new Institution("Fundacja \"Bez domu\"","Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania"));
            institutionService.saveInstitution(new Institution("Fundacja \"Dla dzieci\"","Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej"));
            institutionService.saveInstitution(new Institution("Fundacja \"Mam marzenie\"","Cel i misja: Pomoc dzieciom chorym"));
            institutionService.saveInstitution(new Institution("Fundacja \"Dbam o zdrowie\"","Cel i misja: Pomoc dzieciom z ubogich rodzin"));
        }

        if(userRepository.count()<1){
            User admin = new User();
            admin.setUsername("admin@admin.pl");
            admin.setPassword(bCryptPasswordEncoder.encode("admin"));
            Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN");
          //  admin.setRoles(Collections.singleton(roleRepository.findById(1)));
            admin.setRoles(Collections.singleton(adminRole));
            userRepository.save(admin);
        }

        if(categoryRepository.findAll().size()<1){
            categoryService.saveCategory(new Category("Odzież"));
            categoryService.saveCategory(new Category("Buty"));
            categoryService.saveCategory(new Category("Art. spożywcze"));
            categoryService.saveCategory(new Category("Art. szkolne"));
            categoryService.saveCategory(new Category("Art. higieniczne"));
        }
        return "/index";
    }

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("register")
    public String registerUser(@Valid User user, BindingResult bindingResult, @RequestParam String password, @RequestParam String password2){
        if(bindingResult.hasErrors()){
            return "/register";
        }
        if(password.equals(password2)){
            Role userRole = roleRepository.findByRoleName("ROLE_USER");
            user.setRoles(Collections.singleton(userRole));
            user.setPassword(bCryptPasswordEncoder.encode(password));
            userRepository.save(user);
        }else{
            return "/register";
        }

        return "redirect:/login";
    }

    @GetMapping("/anotherPage")
    public String another(){
        return "/anotherPage";
    }


    @GetMapping("login")
    public String login(){
        return "/login";
    }



    @PostMapping("login")
    public String logged(@RequestParam String username, @RequestParam String password){

        if (userRepository.findByUsername(username).equals(true)) {
            logger.info("!!!!!!!!!!!!!!!!!! USERNAME" + username);
            if (userRepository.findByUsername(username).getPassword().equals(bCryptPasswordEncoder.encode(password))) {
                logger.info("!!!!!!!!!!!!!!!!!! PASSWORD THE SAME " + password);
                return "/logged-page";
            }
        }
        return "/login";
    }

}
