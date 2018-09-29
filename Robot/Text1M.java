import java.io.*;
public class Text1M implements Serializable{
	private int text1;
	public void setText(int text1){
		this.text1=text1;}

	public void output(int text){
	Text1M one=new Text1M();
	one.setText(text);
	try{	ObjectOutputStream os =new ObjectOutputStream(new FileOutputStream("../../Files/Text1M.ser"));
		os.writeObject(one);
		os.close();}
		catch(IOException ex){
			ex.printStackTrace();}
	}
	
	public int getText1(){
	int t=0;
	try{	ObjectInputStream is =new ObjectInputStream(new FileInputStream("../../Files/Text1M.ser"));
		Text1M rone=(Text1M) is.readObject();
		t=rone.text1; }			
		catch(Exception ex){
			ex.printStackTrace();}
	return t;
	}
}