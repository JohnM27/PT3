package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Noise implements Serializable{
	
	/*
	 * Variable qui contient l'unit� des vectors diagonaux
	 */
	private double unit = 1.0/Math.sqrt(2);
	
	/*
	 * tableau contenant toutes les directions
	 */
	private double[][] gradient = 
	{
		{unit, unit}, {-unit, unit}, {unit, -unit}, {-unit, -unit},
		{1, 0},			{-1, 0},		 {0, 1},		  {0, -1}
	};
	
	/*
	 * Table de permutation qui va permettre de g�n�rer les vectors
	 */
	private int[] perm = new int[256];
	/*= 
	{
		151,160,137,91,90,15,131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,
		142,8,99,37,240,21,10,23,190, 6,148,247,120,234,75,0,26,197,62,94,252,219,
		203,117,35,11,32,57,177,33,88,237,149,56,87,174,20,125,136,171,168, 68,175,
		74,165,71,134,139,48,27,166,77,146,158,231,83,111,229,122,60,211,133,230,220,
		105,92,41,55,46,245,40,244,102,143,54, 65,25,63,161,1,216,80,73,209,76,132,
		187,208, 89,18,169,200,196,135,130,116,188,159,86,164,100,109,198,173,186,3,
		64,52,217,226,250,124,123,5,202,38,147,118,126,255,82,85,212,207,206,59,227,
		47,16,58,17,182,189,28,42,223,183,170,213,119,248,152, 2,44,154,163, 70,221,
		153,101,155,167, 43,172,9,129,22,39,253, 19,98,108,110,79,113,224,232,178,185,
		112,104,218,246,97,228,251,34,242,193,238,210,144,12,191,179,162,241,81,51,145,
		235,249,14,239,107,49,192,214, 31,181,199,106,157,184, 84,204,176,115,121,50,45,
		127, 4,150,254,138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,
		156,180
	};
	*/
	
	/*
	 * Coordonn�es x et y
	 */
	private double x;
	private double y;
	
	/*
	 * Coordonn�es de base du point (entier)
	 */
	private int x0;
	private int y0;
	
	/*
	 * Coordonn�es temporaire pour la g�n�ration des vectors
	 */
	private double tmpX, tmpY, tmp;
	
	/*
	 * Resolution qu'on a
	 */
	private double resolution;
	
	/*
	 * variable contenant les coordonn�es entre 0 et 255
	 */
	private int maskX = 0;
	private int maskY = 0;
	
	/*
	 * gradient al�atoire
	 */
	private int gradient0, gradient1, gradient2, gradient3;
	
	/*
	 * vectors al�atoire
	 */
	private double vector0, vector1, vector2, vector3;
	
	/*
	 * Coefficient d'interpolation
	 */
	private double Cx, Cy;
	
	/*
	 * attenuation des valeurs
	 */
	private double attenuation1, attenuation2;
	
	public Noise() {
		int r;
		int i = 0;
		boolean redo = false;
		do {
			r = (int) (Math.random() * 255);
			if(i == 0) {
				perm[i] = r;
			}
			else {
				for(int j = 0; j <= i; j++) {
					if(perm[j] == r) {
						redo = true;
					}
				}
			}
			
			if(redo == false) {
				i++;
				perm[i] = r;
			}
			else {
				redo = false;
			}
			if(i == 255) {
				i = 256;
			}
		}while(i <= perm.length-1);
	}
	
	private void masking() {
		maskX = x0%256;
		maskY = y0%256;
	}
	
	private void coordRes() {
		x/=resolution;
		y/=resolution;
	}
	
	private void position() {
		x0 = (int) x;
		y0 = (int) y;
	}
	
	private void recupVector() {
		
		gradient0 = perm[ (maskX + perm[maskY]) % 256 ] % 8;
		gradient1 = perm[ (maskX+1 + perm[maskY]) % 256] % 8;
		gradient2 = perm[ (maskX + perm[ (maskY+1) % 256]) % 256 ] % 8;
		gradient3 = perm[ (maskX+1 + perm[ (maskY+1) % 256]) % 256 ] % 8;
		
		tmpX = x-x0;
		tmpY = y-y0;
		vector0 = gradient[gradient0][0]*tmpX + gradient[gradient0][1]*tmpY;
		
		tmpX = x-(x0+1);
		tmpY = y-y0;
		vector1 = gradient[gradient1][0]*tmpX + gradient[gradient1][1]*tmpY;
	
		tmpX = x-x0;
		tmpY = y-(y0+1);
		vector2 = gradient[gradient2][0]*tmpX + gradient[gradient2][1]*tmpY;
		
		tmpX = x-(x0+1);
		tmpY = y-(y0+1);
		vector3 = gradient[gradient3][0]*tmpX + gradient[gradient3][1]*tmpY;
	}
	
	private double attenuation() {
		tmp = x-x0;
		Cx = 3*tmp*tmp-2*tmp*tmp*tmp;
		//Cx = tmp;
		
		attenuation1 = vector0 + Cx*(vector1-vector0);
		attenuation2 = vector2 + Cx*(vector3-vector2);
		
		tmp = y-y0;
		Cy = 3*tmp*tmp-2*tmp*tmp*tmp;
		//Cy = tmp;
		
		return attenuation1 + Cy*(attenuation2-attenuation1);
	}
	
	public double createNoise(double x, double y, int resolution) {
		this.x = x;
		this.y = y;
		this.resolution = resolution;
		
		coordRes();
		
		position();
		
		masking();
		
		recupVector();
		
		return attenuation();
	}
}

