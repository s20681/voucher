package com.mzapl.voucher.service;
import com.mzapl.voucher.model.StoreRepository;
import com.mzapl.voucher.model.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StoreService {
    private final StoreRepository StoreRepository;

    @Autowired
    public StoreService(StoreRepository StoreRepository) {
        this.StoreRepository = StoreRepository;
    }

    public Store findById(String id) { return StoreRepository.findById(id).orElseThrow(()->new NoSuchElementException());}

    public Iterable<Store> findAll() {
        return StoreRepository.findAll();
    }

    public Store save(Store store) {
        return StoreRepository.save(store);
    }

    public void deleteById(String id) {
        StoreRepository.deleteById(id);
    }


//    Populate the database
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Store("PL108", "Empik Galeria Bałtycka", "Gdańsk, 80-200 ul. Grunwaldzka"));
        save(new Store("PL303", "Empik Galeria Przymorze", "Gdańsk, 80-100 ul. Obrońców wybrzeża"));
        save(new Store("PL303", "Empik Matarnia", "Gdańsk, 80-298 ul. Złota Karczma"));
    }
}
