package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcDoctorRepository implements DoctorRepository {
    private JdbcTemplate jdbc;
    @Autowired
    public JdbcDoctorRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Doctor> findAll() {
        return jdbc.query("select * from Doctor",
                this::mapRowToIngredient);
    }

    @Override
    public Doctor findById(String id) {
        return jdbc.queryForObject("select * Doctor where id=?", this::mapRowToIngredient, id);
    }

    @Override
    public Doctor save(Doctor doctor) {
        jdbc.update("insert into Doctor (id, idCard, name , address, level,experience, type, academicLevel) values (?, ?, ?)",
                doctor.getId(),
                doctor.getIdCard(),
                doctor.getName(),
                doctor.getAddress(),
                doctor.getLevel(),
                doctor.getExperience(),
                doctor.getType(),
                doctor.getAcademicLevel());
        return doctor;
    }

    private Doctor mapRowToIngredient(ResultSet rs, int rowNum)
            throws SQLException {
        return new Doctor(
                rs.getString("id"),
                rs.getString("idCard"),
                rs.getString("name"),
                rs.getString("address"),
                rs.getString("level"),
                rs.getString("experience"),
                rs.getString("type"),
                rs.getString("academicLevel"));
    }
}