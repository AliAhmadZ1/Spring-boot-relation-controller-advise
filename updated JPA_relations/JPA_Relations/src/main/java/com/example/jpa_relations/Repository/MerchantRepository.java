package com.example.jpa_relations.Repository;

import com.example.jpa_relations.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Integer> {

    Merchant findMerchantById(Integer id);

}