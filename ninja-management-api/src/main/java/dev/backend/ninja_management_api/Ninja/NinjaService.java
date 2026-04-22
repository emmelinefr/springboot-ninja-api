package dev.backend.ninja_management_api.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    public NinjaDTO create(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public List<NinjaDTO> list() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO listById(Integer id) {
        Optional<NinjaModel> ninjaById = ninjaRepository.findById(id);
        return ninjaById.map(ninjaMapper::map).orElse(null);
    }

    public void delete(Integer id) {
        ninjaRepository.deleteById(id);
    }
/*
    public NinjaDTO update(Integer id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> existingNinja = ninjaRepository.findById(id);
        if (existingNinja.isPresent()) {
            NinjaModel ninjaUpdated = ninjaMapper.map(ninjaDTO);
            ninjaUpdated.setId(id);
            NinjaModel ninjaSaved = ninjaRepository.save(ninjaUpdated);
            return ninjaMapper.map(ninjaSaved);
        }
        return null;
    }
*/

    public NinjaDTO partialUpdate(Integer id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> existingNinja = ninjaRepository.findById(id);
        if (existingNinja.isEmpty()) {
            return null;
        }

        NinjaModel entity = existingNinja.get();

        if (ninjaDTO.getName() != null) {
           entity.setName(ninjaDTO.getName());
        }

        if (ninjaDTO.getEmail() != null) {
            entity.setEmail(ninjaDTO.getEmail());
        }

        if (ninjaDTO.getRank() != null) {
            entity.setRank(ninjaDTO.getRank());
        }

        if (ninjaDTO.getMission() != null) {
            entity.setMission(ninjaDTO.getMission());
        }

        if (ninjaDTO.getYearsOld() != null) {
            entity.setYearsOld(ninjaDTO.getYearsOld());
        }

        NinjaModel saved = ninjaRepository.save(entity);

        return ninjaMapper.map(saved);
    }

}
