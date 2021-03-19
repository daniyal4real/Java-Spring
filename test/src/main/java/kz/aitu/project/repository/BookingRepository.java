package kz.aitu.project.repository;

import kz.aitu.project.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAll();

    List<Booking> getBookingById(int id);
}
