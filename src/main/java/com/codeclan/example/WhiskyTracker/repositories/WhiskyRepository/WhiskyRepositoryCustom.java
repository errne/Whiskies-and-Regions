package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WhiskyRepositoryCustom {
     List<Whisky> findWhiskiesByYear(int year);
     List<Whisky> findWhiskiesbyDistilleryIdAndAge(Long distillery_id, int age);


}
