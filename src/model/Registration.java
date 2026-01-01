package model;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private String studentId;
    private String courseId;
    private double amount;
    private LocalDate date;
}
