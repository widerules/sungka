package javabeans;
import java.sql.*;



public class MainJavaBeans {
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	Connection con = null;
	Statement stmt = null;
	
	//Getters and Setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	
	// SQLite Database Connection
	public void Connectdb(){
		try {
				Class.forName("org.sqlite.JDBC");
				String url = "jdbc:sqlite:C:\\Users\\Janver\\Documents\\Janver's Files\\College\\Third Year\\Third Term\\ENTJAVA2\\Workspace\\sungka1\\WebContent\\sungka.db";
				con = DriverManager.getConnection(url);
				stmt = con.createStatement();
						} catch (Exception e) {
				System.out.println("Error "+e.getMessage());
			}	
	}
	
	public void setUser(String iusername){
		setUsername(iusername);
		Connectdb();
		
		String sql = "Select * from user_details";
		try{
			ResultSet set = stmt.executeQuery(sql);
			while(set.next()){
				if(username.equalsIgnoreCase(set.getString("username"))){
					setFname(set.getString("fname"));
					setLname(set.getString("lname"));
					setEmail(set.getString("email"));
				}
			}
		set.close();
		stmt.close();
		con.close();
		}catch(Exception e ){
			System.out.println("Error "+e.getMessage());
		}
	}
	
	
	// Registration
	public void createUser(String iusername,String ipassword, String ifname,String ilname,String iemail){
		Connectdb();
		
		String sql = "insert into user_details (username, password, fname, lname, email) values('"+iusername+"','"+ipassword+"','"+ifname+"','"+ilname+"','"+iemail+"')";
		try{
			stmt.executeUpdate(sql);
		stmt.close();
		con.close();
		}catch(Exception e ){
			System.out.println("Error "+e.getMessage());
		}
	}
	
	// Verifies Registration Input
	public boolean checkInput(String username,String password, String fname,String lname,String email){
		
		boolean isComplete = true;
		String errorData = "";
		
		errorData = errorData + "&username=" + username;
		if(isMissing(username)) {
		isComplete = false;
		}
		
		errorData = errorData + "&password=" + password;
		if(isMissing(password)) {
		isComplete = false;
		}
		
		errorData = errorData + "&fname=" + fname;
		if(isMissing(fname)) {
		isComplete = false;
		}
		
		errorData = errorData + "&lname=" + lname;
		if(isMissing(lname)) {
		isComplete = false;
		}
		
		errorData = errorData + "&email=" + email;
		if(isMissing(email)) {
		isComplete = false;
		}
		
		if(isComplete){
			createUser(username,password,fname,lname,email);
			return true;
		}
		else{
			return false;
		}
			
	}
	
	private boolean isMissing(String param) {
		return((param == null) || (param.trim().equals("")));
		}
	
	// Search Function
	public String search(String iusername){
		
		
		Connectdb();
		String sql = "Select * from user_details where username Like'%" + iusername + "%'";
		String data="";
		
		try{
			ResultSet set = stmt.executeQuery(sql);
		
		
		data+="USERNAME \t";
		data+="First Name \t";
		data+="Last Name : \t";
		data+="E-mail : \n";
		 
		while (set.next())
		 {
			 data+=set.getString("username")+"\t";
			 data+=set.getString("fname")+"\t";
			 data+=set.getString("lname")+"\t";
			 data+=set.getString("email")+"\n";
		 }

			
		
		set.close();
		stmt.close();
		con.close();
		}catch(Exception e ){
			System.out.println("Error "+e.getMessage());
		}
		
		return data;
	}
	
	
	// Verifies Login data and queries details to user.jsp
	public boolean Login(String iusername,String ipassword){
		boolean result = false;
		setUsername(iusername);
		setPassword(ipassword);
		Connectdb();
		
		String sql = "Select * from user_details";
		try{
			ResultSet set = stmt.executeQuery(sql);
			while(set.next()){
				if(username.equalsIgnoreCase(set.getString("username"))&&password.equalsIgnoreCase(set.getString("password"))){
					setFname(set.getString("fname"));
					setLname(set.getString("lname"));
					setEmail(set.getString("email"));
					result = true;
					
				}
			}
		set.close();
		stmt.close();
		con.close();
		}catch(Exception e ){
			System.out.println("Error "+e.getMessage());
		}
		
		
		return result;
	}
}
