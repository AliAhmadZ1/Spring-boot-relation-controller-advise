package com.example.jpa_relations.Service;

import com.example.jpa_relations.ApiResponse.ApiException;
import com.example.jpa_relations.DTO.ProfileDTO;
import com.example.jpa_relations.Model.Customer;
import com.example.jpa_relations.Model.Profile;
import com.example.jpa_relations.Repository.CustomerRepository;
import com.example.jpa_relations.Repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final CustomerRepository customerRepository;


    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    public void addProfile(ProfileDTO profileDTO) {
        Customer customer = customerRepository.findCustomerById(profileDTO.getCustomer_id());

        if (customer == null)
            throw new ApiException("customer not found to set profile");

        Profile profile = new Profile(null, profileDTO.getEmail(), profileDTO.getPhone_number(), profileDTO.getGender(), customer);
        profileRepository.save(profile);
    }

    public void updateProfile(ProfileDTO profileDTO){
        Profile profile = profileRepository.findProfileById(profileDTO.getCustomer_id());
        if (profile==null)
            throw new ApiException("profile not found");
        profile.setGender(profileDTO.getGender());
        profile.setEmail(profileDTO.getEmail());
        profile.setPhone_number(profileDTO.getPhone_number());
        profileRepository.save(profile);
    }



}
