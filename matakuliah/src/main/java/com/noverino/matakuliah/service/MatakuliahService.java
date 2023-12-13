/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.noverino.matakuliah.service;

import com.noverino.matakuliah.entity.Matakuliah;
import com.noverino.matakuliah.Repository.MatakuliahRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service

public class MatakuliahService {
    @Autowired 
    private MatakuliahRepository matakuliahRepository;
    public List<Matakuliah>getAll(){
        return matakuliahRepository.findAll();
    }
    
   public void insert(Matakuliah matakuliah){
       matakuliahRepository.save(matakuliah);
   }
}
