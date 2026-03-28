package dev.backend.ninja_management_api.Ninja;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setYearsOld(ninjaDTO.getYearsOld());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setMission(ninjaDTO.getMission());

        return ninjaModel;

    }


    public NinjaDTO map(NinjaModel ninjaModel) {

        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setYearsOld(ninjaModel.getYearsOld());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setMission(ninjaModel.getMission());

        return ninjaDTO;
    }

}
