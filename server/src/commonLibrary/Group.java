package commonLibrary;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import serverLibrary.ConfigurationManager;

public class Group extends MemberEntity
{
	private static long serialVersionUID;
	private ArrayList<User> _users;
	
	
	public Group(int id, String name, User users[])
	{
		super(name);
		serialVersionUID = ConfigurationManager.getInstance().getGroup_serial();
		this._users = new ArrayList<User>();
		
		for(int i =0;i<users.length;i++)
			this._users.add(users[i]);
	}
	
	public boolean isEqual(Group grp)
	{
		return super.isEqual((MemberEntity)grp) && this._users.equals(grp._users);
	}
	
	
	
	/*
	 * return the user in the list that has the specific id
	 * 
	 * if none have the specific id, return null
	 */
	
	
	public void addUser(User us)
	{
		this._users.add(us);
	}
	
	
	/*
	 * remove user from the group by id
	 */
	
	
	
	
	public int groupSize()
	{
		return this._users.size();
	}
}
