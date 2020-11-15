
public class Solucion {

	
	private int MAXI =0;
	private int MAXJ =0;
	
	private int  productoCeros=0;
	
	private int  producto=1;
	private int  prod=1;
	private int  prodTem=1;
	
	private int[][] a;
	public int solucion(int[][] a,int n,int m) {
		
		this.a=a;
		
		MAXI=n;
		MAXJ=m;
		
		int LIMITE_I =MAXI;
		
		
		int startJ=1;
		int startI=1;
		
		boolean okStartI = startI == 0;

		boolean vueltaI = false;
		boolean finI = false;
		

		for (int i = startI; !finI && (i < LIMITE_I) ; ) {	//Index Filas
			
			for (int j = startJ; (j <MAXJ) ; j++) {			//Index Column
				print("");
				reset();
				for (int jCamino = 0;j>0 && jCamino <=j ; jCamino++) //Camino
					caminos(i, jCamino,j);
				
			}
			startJ=0;
			
			if(i == MAXI-1 && !okStartI) {
				if(vueltaI)
					finI=true;
				else {
					vueltaI=true;
					LIMITE_I=startI;
					i=0;
				}
				
			}else
				i++;
			
		}//positivo
		
		print("----");
		for (int i = MAXI-1; i >= 0 ; i--) {//Index filas
			
			for (int j = MAXJ-1; j>=0; j--) {//Index Column
				print("");
				reset();
				for (int jCamino = MAXJ-1; j< MAXJ-1 && jCamino >= j ; jCamino--) //Camino
					caminos(i, jCamino,j);
				
			}
			
		}//negativo
		
		print("NUMERO: "+producto);
		print("NUMERO_CEROS: "+productoCeros);
		
		return productoCeros;
		
	}
	
	private  void caminos(int i,int jCamino,int j) {
		print(i, jCamino);
		mult(i, jCamino);
		if(jCamino==j) {
			//giro der
			if(i<MAXI-1) {
				for (int ii = i+1; ii <MAXI ; ii++) {//Columnas
					print(ii, jCamino);
					multTemp(ii, jCamino);
				}
				mult();
				resetTemp();
			}
			//giro iz
			if(i>0) {
				for (int ii = i-1; ii >=0 ; ii--) {//Columnas
					print(ii, jCamino);
					multTemp(ii, jCamino);
				}
				mult();
				resetTemp();
			}
			
		}
	}
	
	
	private  void reset() {
		prod=1;
		prodTem=1;
		print("reset");
	}
	private  void resetTemp() {
		prodTem=1;
	}
	private  void multTemp(int i,int j) {	
		String s="a["+i+"]["+j+"]*"+prodTem;
		prodTem=a[i][j]*prodTem;
		print("multTemp:"+s+"="+prodTem);
	}
	private  void mult() {		
		print("PRODUCTO:"+prod*prodTem);
		int ceros=ceroCunt(prod*prodTem);
		if(ceros>productoCeros) {
			productoCeros=ceros;
			producto=prod*prodTem;
		}
	}
	private  void mult(int i,int j) {
		String s="a["+i+"]["+j+"]*"+prod;
		prod=a[i][j]*prod;
		print("mult:"+s+"="+prod);
	}
	private  int  ceroCunt(int n) {
		int c = 0;
		while (n%10 == 0) {
		    c++;
		    n/=10;
		}
		return c;
	}
	private  void print(int i,int j) {
		System.out.println(">a["+i+"]["+j+"]"+a[i][j]);
	}
	private  void print(Object ob) {
		System.out.println(ob.toString());
	}
	
	public static void main(String[] args) {
			
		int[][] a;
		
		a= new int[3][3];
		a[0][0]=10;
		a[0][1]=100;
		a[0][2]=10;
		a[1][0]=1;
		a[1][1]=10;
		a[1][2]=1;
		a[2][0]=1;
		a[2][1]=10;
		a[2][2]=1;
		
		new Solucion().solucion(a, a.length, a[0].length);
	}
}
