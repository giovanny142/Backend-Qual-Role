package com.qual_role.repositories;

import com.qual_role.models.QueueModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QueueRepository extends JpaRepository<QueueModel, UUID> {
}
