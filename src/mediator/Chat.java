package mediator;

import java.util.ArrayList;
import java.util.List;

import singleton.Bot;

public class Chat implements MessageMediator {

	private List<User> users;
	private Bot bot;
	
	public Chat() {
		
		this.users = new ArrayList<>();
	}
	
	@Override
	public void addUser(User user) {
		
		this.users.add(user);
	}
	
	public void removeUser(User user) {
		
		for(User chatUser: this.users) {
			if (chatUser != user) {
				chatUser.receive(user.name + " is removed from chat!");
			}
		}
		this.users.remove(user);
	}

	@Override
	public void sendMessage(String message, User user) {
		
		if(message == "addBot") {
			this.bot = Bot.getInstance();
			for(User chatUser: this.users) {
				if (chatUser != user) {
					chatUser.receive("Bot is added!");
				}
			}
		}
		
		if (bot != null) {
			if (bot.forbiddenMessage(message)) {
				for(User chatUser: this.users) {
					if (chatUser != user) {
						chatUser.receive(message);
					}
				}
			} else {
				removeUser(user);
				for(User chatUser: this.users) {
					if (chatUser != user) {
						chatUser.receive("Cat is forbidden!");
					}
				}
			} 
		} else {
			for(User chatUser: this.users) {
				if (chatUser != user) {
					chatUser.receive(message);
				}
			}
		} 
	}

}
