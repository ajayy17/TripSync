package com.tripsync.bookingservice.service;
import com.tripsync.bookingservice.payload.BookingDTO;

import java.util.Date;
import java.util.List;

public interface BookingService {

    void createBooking(BookingDTO bookingDTO);

    BookingDTO deleteBooking(String PNR);

    List<BookingDTO> getAllBookings();

    BookingDTO updateBooking(String PNR,BookingDTO bookingDTO);

    Integer totalBookings(String PNR);

    Integer totalPrice(String PNR);

    Date travelTime(String PNR);
}
