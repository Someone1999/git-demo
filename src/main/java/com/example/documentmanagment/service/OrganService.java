package com.example.documentmanagment.service;
import com.example.documentmanagment.exception.NotFoundException;
import com.example.documentmanagment.repository.OrganRepository;
import org.springframework.stereotype.Service;
import com.example.documentmanagment.entity.Organ;
import java.util.List;
import java.util.Optional;

@Service
public class OrganService {
    private final OrganRepository organRepository;

    public OrganService(OrganRepository organRepository) {
        this.organRepository = organRepository;
    }

    public List<Organ> getAllOrgans() {
        List<Organ> organs = organRepository.findAll();
        if (organs.isEmpty()) {
            throw new NotFoundException("No organs found");
        }
        return organs;
    }
    public Optional<Organ> getOrganById(Integer id) {
        return organRepository.findById(id);
    }

    public Organ saveOrgan(Organ organ) {
        return organRepository.save(organ);
    }
    public Organ updateOrgan(Integer id, Organ updatedOrgan) {
        return organRepository.findById(id)
                .map(existingOrgan -> {
                    existingOrgan.setOrgan_name(updatedOrgan.getOrgan_name());
                    return organRepository.save(existingOrgan);
                })
                .orElseThrow(() -> new NotFoundException("Organ not found with id: " + id));
    }
    public void deleteOrgan(Integer id) {
        organRepository.deleteById(id);
    }
}

