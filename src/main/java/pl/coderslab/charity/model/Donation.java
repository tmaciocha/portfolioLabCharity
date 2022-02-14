package pl.coderslab.charity.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

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

    @OneToMany
    List<Category> categories = new ArrayList<>();

    @OneToOne
    Institution institution;

    String street;
    String city;
    String zipCode;
    LocalDate pickUpDate;
    LocalTime pickUpTime;
    String pickUpComment;
}
