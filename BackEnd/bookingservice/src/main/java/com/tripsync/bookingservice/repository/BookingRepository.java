package com.tripsync.bookingservice.repository;

import com.tripsync.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    Booking getBookingByPNR(String PNR);

    @Query("Select b.bookedSeats from Booking b where b.PNR=:PNR")
    Integer getTotalBookings(@Param("PNR") String PNR);
    @Query("SELECT b.totalPrice FROM Booking b WHERE b.PNR = :PNR")
    Integer getTotalPrice(@Param("PNR") String pnr);
    @Query("SELECT b.dateAndTimeOfTravel FROM Booking b WHERE b.PNR=:PNR")
    Date getDateAndTime(@Param("PNR") String PNR);
}
