package hospital.data;
import hospital.Doctor;

public interface DoctorRepository {
    Iterable<Doctor> findAll();
    Doctor findById(String id);
    Doctor save(Doctor ingredient);
    void delete(String id);
}