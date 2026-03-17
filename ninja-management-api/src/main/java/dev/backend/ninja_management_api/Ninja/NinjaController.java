package dev.backend.ninja_management_api.Ninja;

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
    public NinjaModel createNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.createNinja(ninja);
    }

    @GetMapping("/list")
    public List<NinjaModel> listNinjas() {
        return ninjaService.listNinjas();
    }

    @GetMapping("/listById/{id}")
    public NinjaModel listById(@PathVariable Integer id) {
        return ninjaService.listById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        ninjaService.delete(id);
    }

    @PutMapping("/update/{id}")
    public NinjaModel update(@PathVariable Integer id, @RequestBody NinjaModel ninjaUpdated) {
        return ninjaService.update(id, ninjaUpdated);
    }

}
