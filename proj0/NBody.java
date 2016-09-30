import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * simulate the solar system
 * @author yiddi
 *
 */
public class NBody {
	/*
	 * ���method����Ϊ��ʵ���� file ��Ϊ����
	 *
	public static double readRadius(String path) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(fis));
		try {
			while(true) {
				String s  = br.readLine();
				if(s == null) {
					break;
				}else {
					System.out.println(s);
				}	
			}
		}catch(IOException e) {
			System.out.println("ERROR in yiddi....");
			e.printStackTrace();
		}
		return 0;
	}
	*/
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		final String PLT_PATH = "./data/planets.txt";
		final String IMG_PATH = "./images/starfield.jpg";
		// ���ñ���
		double radius = readRadius(PLT_PATH);
		System.out.println("Radius: " + radius); // TODO ������
		int canvasHeight = 512;
		int canvasWidth = 512;
		double xScale = radius ;
		double yScale = radius ;
		StdDraw.setCanvasSize(canvasHeight, canvasWidth);
		StdDraw.setXscale(0, xScale);    // ���û�����λ����Χ
		StdDraw.setYscale(0, yScale);
		StdDraw.picture(xScale / 2, yScale / 2, IMG_PATH, xScale, yScale);// picture ������в�������������£�������ʵ�ʻ�����С
		System.out.println("Background Drawing DONE!"); // TODO ��ʹ��
		// �����е�����
		Planet[] plts = readPlanets(PLT_PATH); // ��ȡplanets.txt�����й���planet����Ϣ
		for(Planet p : plts) {
			p.draw();
		}
		// ��������
		double time = 0;
		final double  T = 10000; // TODO
		double dt = 100; // TODO
		int p_num = plts.length;
		double[] xForces = new double[5];
		double[] yForces = new double[5];
		while(true) {
			for (int i = 0; i < p_num; i++) {
				xForces[i] = plts[i].calcNetForceExertedByX(plts);
				yForces[i] = plts[i].calcNetForceExertedByY(plts);
			}
			for (int i = 0; i < p_num; i++) {
				plts[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(xScale / 2, yScale / 2, IMG_PATH, xScale, yScale);// picture ������в�������������£�������ʵ�ʻ�����С
			for(Planet p : plts) {
				p.draw();
			}
			StdDraw.show(1);
			time += dt;
		}
	}
	public static double readRadius(String path) throws FileNotFoundException{
		In in = new In(path);
		in.readDouble();
		double r = in.readDouble();
		in.close();
		return r;
	}
	public static Planet[] readPlanets(String path) throws FileNotFoundException {
		In in = new In(path);
		int p_num = in.readInt();
		System.out.println("This universe has planets: " + p_num);
		in.readDouble();      // ��ȡ�뾶
		Planet[] plts = new Planet[p_num];
		for (int i = 0; i < p_num; i++) {
			plts[i] = new Planet(in.readDouble(), 
					in.readDouble(), in.readDouble(), 
					in.readDouble(), in.readDouble(), in.readString());
		}
		in.close();
		return plts;
	}

}
