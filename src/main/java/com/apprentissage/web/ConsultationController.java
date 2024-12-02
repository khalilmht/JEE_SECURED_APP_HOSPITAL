package com.apprentissage.web;

import com.apprentissage.Dao.ConsultationDao;
import com.apprentissage.POJOs.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ConsultationController {
@Autowired
    ConsultationDao consultationDao;
@GetMapping("/consultations")
    public String consulter(Model model, @RequestParam(name = "page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "5") int size){
    Page<Consultation> consultations=consultationDao.findAll(PageRequest.of(page,size));
    model.addAttribute("consultations",consultations.getContent());
    model.addAttribute("currentpage",page);
    model.addAttribute("pages",new int[consultations.getTotalPages()]);
    return "consultations";
}
@GetMapping("/delete")
public String delete(Long id)
{
    consultationDao.deleteById(id);
    return "redirect:/consultations";
}

}
