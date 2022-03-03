package com.e1.ims.trk.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1.ims.trk.domain.RmLog;
import com.e1.ims.trk.repository.RmLogRepository;
import com.e1.ims.trk.service.RmLogService;


/**
 * Service Implementation for managing RmLog.
 */
@Service
@Transactional
public class RmLogServiceImpl implements RmLogService {

    private final Logger log = LoggerFactory.getLogger(RmLogServiceImpl.class);

    private final RmLogRepository rmLogRepository;

    public RmLogServiceImpl(RmLogRepository rmLogRepository) {
        this.rmLogRepository = rmLogRepository;
    }

    /**
     * Save a rmLog.
     *
     * @param rmLog the entity to save
     * @return the persisted entity
     */
    @Override
    public RmLog insert(RmLog rmLog) {
        log.debug("Request to save RmLog : {}", rmLog);
        return rmLogRepository.save(rmLog);
    }

    @Override
    public RmLog save(RmLog rmLog) {
    	log.debug("Request to save RmLog : {}", rmLog);
    	//return rmLogRepository.save(rmLog);
    	return rmLogRepository.saveAndFlush(rmLog);
    }

    /**
     * Get all the rmLogs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<RmLog> findAll(Pageable pageable) {
        log.debug("Request to get all RmLogs");
        return rmLogRepository.findAll(pageable);
    }

    /**
     * Get one rmLog by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public RmLog findOne(String id) {
        log.debug("Request to get RmLog : {}", id);
        //return rmLogRepository.findById(id).get();
        Optional<RmLog> t = rmLogRepository.findById(id);
        if(t.isPresent()) return t.get();
        return null;
    }


    /**
     * Get one rmLog by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public RmLog findOne(String id, String ptDt, String hopCnt) {
        log.debug("Request to get RmLog : {}{}{}", id, ptDt, hopCnt);
        return rmLogRepository.findOneByIdAndPtDtAndHopCnt(id, ptDt, hopCnt);
    }

    /**
     * Delete the rmLog by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete RmLog : {}", id);
        rmLogRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RmLog> findByGuId(Pageable pageable, String guId) {
        log.debug("Request to get all RmLogs By GuId");
        return rmLogRepository.findAllById(pageable, guId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RmLog> findByGuId(Pageable pageable, String guId, String ptDt) {
        log.debug("Request to get all RmLogs By GuId and PtDt");
        //return rmLogRepository.findAllByIdAndPtDt(pageable, guId, ptDt);
        return rmLogRepository.findAllById(pageable, guId);
    }
}
