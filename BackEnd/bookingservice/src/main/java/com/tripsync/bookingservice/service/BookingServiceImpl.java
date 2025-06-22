package com.tripsync.bookingservice.service;

import com.tripsync.bookingservice.model.Booking;
import com.tripsync.bookingservice.payload.BookingDTO;
import com.tripsync.bookingservice.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void createBooking(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
//        booking.setPNR(bookingDTO.getPNR());
        bookingRepository.save(booking);
    }

    @Override
    public BookingDTO deleteBooking(String PNR) {
        Booking booking = bookingRepository.getBookingByPNR(PNR);

        if (booking.getPNR() != null) {
            bookingRepository.delete(booking);
        }
        return modelMapper.map(booking, BookingDTO.class);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();

        return bookings.stream()
                .map(booking -> modelMapper.map(booking, BookingDTO.class))
                .toList();
    }

    @Override
    public BookingDTO updateBooking(String PNR, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.getBookingByPNR(PNR);

        if (booking.getPNR() != null) {
            if (bookingDTO.getBookedSeats() != null) {
                booking.setBookedSeats(bookingDTO.getBookedSeats());
            }

            if (bookingDTO.getEmail() != null) {
                booking.setEmail(bookingDTO.getEmail());
            }
            if (bookingDTO.getFirstName() != null) {
                booking.setFirstName(bookingDTO.getFirstName());
            }
            if (bookingDTO.getLastName() != null) {
                System.out.println(booking.getPNR());
                booking.setLastName(bookingDTO.getLastName());
            }

            if (bookingDTO.getTotalPrice() != null) {
                booking.setBookedSeats(bookingDTO.getTotalPrice());
            }


        }

bookingRepository.save(booking);
        return modelMapper.map(booking, BookingDTO.class);
    }

    @Override
    public Integer totalBookings(String PNR) {
     return bookingRepository.getTotalBookings(PNR);

    }

    @Override
    public Integer totalPrice(String PNR) {
        return bookingRepository.getTotalPrice(PNR);
    }

    @Override
    public Date travelTime(String PNR) {
        return bookingRepository.getDateAndTime(PNR);

    }
}
