package uz.pdp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersCourses {
    private UUID userId;
    private UUID courseId;
    private boolean completedCourse;

}
