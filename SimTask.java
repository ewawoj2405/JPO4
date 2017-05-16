package oscylator;

import java.util.TimerTask;

public class SimTask extends TimerTask {
	
	private SimEngine obiektSE;
	private SpringApplet obiektSA;
	private double odstep_czasu;
	
	public SimTask(SimEngine obiektSE, SpringApplet obiektSA, double odstep_czasu ){
		
		this.obiektSE=obiektSE;
		this.obiektSA=obiektSA;
		this.odstep_czasu=odstep_czasu;
	}
	
	public void run(){
		
		obiektSE.przebieg_symulacji(odstep_czasu);
		obiektSA.repaint();
		
	}
	
}
