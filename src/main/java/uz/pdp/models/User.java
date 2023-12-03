package uz.pdp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.enums.State;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String userName;
    private String phoneNumber;
    private String chatId;
    private State state;

    public User(String firstName,
                String lastName,
                String userName,
                String phoneNumber,
                String chatId,
                State state)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.chatId = chatId;
        this.state = state;
    }
}
