package service.impl;

import model.facility.Facility;
import model.facility.RentType;
import model.facility.ServiceType;
import repository.impl.FacilityRepository;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    FacilityRepository facilityRepository = new FacilityRepository();


    @Override
    public boolean CreateFacility(Facility facility) {
        return false;
    }

    @Override
    public boolean editFacility(Facility facility, int id) {
        return false;
    }

    @Override
    public boolean deleteFacility(int id) {
        return false;
    }

    @Override
    public List<Facility> findAllFacility() {
        return facilityRepository.findAllFacility();
    }

    @Override
    public List<Facility> findByName() {
        return null;
    }

    @Override
    public Facility findById(int id_search) {
        return null;
    }

    @Override
    public List<ServiceType> getServiceTypeList() {
        return null;
    }

    @Override
    public List<RentType> getRentalTypeList() {
        return null;
    }
}
