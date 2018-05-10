package com.johnpowers.languages.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.johnpowers.languages.models.Language;
import com.johnpowers.languages.services.LanguageService;


@Controller
public class Languages {

	private LanguageService languageService;
	//private LanguageRepository languageRepository;
	
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("languages")
	public String index(Model model) {
		model.addAttribute("language", new Language());
		model.addAttribute("languages", languageService.all());
		return "index";
	}
	
    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguageById(id);
        if(language != null){
            model.addAttribute("language", language);
            return "edit";
        } else {
            return "redirect:/languages";
        }
    }
    
    @PostMapping("/languages/edit/{id}")
    public String updateLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "edit";
        }else{
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @RequestMapping("/languages/{id}")
    public String findLanguageById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", languageService.findLanguageById(id));
        return "language";
    }
	

	@PostMapping("languages/add")
	public String languages(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		
		languageService.create(language);
		return "redirect:/languages";
	}
	
    @RequestMapping(value="/languages/delete/{id}")
    public String destroyLanguage(@PathVariable("id") Long id) {
        languageService.destroyLanguage(id);
        return "redirect:/languages";
    }
	
}