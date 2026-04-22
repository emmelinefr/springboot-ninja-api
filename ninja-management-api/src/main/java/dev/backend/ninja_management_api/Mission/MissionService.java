package dev.backend.ninja_management_api.Mission;

import dev.backend.ninja_management_api.Ninja.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private final MissionMapper missionMapper;
    private final NinjaMapper ninjaMapper;
    private MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper, NinjaMapper ninjaMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
        this.ninjaMapper = ninjaMapper;
    }


    public MissionDTO create(MissionDTO missionDTO) {
        MissionModel mission = missionMapper.map(missionDTO);
        mission = missionRepository.save(mission);
        return missionMapper.map(mission);
    }

    public List<MissionDTO> list() {
        List<MissionModel> missions = missionRepository.findAll();
        return missions.stream()
                .map(missionMapper::map)
                .collect(Collectors.toList());
    }

    public MissionDTO listById(Integer id) {
        Optional<MissionModel> missionById = missionRepository.findById(id);
        return missionById.map(missionMapper::map).orElse(null);
    }

    public void delete(Integer id) {
        missionRepository.deleteById(id);
    }

    /*
    public MissionDTO update(Integer id, MissionDTO missionDTO) {
        Optional<MissionModel> existingMission = missionRepository.findById(id);
        if (existingMission.isPresent()) {
            MissionModel missionUpdated = missionMapper.map(missionDTO);
            missionUpdated.setId(id);
            MissionModel missionSaved = missionRepository.save(missionUpdated);
            return missionMapper.map(missionSaved);
        }
        return null;
    }
     */

    public MissionDTO partialUpdate(Integer id, MissionDTO missionDTO) {
        Optional<MissionModel> existingMission = missionRepository.findById(id);
        if (existingMission.isEmpty()) {
            return null;
        }

        MissionModel entity = existingMission.get();

        if (missionDTO.getName() != null) {
            entity.setName(missionDTO.getName());
        }

        if(missionDTO.getDifficult() != null) {
            entity.setDifficult(missionDTO.getDifficult());
        }

        return missionMapper.map(missionRepository.save(entity));
    }
}
