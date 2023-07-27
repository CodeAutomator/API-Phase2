package api.payload;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Number;

//pojo class has get and setter ..where setter set the value and getter gets the value
public class Submissionpayload {
	int assignmentId;  
	String userId;
    String subDesc;
    String subComments;
    String subPathAttach1;
    String subPathAttach2;
    String subPathAttach3;
    String subPathAttach4;
    String subPathAttach5;
    String subDateTime;
   
	String  gradedBy;
    String gradedDateTime;
    
	int grade;
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubDesc() {
		return subDesc;
	}
	public void setSubDesc(String subDesc) {
		this.subDesc = subDesc;
	}
	public String getSubComments() {
		return subComments;
	}
	public void setSubComments(String subComments) {
		this.subComments = subComments;
	}
	public String getSubPathAttach1() {
		return subPathAttach1;
	}
	public void setSubPathAttach1(String subPathAttach1) {
		this.subPathAttach1 = subPathAttach1;
	}
	public String getSubPathAttach2() {
		return subPathAttach2;
	}
	public void setSubPathAttach2(String subPathAttach2) {
		this.subPathAttach2 = subPathAttach2;
	}
	public String getSubPathAttach3() {
		return subPathAttach3;
	}
	public void setSubPathAttach3(String subPathAttach3) {
		this.subPathAttach3 = subPathAttach3;
	}
	public String getSubPathAttach4() {
		return subPathAttach4;
	}
	public void setSubPathAttach4(String subPathAttach4) {
		this.subPathAttach4 = subPathAttach4;
	}
	public String getSubPathAttach5() {
		return subPathAttach5;
	}
	public void setSubPathAttach5(String subPathAttach5) {
		this.subPathAttach5 = subPathAttach5;
	}
	public String getSubDateTime() {
		return subDateTime;
	}
	public  String setSubDateTime(String subDateTime) {
		return this.subDateTime = subDateTime;
	
	}
	 public String getGradedBy() {
			return gradedBy;
		}
		public void setGradedBy(String gradedBy) {
			this.gradedBy = gradedBy;
		}
		public String getGradedDateTime() {
			return gradedDateTime;
		}
		public void setGradedDateTime(String gradedDateTime) {
			this.gradedDateTime = gradedDateTime;
		}
	
}
