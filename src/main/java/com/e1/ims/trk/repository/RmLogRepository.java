package com.e1.ims.trk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e1.ims.trk.domain.RmLog;


/**
 * Spring Data JPA repository for the RmLog entity.
 */
@Repository
public interface RmLogRepository extends JpaRepository<RmLog, String> {

    //List<RmLog> findByGuId(String guId);
    //@QueryHints(value = {@QueryHint(name = "INDEX", value = "RM_LOG IDX_RM_LOG_01")},forCounting = false)
    Page<RmLog> findAllById(Pageable pageable, String guId);

    //@QueryHints(value = {@QueryHint(name = "INDEX", value = "RM_LOG IDX_RM_LOG_01")},forCounting = false)
    Page<RmLog> findAllByIdAndPtDt(Pageable pageable, String guId, String ptDt);

    //@QueryHints(value = {@QueryHint(name = "INDEX", value = "RM_LOG IDX_RM_LOG_01")},forCounting = false)
    RmLog findOneByIdAndPtDtAndHopCnt(String guId, String ptDt, String hopCnt);

    //@QueryHints(value = {@QueryHint(name = "INDEX", value = "RM_LOG IDX_RM_LOG_01")},forCounting = false)
    void deleteByIdAndPtDtAndHopCnt(String guId, String ptDt, String hopCnt);



}
