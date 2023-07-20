package com.osi.estimationmodule.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osi.estimationmodule.entities.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}
