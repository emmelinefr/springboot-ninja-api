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
    public MissionDTO create(@RequestBody MissionDTO missionDTO) {
        return missionService.create(missionDTO);
    }

    @GetMapping("/list")
    public List<MissionDTO> listMissions() {
        return missionService.list();
    }

    @GetMapping("/listById/{id}")
    public MissionDTO listById(@PathVariable Integer id) {
        return missionService.listById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        missionService.delete(id);
    }

    @PutMapping("/update/{id}")
    public MissionDTO update(@PathVariable Integer id, @RequestBody MissionDTO missionDTO) {
        return missionService.update(id, missionDTO);
    }
}
