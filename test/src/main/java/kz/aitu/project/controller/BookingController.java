package kz.aitu.project.controller;

import kz.aitu.project.entity.Booking;
import kz.aitu.project.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/api/bookings")
    public List<Booking> getAllBookings(){
        return bookingService.getAll();
    }

    @GetMapping("/api/bookings/{id}")
    public List<Booking> getBookingById(@PathVariable int id){
        return bookingService.getBookingById(id);
    }

    @PostMapping("/api/bookings")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking){
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @PutMapping("/api/bookings/{id}")
    public ResponseEntity<?> updateBookingById(@RequestBody Booking booking,@PathVariable int id){
        return ResponseEntity.ok(bookingService.updateBookingById(booking, id));
    }

    @DeleteMapping("/api/bookings/{id}")
    public void deleteBookingById(@PathVariable int id){
        bookingService.deleteById(id);
    }
}
