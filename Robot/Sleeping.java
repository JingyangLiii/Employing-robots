public class Sleeping extends Thread{
	public RobotInterface r=new RobotInterface();
	private int t=0;
	private int test=1;

	public void setT(){
	t=0;}
	public void out(){
		test=0;
	}
	public void run(){
		while(t<30){
			if(test==0)
			break;
			try{
				sleep(1000);}
			catch(InterruptedException e){
				e.printStackTrace();}
			t++;
			if(t>=30)
				r.enterSleep();
		}	
	}
}