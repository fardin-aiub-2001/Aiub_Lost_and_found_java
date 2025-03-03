package AllClass;

import java.lang.*;
import Log.*;
import Interface.Iuser;

public abstract class user implements Iuser {

	private String name;
	private String id;

	//Set
	public user(String name,String id)
	{
		this.name=name;
		this.id=id;
	}

    @Override
	public String getName()
	{
		return name;
	}

	public String getId()
	{
		return id;
	}


}