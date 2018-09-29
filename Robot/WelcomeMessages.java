import java.io.*;
public class WelcomeMessages implements Serializable{
	private String m;
	public String getMessages(){
		return m;}
	public WelcomeMessages(String m){
		this.m=m;}

	public static void main(String[] agrs){
		WelcomeMessages one=new WelcomeMessages("Hi!"); 
		WelcomeMessages two=new WelcomeMessages("I hope you are having a good day!");
		WelcomeMessages three=new WelcomeMessages("Hello!");
		WelcomeMessages four=new WelcomeMessages("How are you today?");
		WelcomeMessages five=new WelcomeMessages("Isn't the weather great!");
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/WelcomeMessages.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.writeObject(four);
		os.writeObject(five);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
 }
}