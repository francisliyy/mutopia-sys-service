/**
 * <p>Title: MailObj</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.vo;

import java.util.Date;

public class MailObj {
	
	private String isImmediate;

	private String mailAttachment;

	private String mailCc;

	private String mailContent;

	private String mailReceiver;

	private String mailSchedule;

	private String mailSourceCtlUrl;

	private String mailSourceSystem;

	private String mailSubject;

	private Date mailTime;

	public String getIsImmediate() {
		return isImmediate;
	}

	public void setIsImmediate(String isImmediate) {
		this.isImmediate = isImmediate;
	}

	public String getMailAttachment() {
		return mailAttachment;
	}

	public void setMailAttachment(String mailAttachment) {
		this.mailAttachment = mailAttachment;
	}

	public String getMailCc() {
		return mailCc;
	}

	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public String getMailReceiver() {
		return mailReceiver;
	}

	public void setMailReceiver(String mailReceiver) {
		this.mailReceiver = mailReceiver;
	}

	public String getMailSchedule() {
		return mailSchedule;
	}

	public void setMailSchedule(String mailSchedule) {
		this.mailSchedule = mailSchedule;
	}

	public String getMailSourceCtlUrl() {
		return mailSourceCtlUrl;
	}

	public void setMailSourceCtlUrl(String mailSourceCtlUrl) {
		this.mailSourceCtlUrl = mailSourceCtlUrl;
	}

	public String getMailSourceSystem() {
		return mailSourceSystem;
	}

	public void setMailSourceSystem(String mailSourceSystem) {
		this.mailSourceSystem = mailSourceSystem;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public Date getMailTime() {
		return mailTime;
	}

	public void setMailTime(Date mailTime) {
		this.mailTime = mailTime;
	}
	
}
