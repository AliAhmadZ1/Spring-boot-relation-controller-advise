package com.example.jpa_relations.Service;

import com.example.jpa_relations.ApiResponse.ApiException;
import com.example.jpa_relations.Model.Merchant;
import com.example.jpa_relations.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public List<Merchant> getAllMerchants(){
        return merchantRepository.findAll();
    }

    public void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }

    public void updateMerchant(Integer id, Merchant merchant){
        Merchant oldMerchant = merchantRepository.findMerchantById(id);
        if (oldMerchant==null)
            throw new ApiException("merchant not found");

        oldMerchant.setName(merchant.getName());
        merchantRepository.save(oldMerchant);
    }

    public void deleteMerchant(Integer id){
        Merchant merchant = merchantRepository.findMerchantById(id);
        if (merchant==null)
            throw new ApiException("merchant not found");
        merchantRepository.delete(merchant);
    }

}
