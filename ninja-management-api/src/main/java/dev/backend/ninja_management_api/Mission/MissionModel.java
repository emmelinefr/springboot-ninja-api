package dev.backend.ninja_management_api.Mission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.backend.ninja_management_api.Ninja.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String difficult;

    @OneToMany(mappedBy = "mission")
    @JsonIgnore
    private List<NinjaModel> ninjaModelList;

}
