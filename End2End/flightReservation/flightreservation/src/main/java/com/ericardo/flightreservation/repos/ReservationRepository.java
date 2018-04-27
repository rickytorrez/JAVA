package com.ericardo.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericardo.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
