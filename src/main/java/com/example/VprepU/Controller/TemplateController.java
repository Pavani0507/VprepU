package com.example.VprepU.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.VprepU.Model.Template;
import com.example.VprepU.Service.TemplateService;

@RestController
@RequestMapping("/temp")
public class TemplateController {
    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping("/templates")
    public Template createTemplate(@RequestBody Template template) {
        return templateService.saveTemplate(template);
    }

    @GetMapping
    public List<Template> getTemplates() {
        return templateService.getAllTemplates();
    }
    
    @GetMapping("/{templateId}")
    public Template getTemplateById(@PathVariable int template_id) {
         return templateService.getTemplateById(template_id);
    }
    @DeleteMapping("/{templateId}")
    public void deleteTemplate(@PathVariable int template_id) {
        templateService.deleteTemplate(template_id);
    }
}