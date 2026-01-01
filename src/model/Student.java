package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    private String username;
    private String password;
    private String email;
}
