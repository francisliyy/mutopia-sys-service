/**
 * <p>Title: SmsVo</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.vo;

import java.util.Date;

public class SmsVo {
	
	private int smsId;

	private String bizid;

	private String isImmediate;

	private String requestid;

	private String smsContent;

	private String smsReceiver;

	private String smsResult;

	private String smsResultDesc;

	private String smsSchedule;

	private String smsSourceCtlUrl;

	private String smsSourceSystem;

	private Date smsTime;

	public int getSmsId() {
		return smsId;
	}

	public void setSmsId(int smsId) {
		this.smsId = smsId;
	}

	public String getBizid() {
		return bizid;
	}

	public void setBizid(String bizid) {
		this.bizid = bizid;
	}

	public String getIsImmediate() {
		return isImmediate;
	}

	public void setIsImmediate(String isImmediate) {
		this.isImmediate = isImmediate;
	}

	public String getRequestid() {
		return requestid;
	}

	public void setRequestid(String requestid) {
		this.requestid = requestid;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSmsReceiver() {
		return smsReceiver;
	}

	public void setSmsReceiver(String smsReceiver) {
		this.smsReceiver = smsReceiver;
	}

	public String getSmsResult() {
		return smsResult;
	}

	public void setSmsResult(String smsResult) {
		this.smsResult = smsResult;
	}

	public String getSmsResultDesc() {
		return smsResultDesc;
	}

	public void setSmsResultDesc(String smsResultDesc) {
		this.smsResultDesc = smsResultDesc;
	}

	public String getSmsSchedule() {
		return smsSchedule;
	}

	public void setSmsSchedule(String smsSchedule) {
		this.smsSchedule = smsSchedule;
	}

	public String getSmsSourceCtlUrl() {
		return smsSourceCtlUrl;
	}

	public void setSmsSourceCtlUrl(String smsSourceCtlUrl) {
		this.smsSourceCtlUrl = smsSourceCtlUrl;
	}

	public String getSmsSourceSystem() {
		return smsSourceSystem;
	}

	public void setSmsSourceSystem(String smsSourceSystem) {
		this.smsSourceSystem = smsSourceSystem;
	}

	public Date getSmsTime() {
		return smsTime;
	}

	public void setSmsTime(Date smsTime) {
		this.smsTime = smsTime;
	}

}
