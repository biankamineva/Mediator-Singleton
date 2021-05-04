package singleton;

public class Bot {

	private static Bot instance;
	
	String word  = "cat";
	
	private Bot() {
		
	}

	public static Bot getInstance() {
		
		if(instance == null) {
			instance = new Bot();
		}
		
		return instance;
	}
	
	public boolean forbiddenMessage(String message) {
		if ( message.toLowerCase().indexOf(word.toLowerCase()) != -1 ) {

			return false;
		}
		return true;
	}
	
}
