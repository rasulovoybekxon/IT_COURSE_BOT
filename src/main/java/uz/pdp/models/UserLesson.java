package uz.pdp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLesson {
    private UUID lessonId;
    private UUID userId;
    private boolean completed;
    private LocalDateTime completedDate;
}
