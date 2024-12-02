package com.apprentissage.web;

import com.apprentissage.Dao.AdmissionDao;
import com.apprentissage.Dao.MedecinDao;
import com.apprentissage.Dao.PatientDao;
import com.apprentissage.POJOs.AdmissionPatient;
import com.apprentissage.POJOs.Medecin;
import com.apprentissage.POJOs.Patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdmissionController {
@Autowired
    AdmissionDao admissionDao;

@GetMapping("/admissions")
    public String admission(Model model, @RequestParam(name="page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "6") int size){
    Page<AdmissionPatient> admissionPatients=admissionDao.findAll(PageRequest.of(page,size));
    model.addAttribute("admissions",admissionPatients);
    return "admissions";
}


    @GetMapping("/addAdmission")
public String addAdmission(Model model)
{
    model.addAttribute("admission",new AdmissionPatient());
    return " addAdmission";
}
@PostMapping("/saveAdmission")
    public String saveAdmission(Model model,  AdmissionPatient admissionPatient)
{
     admissionDao.save(admissionPatient);
    return "redirect:/addAdmission";
}
}
