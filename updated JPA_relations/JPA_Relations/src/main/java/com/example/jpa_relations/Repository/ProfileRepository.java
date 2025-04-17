package com.example.jpa_relations.Repository;

import com.example.jpa_relations.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {


    Profile findProfileById(Integer id);
}
