package AllClass;

import java.lang.*;
import Log.*;
import Interface.*;

public class admin extends user implements Iuser


{
	private String adpass;

	public admin(String name,String id,String adpass)
	{
		super(name,id);
		this.adpass=adpass;
	}
	public String getAdPass()
	{
		return adpass;
	}
	public void AdminDisplay()
	{
		System.out.println("Name :"+getName());
		System.out.println("ID :"+getId());
		System.out.println("Password :"+adpass);
	}
}

