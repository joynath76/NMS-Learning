package com.spring.nmsjpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@AttributeOverrides({
	@AttributeOverride(
		name = "name",
		column = @Column(name="guardian_name")
	),
	@AttributeOverride(
		name = "emailId",
		column = @Column(name="guardian_email_id")
	),
	@AttributeOverride(
		name = "mobileNo",
		column = @Column(name="guardian_mobile_no")
	)
})
@Embeddable
public class Guardian {

    private String name;
	private String emailId;
	private String mobileNo;
	
	
	public Guardian() {
	}


	public Guardian(String name, String emailId, String mobileNo) {
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "Guardian [emailId=" + emailId + ", mobileNo=" + mobileNo + ", name=" + name + "]";
	}
	
}
