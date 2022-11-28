package br.com.TrabalhoJorge.TrabalhoJorge.controller;

import br.com.TrabalhoJorge.TrabalhoJorge.model.ProfessorModel;
import br.com.TrabalhoJorge.TrabalhoJorge.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor/v1/")
public class ProfessorControllerV1 {

    @Autowired
    private ProfessorService service;

    @GetMapping("/{id}")
    public ProfessorModel findById(@PathVariable("id") long id){
        var model = service.findById(id).get();

        if (model.getLinks().isEmpty()){
            buildEntityLinks(model);
        }
        return model;
    }

    @PostMapping
    public ProfessorModel save(@RequestBody ProfessorModel model){
        return service.save(model);
    }

    @GetMapping
    public List<ProfessorModel> findAll(){
        var model = service.findAll();

        for (ProfessorModel vModel : model){
            buildEntityLinks(vModel);
        }
        return model;
    }

    @PutMapping
    public ProfessorModel update(@RequestBody ProfessorModel model){
        return service.update(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    public void buildEntityLinks(ProfessorModel model){
        model.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass())
                                .findById(model.getId())
                ).withSelfRel()
        );

        Link link = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProfessorControllerV1.class)
                        .findById(model.getDisciplina().getId())
        ).withSelfRel();
        model.getDisciplina().add(link);
    }
}
