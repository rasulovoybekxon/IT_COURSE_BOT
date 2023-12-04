package uz.pdp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private UUID id;
    private String courseName;
    private String category;
    private String description;
    private Integer level;
    private Long numberOfUsers;
    private Boolean completed_course;

    public Course(String courseName,
                  String category,
                  String description,
                  Integer level,
                  Long numberOfUsers,
                  Boolean completed_course)
    {
        this.courseName = courseName;
        this.category = category;
        this.description = description;
        this.level = level;
        this.numberOfUsers = numberOfUsers;
        this.completed_course = completed_course;
    }
}
