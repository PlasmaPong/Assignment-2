package assignment2;

public class MsgTotalVisitor implements Visitor {

	public int visitGroup(UserGroup userGroup) {
		int count = 0;
		if(userGroup.getUserCompList().isEmpty()){
			return 0;
		}else{
			for(UserComponent comp : userGroup.getUserCompList()){
				count += comp.accept(this);
			}
			return count;
		}
	}

	public int visitUser(TwtUser twtUser) {
		return twtUser.getNewsFeed().size();
	}



}
