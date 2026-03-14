package dev.backend.ninja_management_api.Mission;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {

    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping("/create")
    public MissionModel createMission(@RequestBody MissionModel mission) {
        return missionService.createMission(mission);
    }

    @GetMapping("/list")
    public List<MissionModel> listMissions() {
        return missionService.listMissions();
    }

    @GetMapping("/findById/{id}")
    public MissionModel findById(@PathVariable int id) {
        return missionService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMission(@PathVariable int id) {
        missionService.deleteMission(id);
    }

    @PutMapping("/update/{id}")
    public MissionModel updateMission(@PathVariable int id, @RequestBody MissionModel missionModelUpdated) {
        return missionService.updateMission(id, missionModelUpdated);
    }
}
