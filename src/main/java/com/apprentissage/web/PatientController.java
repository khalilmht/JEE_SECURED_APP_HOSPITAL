package com.apprentissage.web;

import com.apprentissage.Dao.PatientDao;
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
public class PatientController {
@Autowired
PatientDao patientRepository;
//
//    public PatientController(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }

    @GetMapping("/index")
public String index(Model model,
                    @RequestParam(name = "mc",defaultValue = "") String mc,
                    @RequestParam(name="page",defaultValue="0") int page,
                    @RequestParam(name = "size",defaultValue = "8") int size)
{
    Page<Patient> patientPage = patientRepository.findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(mc,mc,PageRequest.of(page,size));
    model.addAttribute("listepatients",patientPage.getContent());
    model.addAttribute("pages",new int [patientPage.getTotalPages()]);
    model.addAttribute("mc",mc);
    model.addAttribute("currentpage",page);
return "patients";
}

@GetMapping("/deletePatient")
public String delete(Long id,String mc,int page)
{
    patientRepository.deleteById(id);
    return "redirect:/index?page="+page+"&mc="+mc;
}
@GetMapping("/")
    public String home()
    {
    return "redirect:index";
    }

    @GetMapping("/addPatient")
public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "addPatients";
    }


    @GetMapping("/editPatient")
    public String editPatient(Model model,Patient patient,Long id){
        patient= patientRepository.findById(id).orElse(null);
        if (patient==null) throw new RuntimeException("patient introuvable");
        model.addAttribute("patient",patient);
        return "editPatients";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Patient patient,  BindingResult bindingResult){
        if (bindingResult.hasErrors())
        {return "redirect:index";}
        patientRepository.save(patient);
        return "redirect:/index";
    }


    @PostMapping(path = "/saveEdit")
    public String saveEdit(Model model, @Valid Patient patient, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        return "redirect:/index";
    }
}
