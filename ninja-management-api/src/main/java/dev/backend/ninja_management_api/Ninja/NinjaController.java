package dev.backend.ninja_management_api.Ninja;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjaManagement")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @PostMapping("/create")
    @Operation(
            summary = "Creates a new Ninja",
            description = "Creates a new ninja with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<String> createNinja(
            @Parameter(description = "Ninja data to be created")
            @RequestBody NinjaDTO ninjaDTO) {

        NinjaDTO newNinja = ninjaService.create(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Successfully created ninja: " + newNinja.getName());
    }

    @GetMapping("/list")
    @Operation(
            summary = "List all ninjas",
            description = "Returns a complete list of all registered ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas listed successfully")})

    public ResponseEntity<List<NinjaDTO>> listNinjas() {
        List<NinjaDTO> ninjas = ninjaService.list();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listById/{id}")
    @Operation(
            summary = "List the Ninja by ID",
            description = "Returns a ninja based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja found successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<NinjaDTO> listById(
            @Parameter(description = "ID of the ninja to be searched")
            @PathVariable Integer id) {

        NinjaDTO ninja = ninjaService.listById(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @Operation(
            summary = "Delete ninja by ID",
            description = "Deletes a ninja based on the provided ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Ninja not found")
    })
    public ResponseEntity<String> delete(
            @Parameter(description = "ID of the ninja to be deleted")
            @PathVariable Integer id) {

        if (ninjaService.listById(id) != null) {
            ninjaService.delete(id);
            return ResponseEntity.ok("Ninja with ID " + id + " successfully deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The ninja with ID " + id + " was not found!");
        }
    }

    @PutMapping("/update/{id}")
    @Operation(
            summary = "Change the ninja by ID",
            description = "Updates a ninja based on the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja altered with success"),
            @ApiResponse(responseCode = "404", description = "Ninja not found, It was not possible to change")
    })
    public ResponseEntity<NinjaDTO> update(
            @Parameter(description = "ID of the ninja provided in the path")
            @PathVariable Integer id,
            @Parameter(description = "Updated ninja data sent in the request body")
            @RequestBody NinjaDTO ninjaDTO) {

        NinjaDTO ninja = ninjaService.update(id, ninjaDTO);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
