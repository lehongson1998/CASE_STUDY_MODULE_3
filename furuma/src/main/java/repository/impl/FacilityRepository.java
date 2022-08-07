package repository.impl;

import connect.DatabaseConnect;
import model.facility.Facility;
import model.facility.RentType;
import model.facility.ServiceType;
import repository.IFacilityRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private final String FIND_FACILITY = "CALL find_all_service();";

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
        List<Facility> facilityList = new ArrayList<>();
        Facility facility;
        Connection connection = DatabaseConnect.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(FIND_FACILITY);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                int area = resultSet.getInt("dien_tich");
                double deposit = resultSet.getInt("chi_phi_thue");
                int maxPeople = resultSet.getInt("so_nguoi_toi_da");
                int rentType = resultSet.getInt("ma_kieu_thue");
                int facilityType = resultSet.getInt("ma_loai_dich_vu");
                String standardRoom = resultSet.getString("tieu_chuan_phong");
                String description = resultSet.getString("mo_ta_tien_nghi_khac");
                double poolArea = resultSet.getInt("dien_tich_ho_boi");
                int numberFloor = resultSet.getInt("so_tang");
                String facilityFree = resultSet.getString("dien_tich_mien_phi_di_kem");
                facility = new Facility(id, name, area, deposit, maxPeople, rentType, facilityType, standardRoom, description, poolArea, numberFloor, facilityFree);
                facilityList.add(facility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilityList;
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
