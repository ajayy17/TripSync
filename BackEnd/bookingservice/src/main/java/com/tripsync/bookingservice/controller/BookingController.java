package com.tripsync.bookingservice.controller;

import com.tripsync.bookingservice.payload.BookingDTO;
import com.tripsync.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/tripSync")
public class BookingController {

    @Autowired
    BookingService bookingService;

@PostMapping("booking/createBooking")
public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO){
bookingService.createBooking(bookingDTO);
    return new ResponseEntity<>(bookingDTO, HttpStatus.CREATED);
}

    @GetMapping("booking/getAllBookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings(){
  List<BookingDTO> bookings=  bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.FOUND);
    }


    @PutMapping("booking/updateBooking/{PNR}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable String PNR,@RequestBody BookingDTO bookingDTO){
BookingDTO booking=bookingService.updateBooking(PNR,bookingDTO);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping("booking/deleteBooking/{PNR}")
    public ResponseEntity<BookingDTO> deleteBooking(@PathVariable String PNR)
    {
        BookingDTO booking=bookingService.deleteBooking(PNR);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("booking/getAmount/{PNR}")
    public ResponseEntity<Integer> getAmount(@PathVariable String PNR)
    {
        Integer booking=bookingService.totalPrice(PNR);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("booking/getBookings/{PNR}")
    public ResponseEntity<Integer> getBookings(@PathVariable String PNR)
    {
        Integer booking=bookingService.totalBookings(PNR);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @GetMapping("booking/travelTime/{PNR}")
    public ResponseEntity<Date> travelTime(@PathVariable String PNR)
    {
        Date booking=bookingService.travelTime(PNR);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
