package com.hospitalmanagementsystem.service;

import com.hospitalmanagementsystem.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> getAllList();
    Hospital saveData(Hospital hospital);

    Hospital getDataById(Long id);

    Hospital updateData(Hospital hospital);

    void deleteDataById(Long id);
    public List<Hospital> getByKeyword(String keyword);
}
