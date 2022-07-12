package crud.model;

public class Teacher {
   private int tid;
   private String name;
   private String email;
   private int phone_no;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPhone_no() {
	return phone_no;
}
public void setPhone_no(int phone_no) {
	this.phone_no = phone_no;
}
public Teacher(int tid, String name, String email, int phone_no) {
	super();
	this.tid = tid;
	this.name = name;
	this.email = email;
	this.phone_no = phone_no;
}

}