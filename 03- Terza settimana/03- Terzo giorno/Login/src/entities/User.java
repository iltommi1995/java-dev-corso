package entities;

public class User 
{
	public String username;
	public String password;
	
	public boolean checkUser(String user) {
		boolean check = false;
		if (username.equals(user))
			check = true;
		return check;
	}
	
	public boolean checkPw(String pw) {
		boolean check = false;
		if (password.equals(pw))
			check = true;
		return check;
	}
}
