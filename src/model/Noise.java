package model;

public class Noise {
	private double unite = 1.0/Math.sqrt(2);
	
	private double[][] gradient = 
		{{unite,unite}, {-unite,unite}, {unite,-unite}, {-unite,-unite},
		{1,0},      	{-1,0},		{0,1},			{0,-1}};
	
	private int[] perm = new int[255];
	
	private double tempX, tempY;
	
	private int x0, y0, ii, jj, gi0, gi1, gi2, gi3;
	private double tmp, s, t, u, v, Cx, Cy, Li1, Li2;
	
	public Noise() {
		int r;
		int i = 0;
		boolean non = false;
		
		while (i < 255) {
			//a refaire car censé avoir 1 seule chiffre
			r = (int) (Math.random() * 255);
			non = false;
			for(int j = 0; j < perm.length; j++) {
				if( perm[j] == (r = (int) (Math.random() * 255)) ) {
					non = true;
					break;
				}
			}
			
			if(non == false) {
				perm[i] = r;
				i++;
			}
		}
		
		for(int k = 0; k < perm.length; k++) {
			System.out.print(perm[k]+"; ");
		}
	}
		
	public double creerNoise(float x, float y, float res) {
		
		x /= res;
		y /= res;
		
		x0 = (int) x;
		y0 = (int) y;
		
		ii = x0 & 255;
		jj = y0 & 255;
		
		gi0 = perm[ii + perm[jj]] % 8;
		gi1 = perm[ii + 1 + perm[jj]] % 8;
		gi2 = perm[ii + perm[jj + 1]] % 8;
		gi3 = perm[ii + 1 + perm[jj + 1]] % 8;
		
		tempX = x-x0;
		tempY = y-y0;
		s = gradient[gi0][0]*tempX + gradient[gi0][1]*tempY;
		
		tempX = x-(x0+1);
		tempY = y-y0;
		t = gradient[gi1][0]*tempX + gradient[gi1][1]*tempY;
		
		tempX = x-x0;
		tempY = y-(y0+1);
		u = gradient[gi2][0]*tempX + gradient[gi2][1]*tempY;
		
		tempX = x-(x0+1);
		tempY = y-(y0+1);
		v = gradient[gi3][0]*tempX + gradient[gi3][1]*tempY;
		
		tmp = x-x0;
		Cx = 3*tmp*tmp-2*tmp*tmp*tmp;
		
		Li1 = s + Cx*(t-s);
		Li2 = u + Cx*(v-u);
		
		tmp = y-y0;
		Cy = 3*tmp*tmp-2*tmp*tmp*tmp;
		
		return Li1 + Cy*(Li2-Li1);
	}
}

