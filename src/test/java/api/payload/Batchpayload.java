package api.payload;

public class Batchpayload {
	String batchDescription;
	  int batchId;
	  String batchName;
	  int batchNoOfClasses;
	  String batchStatus;
	  int programId;
	  String programName;
	  
	
		  public String getBatchDescription() {
		return batchDescription;
	}
	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getBatchNoOfClasses() {
		return batchNoOfClasses;
	}
	public void setBatchNoOfClasses(int subPathAttach2) {
		this.batchNoOfClasses = subPathAttach2;
	}
	public String getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
}
