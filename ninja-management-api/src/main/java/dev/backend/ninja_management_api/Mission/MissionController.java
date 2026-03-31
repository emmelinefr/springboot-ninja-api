package dev.backend.ninja_management_api.Mission;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(
            summary = "Create a new mission",
            description = "Creates a new mission with the provided data"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mission created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<String> create(
            @Parameter(description = "Mission data to be created")
            @RequestBody MissionDTO missionDTO) {

        MissionDTO newMission = missionService.create(missionDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Successfully created mission: " + newMission.getName());
    }

    @GetMapping("/list")
    @Operation(
            summary = "List all missions",
            description = "Returns a complete list of all registered missions"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missions listed successfully")
    })
    public ResponseEntity<List<MissionDTO>> listMissions() {
        List<MissionDTO> missions = missionService.list();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/listById/{id}")
    @Operation(
            summary = "Get mission by ID",
            description = "Returns a mission based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mission found successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    public ResponseEntity<MissionDTO> listById(
            @Parameter(description = "ID of the mission to be searched")
            @PathVariable Integer id) {

        MissionDTO mission = missionService.listById(id);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete mission by ID",
            description = "Deletes a mission based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mission deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    public ResponseEntity<String> delete(
            @Parameter(description = "ID of the mission to be deleted")
            @PathVariable Integer id) {

        if (missionService.listById(id) != null) {
            missionService.delete(id);
            return ResponseEntity.ok("Mission with ID " + id + " successfully deleted!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The mission with ID " + id + " was not found!");
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Update mission by ID",
            description = "Updates an existing mission based on the provided ID and request body data"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mission updated successfully"),
            @ApiResponse(responseCode = "404", description = "Mission not found")
    })
    public ResponseEntity<MissionDTO> update(
            @Parameter(description = "ID of the mission provided in the path")
            @PathVariable Integer id,

            @Parameter(description = "Updated mission data sent in the request body")
            @RequestBody MissionDTO missionDTO) {

        MissionDTO mission = missionService.update(id, missionDTO);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
