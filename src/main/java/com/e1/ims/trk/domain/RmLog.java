package com.e1.ims.trk.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

/**
 * A RmLog.
 */
@Entity
@Table(name = "rm_log")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RmLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    */

    @Id
    @Size(max = 50)
    @Column(name = "gu_id", length = 50, nullable = false)
    private String id;

    @Size(max = 14)
    @Column(name = "pt_dt", length = 14)
    private String ptDt;

//    @Size(max = 100)
//    @Column(name = "gu_id", length = 100)
//    private String guId;

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

    @Size(max = 17)
    @Column(name = "proc_tm", length = 17)
    private String procTm;

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
    //@Lob
    @Column(name = "err_msg")
    private String errMsg;

    @Size(max = 4000)
    //@Lob
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

    //@Size(max = 4000)
    //@Column(name = "msg", columnDefinition = "clob")
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "msg")
    private String msg;

    //@Size(max = 7)
    //@Column(name = "insert_dt", length = 7)
    @Column(name = "insert_dt")
    private Instant insertDt = Instant.now();
    //private String insertDt;

    @Size(max = 1)
    @Column(name = "flag", length = 1)
    private String flag;

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

    @NotNull
    @Size(max = 2)
    @Column(name = "trkmst_key", length = 2, nullable = false)
    private String trkmstKey;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = Long.toString(id);
    }

    public String getPtDt() {
        return ptDt;
    }

    public RmLog ptDt(String ptDt) {
        this.ptDt = ptDt;
        return this;
    }

    public void setPtDt(String ptDt) {
        this.ptDt = ptDt;
    }

    public String getGuId() {
        //return guId;
        return id;
    }

    public RmLog guId(String guId) {
        //this.guId = guId;
        this.id = guId;
        return this;
    }

    public void setGuId(String guId) {
        //this.guId = guId;
        this.id = guId;
    }



    public String getBguId() {
        return bguId;
    }

    public RmLog bguId(String bguId) {
        this.bguId = bguId;
        return this;
    }

    public void setBguId(String bguId) {
        this.bguId = bguId;
    }




    public String getIfId() {
        return ifId;
    }

    public RmLog ifId(String ifId) {
        this.ifId = ifId;
        return this;
    }

    public void setIfId(String ifId) {
        this.ifId = ifId;
    }

    public String getHopCnt() {
        return hopCnt;
    }

    public RmLog hopCnt(String hopCnt) {
        this.hopCnt = hopCnt;
        return this;
    }

    public void setHopCnt(String hopCnt) {
        this.hopCnt = hopCnt;
    }

    public String getProcTmCust01() {
        return procTmCust01;
    }

    public RmLog procTmCust01(String procTmCust01) {
        this.procTmCust01 = procTmCust01;
        return this;
    }

    public void setProcTmCust01(String procTmCust01) {
        this.procTmCust01 = procTmCust01;
    }

    public String getProcTmCust02() {
        return procTmCust02;
    }

    public RmLog procTmCust02(String procTmCust02) {
        this.procTmCust02 = procTmCust02;
        return this;
    }

    public void setProcTmCust02(String procTmCust02) {
        this.procTmCust02 = procTmCust02;
    }

    public String getProcTmCust03() {
        return procTmCust03;
    }

    public RmLog procTmCust03(String procTmCust03) {
        this.procTmCust03 = procTmCust03;
        return this;
    }

    public void setProcTmCust03(String procTmCust03) {
        this.procTmCust03 = procTmCust03;
    }

    public String getProcTmCust04() {
        return procTmCust04;
    }

    public RmLog procTmCust04(String procTmCust04) {
        this.procTmCust04 = procTmCust04;
        return this;
    }

    public void setProcTmCust04(String procTmCust04) {
        this.procTmCust04 = procTmCust04;
    }

    public String getProcTmCust05() {
        return procTmCust05;
    }

    public RmLog procTmCust05(String procTmCust05) {
        this.procTmCust05 = procTmCust05;
        return this;
    }

    public void setProcTmCust05(String procTmCust05) {
        this.procTmCust05 = procTmCust05;
    }

    public String getProcTm() {
        return procTm;
    }

    public RmLog procTm(String procTm) {
        this.procTm = procTm;
        return this;
    }

    public void setProcTm(String procTm) {
        this.procTm = procTm;
    }

    public String getType() {
        return type;
    }

    public RmLog type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSndSysNm() {
        return sndSysNm;
    }

    public RmLog sndSysNm(String sndSysNm) {
        this.sndSysNm = sndSysNm;
        return this;
    }

    public void setSndSysNm(String sndSysNm) {
        this.sndSysNm = sndSysNm;
    }

    public String getRcvSysNm() {
        return rcvSysNm;
    }

    public RmLog rcvSysNm(String rcvSysNm) {
        this.rcvSysNm = rcvSysNm;
        return this;
    }

    public void setRcvSysNm(String rcvSysNm) {
        this.rcvSysNm = rcvSysNm;
    }

    public String getSndIp() {
        return sndIp;
    }

    public RmLog sndIp(String sndIp) {
        this.sndIp = sndIp;
        return this;
    }

    public void setSndIp(String sndIp) {
        this.sndIp = sndIp;
    }

    public String getRcvIp() {
        return rcvIp;
    }

    public RmLog rcvIp(String rcvIp) {
        this.rcvIp = rcvIp;
        return this;
    }

    public void setRcvIp(String rcvIp) {
        this.rcvIp = rcvIp;
    }

    public String getRtnCd() {
        return rtnCd;
    }

    public RmLog rtnCd(String rtnCd) {
        this.rtnCd = rtnCd;
        return this;
    }

    public void setRtnCd(String rtnCd) {
        this.rtnCd = rtnCd;
    }

    public String getErrCd() {
        return errCd;
    }

    public RmLog errCd(String errCd) {
        this.errCd = errCd;
        return this;
    }

    public void setErrCd(String errCd) {
        this.errCd = errCd;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public RmLog errMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrDetail() {
        return errDetail;
    }

    public RmLog errDetail(String errDetail) {
        this.errDetail = errDetail;
        return this;
    }

    public void setErrDetail(String errDetail) {
        this.errDetail = errDetail;
    }

    public String getDataLen() {
        return dataLen;
    }

    public RmLog dataLen(String dataLen) {
        this.dataLen = dataLen;
        return this;
    }

    public void setDataLen(String dataLen) {
        this.dataLen = dataLen;
    }

    public String getQmgrNm() {
        return qmgrNm;
    }

    public RmLog qmgrNm(String qmgrNm) {
        this.qmgrNm = qmgrNm;
        return this;
    }

    public void setQmgrNm(String qmgrNm) {
        this.qmgrNm = qmgrNm;
    }

    public String getBkNm() {
        return bkNm;
    }

    public RmLog bkNm(String bkNm) {
        this.bkNm = bkNm;
        return this;
    }

    public void setBkNm(String bkNm) {
        this.bkNm = bkNm;
    }

    public String getEgNm() {
        return egNm;
    }

    public RmLog egNm(String egNm) {
        this.egNm = egNm;
        return this;
    }

    public void setEgNm(String egNm) {
        this.egNm = egNm;
    }

    public String getMfNm() {
        return mfNm;
    }

    public RmLog mfNm(String mfNm) {
        this.mfNm = mfNm;
        return this;
    }

    public void setMfNm(String mfNm) {
        this.mfNm = mfNm;
    }

    public String getqNm() {
        return qNm;
    }

    public RmLog qNm(String qNm) {
        this.qNm = qNm;
        return this;
    }

    public void setqNm(String qNm) {
        this.qNm = qNm;
    }

    public String getMsg() {
        return msg;
    }

    public RmLog msg(String msg) {
        this.msg = msg;
        return this;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Instant getInsertDt() {
        return insertDt;
    }

    public RmLog insertDt(Instant insertDt) {
        this.insertDt = insertDt;
        return this;
    }

    public void setInsertDt(Instant insertDt) {
        this.insertDt = insertDt;
    }

    public String getFlag() {
        return flag;
    }

    public RmLog flag(String flag) {
        this.flag = flag;
        return this;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRcol1() {
        return rcol1;
    }

    public RmLog rcol1(String rcol1) {
        this.rcol1 = rcol1;
        return this;
    }

    public void setRcol1(String rcol1) {
        this.rcol1 = rcol1;
    }

    public String getRcol2() {
        return rcol2;
    }

    public RmLog rcol2(String rcol2) {
        this.rcol2 = rcol2;
        return this;
    }

    public void setRcol2(String rcol2) {
        this.rcol2 = rcol2;
    }

    public String getRcol3() {
        return rcol3;
    }

    public RmLog rcol3(String rcol3) {
        this.rcol3 = rcol3;
        return this;
    }

    public void setRcol3(String rcol3) {
        this.rcol3 = rcol3;
    }

    public String getRcol4() {
        return rcol4;
    }

    public RmLog rcol4(String rcol4) {
        this.rcol4 = rcol4;
        return this;
    }

    public void setRcol4(String rcol4) {
        this.rcol4 = rcol4;
    }

    public String getRcol5() {
        return rcol5;
    }

    public RmLog rcol5(String rcol5) {
        this.rcol5 = rcol5;
        return this;
    }

    public void setRcol5(String rcol5) {
        this.rcol5 = rcol5;
    }

    public String getRcol6() {
        return rcol6;
    }

    public RmLog rcol6(String rcol6) {
        this.rcol6 = rcol6;
        return this;
    }

    public void setRcol6(String rcol6) {
        this.rcol6 = rcol6;
    }

    public String getRcol7() {
        return rcol7;
    }

    public RmLog rcol7(String rcol7) {
        this.rcol7 = rcol7;
        return this;
    }

    public void setRcol7(String rcol7) {
        this.rcol7 = rcol7;
    }

    public String getRcol8() {
        return rcol8;
    }

    public RmLog rcol8(String rcol8) {
        this.rcol8 = rcol8;
        return this;
    }

    public void setRcol8(String rcol8) {
        this.rcol8 = rcol8;
    }

    public String getRcol9() {
        return rcol9;
    }

    public RmLog rcol9(String rcol9) {
        this.rcol9 = rcol9;
        return this;
    }

    public void setRcol9(String rcol9) {
        this.rcol9 = rcol9;
    }

    public String getRcol10() {
        return rcol10;
    }

    public RmLog rcol10(String rcol10) {
        this.rcol10 = rcol10;
        return this;
    }

    public void setRcol10(String rcol10) {
        this.rcol10 = rcol10;
    }

    public String getRcol11() {
        return rcol11;
    }

    public RmLog rcol11(String rcol11) {
        this.rcol11 = rcol11;
        return this;
    }

    public void setRcol11(String rcol11) {
        this.rcol11 = rcol11;
    }

    public String getRcol12() {
        return rcol12;
    }

    public RmLog rcol12(String rcol12) {
        this.rcol12 = rcol12;
        return this;
    }

    public void setRcol12(String rcol12) {
        this.rcol12 = rcol12;
    }

    public String getRcol13() {
        return rcol13;
    }

    public RmLog rcol13(String rcol13) {
        this.rcol13 = rcol13;
        return this;
    }

    public void setRcol13(String rcol13) {
        this.rcol13 = rcol13;
    }

    public String getTrkmstKey() {
        return trkmstKey;
    }

    public RmLog trkmstKey(String trkmstKey) {
        this.trkmstKey = trkmstKey;
        return this;
    }

    public void setTrkmstKey(String trkmstKey) {
        this.trkmstKey = trkmstKey;
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
        RmLog rmLog = (RmLog) o;
        if (rmLog.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), rmLog.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "RmLog{" +
            "id=" + getId() +
            ", ptDt='" + getPtDt() + "'" +
            ", guId='" + getGuId() + "'" +
            ", bguId='" + getBguId() + "'" +
            ", ifId='" + getIfId() + "'" +
            ", hopCnt='" + getHopCnt() + "'" +
            ", procTmCust01='" + getProcTmCust01() + "'" +
            ", procTmCust02='" + getProcTmCust02() + "'" +
            ", procTmCust03='" + getProcTmCust03() + "'" +
            ", procTmCust04='" + getProcTmCust04() + "'" +
            ", procTmCust05='" + getProcTmCust05() + "'" +
            ", procTm='" + getProcTm() + "'" +
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
            ", msg='" + getMsg() + "'" +
            ", insertDt='" + getInsertDt() + "'" +
            ", flag='" + getFlag() + "'" +
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
            ", trkmstKey='" + getTrkmstKey() + "'" +
            "}";
    }
}
