package com.intuit.be_a_friend.DTO;

import com.intuit.be_a_friend.entities.UserInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    public UserDTO(UserInfo user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }
}
