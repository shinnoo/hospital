package tacos.data;
import tacos.Doctor;

public interface DoctorRepository {
    Iterable<Doctor> findAll();
    Doctor findById(String id);
    Doctor save(Doctor ingredient);
}