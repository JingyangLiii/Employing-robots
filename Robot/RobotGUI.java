import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class RobotGUI {
	public static void main(String[] args){
		FishDishes fish=new FishDishes(" ",0,0);
		fish.renew();
		RiceDishes rice=new RiceDishes(" ",0,0);
		rice.renew();
		MeatDishes meat=new MeatDishes(" ",0,0);
		meat.renew();
		NoodleDishes noodle=new NoodleDishes(" ",0,0);
		noodle.renew();
		Drink drink=new Drink(" ",0,0);
		drink.renew();
		RobotInterface a =new RobotInterface();
		a.greet();}

}