package com.chris.mvcprojsecond.model.message.dto;

public class UserVO {
	private String userid;	// �����ID
	private String userpw;	// �����PW
	private String uname;	// ������̸�
	private int upoint;		// �������������Ʈ
	// Getter/Setter
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	// toString
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", userpw=" + userpw + ", uname=" + uname + ", upoint=" + upoint + "]";
	}
}