package W_7_5_Email_Check;
public class Responses {
	
	// This class contains specific responses to false boolean checks, which will be invoked in class CheckMail  
	
	public void hasNoAtChar() {
		System.out.println("E-mail address does not contain '@' character.");
	}
	
	public void hasNoDotChar() {
		System.out.println("E-mail address does not contain '.' character.");
	}
	
	public void localPartIncorrect() {
		System.out.println("Local part of given e-mail address does not seem be correct.");
	}
	
	public void domainPartIncorrect() {
		System.out.println("Domain name of mail provider does not seem be correct.");
	}
	
	public void topLevelDomainIncorrect() {
		System.out.println("Top level domain of given e-mail address does not seem be correct.");
	}
}
