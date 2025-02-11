//package com.example.VprepU.Service;
//
//import java.util.List;
//
//
//import org.springframework.stereotype.Service;
//
//import com.example.VprepU.Model.Template;
//import com.example.VprepU.Repository.TemplateRepository;
//
//@Service
//public class TemplateService {
//	private final TemplateRepository templateRepository;
//
//	public TemplateService(TemplateRepository templateRepository) {
//		super();
//		this.templateRepository = templateRepository;
//	}
//	public Template saveTemplate(Template template) {
//		return templateRepository.save(template);
//	}
//	public List<Template>getAllTemplates(){
//		return templateRepository.findAll();
//	}
//	public  void deleteTemplate(int templateId) {
//		templateRepository.deleteById(templateId);
//		
//	}
//	@SuppressWarnings("deprecation")
//	public Template getTemplateById(int template_id) {
//		return templateRepository.getById(template_id);
//	}
//}
package com.example.VprepU.Service;

import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.stereotype.Service;
import com.example.VprepU.Model.Template;
import com.example.VprepU.Repository.TemplateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateService {
    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        super();
        this.templateRepository = templateRepository;
    }

    public Template saveTemplate(Template template) {
        try {
            return templateRepository.save(template);
        } catch (ConcurrencyFailureException e) {
            throw new IllegalStateException("The template you're trying to update has already been modified or deleted by another transaction.", e);
        }
    }

    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    public void deleteTemplate(int templateId) {
        try {
            templateRepository.deleteById(templateId);
        } catch (Exception e) {
            throw new IllegalStateException("Error occurred while deleting the template.", e);
        }
    }

    public Template getTemplateById(int templateId) {
        Optional<Template> template = templateRepository.findById(templateId);
        if (template.isPresent()) {
            return template.get();
        } else {
            throw new IllegalStateException("Template not found with ID: " + templateId);
        }
    }
}
