package com.Kasun.car_rental_system.services.company;

import com.Kasun.car_rental_system.dto.AdDTO;
import com.Kasun.car_rental_system.dto.ReservationDTO;

import java.io.IOException;
import java.util.List;

public interface CompanyService {

    boolean postAd(Long userId, AdDTO adDTO) throws IOException;

    List<AdDTO> getAllAds(Long userId);

    AdDTO getAdById(Long adId);

    boolean updateAd(Long adId, AdDTO adDTO) throws IOException;

    boolean deleteAd(Long adId);

    List<ReservationDTO> getAllAdBookings(Long companyId);

    boolean changeBookingStatus(Long bookingId, String status);
}
