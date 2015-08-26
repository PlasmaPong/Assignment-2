package assignment2;
/*
 * base interface for the visitors used in analysis of 
 * the network of users
 */
public interface Visitor {
	/*
	 * handles objects in list that are usergroups
	 */
	int visitGroup(UserGroup userGroup);
	/*
	 * handles objects that are twtusers
	 */
	int visitUser(TwtUser twtUser);
}
