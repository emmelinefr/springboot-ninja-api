package dev.backend.ninja_management_api.Ninja;

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
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO newNinja = ninjaService.create(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Successfully created ninja: " + newNinja.getName());
    }

    @GetMapping("/list")
    public ResponseEntity<List<NinjaDTO>> listNinjas() {
        List<NinjaDTO> ninjas = ninjaService.list();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listById/{id}")
    public ResponseEntity<NinjaDTO> listById(@PathVariable Integer id) {
        NinjaDTO ninja = ninjaService.listById(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (ninjaService.listById(id) != null) {
            ninjaService.delete(id);
            return ResponseEntity.ok("Ninja with ID " + id + " successfully deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The ninja with ID " + id + " was not found!");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NinjaDTO> update(@PathVariable Integer id, @RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninja = ninjaService.update(id, ninjaDTO);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
