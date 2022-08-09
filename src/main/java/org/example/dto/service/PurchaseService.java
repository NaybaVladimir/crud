package org.example.dto.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dto.model.Purchases;
import org.example.dto.repos.PurchaseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PurchaseService {
    private PurchaseRepository purchaseRepository;

    @Transactional
    public void save(Purchases purchases) {
        purchaseRepository.save(purchases);
    }

}
