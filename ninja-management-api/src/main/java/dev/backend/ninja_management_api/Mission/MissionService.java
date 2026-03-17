package dev.backend.ninja_management_api.Mission;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    private MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }


    public MissionModel create(MissionModel mission) {
        return missionRepository.save(mission);
    }

    public List<MissionModel> list() {
        return missionRepository.findAll();
    }

    public MissionModel listById(Integer id) {
        Optional<MissionModel> missionById = missionRepository.findById(id);
        return missionById.orElse(null);
    }

    public void delete(Integer id) {
        missionRepository.deleteById(id);
    }

    public MissionModel update(Integer id, MissionModel missionModelUpdated) {
        if (missionRepository.existsById(id)) {
            missionModelUpdated.setId(id);
            return missionRepository.save(missionModelUpdated);
        }
        return null;
    }
}
