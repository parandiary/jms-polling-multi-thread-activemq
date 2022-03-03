package com.e1.ims.trk.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.e1.ims.trk.domain.RmLogBuf;

/**
 * Service Interface for managing RmLogBuf.
 */
public interface RmLogBufService {

    /**
     * Save a rmLogBuf.
     *
     * @param rmLogBuf the entity to save
     * @return the persisted entity
     */
    RmLogBuf save(RmLogBuf rmLogBuf);

    /**
     * Get all the rmLogBufs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<RmLogBuf> findAll(Pageable pageable);

    /**
     * Get the "id" rmLogBuf.
     *
     * @param id the id of the entity
     * @return the entity
     */
    RmLogBuf findOne(Long id);

    /**
     * Delete the "id" rmLogBuf.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
