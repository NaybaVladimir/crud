package org.example.dto.repos;

import org.example.dto.model.Purchases;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchases, Long> {
}
