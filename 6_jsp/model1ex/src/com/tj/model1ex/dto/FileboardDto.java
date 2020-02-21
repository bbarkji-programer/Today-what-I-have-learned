package com.tj.model1ex.dto;

import java.sql.Timestamp;

public class FileboardDto {
	private int fnum;
	private String cId;
	private String fsubject;
	private String fcontent;
	private String ffilename;
	private String fpw;
	private int fhit;
	private int fref;
	private int fre_step;
	private int fre_level;
	private String fip;
	private Timestamp frdate;
	private String cname; // 글 상세보기 출력에 필요
	private String cemail; // 글 상세보기 출력에 필요
	
	public FileboardDto() { // 꼭 필요
	
	}

	public FileboardDto(int fnum, String cId, String fsubject, String fcontent, String ffilename, String fpw, int fhit,
			int fref, int fre_step, int fre_level, String fip, Timestamp frdate, String cname, String cemail) {
		super();
		this.fnum = fnum;
		this.cId = cId;
		this.fsubject = fsubject;
		this.fcontent = fcontent;
		this.ffilename = ffilename;
		this.fpw = fpw;
		this.fhit = fhit;
		this.fref = fref;
		this.fre_step = fre_step;
		this.fre_level = fre_level;
		this.fip = fip;
		this.frdate = frdate;
		this.cname = cname;
		this.cemail = cemail;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getFsubject() {
		return fsubject;
	}

	public void setFsubject(String fsubject) {
		this.fsubject = fsubject;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getFfilename() {
		return ffilename;
	}

	public void setFfilename(String ffilename) {
		this.ffilename = ffilename;
	}

	public String getFpw() {
		return fpw;
	}

	public void setFpw(String fpw) {
		this.fpw = fpw;
	}

	public int getFhit() {
		return fhit;
	}

	public void setFhit(int fhit) {
		this.fhit = fhit;
	}

	public int getFref() {
		return fref;
	}

	public void setFref(int fref) {
		this.fref = fref;
	}

	public int getFre_step() {
		return fre_step;
	}

	public void setFre_step(int fre_step) {
		this.fre_step = fre_step;
	}

	public int getFre_level() {
		return fre_level;
	}

	public void setFre_level(int fre_level) {
		this.fre_level = fre_level;
	}

	public String getFip() {
		return fip;
	}

	public void setFip(String fip) {
		this.fip = fip;
	}

	public Timestamp getFrdate() {
		return frdate;
	}

	public void setFrdate(Timestamp frdate) {
		this.frdate = frdate;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	@Override
	public String toString() {
		return "FileboardDto [fnum=" + fnum + ", cId=" + cId + ", fsubject=" + fsubject + ", fcontent=" + fcontent
				+ ", ffilename=" + ffilename + ", fpw=" + fpw + ", fhit=" + fhit + ", fref=" + fref + ", fre_step="
				+ fre_step + ", fre_level=" + fre_level + ", fip=" + fip + ", frdate=" + frdate + ", cname=" + cname
				+ ", cemail=" + cemail + "]";
	}
	
	
	
}
