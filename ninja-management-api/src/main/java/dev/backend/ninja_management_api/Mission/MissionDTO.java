package dev.backend.ninja_management_api.Mission;

import dev.backend.ninja_management_api.Ninja.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {

    private Integer id;
    private String name;
    private String difficult;
    private List<NinjaModel> ninjaModelList;

}
