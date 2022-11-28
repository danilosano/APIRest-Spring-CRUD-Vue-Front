package br.com.TrabalhoJorge.TrabalhoJorge.service;

import br.com.TrabalhoJorge.TrabalhoJorge.model.DisciplinaModel;
import br.com.TrabalhoJorge.TrabalhoJorge.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public Optional<DisciplinaModel> findById(long id){
        return repository.findById(id);
    }

    public List<DisciplinaModel> findAll(){
        return repository.findAll();
    }

    public DisciplinaModel save(DisciplinaModel model){
        return repository.save(model);
    }

    public DisciplinaModel update(DisciplinaModel model){
        Optional<DisciplinaModel> p = repository.findById(model.getId());
        if(p.isPresent()){
            p.get().setNomeDisciplina(model.getNomeDisciplina());
            p.get().setAulasDisciplina(model.getAulasDisciplina());
            return repository.save(p.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<DisciplinaModel> p = repository.findById(id);
        if(p.isPresent()){
            repository.delete(p.get());
        }
    }
}
