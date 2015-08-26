package assignment2;
	/*
	 * Interface for base functions of users
	 */
public interface UserComponent extends Visitable {
	
	/*
	 * follows selected user
	 */
	void follow(TwtUser user);
	/*
	 * posts a tweet that is seen by all followers of this user
	 */
	void tweet(String string);
	/*
	 * returns object's given id
	 */
	String getID();
}
