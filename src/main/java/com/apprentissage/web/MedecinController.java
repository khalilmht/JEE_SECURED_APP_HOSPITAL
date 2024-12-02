package com.apprentissage.web;

import com.apprentissage.Dao.MedecinDao;
import com.apprentissage.POJOs.Medecin;
import com.apprentissage.POJOs.Patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MedecinController {
    @Autowired
    MedecinDao medecinRepository;

    @GetMapping("/medecins")
public String medecins(Model model  ,
                       @RequestParam(name = "mc",defaultValue = "") String mc,
                       @RequestParam(name = "page",defaultValue = "0") int page,
                       @RequestParam(name = "size",defaultValue = "6") int size)
{
    Page<Medecin> medecinPage= medecinRepository.findByNomContainsIgnoreCaseOrPrenomContainsIgnoreCase(mc,mc,PageRequest.of(page,size));
    model.addAttribute("pages",new int[medecinPage.getTotalPages()]);
    model.addAttribute("currentpage",page);
    model.addAttribute("mc",mc);
    model.addAttribute("listmedecins",medecinPage.getContent());
    return "medecins";
}
@GetMapping("/deleteMedecin")
    public String delete(Long id,String mc, int page)
    {
        medecinRepository.deleteById(id);
    return "redirect:/medecins?page="+page+"&mc="+mc;
    }

    @GetMapping("/addmedecins")
    public String addmedecins(Model model)
    {
        model.addAttribute("medecin",new Medecin());
        return "addmedecins";
    }
    @PostMapping("/saveMedecin")
    public String saveMedecin(Model model, @Valid Medecin medecin, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "addmedecins";
        medecinRepository.save(medecin);
        return "redirect:addmedecins";
    }
    @GetMapping("/editMedecin")
    public String editMedecin(Model model,Long id, Medecin medecin)
    {
        medecin=medecinRepository.findById(id).orElse(null);
        if (medecin==null)throw new RuntimeException("Medecin introuvable");
        model.addAttribute("medecin",medecin);
        return "/editMedecins";
    }
    @PostMapping("/saveEditMedecin")
    public String saveEditMedecin(@Valid  Medecin medecin,Model model,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) return "editMedecin";
        medecinRepository.save(medecin);
        return "redirect:medecins";
    }
}
