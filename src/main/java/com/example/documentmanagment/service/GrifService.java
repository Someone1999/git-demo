package com.example.documentmanagment.service;
import com.example.documentmanagment.exception.NotFoundException;
import com.example.documentmanagment.entity.Grif;
import com.example.documentmanagment.repository.GrifRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class GrifService {
    private final GrifRepository grifRepository;
    public GrifService(GrifRepository grifRepository) {
        this.grifRepository = grifRepository;
    }

    public List<Grif> getAllGrifs() {
        return grifRepository.findAll();
    }

    public Optional<Grif> getGrifById(Integer id) {
        return grifRepository.findById(id);
    }

    public Grif saveGrif(Grif grif) {
        return grifRepository.save(grif);
    }

    public void deleteGrif(Integer id) {
        grifRepository.deleteById(id);
    }
    public Grif updateGrif(Integer id, Grif updatedGrif) {
        return grifRepository.findById(id)
                .map(existingGrif -> {
                    existingGrif.setGrif_nomi(updatedGrif.getGrif_nomi());
                    return grifRepository.save(existingGrif);
                })
                .orElseThrow(() -> new NotFoundException("Grif not found with id: " + id));
    }
}

