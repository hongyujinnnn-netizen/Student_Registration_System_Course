package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private String courseId;
    private String courseName;
    private double price;
    private int seats;
}
