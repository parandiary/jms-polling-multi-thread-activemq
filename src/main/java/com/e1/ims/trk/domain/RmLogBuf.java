package com.e1.ims.trk.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A RmLogBuf.
 */
@Entity
@Table(name = "rm_log_buf")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RmLogBuf implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 14)
    @Column(name = "pt_dt", length = 14)
    private String ptDt;

    @Size(max = 100)
    @Column(name = "gu_id", length = 100)
    private String guId;

    @Size(max = 100)
    @Column(name = "bgu_id", length = 100)
    private String bguId;

    @Size(max = 24)
    @Column(name = "if_id", length = 24)
    private String ifId;

    @Size(max = 2)
    @Column(name = "hop_cnt", length = 2)
    private String hopCnt;

    @Size(max = 17)
    @Column(name = "proc_tm", length = 17)
    private String procTm;

    @Size(max = 17)
    @Column(name = "proc_tm_cust_01", length = 17)
    private String procTmCust01;

    @Size(max = 17)
    @Column(name = "proc_tm_cust_02", length = 17)
    private String procTmCust02;

    @Size(max = 17)
    @Column(name = "proc_tm_cust_03", length = 17)
    private String procTmCust03;

    @Size(max = 17)
    @Column(name = "proc_tm_cust_04", length = 17)
    private String procTmCust04;

    @Size(max = 17)
    @Column(name = "proc_tm_cust_05", length = 17)
    private String procTmCust05;

    @Size(max = 4)
    @Column(name = "type", length = 4)
    private String type;

    @Size(max = 10)
    @Column(name = "snd_sys_nm", length = 10)
    private String sndSysNm;

    @Size(max = 10)
    @Column(name = "rcv_sys_nm", length = 10)
    private String rcvSysNm;

    @Size(max = 23)
    @Column(name = "snd_ip", length = 23)
    private String sndIp;

    @Size(max = 23)
    @Column(name = "rcv_ip", length = 23)
    private String rcvIp;

    @Size(max = 1)
    @Column(name = "rtn_cd", length = 1)
    private String rtnCd;

    @Size(max = 10)
    @Column(name = "err_cd", length = 10)
    private String errCd;

    @Size(max = 4000)
    @Lob
    @Column(name = "err_msg")
    private String errMsg;

    @Size(max = 4000)
    @Lob
    @Column(name = "err_detail")
    private String errDetail;

    @Size(max = 10)
    @Column(name = "data_len", length = 10)
    private String dataLen;

    @Size(max = 20)
    @Column(name = "qmgr_nm", length = 20)
    private String qmgrNm;

    @Size(max = 20)
    @Column(name = "bk_nm", length = 20)
    private String bkNm;

    @Size(max = 50)
    @Column(name = "eg_nm", length = 50)
    private String egNm;

    @Size(max = 50)
    @Column(name = "mf_nm", length = 50)
    private String mfNm;

    @Size(max = 50)
    @Column(name = "q_nm", length = 50)
    private String qNm;

    @Size(max = 7)
    @Column(name = "insert_dt", length = 7)
    private String insertDt;

    @Size(max = 1000)
    @Column(name = "rcol_1", length = 1000)
    private String rcol1;

    @Size(max = 200)
    @Column(name = "rcol_2", length = 200)
    private String rcol2;

    @Size(max = 200)
    @Column(name = "rcol_3", length = 200)
    private String rcol3;

    @Size(max = 200)
    @Column(name = "rcol_4", length = 200)
    private String rcol4;

    @Size(max = 200)
    @Column(name = "rcol_5", length = 200)
    private String rcol5;

    @Size(max = 200)
    @Column(name = "rcol_6", length = 200)
    private String rcol6;

    @Size(max = 200)
    @Column(name = "rcol_7", length = 200)
    private String rcol7;

    @Size(max = 200)
    @Column(name = "rcol_8", length = 200)
    private String rcol8;

    @Size(max = 200)
    @Column(name = "rcol_9", length = 200)
    private String rcol9;

    @Size(max = 200)
    @Column(name = "rcol_10", length = 200)
    private String rcol10;

    @Size(max = 200)
    @Column(name = "rcol_11", length = 200)
    private String rcol11;

    @Size(max = 200)
    @Column(name = "rcol_12", length = 200)
    private String rcol12;

    @Size(max = 200)
    @Column(name = "rcol_13", length = 200)
    private String rcol13;

    @Size(max = 200)
    @Column(name = "rcol_14", length = 200)
    private String rcol14;

    @Size(max = 200)
    @Column(name = "rcol_15", length = 200)
    private String rcol15;

    @Size(max = 200)
    @Column(name = "rcol_16", length = 200)
    private String rcol16;

    @Size(max = 200)
    @Column(name = "rcol_17", length = 200)
    private String rcol17;

    @Size(max = 200)
    @Column(name = "rcol_18", length = 200)
    private String rcol18;

    @Size(max = 200)
    @Column(name = "rcol_19", length = 200)
    private String rcol19;

    @Size(max = 200)
    @Column(name = "rcol_20", length = 200)
    private String rcol20;

    @Size(max = 1)
    @Column(name = "trkmst_key", length = 1)
    private String trkmstKey;

    @NotNull
    @Size(max = 2)
    @Column(name = "insert_hour", length = 2, nullable = false)
    private String insertHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPtDt() {
        return ptDt;
    }

    public RmLogBuf ptDt(String ptDt) {
        this.ptDt = ptDt;
        return this;
    }

    public void setPtDt(String ptDt) {
        this.ptDt = ptDt;
    }

    public String getGuId() {
        return guId;
    }

    public RmLogBuf guId(String guId) {
        this.guId = guId;
        return this;
    }

    public void setGuId(String guId) {
        this.guId = guId;
    }



    public String getBguId() {
        return bguId;
    }

    public RmLogBuf bguId(String bguId) {
        this.bguId = bguId;
        return this;
    }

    public void setBguId(String bguId) {
        this.bguId = bguId;
    }




    public String getIfId() {
        return ifId;
    }

    public RmLogBuf ifId(String ifId) {
        this.ifId = ifId;
        return this;
    }

    public void setIfId(String ifId) {
        this.ifId = ifId;
    }

    public String getHopCnt() {
        return hopCnt;
    }

    public RmLogBuf hopCnt(String hopCnt) {
        this.hopCnt = hopCnt;
        return this;
    }

    public void setHopCnt(String hopCnt) {
        this.hopCnt = hopCnt;
    }

    public String getProcTm() {
        return procTm;
    }

    public RmLogBuf procTm(String procTm) {
        this.procTm = procTm;
        return this;
    }

    public void setProcTm(String procTm) {
        this.procTm = procTm;
    }

    public String getProcTmCust01() {
        return procTmCust01;
    }

    public RmLogBuf procTmCust01(String procTmCust01) {
        this.procTmCust01 = procTmCust01;
        return this;
    }

    public void setProcTmCust01(String procTmCust01) {
        this.procTmCust01 = procTmCust01;
    }

    public String getProcTmCust02() {
        return procTmCust02;
    }

    public RmLogBuf procTmCust02(String procTmCust02) {
        this.procTmCust02 = procTmCust02;
        return this;
    }

    public void setProcTmCust02(String procTmCust02) {
        this.procTmCust02 = procTmCust02;
    }

    public String getProcTmCust03() {
        return procTmCust03;
    }

    public RmLogBuf procTmCust03(String procTmCust03) {
        this.procTmCust03 = procTmCust03;
        return this;
    }

    public void setProcTmCust03(String procTmCust03) {
        this.procTmCust03 = procTmCust03;
    }

    public String getProcTmCust04() {
        return procTmCust04;
    }

    public RmLogBuf procTmCust04(String procTmCust04) {
        this.procTmCust04 = procTmCust04;
        return this;
    }

    public void setProcTmCust04(String procTmCust04) {
        this.procTmCust04 = procTmCust04;
    }

    public String getProcTmCust05() {
        return procTmCust05;
    }

    public RmLogBuf procTmCust05(String procTmCust05) {
        this.procTmCust05 = procTmCust05;
        return this;
    }

    public void setProcTmCust05(String procTmCust05) {
        this.procTmCust05 = procTmCust05;
    }

    public String getType() {
        return type;
    }

    public RmLogBuf type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSndSysNm() {
        return sndSysNm;
    }

    public RmLogBuf sndSysNm(String sndSysNm) {
        this.sndSysNm = sndSysNm;
        return this;
    }

    public void setSndSysNm(String sndSysNm) {
        this.sndSysNm = sndSysNm;
    }

    public String getRcvSysNm() {
        return rcvSysNm;
    }

    public RmLogBuf rcvSysNm(String rcvSysNm) {
        this.rcvSysNm = rcvSysNm;
        return this;
    }

    public void setRcvSysNm(String rcvSysNm) {
        this.rcvSysNm = rcvSysNm;
    }

    public String getSndIp() {
        return sndIp;
    }

    public RmLogBuf sndIp(String sndIp) {
        this.sndIp = sndIp;
        return this;
    }

    public void setSndIp(String sndIp) {
        this.sndIp = sndIp;
    }

    public String getRcvIp() {
        return rcvIp;
    }

    public RmLogBuf rcvIp(String rcvIp) {
        this.rcvIp = rcvIp;
        return this;
    }

    public void setRcvIp(String rcvIp) {
        this.rcvIp = rcvIp;
    }

    public String getRtnCd() {
        return rtnCd;
    }

    public RmLogBuf rtnCd(String rtnCd) {
        this.rtnCd = rtnCd;
        return this;
    }

    public void setRtnCd(String rtnCd) {
        this.rtnCd = rtnCd;
    }

    public String getErrCd() {
        return errCd;
    }

    public RmLogBuf errCd(String errCd) {
        this.errCd = errCd;
        return this;
    }

    public void setErrCd(String errCd) {
        this.errCd = errCd;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public RmLogBuf errMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrDetail() {
        return errDetail;
    }

    public RmLogBuf errDetail(String errDetail) {
        this.errDetail = errDetail;
        return this;
    }

    public void setErrDetail(String errDetail) {
        this.errDetail = errDetail;
    }

    public String getDataLen() {
        return dataLen;
    }

    public RmLogBuf dataLen(String dataLen) {
        this.dataLen = dataLen;
        return this;
    }

    public void setDataLen(String dataLen) {
        this.dataLen = dataLen;
    }

    public String getQmgrNm() {
        return qmgrNm;
    }

    public RmLogBuf qmgrNm(String qmgrNm) {
        this.qmgrNm = qmgrNm;
        return this;
    }

    public void setQmgrNm(String qmgrNm) {
        this.qmgrNm = qmgrNm;
    }

    public String getBkNm() {
        return bkNm;
    }

    public RmLogBuf bkNm(String bkNm) {
        this.bkNm = bkNm;
        return this;
    }

    public void setBkNm(String bkNm) {
        this.bkNm = bkNm;
    }

    public String getEgNm() {
        return egNm;
    }

    public RmLogBuf egNm(String egNm) {
        this.egNm = egNm;
        return this;
    }

    public void setEgNm(String egNm) {
        this.egNm = egNm;
    }

    public String getMfNm() {
        return mfNm;
    }

    public RmLogBuf mfNm(String mfNm) {
        this.mfNm = mfNm;
        return this;
    }

    public void setMfNm(String mfNm) {
        this.mfNm = mfNm;
    }

    public String getqNm() {
        return qNm;
    }

    public RmLogBuf qNm(String qNm) {
        this.qNm = qNm;
        return this;
    }

    public void setqNm(String qNm) {
        this.qNm = qNm;
    }

    public String getInsertDt() {
        return insertDt;
    }

    public RmLogBuf insertDt(String insertDt) {
        this.insertDt = insertDt;
        return this;
    }

    public void setInsertDt(String insertDt) {
        this.insertDt = insertDt;
    }

    public String getRcol1() {
        return rcol1;
    }

    public RmLogBuf rcol1(String rcol1) {
        this.rcol1 = rcol1;
        return this;
    }

    public void setRcol1(String rcol1) {
        this.rcol1 = rcol1;
    }

    public String getRcol2() {
        return rcol2;
    }

    public RmLogBuf rcol2(String rcol2) {
        this.rcol2 = rcol2;
        return this;
    }

    public void setRcol2(String rcol2) {
        this.rcol2 = rcol2;
    }

    public String getRcol3() {
        return rcol3;
    }

    public RmLogBuf rcol3(String rcol3) {
        this.rcol3 = rcol3;
        return this;
    }

    public void setRcol3(String rcol3) {
        this.rcol3 = rcol3;
    }

    public String getRcol4() {
        return rcol4;
    }

    public RmLogBuf rcol4(String rcol4) {
        this.rcol4 = rcol4;
        return this;
    }

    public void setRcol4(String rcol4) {
        this.rcol4 = rcol4;
    }

    public String getRcol5() {
        return rcol5;
    }

    public RmLogBuf rcol5(String rcol5) {
        this.rcol5 = rcol5;
        return this;
    }

    public void setRcol5(String rcol5) {
        this.rcol5 = rcol5;
    }

    public String getRcol6() {
        return rcol6;
    }

    public RmLogBuf rcol6(String rcol6) {
        this.rcol6 = rcol6;
        return this;
    }

    public void setRcol6(String rcol6) {
        this.rcol6 = rcol6;
    }

    public String getRcol7() {
        return rcol7;
    }

    public RmLogBuf rcol7(String rcol7) {
        this.rcol7 = rcol7;
        return this;
    }

    public void setRcol7(String rcol7) {
        this.rcol7 = rcol7;
    }

    public String getRcol8() {
        return rcol8;
    }

    public RmLogBuf rcol8(String rcol8) {
        this.rcol8 = rcol8;
        return this;
    }

    public void setRcol8(String rcol8) {
        this.rcol8 = rcol8;
    }

    public String getRcol9() {
        return rcol9;
    }

    public RmLogBuf rcol9(String rcol9) {
        this.rcol9 = rcol9;
        return this;
    }

    public void setRcol9(String rcol9) {
        this.rcol9 = rcol9;
    }

    public String getRcol10() {
        return rcol10;
    }

    public RmLogBuf rcol10(String rcol10) {
        this.rcol10 = rcol10;
        return this;
    }

    public void setRcol10(String rcol10) {
        this.rcol10 = rcol10;
    }

    public String getRcol11() {
        return rcol11;
    }

    public RmLogBuf rcol11(String rcol11) {
        this.rcol11 = rcol11;
        return this;
    }

    public void setRcol11(String rcol11) {
        this.rcol11 = rcol11;
    }

    public String getRcol12() {
        return rcol12;
    }

    public RmLogBuf rcol12(String rcol12) {
        this.rcol12 = rcol12;
        return this;
    }

    public void setRcol12(String rcol12) {
        this.rcol12 = rcol12;
    }

    public String getRcol13() {
        return rcol13;
    }

    public RmLogBuf rcol13(String rcol13) {
        this.rcol13 = rcol13;
        return this;
    }

    public void setRcol13(String rcol13) {
        this.rcol13 = rcol13;
    }

    public String getRcol14() {
        return rcol14;
    }

    public RmLogBuf rcol14(String rcol14) {
        this.rcol14 = rcol14;
        return this;
    }

    public void setRcol14(String rcol14) {
        this.rcol14 = rcol14;
    }

    public String getRcol15() {
        return rcol15;
    }

    public RmLogBuf rcol15(String rcol15) {
        this.rcol15 = rcol15;
        return this;
    }

    public void setRcol15(String rcol15) {
        this.rcol15 = rcol15;
    }

    public String getRcol16() {
        return rcol16;
    }

    public RmLogBuf rcol16(String rcol16) {
        this.rcol16 = rcol16;
        return this;
    }

    public void setRcol16(String rcol16) {
        this.rcol16 = rcol16;
    }

    public String getRcol17() {
        return rcol17;
    }

    public RmLogBuf rcol17(String rcol17) {
        this.rcol17 = rcol17;
        return this;
    }

    public void setRcol17(String rcol17) {
        this.rcol17 = rcol17;
    }

    public String getRcol18() {
        return rcol18;
    }

    public RmLogBuf rcol18(String rcol18) {
        this.rcol18 = rcol18;
        return this;
    }

    public void setRcol18(String rcol18) {
        this.rcol18 = rcol18;
    }

    public String getRcol19() {
        return rcol19;
    }

    public RmLogBuf rcol19(String rcol19) {
        this.rcol19 = rcol19;
        return this;
    }

    public void setRcol19(String rcol19) {
        this.rcol19 = rcol19;
    }

    public String getRcol20() {
        return rcol20;
    }

    public RmLogBuf rcol20(String rcol20) {
        this.rcol20 = rcol20;
        return this;
    }

    public void setRcol20(String rcol20) {
        this.rcol20 = rcol20;
    }

    public String getTrkmstKey() {
        return trkmstKey;
    }

    public RmLogBuf trkmstKey(String trkmstKey) {
        this.trkmstKey = trkmstKey;
        return this;
    }

    public void setTrkmstKey(String trkmstKey) {
        this.trkmstKey = trkmstKey;
    }

    public String getInsertHour() {
        return insertHour;
    }

    public RmLogBuf insertHour(String insertHour) {
        this.insertHour = insertHour;
        return this;
    }

    public void setInsertHour(String insertHour) {
        this.insertHour = insertHour;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RmLogBuf rmLogBuf = (RmLogBuf) o;
        if (rmLogBuf.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rmLogBuf.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RmLogBuf{" +
            "id=" + getId() +
            ", ptDt='" + getPtDt() + "'" +
            ", guId='" + getGuId() + "'" +
            ", bguId='" + getBguId() + "'" +
            ", ifId='" + getIfId() + "'" +
            ", hopCnt='" + getHopCnt() + "'" +
            ", procTm='" + getProcTm() + "'" +
            ", procTmCust01='" + getProcTmCust01() + "'" +
            ", procTmCust02='" + getProcTmCust02() + "'" +
            ", procTmCust03='" + getProcTmCust03() + "'" +
            ", procTmCust04='" + getProcTmCust04() + "'" +
            ", procTmCust05='" + getProcTmCust05() + "'" +
            ", type='" + getType() + "'" +
            ", sndSysNm='" + getSndSysNm() + "'" +
            ", rcvSysNm='" + getRcvSysNm() + "'" +
            ", sndIp='" + getSndIp() + "'" +
            ", rcvIp='" + getRcvIp() + "'" +
            ", rtnCd='" + getRtnCd() + "'" +
            ", errCd='" + getErrCd() + "'" +
            ", errMsg='" + getErrMsg() + "'" +
            ", errDetail='" + getErrDetail() + "'" +
            ", dataLen='" + getDataLen() + "'" +
            ", qmgrNm='" + getQmgrNm() + "'" +
            ", bkNm='" + getBkNm() + "'" +
            ", egNm='" + getEgNm() + "'" +
            ", mfNm='" + getMfNm() + "'" +
            ", qNm='" + getqNm() + "'" +
            ", insertDt='" + getInsertDt() + "'" +
            ", rcol1='" + getRcol1() + "'" +
            ", rcol2='" + getRcol2() + "'" +
            ", rcol3='" + getRcol3() + "'" +
            ", rcol4='" + getRcol4() + "'" +
            ", rcol5='" + getRcol5() + "'" +
            ", rcol6='" + getRcol6() + "'" +
            ", rcol7='" + getRcol7() + "'" +
            ", rcol8='" + getRcol8() + "'" +
            ", rcol9='" + getRcol9() + "'" +
            ", rcol10='" + getRcol10() + "'" +
            ", rcol11='" + getRcol11() + "'" +
            ", rcol12='" + getRcol12() + "'" +
            ", rcol13='" + getRcol13() + "'" +
            ", rcol14='" + getRcol14() + "'" +
            ", rcol15='" + getRcol15() + "'" +
            ", rcol16='" + getRcol16() + "'" +
            ", rcol17='" + getRcol17() + "'" +
            ", rcol18='" + getRcol18() + "'" +
            ", rcol19='" + getRcol19() + "'" +
            ", rcol20='" + getRcol20() + "'" +
            ", trkmstKey='" + getTrkmstKey() + "'" +
            ", insertHour='" + getInsertHour() + "'" +
            "}";
    }
}
