package com.example.documentmanagment.service;
import com.example.documentmanagment.exception.NotFoundException;
import com.example.documentmanagment.repository.ShaklRepository;
import org.springframework.stereotype.Service;
import com.example.documentmanagment.entity.Shakl;
import java.util.List;
import java.util.Optional;
@Service
public class ShaklService {
    private final ShaklRepository shaklRepository;
    public ShaklService(ShaklRepository shaklRepository) {
        this.shaklRepository = shaklRepository;
    }

    public List<Shakl> getAllShakls() {
        List<Shakl> shakls = shaklRepository.findAll();
        if (shakls.isEmpty()) {
            throw new NotFoundException("No shakls found");
        }
        return shakls;
    }
    public Optional<Shakl> getShaklById(Integer id) {
        return shaklRepository.findById(id);
    }

    public Shakl saveShakl(Shakl shakl) {
        return shaklRepository.save(shakl);
    }
    public Shakl updateShakl(Integer id, Shakl updatedShakl) {
        return shaklRepository.findById(id)
                .map(existingShakl -> {
                    existingShakl.setShakl_nomi(updatedShakl.getShakl_nomi());
                    return shaklRepository.save(existingShakl);
                })
                .orElseThrow(() -> new NotFoundException("Shakl not found with id: " + id));
    }
    public void deleteShakl(Integer id) {
        shaklRepository.deleteById(id);
    }
}


