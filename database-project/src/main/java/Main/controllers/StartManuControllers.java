package Main.controllers;


import Main.DAO.serviceInterfaces.AgencyService;
import Main.DAO.serviceInterfaces.PictureService;
import Main.DAO.serviceInterfaces.UserService;
import Main.classes.NormalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class StartManuControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private PictureService pictureService;

    @GetMapping("/api")
    public String getManu(Model model){
        return "manu";
    }

    @RequestMapping("/")
    public String getManu1(Model model, @ModelAttribute String city){
        return "filter";
    }

    @PostMapping("/upload")
    public String getImage(Model model, @ModelAttribute String city) throws IOException {
        return "manu";
    }

    @PostMapping("/sign")
    public String getForm(Model model) {
        String parameter = "";
        model.addAttribute("parameter", parameter);
        NormalUser normalUser =new NormalUser(1L,"test","test","test","tttt");
        System.out.println(normalUser +"\n\n\n\n\\n\n\\n");
//        userService.addUser(normalUser);
        return "sign-in-page";
    }




}
