package com.tripsync.userservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "LoginTable",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "loginId")
        })

public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private int loginId;

    @NotBlank
    @OneToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User email;

    @NotBlank
    @Column(name = "jwtToken")
    private String token;

    @NotBlank
    @Column(name = "Date")
    private Date Date;

    @NotBlank
    @Column(name = "Time")
    private Time time;
}