package uz.pdp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.enums.State;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String chatId;
    private State state;


}
