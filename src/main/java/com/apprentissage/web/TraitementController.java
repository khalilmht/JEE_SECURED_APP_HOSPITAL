package com.apprentissage.web;

import com.apprentissage.Dao.TraitementDao;
import com.apprentissage.POJOs.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TraitementController {
@Autowired
    TraitementDao traitementDao;
@GetMapping("/traitements")
public String traitements(Model model)
{
    List<Traitement> traitementList = traitementDao.findAll();
    model.addAttribute("traitements",traitementList);
    return "/traitements";
}
}
