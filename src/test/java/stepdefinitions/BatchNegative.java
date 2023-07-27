package stepdefinitions;

import api.test.BatchTest;
import io.cucumber.java.en.*;

public class BatchNegative {
	BatchTest post=new BatchTest();
	
	@Then(": Status {int} Badrequest.")
	public void status_badrequest(Integer int1) {
		  post.verify_post_status(400);
	}

	@Then(": Batch didnot get updated")
	public void batch_didnot_get_updated() {
		post.VerifyUpdate_status(400);
		
	}

	@Then(": batch id didnot get deleted by {int} status code")
	public void batch_id_didnot_get_deleted_by_status_code(Integer int1) {
		post.verify_del_status(int1);
	}


}
