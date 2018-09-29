import java.io.*;
public class TextM implements Serializable{
	private int text;
	public void setText(int text){
		this.text=text;}

	public void output(int text){
	TextM one=new TextM();
	one.setText(text);
	try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/TextM.ser"));
		os.writeObject(one);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
	}
	
	public int getText(){
	int t=0;
	try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/TextM.ser"));
		TextM rone=(TextM) is.readObject();
		t=rone.text;}			
		catch(Exception ex){
			ex.printStackTrace();}
	return t;
	}
}