package api.payload;

public class UserBatchStatus {
	private int batchId;
	private String userRoleProgramBatchStatus;
	
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int BatchId) {
		batchId = BatchId;
	}
	
	public String getUserRoleProgramBatchStatus() {
		return userRoleProgramBatchStatus;
	}
	public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
		this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
	}
}
