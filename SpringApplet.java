package oscylator;

import javax.swing.JApplet;

import java.awt.*;
import javax.swing.*;
import java.util.Timer;


public class SpringApplet extends JApplet {
	
	private SimEngine obiektSE;
	private SimTask obiektST;
	private Timer obiektT;
	
	public void init(){
		Vector2D polozenie1 = new Vector2D(400, 200);
		Vector2D predkosc = new Vector2D(0,0);
		Vector2D polozenie2 = new Vector2D(400, 20);
		
		obiektSE = new SimEngine(20, 30, 2, 100, 9.81, predkosc, polozenie1, polozenie2);
		obiektST = new SimTask(obiektSE, this, 0.05 );
		obiektT = new Timer();
		obiektT.scheduleAtFixedRate(obiektST, 0, 50);
	
	}
	
	public void paint(Graphics g){
		
		g.clearRect(0,0,getWidth(),getHeight());
		
		
		g.drawLine((int) obiektSE.getPOLOZENIE_MASY().x, (int) obiektSE.getPOLOZENIE_MASY().y,(int) obiektSE.getPOLOZENIE_PKT().x, (int) obiektSE.getPOLOZENIE_PKT().y);
		
		g.drawLine((int) obiektSE.getPOLOZENIE_MASY().x-50, (int) obiektSE.getPOLOZENIE_MASY().y,(int) obiektSE.getPOLOZENIE_MASY().x+50, (int) obiektSE.getPOLOZENIE_MASY().y);
		
		g.drawOval((int) obiektSE.getPOLOZENIE_PKT().x-25, (int) obiektSE.getPOLOZENIE_PKT().y, 50, 50);
		
		
	}

}
