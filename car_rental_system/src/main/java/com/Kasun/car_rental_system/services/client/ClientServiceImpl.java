package com.Kasun.car_rental_system.services.client;


import com.Kasun.car_rental_system.dto.AdDTO;
import com.Kasun.car_rental_system.dto.AdDetailsForClientDTO;
import com.Kasun.car_rental_system.dto.ReservationDTO;
import com.Kasun.car_rental_system.entity.Ad;
import com.Kasun.car_rental_system.entity.Reservation;
import com.Kasun.car_rental_system.entity.User;
import com.Kasun.car_rental_system.enums.ReservationStatus;
import com.Kasun.car_rental_system.enums.ReviewStatus;
import com.Kasun.car_rental_system.repository.AdRepository;
import com.Kasun.car_rental_system.repository.ReservationRepository;
import com.Kasun.car_rental_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private AdRepository adRepository;

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public ReservationRepository reservationRepository;

    public List<AdDTO> getAllAds(){
        return adRepository.findAll().stream().map(Ad::getAdDTO).collect(Collectors.toList());
    }

    public List<AdDTO> searchAdByName(String name){
        return adRepository.findAllByServiceNameContaining(name).stream().map(Ad::getAdDTO).collect(Collectors.toList());
    }

    public boolean bookService(ReservationDTO reservationDTO){

        Optional<Ad> optionalAd=adRepository.findById(reservationDTO.getAdId());
        Optional<User> optionalUser=userRepository.findById(reservationDTO.getUserId());

        if(optionalAd.isPresent() && optionalUser.isPresent()){
           Reservation reservation=new Reservation();

           reservation.setBookDate(reservationDTO.getBookDate());
           reservation.setReservationStatus(ReservationStatus.PENDING);
           reservation.setUser(optionalUser.get());
           reservation.setAd(optionalAd.get());
           reservation.setCompany(optionalAd.get().getUser());
           reservation.setReviewStatus(ReviewStatus.FALSE);

           reservationRepository.save(reservation);
           return true;
        }
return false;
    }

    public AdDetailsForClientDTO getAdDetailsByAdId(Long adId){
        Optional<Ad> optionalAd=adRepository.findById(adId);
        AdDetailsForClientDTO adDetailsForClientDTO=new AdDetailsForClientDTO();
        if(optionalAd.isPresent()){
            adDetailsForClientDTO.setAdDTO(optionalAd.get().getAdDTO());
        }
        return adDetailsForClientDTO;

    }

    public List<ReservationDTO> getAllBookingsByUserId(Long userId){
        return reservationRepository.findAllByCompanyId(userId).stream().map(Reservation::getReservationDto).collect(Collectors.toList());
    }


}
