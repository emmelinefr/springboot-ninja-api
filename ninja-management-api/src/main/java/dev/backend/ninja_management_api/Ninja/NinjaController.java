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
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.create(ninjaDTO);
    }

    @GetMapping("/list")
    public List<NinjaDTO> listNinjas() {
        return ninjaService.list();
    }

    @GetMapping("/listById/{id}")
    public NinjaDTO listById(@PathVariable Integer id) {
        return ninjaService.listById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        ninjaService.delete(id);
    }

    @PutMapping("/update/{id}")
    public NinjaDTO update(@PathVariable Integer id, @RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.update(id, ninjaDTO);
    }

}
