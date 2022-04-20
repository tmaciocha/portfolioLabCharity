package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService{
    private final InstitutionRepository institutionRepository;


    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public void saveInstitution(Institution institution) {
        institutionRepository.save(institution);
    }


}


