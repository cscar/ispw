import java.io.IOException;

import javax.swing.JFrame;

import boundary.frame.BoundaryFrame;
import entity.Administrator;

public class Start extends JFrame{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		//Entry point for Java Application

		new Administrator("admin", "password");
		
		new BoundaryFrame();
	}
	
}
