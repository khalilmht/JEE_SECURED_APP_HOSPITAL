package com.apprentissage.web;

import com.apprentissage.Dao.SortiePatientDao;
import com.apprentissage.POJOs.SortiePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SortieController {
@Autowired
    SortiePatientDao sortiePatientDao;
@GetMapping("/sorties")
    public String sorties(Model model){
    List<SortiePatient> sortiePatients=sortiePatientDao.findAll();
    model.addAttribute("sorties",sortiePatients);
    return "/sorties";
}
}
