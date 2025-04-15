package com.example.jpa_relations.Controller;

import com.example.jpa_relations.ApiResponse.ApiResponse;
import com.example.jpa_relations.DTO.ProfileDTO;
import com.example.jpa_relations.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;


    @GetMapping("/get")
    public ResponseEntity getAllProfiles(){
        return ResponseEntity.status(200).body(profileService.getAllProfiles());
    }

    @PostMapping("/add")
    public ResponseEntity addProfile(@RequestBody@Valid ProfileDTO profileDTO){
        profileService.addProfile(profileDTO);
        return ResponseEntity.status(200).body(new ApiResponse("profile is added"));
    }


}
