import java.lang.Math;

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 *
 * If you add code here, add yourself as @author below
 * @author Dav King
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		double dist = Math.sqrt((this.myXPos - b.myXPos) * (this.myXPos - b.myXPos) + (this.myYPos - b.myYPos) * (this.myYPos - b.myYPos));
		return dist;
	}

	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		double force = ((this.myMass * b.myMass) / (calcDistance(b) * calcDistance(b))) * (6.67*1e-11);
		return force;
	}

	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		double forceX = ((b.myXPos - this.myXPos) / calcDistance(b)) * calcForceExertedBy(b);
		return forceX;
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		double forceY = ((b.myYPos - this.myYPos) / calcDistance(b)) * calcForceExertedBy(b);
		return forceY;
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sum = 0.0;
		for(CelestialBody b : bodies){
			if(!b.equals(this)){
				sum += calcForceExertedByX(b);
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for(CelestialBody b : bodies){
			if(!b.equals(this)){
				sum += calcForceExertedByY(b);
			}
		}
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double accelX = xforce / this.myMass;
		double accelY = yforce / this.myMass;
		double nvx = this.myXVel + deltaT * accelX;
		double nvy = this.myYVel + deltaT * accelY;
		double nx = this.myXPos + deltaT * nvx;
		double ny = this.myYPos + deltaT * nvy;
		this.myXPos = nx;
		this.myYPos = ny;
		this.myXVel = nvx;
		this.myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
