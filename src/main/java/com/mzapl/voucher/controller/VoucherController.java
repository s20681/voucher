package com.mzapl.voucher.controller;

import com.mzapl.voucher.model.entity.Voucher;
import com.mzapl.voucher.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/vouchers")
public class VoucherController {
    private VoucherService vouchers;

    @Autowired
    public VoucherController(VoucherService vouchers) {
        this.vouchers = vouchers;
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(vouchers.findAll());
    }

    @GetMapping("/entity")
    public ResponseEntity getAllEntity(){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(vouchers.findAll());
    }

    @GetMapping
    public ResponseEntity getById(@RequestParam Long id){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(vouchers.findById(id));
    }

    @PostMapping
    public ResponseEntity addVoucher(@RequestBody Voucher voucher){
        voucher.activation_date = LocalDate.now();
        return ResponseEntity.ok().headers(new HttpHeaders()).body(vouchers.save(voucher));
    }

    @PutMapping
    public ResponseEntity updateVoucher(@RequestBody Voucher voucher){
        return ResponseEntity.ok().headers(new HttpHeaders()).body(vouchers.save(voucher));
    }

    @DeleteMapping
    public void deleteVoucher(@RequestParam Long id){
        vouchers.deleteById(id);
    }

}
