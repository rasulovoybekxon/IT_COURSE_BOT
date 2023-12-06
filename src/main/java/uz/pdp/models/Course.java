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
    private long numberUsers;
}
