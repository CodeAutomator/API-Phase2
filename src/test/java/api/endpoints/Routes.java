package api.endpoints;

import java.net.URI;

public class Routes {

	public static String base_url="https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";

	
	//AssignmentSubmission Module
	public static String assignment_subpost="/assignmentsubmission";
	public static String assignmentid="/assignmentsubmission/getGrades/{assignmentId}";
	
	public static String post_urls=base_url+assignment_subpost;
	public static String getassignmentid_url=base_url+"/assignmentsubmission/getGrades/{assignmentId}";
	public static String getgradesbyid_url=base_url+"/assignmentsubmission/getGradesByStudentId/{studentID}";
	public static String batchid_url=base_url+"/assignmentsubmission/grades/{batchID}";		
	public static String subuserid_url=base_url+"/assignmentsubmission/student/{userId}";
	public static String subbatch_id=base_url+"/assignmentsubmission/studentbatch/{batchId}";
	public static String putgrades_subid=base_url+"/assignmentsubmission/gradesubmission/{submissionId}";
			
	
	//https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms/assignmentsubmission/{Id}

	public static String get_url=base_url+assignment_subpost;
	public static String put_submission=base_url+"/assignmentsubmission/{Id}";
	public static String del_url=base_url+"/assignmentsubmission/{Id}";
	public static String end_url="/saveprogram";
	public static String progurl=base_url+end_url;
//--------------------------------------------------------------------------------------------------//
	//ASSIGNMENT MODULE
//	public static String base_url  
//	= "https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms";
public static String postAssignment_url = base_url + "/assignments";
public static String getAllAssignments_url = base_url + "/assignments";
public static String getAssignmentByAssignmentId_url = base_url + "/assignments/{id}";
public static String getAssignmentsByBatchId_url = base_url + "/assignments/batch/{batchId}";
public static String putAssignment_url = base_url + "/assignments/{id}";
public static String deleteAssignment_url = base_url + "/assignments/{id}";	

//-------------------------------Batch Module
public static String post_url=base_url+"/batches";

public static String getAll_url=base_url+"/batches";

public static String update_url=base_url+"/batches/{batchId}";

public static String delete_url=base_url+"/batches/{id}";

public static String getById_url=base_url+"/batches/batchId/{batchId}";

public static String getByName_url=base_url+"/batches/batchName/{batchName}";

public static String getByProgram_url=base_url+"/batches/program/{programId}";
	
//User Module
	public static String userpost_url=base_url+"/users/users/roleStatus";
	public static String get_allusers_url=base_url+"/users/users";
	public static String get_byuserid_url=base_url+"/users/users/{userId}";
	public static String get_userwithroles_url=base_url+"/users/users/roles";
	public static String get_allstaff_url=base_url+"/users/users/getAllStaff";
	public static String put_url=base_url+"/users/users/{userId}";
	public static String put_userrole_url=base_url+"/users/users/roleStatus/{userId}";
	public static String put_assignuser_url=base_url+"/users/users/roleProgramBatchStatus/{userId}";
	public static String userdelete_url=base_url+"/users/users/{userId}";
	
	
	
}
