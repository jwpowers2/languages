package com.johnpowers.languages.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.johnpowers.languages.models.Language;
import com.johnpowers.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public Language create(Language language) {
		return languageRepository.save(language);
	}
	
	public ArrayList<Language> all() {
		return (ArrayList<Language>) languageRepository.findAll();
	}
	
    public Language findLanguageById(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    public void destroyLanguage(Long id) {
        languageRepository.deleteById(id);
    }
    
    public void updateLanguage(Language language) {
        languageRepository.save(language);
    }
}
