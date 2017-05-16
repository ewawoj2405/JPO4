package oscylator;

public class SimEngine {
	
	private double masa, wspol_sprezystosci, wspol_tlumienia, dl_sprezyny, przysp_graw;
	private Vector2D polozenie_masy, predkosc_masy, polozenie_pkt;
	
	public SimEngine(double masa, double wspol_sprezystosci,
	double wspol_tlumienia, double dl_sprezyny, double przysp_graw,
	Vector2D polozenie_masy, Vector2D predkosc_masy, Vector2D polozenie_pkt){
		
		this.masa=masa;
		this.wspol_sprezystosci=wspol_sprezystosci;
		this.wspol_tlumienia=wspol_tlumienia;
		this.dl_sprezyny=dl_sprezyny;
		this.przysp_graw=przysp_graw;
		this.polozenie_masy=polozenie_masy;
		this.predkosc_masy=predkosc_masy;
		this.polozenie_pkt=polozenie_pkt;
	}
	
	public double getMASA(){
		return masa;
	}
	public void setMASA(double masa){
		this.masa=masa;
	}
	
	public double getWSPOL_SPREZYSTOSCI(){
		return wspol_sprezystosci;
	}
	public void setWSPOL_SPREZYSTOSCI(double wspol_sprezystosci){
		this.wspol_sprezystosci=wspol_sprezystosci;
	}
	
	public double getWSPOL_TLUMIENIA(){
		return wspol_tlumienia;
	}
	public void setWSPOL_TLUMIENIA(double wspol_tlumienia){
		this.wspol_tlumienia=wspol_tlumienia;
	}
	
	public double getDL_SPREZYNY(){
		return dl_sprezyny;
	}
	public void setDL_SPREZYNY(double dl_sprezyny){
		this.dl_sprezyny=dl_sprezyny;
	}
	
	public double getPRZYSP_GRAW(){
		return przysp_graw;
	}
	public void setPRZYSP_GRAW(double przysp_graw){
		this.przysp_graw=przysp_graw;
	}
	
	public Vector2D getPOLOZENIE_MASY(){
		return polozenie_masy;
	}
	public void setPOLOZENIE_MASY(Vector2D polozenie_masy){
		this.polozenie_masy=polozenie_masy;
	}
	
	public Vector2D getPREDKOSC_MASY(){
		return predkosc_masy;
	}
	public void setPREDKOSC_MASY(Vector2D predkosc_masy){
		this.predkosc_masy=predkosc_masy;
	}
	
	public Vector2D getPOLOZENIE_PKT(){
		return polozenie_pkt;
	}
	public void setPOLOZENIE_PKT(Vector2D polozenie_pkt){
		this.polozenie_pkt=polozenie_pkt;
	}
	
		public void przebieg_symulacji(double t)
		{
			Vector2D sila_wypadkowa = new Vector2D();
			Vector2D sila_grawitacji = new Vector2D(0,masa*przysp_graw);
			Vector2D sila_sprezystosci = new Vector2D();
			Vector2D sila_tlumienia_wisk = new Vector2D();
			
			sila_sprezystosci=polozenie_masy.roznica(polozenie_pkt).znorm_wektor().iloczyn(wspol_tlumienia*(polozenie_pkt.roznica(polozenie_masy). dlugosc()-getDL_SPREZYNY()));
			sila_tlumienia_wisk = predkosc_masy.iloczyn(-wspol_tlumienia);
			sila_wypadkowa=sila_grawitacji.suma(sila_sprezystosci).suma(sila_tlumienia_wisk);
			predkosc_masy=predkosc_masy.suma(sila_wypadkowa.iloczyn(t/masa));
			polozenie_pkt=polozenie_pkt.suma(predkosc_masy.iloczyn(t));
}


public void zerownie(){
	predkosc_masy.x=0;
	predkosc_masy.y=0;

}
}

