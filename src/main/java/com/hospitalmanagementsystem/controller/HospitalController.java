package com.hospitalmanagementsystem.controller;

import com.hospitalmanagementsystem.entity.Hospital;
import com.hospitalmanagementsystem.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(path = {"/","/search"})
    public String home(Hospital hospital, Model model, String keyword) {
        if(keyword!=null) {
            List<Hospital> list = hospitalService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Hospital> list = hospitalService.getAllList();
            model.addAttribute("list", list);}
        return "hospital_list";
    }
    @GetMapping("/hospital")
    public String listHospital(Model model) {
        model.addAttribute("hospitals", hospitalService.getAllList());
        return "hospital";
    }

    @GetMapping("/hospital/new")
    public String createHospitalForm(Model model) {


        Hospital hospital = new Hospital();
        model.addAttribute("hospital", hospital);
        return "create_hospital";

    }

    @PostMapping("/hospital")
    public String saveHospital(@ModelAttribute("hospital") Hospital hospital) {
        hospitalService.saveData(hospital);
        return "redirect:/hospital";
    }

    @GetMapping("/hospital/edit/{id}")
    public String editHospitalForm(@PathVariable Long id, Model model) {
        model.addAttribute("hospital", hospitalService.getDataById(id));
        return "edit_hospital";
    }

    @PostMapping("/hospital/{id}")
    public String updateHospital(@PathVariable Long id,
                             @ModelAttribute("hospital") Hospital hospital,
                             Model model) {


        Hospital hospital1 = hospitalService.getDataById(id);
        hospital1.setId(id);
        hospital1 .setDoctorName(hospital.getDoctorName());
        hospital1.setPatientName(hospital.getPatientName());
        hospital1.setAppointmentDate(hospital.getAppointmentDate());
        hospital1.setPatientPhone(hospital.getPatientPhone());
        hospital1.setFee(hospital.getFee());


        hospitalService.updateData(hospital1);
        return "redirect:/hospital";
    }



    @GetMapping("/hospital/{id}")
    public String deleteHospital(@PathVariable Long id) {
        hospitalService.deleteDataById(id);
        return "redirect:/hospital";
    }
}
