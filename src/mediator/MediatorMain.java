package mediator;

public class MediatorMain {

	
	public static void main(String[] args) {
		
		MessageMediator chat = new Chat();
		
		User user1 = new ChatUser(chat, "Bobi");
		User user2 = new ChatUser(chat, "Kiko");
		User user3 = new ChatUser(chat, "Zazu");
		
		user1.send("addBot");
		user3.send("ok");
		user2.send("Nice cat");
		user1.send("noooo");

	}

}
