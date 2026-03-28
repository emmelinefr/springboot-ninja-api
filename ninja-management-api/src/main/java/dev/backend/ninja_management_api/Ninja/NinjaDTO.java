package dev.backend.ninja_management_api.Ninja;
import dev.backend.ninja_management_api.Mission.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Integer id;
    private Integer yearsOld;
    private String name;
    private String email;
    private String rank;
    private MissionModel mission;

}
