package hospital.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hospital.Doctor;
import hospital.data.DoctorRepository;

@Slf4j
@Controller
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorRepository doctorRepository;
    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @GetMapping("/")
    public String showList(Model model) {
        Iterable<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
        return "addDoctor";
    }
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("doctor", new Doctor(null,null,null,null,null,null,null,null));
        return "addDoctor";
    }
    @PostMapping
    public String addDoctor(Doctor doctor, Model model) {
        doctorRepository.save(doctor);
        model.addAttribute(doctor);
        log.info("Doctor saved: " + doctor);
        return "addDoctorSuccess";
    }
    @DeleteMapping("{doctorId}")
    public String deleteDoctor(@PathVariable String doctorId) {
        doctorRepository.delete(doctorId);
        log.info("Doctor delete: " + doctorId);
        return "deleteSuccess";
    }
}
