package com.tripsync.bookingservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@Table(name="booking",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id"),

        @UniqueConstraint(columnNames = "email")
})

@Setter
@Getter
public class Booking {


    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "PNR")
    private String PNR;


    @NotBlank
    @Column(name = "username")
    private String userName;

    @NotBlank
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "firstName")
    private String firstName;

    @NotBlank
    @Column(name = "lastName")
    private String lastName;

    @NotBlank
    @Column(name = "dateAndTimeOfTravel")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAndTimeOfTravel;

    @NotBlank
    @Column(name = "departureAirport")
    private String departureAirport;

    @NotBlank
    @Column(name = "arrivalAirport")
    private String arrivalAirport;

    @NotBlank
    @Column(name = "fromCity")
    private String fromCity;

    @NotBlank
    @Column(name = "toCity")
    private String toCity;



    @NotBlank
    @Column(name = "totalPrice")
    private Integer totalPrice;

    @NotBlank
    @Column(name = "bookedSeats")
    private Integer bookedSeats;


}



