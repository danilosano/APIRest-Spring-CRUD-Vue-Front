package br.com.TrabalhoJorge.TrabalhoJorge.controller;

import br.com.TrabalhoJorge.TrabalhoJorge.model.UsuarioModel;
import br.com.TrabalhoJorge.TrabalhoJorge.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Api Rest for Contacts Management")
@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @ApiOperation(value = "Insert person in table person")
    @PostMapping("/save")//método post
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioModel save(@RequestBody @Valid UsuarioModel usuario) {

        return repository.save(usuario);
    }

    @ApiOperation(value = "return a person list")
    @GetMapping("list")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioModel> list() {
        return repository.findAll();
    }

    @ApiOperation(value = "Delete a person by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Integer id) {
//        repository.deleteById(id);
//    }
    public void deleteById(@PathVariable Integer id) {
        repository
                .findById(id)
                .map(person -> {
                    repository.delete(person);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encongtrado"));
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Return a person by id")
    public UsuarioModel findById(@PathVariable Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuário não encontrado"));
    }

    @ApiOperation(value = "Update person")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid UsuarioModel usuarioUpdated) {
        repository.findById(id).map(usuario -> {
            usuarioUpdated.setId(usuario.getId());
            return repository.save(usuarioUpdated);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));}
    /*@PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public  Contact update(@RequestBody Contact contact) {
        return repository.save(contact);
    }*/
}
