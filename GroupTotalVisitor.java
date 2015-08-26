package assignment2;

public class GroupTotalVisitor implements Visitor {

	public int visitGroup(UserGroup userGroup) {
		int count = 1;
		if(userGroup.getUserCompList().isEmpty()){
			return count;
		}else{
			for(UserComponent comp : userGroup.getUserCompList()){
				count += comp.accept(this);
			}
		}
		return count;
		// TODO Auto-generated method stub
		//return 1;
	}
	public int visitUser(TwtUser twtUser) {
		return 0;
	}

}
