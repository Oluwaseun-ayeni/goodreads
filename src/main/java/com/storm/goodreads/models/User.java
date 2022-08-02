package com.storm.goodreads.models;

import com.storm.goodreads.models.enums.AccountStatus;
import com.storm.goodreads.models.enums.Gender;
import lombok.*;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;



@Getter
@Setter
@Entity
@Table(name = "users")
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }


    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_sequence")
    private long id;

    @NotNull
    @NotBlank
    private String firstname;


    @NotNull
    @NotBlank
    private  String lastname;

    @Email
    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    private String password;
    private LocalDateTime dob;
    private LocalDateTime datejoined;
    private String location;

    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;


}
