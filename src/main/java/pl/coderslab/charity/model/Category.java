package pl.coderslab.charity.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import net.bytebuddy.implementation.bind.annotation.Default;
import net.bytebuddy.implementation.bind.annotation.DefaultMethod;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String name;

    public Category(String name) {
        this.name = name;
    }

}
