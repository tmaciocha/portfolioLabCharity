package pl.coderslab.charity.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    Integer quantity;// (liczba worków)

    @ManyToMany //ManyToMany
    List<Category> categories = new ArrayList<>();

    @ManyToOne //ManyToOne
    Institution institution;

    String street;
    String city;
    String zipCode;
    String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;
}
