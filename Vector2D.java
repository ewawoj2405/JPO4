package oscylator;

public class Vector2D {
	public double x;
	public double y;

	public Vector2D() {
		
	}

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D suma(Vector2D vector) {
		Vector2D suma_wektorow = new Vector2D(this.x + vector.x, this.y + vector.y);
		return suma_wektorow;
	}

	public Vector2D roznica(Vector2D vector) {
		Vector2D roznica_wektorow = new Vector2D(this.x - vector.x, this.y - vector.y);
		return roznica_wektorow;
	}

	public Vector2D iloczyn(double stala) {
		Vector2D iloczyn_wektorow = new Vector2D(this.x * stala, this.y * stala);
		return iloczyn_wektorow;
	}

	public double dlugosc() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public Vector2D znorm_wektor() {

		Vector2D znormalizowany_wektor = new Vector2D(this.x / this.dlugosc(), this.y / this.dlugosc());
		return znormalizowany_wektor;

	}
}
