package entity;

import javax.swing.JFrame;

public class SingletonFrame {
	private static SingletonFrame instance=null;
	private JFrame frame;
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}public JFrame getFrame(){
		return frame;
	}
	
	public synchronized static final SingletonFrame getFrameInstance() {
		if (SingletonFrame.instance == null) {
			SingletonFrame.instance = new SingletonFrame();
		}
		return SingletonFrame.instance;
	}
}
