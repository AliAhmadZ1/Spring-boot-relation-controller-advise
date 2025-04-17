package com.example.jpa_relations.Repository;

import com.example.jpa_relations.Model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

    Branch findBranchesById(Integer id);

}