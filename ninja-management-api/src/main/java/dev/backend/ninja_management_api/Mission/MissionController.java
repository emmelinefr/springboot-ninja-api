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
    public MissionModel create(@RequestBody MissionModel mission) {
        return missionService.create(mission);
    }

    @GetMapping("/list")
    public List<MissionModel> listMissions() {
        return missionService.list();
    }

    @GetMapping("/listById/{id}")
    public MissionModel listById(@PathVariable Integer id) {
        return missionService.listById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        missionService.delete(id);
    }

    @PutMapping("/update/{id}")
    public MissionModel update(@PathVariable Integer id, @RequestBody MissionModel missionModelUpdated) {
        return missionService.update(id, missionModelUpdated);
    }
}
