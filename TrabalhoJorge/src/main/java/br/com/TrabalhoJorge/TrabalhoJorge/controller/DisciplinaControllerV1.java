package br.com.TrabalhoJorge.TrabalhoJorge.controller;

import br.com.TrabalhoJorge.TrabalhoJorge.model.DisciplinaModel;
import br.com.TrabalhoJorge.TrabalhoJorge.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/disciplina/v1/")
public class DisciplinaControllerV1 {
    @Autowired
    private DisciplinaService service;

    @GetMapping("/{id}")
    public Optional<DisciplinaModel> findById(@PathVariable("id") long id){
        return service.findById(id);
    }

    @PostMapping
    public DisciplinaModel save(@RequestBody DisciplinaModel model){
        return service.save(model);
    }

    @GetMapping
    public List<DisciplinaModel> findAll(){
        return service.findAll();
    }

    @PutMapping
    public DisciplinaModel update(@RequestBody DisciplinaModel model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
