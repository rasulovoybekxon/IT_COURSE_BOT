package uz.pdp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lesson {
    private UUID id;
    private String nameOfLesson;
    private Boolean completedLesson;
    private UUID courseId;

    public Lesson(String nameOfLesson,
                  Boolean completedLesson,
                  UUID courseId) {
        this.nameOfLesson = nameOfLesson;
        this.completedLesson = completedLesson;
        this.courseId = courseId;
    }

}
