/* Prüffunktion für Emailadressen. Testet, ob eine Emailadresse korrekt aufgebaut ist
 * Schema: 
 * <1 - n Zeichen>@<1 - n Zeichen>.<2 - 3 Zeichen> */
package W_7_5_Email_Check;

public class CheckMailAddress {
	
	private int positionAtChar, positionDotChar;
	private boolean spaceBeforeAtChar, spaceBeforePointChar, spaceAfterPointChar, allRequirementsOk; 
	private String emailAddress;
	Responses a, b, c, d, e;
	
	
	public CheckMailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		isEmail(this.emailAddress);
	}

	public void isEmail(String emailAddress) {
		System.out.println("Total length of e-mail address: " + emailAddress.length() + " characters");
		
		// search e-mail address for '@'-character. If it doesn't exist within the String,
		// print error message from class "Responses"
		positionAtChar = emailAddress.indexOf("@");
		if(positionAtChar == -1) {
			a = new Responses();
			a.hasNoAtChar();
		} else {
			positionAtChar += 1;
		}
		
		// search e-mail address for '.'-character. If it doesn't exist within the String,
		// print error message from class "Responses"
		positionDotChar = emailAddress.indexOf(".");
		if(positionDotChar == -1) {
			b = new Responses();
			b.hasNoDotChar();
		} else {
			positionDotChar += 1;
		}
		
		// verify, if local part of e-mail address contains >= 1 character(s) before '@'-character
		if(positionAtChar >= 2) {
			spaceBeforeAtChar = true;
		} else {
			spaceBeforeAtChar = false;
			c = new Responses();
			c.localPartIncorrect();
		}
		
		// verify, if host name of e-mail address contains >= 1 character(s) after '@'- and before '.'-character
		if((positionDotChar - positionAtChar) >= 2) {
			spaceBeforePointChar = true;
		} else {
			spaceBeforePointChar = false;
			d = new Responses();
			d.domainPartIncorrect();
		}		
		
		// In this case the code verifies if the top-level domain of the e-mail address consists of 2 - 3 characters.
		// In general more characters are valid
		if((emailAddress.length() - positionDotChar) == 2 || (emailAddress.length() - positionDotChar) == 3) {
			spaceAfterPointChar = true;
		} else {
			spaceAfterPointChar = false;
			e = new Responses();
			e.topLevelDomainIncorrect();
		}
		
		if(spaceBeforeAtChar == true && spaceBeforePointChar == true && spaceAfterPointChar == true) {
			allRequirementsOk = true;
		}
		System.out.println("\nDoes the given e-mail address have a valid structure: " + allRequirementsOk);
	}
	
	
}
