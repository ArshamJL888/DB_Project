package Main.controllers;

import Main.DAO.serviceInterfaces.AgencyService;
import Main.Utils.LoginHolder;
import Main.classes.RealStateAgency;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agency")
public class AgencyController {

    @Autowired
    private AgencyService service;

    @GetMapping("/show/{phone}/{password}")
    public RealStateAgency getAgency(@PathVariable String phone,@PathVariable String password){
        RealStateAgency agency=service.findRealStateAgencyByMPhone(phone);
        if (agency==null){
            return null;
        }else if (agency.getPassword().equals(password)){
            return agency;
        }
        return null;
    }

    @PutMapping("/update")
    public RealStateAgency updateAgency(@RequestBody RealStateAgency agency){
        RealStateAgency agency1=service.findRealStateAgencyByMPhone(agency.getMPhone());
        agency.setId(agency1.getId());
        service.updateAgency(agency);
        return agency;
    }

    @DeleteMapping("/delete/{mPhone}")
    public String deleteAgency(@PathVariable String mPhone){
        RealStateAgency agency=service.findRealStateAgencyByMPhone(mPhone);
        service.deleteAgency(agency);
        return "success";
    }

    @PostMapping("/add")
    public RealStateAgency addAgency(@RequestBody RealStateAgency agency){
        service.addAgency(agency);
        return agency;
    }
}
