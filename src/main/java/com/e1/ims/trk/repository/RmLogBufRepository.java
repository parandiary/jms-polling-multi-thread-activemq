package com.e1.ims.trk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e1.ims.trk.domain.RmLogBuf;


/**
 * Spring Data JPA repository for the RmLogBuf entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RmLogBufRepository extends JpaRepository<RmLogBuf, Long> {

}
