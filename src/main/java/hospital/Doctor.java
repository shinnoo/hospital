package hospital;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Doctor {
    private String id;
    private String idCard;
    private String name;
    private String address;
    private String level;
    private String experience;
    private String type;
    private String academicLevel;

}
