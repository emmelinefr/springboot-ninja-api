package dev.backend.ninja_management_api.Mission;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> create(@RequestBody MissionDTO missionDTO) {
        MissionDTO newMission = missionService.create(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Successfully created mission: " + newMission.getName());
    }

    @GetMapping("/list")
    public ResponseEntity<List<MissionDTO>> listMissions() {
        List<MissionDTO> missions = missionService.list();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/listById/{id}")
    public ResponseEntity<MissionDTO> listById(@PathVariable Integer id) {
        MissionDTO mission = missionService.listById(id);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (missionService.listById(id) != null) {
            missionService.delete(id);
            return ResponseEntity.ok("Mission with ID " + id + " successfully deleted!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The mission with ID " + id + " was not found!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MissionDTO> update(@PathVariable Integer id, @RequestBody MissionDTO missionDTO) {
        MissionDTO mission = missionService.update(id, missionDTO);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
