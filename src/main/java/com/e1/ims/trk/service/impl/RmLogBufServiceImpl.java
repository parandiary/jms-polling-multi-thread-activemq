package com.e1.ims.trk.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1.ims.trk.domain.RmLogBuf;
import com.e1.ims.trk.repository.RmLogBufRepository;
import com.e1.ims.trk.service.RmLogBufService;


/**
 * Service Implementation for managing RmLogBuf.
 */
@Service
@Transactional
public class RmLogBufServiceImpl implements RmLogBufService {

    private final Logger log = LoggerFactory.getLogger(RmLogBufServiceImpl.class);

    private final RmLogBufRepository rmLogBufRepository;

    public RmLogBufServiceImpl(RmLogBufRepository rmLogBufRepository) {
        this.rmLogBufRepository = rmLogBufRepository;
    }

    /**
     * Save a rmLogBuf.
     *
     * @param rmLogBuf the entity to save
     * @return the persisted entity
     */
    @Override
    public RmLogBuf save(RmLogBuf rmLogBuf) {
        log.debug("Request to save RmLogBuf : {}", rmLogBuf);
        return rmLogBufRepository.save(rmLogBuf);
    }

    /**
     * Get all the rmLogBufs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RmLogBuf> findAll(Pageable pageable) {
        log.debug("Request to get all RmLogBufs");
        return rmLogBufRepository.findAll(pageable);
    }

    /**
     * Get one rmLogBuf by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public RmLogBuf findOne(Long id) {
        log.debug("Request to get RmLogBuf : {}", id);
        //return rmLogBufRepository.findById(id).get();
        Optional<RmLogBuf> t = rmLogBufRepository.findById(id);
        if(t.isPresent()) return t.get();
        return null;
    }

    /**
     * Delete the rmLogBuf by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RmLogBuf : {}", id);
        rmLogBufRepository.deleteById(id);
    }
}
