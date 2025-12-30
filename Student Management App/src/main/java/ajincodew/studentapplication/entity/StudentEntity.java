package ajincodew.studentapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//L'entité principale Student contient les champs id, firstName, lastName, email et age.
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT")
public class StudentEntity {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Age")
    private int age;

    @OneToOne
    private MajorEntity major;
}