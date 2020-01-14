package com.tj.supermarket;

public class CustomerDTO {
	private String ctel;
	private String cname;
	private int cpoint;
	private int ccost;
	private String level_name;
	private int smm;
	
	public CustomerDTO(String ctel, String cname, int cpoint, int ccost, String level_name, int smm) {
		super();
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.ccost = ccost;
		this.level_name = level_name;
		this.smm = smm;
	}

	@Override
	public String toString() {
		return ctel + "\t" + cname + "\t" + cpoint + "\t" + ccost + "\t"
				+ level_name + "\t" + smm;
	}
	
	

}
