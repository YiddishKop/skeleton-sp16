/**
 * test the Planet class
 * @author yiddi
 *
 */
public class TestPlanet {
	public static void main(String[] args) {
		Planet[] someP = new Planet[2];
		someP[0] = new Planet(0,0,0,0,10,"YL");
		someP[1] = new Planet(1,1,1,1,20,"YX");
		System.out.println(someP[0].calcNetForceExertedByX(someP));
		System.out.println(someP[0].calcNetForceExertedByY(someP));
		System.out.println(someP[1].calcNetForceExertedByX(someP));
		System.out.println(someP[1].calcNetForceExertedByY(someP));
		
	}
}
