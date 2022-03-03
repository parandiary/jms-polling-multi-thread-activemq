package com.e1.ims.trk.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.e1.ims.trk.domain.RmLog;

/**
 * Service Interface for managing RmLog.
 */
public interface RmLogService {

    /**
     * Save a rmLog.
     *
     * @param rmLog the entity to save
     * @return the persisted entity
     */
    RmLog insert(RmLog rmLog);

    RmLog save(RmLog rmLog);

    /**
     * Get all the rmLogs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<RmLog> findAll(Pageable pageable);

    /**
     * Get the "id" rmLog.
     *
     * @param id the id of the entity
     * @return the entity
     */
    RmLog findOne(String id);

    /**
     * Get the "id" rmLog.
     *
     * @param id the id of the entity
     * @return the entity
     */
    RmLog findOne(String id, String ptDt, String hopCnt);

    /**
     * Delete the "id" rmLog.
     *
     * @param id the id of the entity
     */
    void delete(String id);

    Page<RmLog> findByGuId(Pageable pageable, String guId);

    Page<RmLog> findByGuId(Pageable pageable, String guId, String ptDt);

}
