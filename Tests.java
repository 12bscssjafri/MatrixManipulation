package ai_lab1;
import java.io.*;
import java.util.ArrayList;
public class Tests {
	int[][] magic=new int[2][2];
	
	public Tests(){
		magic[0][0]=-6789;
		magic[0][1]=-6789;
		magic[1][0]=-6789;
		magic[1][1]=-6789;
	}
	public ArrayList<int[][]> read_and_set_matrices(){
		
		int[][] a;
		ArrayList<int[][]> elements=new ArrayList<int[][]>();
		try {
			BufferedReader in = new BufferedReader
			(new FileReader("F:\\AI_lab1\\AI_lab1\\src\\ai_lab1\\sample.txt"));
			String str,temp;
			String order="";
			int counter=0,rows=0,columns=0,rc=0,cc=0,number=2;
			while ((str = in.readLine()) != null) {
				rc=0;cc=0;
				String[] result = str.split("\\s");
				temp=result[0];
				String[] t2 = temp.split("x");
				rows=Integer.parseInt(t2[0]);
				columns=Integer.parseInt(t2[1]);
				a=new int[rows][columns];
				for (int x=0; x<rows; x++){
					String[] result2 = result[x+1].split(",");
					for (int y=0; y<columns; y++){
						a[x][y]=Integer.parseInt(result2[y]);
					}
				}
				elements.add(a);
				counter++;
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		return  elements;
	}
	
	public void testAdd(ArrayList<int[][]> matlist){
		int[][] result;
		Matrix a=new Matrix();
		if(matlist.size()==2){
			
			result=a.Add(matlist.get(0), matlist.get(1));
			if(result==magic){
				System.out.println("dimensions different,cannot add!");
				return;
			}
			a.Display(result);
			
			return;
		}
		int length=matlist.size();
		
		
		result=a.Add(matlist.get(0), matlist.get(1));
		if(result==magic){
			System.out.println("dimensions different,cannot add!");
			return;
		}
		
		
		
		
		for(int i=2;i<3;i++){
			
			
			result=a.Add(result,matlist.get(i));
		}
		
		a.Display(result);
		return ;
	}
	
	public void testSub(ArrayList<int[][]> matlist){
		int[][] result;
		Matrix a=new Matrix();
		if(matlist.size()<3){
			
			result=a.Subtract(matlist.get(0), matlist.get(1));
			a.Display(result);
			//System.out.println("cannot subtract!!!!!!!");
			return;
		}
		int length=matlist.size();
		
		
		result=a.Subtract(matlist.get(0), matlist.get(1));
		if(result==magic){
			
			return;
		}
		
		a.Display(result);
		
		
		for(int i=2;i<length;i++){
			
			
			result=a.Subtract(result,matlist.get(i));
		}
		
		a.Display(result);
		return ;
	}
	
	public void testMul(ArrayList<int[][]> matlist){
		int length=matlist.size();
		int[][] result;
		Matrix a=new Matrix();
		
		result=a.Multiply(matlist.get(0), matlist.get(1));
		
		a.Display(result);
		
		if(result==magic){
			
			return;
		}
		
		return;
	}
	
	public void add_and_mul(ArrayList<int[][]> matlist){
		
		if(matlist.size()<3){
			System.out.println("Matrices less than 3,cannot test!!!");
			return;
		}
		int length=matlist.size();
		int[][] result;
		Matrix a=new Matrix();
		result=a.Multiply(matlist.get(0), matlist.get(1));
		if(result==magic){
			
			return;
		}
		
		result=a.Add(result, matlist.get(2));
		if(result==magic){
			
			return;
		}
		a.Display(result);
	}
	
	
	public static void main(String[] args) {
		Tests test=new Tests();
		ArrayList<int[][]> matlist=new ArrayList<int[][]>();
		matlist=test.read_and_set_matrices();
		System.out.println("____________________________________________");
		System.out.println("Case 1,multiply 2 matrices:");
		System.out.println("");
		test.testMul(matlist);
		System.out.println("____________________________________________");
		System.out.println("Case 2,Add 3 matrices:");
		System.out.println("");
		test.testAdd(matlist);
		System.out.println("____________________________________________");
		System.out.println("Case 3,subtract 2 matrices:");
		System.out.println("");
		test.testSub(matlist);
		System.out.println("____________________________________________");
		System.out.println("Case 4,multiply 2 matrices,add to 3rd matrix:");
		System.out.println("");
		test.add_and_mul(matlist);
		System.out.println("____________________________________________");
	}
	
}
