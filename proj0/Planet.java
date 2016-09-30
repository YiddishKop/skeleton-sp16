
public class Planet {
	public double xxPos; // its current x position
	public double yyPos; // its current y position
	public double xxVel; // its current velocity in x direction
	public double yyVel; // its current velocity in y direction
	public double mass; // its mass
	public String imgFileName; // its name of an image in the images directory
	
	public  static final double G = 6.67e-11;
	
	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass  = p.mass;
		imgFileName = p.imgFileName;
	}
	
	// 距离
	public double calcDistance (Planet p) {
		double distInX = p.xxPos - this.xxPos;
		double distInY = p.yyPos - this.yyPos;
		double dist = Math.sqrt(Math.pow(distInX, 2) +
				Math.pow(distInY, 2));

		return dist; 
	}
	// 受力
	public double calcForceExertedBy(Planet p) {
		double force = G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
		return force;
	}
	// x方向的受力：受力者.force(施力者)
	public double calcForceExertedByX(Planet p) {
		double distInX = p.xxPos - this.xxPos;
		double distInY = p.yyPos - this.yyPos;
		double dist = Math.sqrt(Math.pow(distInX, 2) +
				Math.pow(distInY, 2));
		double force = G * this.mass * p.mass / Math.pow(dist, 2);
		double forceByX = force * (distInX/dist);
		return forceByX;
	}
	// y方向的受力：受力者.force(施力者)
	public double calcForceExertedByY(Planet p) {
		double distInX = p.xxPos - this.xxPos;
		double distInY = p.yyPos - this.yyPos;
		double dist = Math.sqrt(Math.pow(distInX, 2) +
				Math.pow(distInY, 2));
		double force = G * this.mass * p.mass / Math.pow(dist, 2);
		double forceByY = force * (distInY/dist);
		return forceByY;
	} 
	// NetForce in x-direction
	public double calcNetForceExertedByX(Planet[] planets) {
		double force_x = 0;
		for (Planet i : planets) {
			if (this == i) {
				continue;
			}else {
				force_x += this.calcForceExertedByX(i);
			}
		}
		return force_x;
	}
	// NetForce in y-direction
	public double calcNetForceExertedByY(Planet[] planets) {
		double force_y = 0;
		for (Planet i : planets) {
			if (this == i) {
				continue;
			}else {
				force_y += this.calcForceExertedByY(i);
			}
		}
		return force_y;
	}
	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel = this.xxVel + dt * aX;
		this.yyVel = this.yyVel + dt * aY;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
	// draw
	public void draw() {
		System.out.printf("Star: %s\tX: %f\tY: %f\n",this.imgFileName, this.xxPos, this.yyPos);
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);
	}
}
