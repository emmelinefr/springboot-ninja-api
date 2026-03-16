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

    @GetMapping("/findById/{id}")
    public NinjaModel findNinjaById(@PathVariable int id) {
        return ninjaService.findById(id);
    }

    @DeleteMapping("/deleteNinja/{id}")
    public void deleteNinja(@PathVariable int id) {
        ninjaService.deleteNinja(id);
    }

    @PutMapping("/edit/{id}")
    public NinjaModel updateNinja(@PathVariable int id, @RequestBody NinjaModel ninjaUpdated) {
        return ninjaService.updateNinja(id, ninjaUpdated);
    }

}
