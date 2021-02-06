package com.mzapl.voucher.controller;

import com.mzapl.voucher.model.entity.Voucher;
import com.mzapl.voucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    private VoucherService stores;

    @Autowired
    public StoreController(VoucherService vouchers) {
        this.stores = vouchers;
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(stores.findAll());
    }

    @GetMapping("/entity")
    public ResponseEntity getAllEntity(){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(stores.findAll());
    }

    @GetMapping
    public ResponseEntity getById(@RequestParam Long id){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(stores.findById(id));
    }

    @PostMapping
    public ResponseEntity addStore(@RequestBody Voucher voucher){
        voucher.activation_date = LocalDate.now();
        return ResponseEntity.ok().headers(new HttpHeaders()).body(stores.save(voucher));
    }

    @PutMapping
    public ResponseEntity updateStore(@RequestBody Voucher voucher){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(stores.save(voucher));
    }

    @DeleteMapping
    public void deleteVoucher(@RequestParam Long id){
        stores.deleteById(id);
    }
}
