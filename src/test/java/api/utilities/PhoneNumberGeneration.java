package api.utilities;
import java.util.Random;
public class PhoneNumberGeneration {

	Random rand = new Random();
	
     int set1,set2, set3; //sequence 2 and 3 of the phone number
	public String getPhoneNumber()
	{
			set1=rand.nextInt(254) + 100;
	        set2 = rand.nextInt(643) + 100;
	        set3 = rand.nextInt(8999) + 1000;
	        
	        String phonenumber= set1+""+set2+""+set3;
	        
	        return phonenumber;
		//int phoneNumber = rand.nextInt(9999999999); 
	}
}
