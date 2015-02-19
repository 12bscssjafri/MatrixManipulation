package ai_lab1;

public class Matrix {
	
	int[][] mymatrix;
	int[][]result;
	int[][] magic=new int[2][2];
	
	public Matrix(){
		magic[0][0]=-6789;
		magic[0][1]=-6789;
		magic[1][0]=-6789;
		magic[1][1]=-6789;
	}
	
	public int[][] Add(int[][]a,int[][]b){
		
		if(checkValid(a,b,1)){
			int rows=a.length;
			int columns=a[0].length;
			result=new int[rows][columns];
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					result[i][j]=a[i][j]+b[i][j];
					
				}
			}
			
			return result;
		}
		else{
			System.out.println("dimensions different,cannot add");
		}
		return magic;
	}
	
	public int[][] Subtract(int[][]a,int[][]b){
		
		if(checkValid(a,b,1)){
			int rows=a.length;
			int columns=a[0].length;
			result=new int[rows][columns];
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					result[i][j]=a[i][j]-b[i][j];
					
				}
			}
			
			return result;
		}
		else{
			System.out.println("dimensions different,cannot subtract");
		}
		return magic;
	}
	
	public int[][] Multiply(int[][]a,int[][]b){
		int rows,columns_b,columns_a;
		
		if(checkValid(a,b,2)){
			rows=a.length;
			columns_b=b[0].length;
			columns_a=a[0].length;
			int[][] c = new int[rows][columns_b];
			for(int i=0;i<rows;i++){
				
				for(int j=0;j<columns_b;j++){
					
					for(int k=0;k<columns_a;k++){
						
						c[i][j]+=a[i][k]*b[k][j];
						
					}
				}
			}
			return c;
		}
		else{
			System.out.println("dimensions not correct,cannot multiply");
			
		}
		return magic;
	}
	
	public boolean checkValid(int[][]a,int[][]b,int oper){
		
		if(oper==1){
			if( a.length!= b.length || a[0].length!=b[0].length){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			if(a[0].length!=b.length){
				return false;
			}
		}
		return true;
	}
	
	public void Display(int[][]result){
		if(result==magic){
			
			return;
		}
		
		if(result.length==0){
			
			return;
		}
		
		System.out.println("Result:");
		for(int i=0;i<result.length;i++){
			System.out.print("\t");
			for(int j=0;j<result[0].length;j++){
				System.out.print("\t");
				
				System.out.print(result[i][j]);
				System.out.print(" ");
				
			}
			System.out.println("");
		}
	}
}
