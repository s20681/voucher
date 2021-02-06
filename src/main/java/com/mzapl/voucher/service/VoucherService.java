package com.mzapl.voucher.service;

import com.mzapl.voucher.controller.StoreController;
import com.mzapl.voucher.model.VoucherRepository;
import com.mzapl.voucher.model.entity.Store;
import com.mzapl.voucher.model.entity.Voucher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VoucherService {
    private final VoucherRepository VoucherRepository;

    @Autowired
    public VoucherService(VoucherRepository VoucherRepository) {
        this.VoucherRepository = VoucherRepository;
    }

    @Autowired
    StoreService stores;

    public Voucher findById(Long id) { return VoucherRepository.findById(id).orElseThrow(()->new NoSuchElementException()); }

    public Iterable<Voucher> findAll() {
        return VoucherRepository.findAll();
    }

    public Voucher save(Voucher voucher) {
        return VoucherRepository.save(voucher);
    }

    public void deleteById(Long id) {
        VoucherRepository.deleteById(id);
    }

//    Populate the database
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {

//        save(new Voucher(new Store("PL303","x", "y"), 666L, true));
        save(new Voucher(100L, true));
        save(new Voucher(300L, true));
        save(new Voucher(200L, true));
        save(new Voucher(250L, true));
        save(new Voucher(350L, false));
    }
}
