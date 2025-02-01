package com.Kasun.car_rental_system.services.client;

import com.Kasun.car_rental_system.dto.AdDTO;
import com.Kasun.car_rental_system.dto.AdDetailsForClientDTO;
import com.Kasun.car_rental_system.dto.ReservationDTO;

import java.util.List;

public interface ClientService {

    List<AdDTO> getAllAds();

    List<AdDTO> searchAdByName(String name);

    boolean bookService(ReservationDTO reservationDTO);

    AdDetailsForClientDTO getAdDetailsByAdId(Long adId);

    List<ReservationDTO> getAllBookingsByUserId(Long userId);


}
