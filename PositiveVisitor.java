package assignment2;

public class PositiveVisitor implements Visitor {

	public int visitGroup(UserGroup userGroup) {
		int posCount = 0;
		if(userGroup.getUserCompList().isEmpty()){
			return 0;
		}else{
			for(UserComponent comp : userGroup.getUserCompList()){
				posCount += comp.accept(this);
			}
			return posCount;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see assignment2.Visitor#visitUser(assignment2.TwtUser)
	 * parses the strings of this user's newsfeed for words matching 
	 * those defined as positive
	 */
	public int visitUser(TwtUser twtUser) {
		if(twtUser.getNewsFeed().isEmpty()){
			return 0;
		}else{
			int posCount = 0;
			/*
			 * Limited implementation of positive words
			 * only detects one word but can be easily expanded for 
			 * more words
			 */
			for(String tweet : twtUser.getNewsFeed()){
				if(tweet.contains("amazing")){
					posCount++;
				}
			}
			return posCount;
		}
	}

}
