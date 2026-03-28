package dev.backend.ninja_management_api.Mission;

import dev.backend.ninja_management_api.Ninja.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public MissionModel map(MissionDTO missionDTO) {

        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setDifficult(missionDTO.getDifficult());
        missionModel.setNinjaModelList(missionDTO.getNinjaModelList());

        return missionModel;
    }


    public MissionDTO map(MissionModel missionModel) {

        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setDifficult(missionModel.getDifficult());
        missionDTO.setNinjaModelList(missionModel.getNinjaModelList());

        return missionDTO;
    }

}
