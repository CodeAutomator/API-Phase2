package api.payload;
import java.util.List;
public class AssignUserProgram {
	private int programId;
	private String RoleId;
	private String UserId;
	
	
	
	List<UserBatchStatus> userRoleProgramBatches;
	
	
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int ProgramId) {
		programId = ProgramId;
	}
	
	public String getRoleId() {
		return RoleId;
	}
	public void setRoleId(String roleId) {
		RoleId = roleId;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	 public List<UserBatchStatus> getUserRoleProgramBatches() {
			return userRoleProgramBatches;
		}
		public void setUserRoleProgramBatches(List<UserBatchStatus> userRoleProgramBatches) {
			this.userRoleProgramBatches = userRoleProgramBatches;
		}
}
