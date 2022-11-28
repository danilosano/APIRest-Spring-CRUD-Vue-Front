package br.com.TrabalhoJorge.TrabalhoJorge.service;

import br.com.TrabalhoJorge.TrabalhoJorge.model.ProfessorModel;
import br.com.TrabalhoJorge.TrabalhoJorge.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public Optional<ProfessorModel> findById(long id){
        return repository.findById(id);
    }

    public List<ProfessorModel> findAll(){
        return repository.findAll();
    }

    public ProfessorModel save(ProfessorModel model){
        return repository.save(model);
    }

    public ProfessorModel update(ProfessorModel model){
        Optional<ProfessorModel> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setNomeCompleto(model.getNomeCompleto());
            p.get().setSalario(model.getSalario());
            p.get().setIdade(model.getIdade());
            p.get().setEmail(model.getEmail());
            p.get().setDisciplina(model.getDisciplina());
            return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        var found = repository.findById(id);
        if(found.isPresent()){
            repository.delete(found.get());
        }
    }
}
