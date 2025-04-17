package com.example.jpa_relations.Controller;

import com.example.jpa_relations.ApiResponse.ApiResponse;
import com.example.jpa_relations.Model.Branch;
import com.example.jpa_relations.Model.Merchant;
import com.example.jpa_relations.Service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/branch")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(branchService.getAll());
    }

    @PostMapping("/add-with/{merchantId}")
    public ResponseEntity addWithMerchant(@RequestBody@Valid Branch branch, @PathVariable Integer merchantId){
        branchService.addWithMerchant(branch, merchantId);
        return ResponseEntity.status(200).body(new ApiResponse("new branch added"));
    }

    @PostMapping("/add")
    public ResponseEntity addBranch(@RequestBody@Valid Branch branch){
        branchService.addBranch(branch);
        return ResponseEntity.status(200).body(new ApiResponse("new branch added"));
    }

    @PutMapping("/assign-branch/branch/{branch_id}/merchant/{merchantId}")
    public ResponseEntity assignBranchToMerchant(@PathVariable Integer branch_id, @PathVariable Integer merchantId){
        branchService.assignBranchToMerchant(branch_id, merchantId);
        return ResponseEntity.status(200).body(new ApiResponse("branch assigned to merchant successfully"));
    }

}
