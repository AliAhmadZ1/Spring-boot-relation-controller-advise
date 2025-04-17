package com.example.jpa_relations.Controller;

import com.example.jpa_relations.ApiResponse.ApiResponse;
import com.example.jpa_relations.Model.Merchant;
import com.example.jpa_relations.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(merchantService.getAllMerchants());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody@Valid Merchant merchant){
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("new Merchant is added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id,@RequestBody@Valid Merchant merchant){
        merchantService.updateMerchant(id, merchant);
        return ResponseEntity.status(200).body(new ApiResponse(" Merchant is updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity addMerchant(@PathVariable Integer id){
        merchantService.deleteMerchant(id);
        return ResponseEntity.status(200).body(new ApiResponse(" Merchant is deleted"));
    }
}
