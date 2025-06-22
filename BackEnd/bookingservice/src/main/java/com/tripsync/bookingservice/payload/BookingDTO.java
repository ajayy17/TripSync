package com.tripsync.bookingservice.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;

    private String userName;

    private String email;

    private String firstName;

    private String lastName;

    private Date dateAndTimeOfTravel;

    private String departureAirport;

    private String arrivalAirport;

    private String fromCity;

    private String toCity;

    private String PNR;

    private Integer totalPrice;

    private Integer bookedSeats;

}
