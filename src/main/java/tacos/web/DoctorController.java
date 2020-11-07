package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.Doctor;
import tacos.Ingredient;
import tacos.data.DoctorRepository;
import tacos.data.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorRepository doctorRepository;
    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Ingredient(null, null, null));
        return "addIngredient";
    }
    @PostMapping
    public String addDoctor(Doctor doctor, Model model) {
        doctorRepository.save(doctor);
        model.addAttribute(doctor);
        log.info("Doctor saved: " + doctor);
        return "addIngredientSuccess";
    }
}
