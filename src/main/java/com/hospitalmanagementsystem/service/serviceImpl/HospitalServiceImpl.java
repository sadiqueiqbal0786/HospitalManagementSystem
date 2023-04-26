package com.hospitalmanagementsystem.service.serviceImpl;

import com.hospitalmanagementsystem.entity.Hospital;
import com.hospitalmanagementsystem.repo.HospitalRepo;
import com.hospitalmanagementsystem.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    HospitalRepo hospitalRepo;
    @Override
    public List<Hospital> getAllList() {
        return hospitalRepo.findAll();
    }

    @Override
    public Hospital saveData(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    @Override
    public Hospital getDataById(Long id) {
        return hospitalRepo.findById(id).get();
    }

    @Override
    public Hospital updateData(Hospital hospital) {
        return hospitalRepo.save(hospital);
    }

    @Override
    public void deleteDataById(Long id) {
        hospitalRepo.deleteById(id);

    }

    @Override
    public List<Hospital> getByKeyword(String keyword) {
        return hospitalRepo.findByKeyword(keyword);
    }
}
