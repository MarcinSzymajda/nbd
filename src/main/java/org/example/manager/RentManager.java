package org.example.manager;

import jakarta.persistence.PersistenceException;
import org.example.entity.Rent;
import org.example.repository.IRentRepository;

import java.time.LocalDateTime;
import java.util.List;

public class RentManager extends Manager<Rent> {

   private final IRentRepository rentRepository;

   public RentManager(IRentRepository rentRepository) {
      super(rentRepository);
      this.rentRepository = rentRepository;
   }


   @Override
   public boolean add(Rent rent) {
      try {
         // Rent time cannot be in past
         if (rent.getBeginTime().isBefore(LocalDateTime.now()) ||
             rent.getEndTime().isBefore(LocalDateTime.now())) {
            return false;
         }

         // Rent end time cannot be before rent start time
         if (rent.getEndTime().isBefore(rent.getBeginTime())) {
            return false;
         }

         List<Rent> courtRents = rentRepository.findByCourtId(rent.getCourt().getId());

         // New rent cannot interfere with other rents
         if (courtRents.stream().anyMatch(courtRent -> hasConflictWith(rent, courtRent))) {
            return false;
         }

         List<Rent> clientRents = rentRepository.findByClientId(rent.getClient().getId());

         // One person cannot rent more than one court at the same time
         if (clientRents.stream().anyMatch(clientRent -> hasConflictWith(rent, clientRent))) {
            return false;
         }

         return rentRepository.add(rent);

      } catch (PersistenceException e) {
          return false;
      }
   }

   private boolean hasConflictWith(Rent rent, Rent rentDB) {
      return !rent.getEndTime().isBefore(rentDB.getBeginTime()) &&
              !rent.getBeginTime().isAfter(rentDB.getEndTime());
   }
}
