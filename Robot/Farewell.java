import java.io.*;
public class Farewell implements Serializable{
	private String farewell;
	public Farewell(String farewell){
		this.farewell=farewell;}
	public String getFarewell(){
		return farewell; }

	public static void main(String[] agrs){
		Farewell one=new Farewell("I will miss you!");
		Farewell two=new Farewell("Wish you a pleasant journey!");
		Farewell three=new Farewell("Have a nice day!");
		Farewell four=new Farewell("See you!");
		try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Farewell.ser"));
		os.writeObject(one);
		os.writeObject(two);
		os.writeObject(three);
		os.writeObject(four);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
	}
 }