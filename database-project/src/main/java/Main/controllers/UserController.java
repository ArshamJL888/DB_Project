package Main.controllers;

import Main.DAO.serviceInterfaces.UserService;
import Main.Utils.UserLoginHelper;
import Main.classes.NormalUser;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;


    @GetMapping("/show/{emailOrPhone}")
    public NormalUser getUser(@PathVariable String emailOrPhone) {
        NormalUser normalUser = service.getUserEmail(emailOrPhone);
        if (normalUser == null) {
            normalUser = service.getUserPhone(emailOrPhone);
            if (normalUser == null) {
                normalUser = new NormalUser();
                if (emailOrPhone.contains("@")) {
                    normalUser.setEmail(emailOrPhone);
                } else {
                    normalUser.setPhoneNumber(emailOrPhone);
                }
                service.addUser(normalUser);
            }
        }
        return normalUser;
    }


    @PutMapping("/update")
    public NormalUser updateUser(@RequestBody NormalUser user) {
        if (user.getEmail().equals("")) {
            service.updateUserPhone(user);
        } else {
            service.updateUserEmail(user);
        }
        return user;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "successfully deleted user";
    }
}
