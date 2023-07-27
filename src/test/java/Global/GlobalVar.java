package Global;
public class GlobalVar {
	
	
	//------------------Program Module 
	public static int programId;
	
	//public static String programName;
//------------------------------------------------
	//public static int programId=10732;
	public static int batchId;
	public static int batchNoOfClasses=10;
	//public static int wrongBatchId=100;

	public static int varforsubid;
	//----ASSIGNMENTMODULE VARIABLES----//
	//public static int programId = 10732;
	//public static int batchId;// = 6873;
	public static String StudentIdsession;
	public static int assignmentId ;//= 3251;
	//public static int wrongBatchId = 100;
//	public static int programId;
	public static String responseBody;
	public static String programName;
//public static String StudentIdsession;
	
	public static String StudentRoleID;

	public static String StaffIDDelete;
	public static String RoleIdForUpdate="R02";
	public static String RoleStatusForUpdate="InActive";
	

	//public static int programId;
	//public static int batchId=6873;
	public static String RoleId="R03";
	public static String AdminIDUpdate;
	public static String InvalidUserId="U9239";
	
	public String getStudentRoleID() {
		return StudentRoleID;
	}

	public void setStudentRoleID(String studentRoleID) {
		StudentRoleID = studentRoleID;
	}
	/*public void setStudentRoleStatus(String studentRoleStatus) {
		StudentRoleStatus = studentRoleStatus;
	}*/

	
	public static String getStudentIdsession() {
		return StudentIdsession;
	}

	public  void setStudentIdsession(String Userid) {
		
		System.out.println("In the session class, Student role = "+StudentRoleID);
		if (StudentRoleID.equals("R03"))
		{
			StudentIdsession=Userid;
			System.out.println("Student ID created   = "+StudentIdsession );
		}
		else if(StudentRoleID.equals("R01"))
		{
			AdminIDUpdate=Userid;
		}
		else if(StudentRoleID.equals("R02"))
		{
			StaffIDDelete=Userid;
		}
	}
	
}
