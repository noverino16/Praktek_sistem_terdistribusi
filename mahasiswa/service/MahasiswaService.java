/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noverino.mahasiswa.service;

import com.noverino.mahasiswa.entity.Mahasiswa;
import com.noverino.mahasiswa.repository.MahasiswaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MahasiswaService {
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    
    public void insert(Mahasiswa mahasiswa){
        Optional<Mahasiswa> mhsOptional = 
                mahasiswaRepository.findMahasiswaByEmail(mahasiswa.getEmail());
        if(mhsOptional.isPresent()){
            throw new IllegalStateException("Email sudah ada");
        }
        mahasiswaRepository.save(mahasiswa);
    }
    
    public List<Mahasiswa> getAll(){
        return mahasiswaRepository.findAll();
    }
}
