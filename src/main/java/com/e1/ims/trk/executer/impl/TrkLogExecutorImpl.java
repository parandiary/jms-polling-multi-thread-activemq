package com.e1.ims.trk.executer.impl;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1.ims.trk.domain.RmLog;
import com.e1.ims.trk.executer.TrkLogExecutor;
import com.e1.ims.trk.repository.RmLogRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrkLogExecutorImpl implements TrkLogExecutor {


//	@Autowired
//	private RmLogService rmLogService;

	@Autowired
	private RmLogRepository rmLogRepository;

	@PersistenceContext
	private EntityManager em;
	//private EntityManager entityManger;

//	@PersistenceUnit
//	private EntityManagerFactory entityManagerFactory;

	private SimpleDateFormat ptdtDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private SimpleDateFormat procDateFormat = new SimpleDateFormat("YYYYMMddHHmmssSSS");


	@Override
	public void syncTest(String param) throws Exception {
		log.debug("TrkLogServiceImpl message {} ", param);
		Thread.sleep(1000);
	}



	@Override
	@Async("dbProcThreadPoolTaskExecutor")
	@Transactional
	public void insertRmLog(List messages) throws Exception {
		LocalDateTime checkTime = LocalDateTime.now();


		//log.debug("TrkLogServiceImpl insertRmLog messages {} ", messages);
		//EntityManager em = entityManagerFactory.createEntityManager();
		//em.getTransaction().begin();
		// service가 아니라 여기에서 repository를 가져와서 바로 처리
		int cnt = 0;
		for (Object object : messages) {
			String msg = (String) object;
			// TODO: msg converter

			String tmpDate = ptdtDateFormat.format(new Date());
			String tmpProcDate = procDateFormat.format(new Date());

			RmLog rmlog = new RmLog();
			//to_char(systimestamp,'YYYYMMDDHH24MISSFF3')||'_TEST'|| lpad(ROUND(DBMS_RANDOM.VALUE(1, 999),0),3,'0')
			String guid = tmpProcDate +"_" + Thread.currentThread().getName()+ "_" +String.format("%03d", cnt++) ;
			rmlog.setBguId(guid);
			rmlog.setGuId(guid);
			//rmlog.setId(guid);

			rmlog.setPtDt(tmpDate);
			rmlog.setHopCnt("10");
			rmlog.setIfId("IF-TEST-001");
			rmlog.setMsg(msg);
			rmlog.setProcTm(tmpProcDate);
			rmlog.setType("01");
			rmlog.setFlag("N");
			rmlog.setRtnCd("0");
			rmlog.setTrkmstKey("01");


			em.persist(rmlog);
			//rmLogRepository.save(rmlog);

		}
		em.flush();
		//rmLogRepository.flush();

		//em.getTransaction().commit();
		//Thread.sleep(1000);

		Duration duration = Duration.between(checkTime, LocalDateTime.now());
		log.debug(">> insertRmLog duration check msgCnt={} timeNS={} timeS={}",messages.size(), duration.getNano(), duration.getSeconds());

		//em.close();


	}


	@Override
	@Async("dbProcThreadPoolTaskExecutor")
	public void insertRmLogBuf(List messages) throws Exception {
		log.debug("TrkLogServiceImpl insertRmLogBuf messages {} ", messages);
		Thread.sleep(500);

	}

}
