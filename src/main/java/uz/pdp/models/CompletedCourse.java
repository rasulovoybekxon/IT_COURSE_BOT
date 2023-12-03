package uz.pdp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompletedCourse {
    private UUID userId;
    private UUID courseId;
    private String startedCourse;
    private String completedDate;
}
