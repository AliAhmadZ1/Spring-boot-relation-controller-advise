package com.example.jpa_relations.Service;

import com.example.jpa_relations.ApiResponse.ApiException;
import com.example.jpa_relations.Model.Branch;
import com.example.jpa_relations.Model.Merchant;
import com.example.jpa_relations.Repository.BranchRepository;
import com.example.jpa_relations.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final MerchantRepository merchantRepository;

    public List<Branch> getAll(){
        return branchRepository.findAll();
    }

    public void addBranch(Branch branch){
        branchRepository.save(branch);
    }

    public void addWithMerchant(Branch branch, Integer merchantId){
        Merchant merchant = merchantRepository.findMerchantById(merchantId);
        if (merchant==null)
            throw new ApiException("Merchant not found");
        branch.setMerchant(merchant);
        branchRepository.save(branch);
    }

    public void assignBranchToMerchant(Integer branch_id, Integer merchant_id){
        Merchant merchant = merchantRepository.findMerchantById(merchant_id);
        Branch branch = branchRepository.findBranchesById(branch_id);
        if (merchant==null||branch==null)
            throw new ApiException("Merchant or Branch not found");
        branch.setMerchant(merchant);
        branchRepository.save(branch);
    }

    public void updateBranch(Branch branch){

    }

    public void deleteBranch(Integer id){
        Branch branch = branchRepository.findBranchesById(id);
        if (branch==null)
            throw new ApiException("Not found");
        branchRepository.delete(branch);
    }
}
