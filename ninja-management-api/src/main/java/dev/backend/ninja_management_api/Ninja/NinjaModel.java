package dev.backend.ninja_management_api.Ninja;
import dev.backend.ninja_management_api.Mission.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "tb_register")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer yearsOld;
    private String name;
    @Column(unique = true)
    private String email;
    private String rank;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private MissionModel mission;

}
