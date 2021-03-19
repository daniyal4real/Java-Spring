package kz.aitu.project.service;

import kz.aitu.project.entity.Booking;
import kz.aitu.project.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingById(int id) {
        return bookingRepository.getBookingById(id);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBookingById(Booking booking, int id) {
        return bookingRepository.save(booking);
    }

    public void deleteById(long id) {
        bookingRepository.deleteById(id);
    }
}
