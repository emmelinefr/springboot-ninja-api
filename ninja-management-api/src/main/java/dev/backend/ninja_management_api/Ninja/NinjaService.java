package dev.backend.ninja_management_api.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }


    public NinjaModel createNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<NinjaModel> listNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listById(Integer id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.orElse(null);
    }

    public void delete(Integer id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaModel update(Integer id, NinjaModel ninjaUpdated) {
        if (ninjaRepository.existsById(id)) {
            ninjaUpdated.setId(id);
            return ninjaRepository.save(ninjaUpdated);
        }
        return null;
    }
}
