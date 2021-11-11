	package binary;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Scanner;

public class a1 {
	
	static public class matrix{
	        int r;
	        int c;
	        String name;
	        int matrix[][]=new int[r][c];
	        ArrayList<String> types = new ArrayList<String>();

	        matrix(int r,int c,int matrix[][],String name){
	            this.c=c;
	            this.r=r;
	            this.matrix=matrix;
	            this.name=name;
	        }

	        void show(matrix mat) {
	            for(int i=0;i<mat.types.size()-1;i++) {
	                System.out.println(mat.types.get(i));
	            }
	        }

	        String returnname() {
	            return name;
	        }

	        public int[][] getmat() {
	            return matrix;
	        }
	    }

	    static void labels(matrix mat) {
	        if(Rectangular(mat)) {
	            mat.types.add("Rectangular Matrix");
	        }
	        if(Row(mat)) {
	            mat.types.add("Row Matrix");
	        }
	        if(Column(mat)) {
	            mat.types.add("Column Matrix");
	        }
	        if(Square(mat)) {
	            mat.types.add("Square Matrix");
	        }
	        if(Symmetric(mat)) {
	            mat.types.add("Symmetric Matrix");
	        }
	        if(Skew(mat)) {
	            mat.types.add("Skew-symmetric Matrix");
	        }
	        if(upper_triangular(mat)) {
	            mat.types.add("Upper-Triangular Matrix");
	        }
	        if(Lower_triangular(mat)) {
	            mat.types.add("Lower-Triangular Matrix");
	        }
	        if(Singular(mat)) {
	            mat.types.add("Singular Matrix");
	        }
	        if(Diagonal(mat)) {
	            mat.types.add("Diagonal Matrix");
	        }
	        if(Scalar(mat)) {
	            mat.types.add("Scalar Matrix");
	        }
	        if(Identity(mat)) {
	            mat.types.add("Identity Matrix");
	        }
	        if(Singleton(mat)) {
	            mat.types.add("Singleton Matrix");
	        }
	        if(Ones(mat)) {
	            mat.types.add("Ones Matrix");
	        }
	        if(Null(mat)) {
	            mat.types.add("Null Matrix");
	        }
	    }

	    static boolean Rectangular(matrix mat) {
	        if(mat.r!=mat.c) {
	            return true;
	        }
	        return false;
	    }

	    static boolean Row(matrix mat) {
	        if(mat.r==1 && mat.c>1) {
	            return true;
	        }
	        return false;
	    }

	    static boolean Column(matrix mat) {
	        if(mat.c==1 && mat.r>1) {
	            return true;
	        }
	        return false;
	    }

	    static boolean Square(matrix mat) {
	        if(mat.r==mat.c) {
	            return true;
	        }
	        return false;
	    }

	    static int[][] transpose(int matrix[][],int r,int c){

	        int[][] transpose = new int[r][c];

	        for (int i =0;i<r; i++) {
	            for (int j = 0; j <c; j++) {
	                transpose[j][i] = matrix[i][j];
	            }
	        }
	        return transpose;

	    }

	    static boolean Symmetric(matrix mat) {

	        int i, j, flag = 1;

	        if (mat.r== mat.c) {
	            int[][] transpose=transpose(mat.matrix,mat.r,mat.c);

	            for (i = 0; i < mat.r; i++) {
	                for (j = 0; j < mat.c; j++) {
	                    if (mat.matrix[i][j] != transpose[i][j]) {
	                        flag = 0;
	                        return false;
	                    }
	                }

	            }
	            if(flag==1) {
	                return true;
	            }

	        }
	        return false;
	    }

	    static boolean Skew(matrix mat){


	        if(mat.r==mat.c) {
	            int[][] transpose=transpose(mat.matrix,mat.r,mat.c);
	            for (int i = 0; i < mat.r; i++) {
	                for (int j = 0; j < mat.c; j++) {
	                    if (mat.matrix[i][j] == -transpose[i][j]) {
	                        return true;
	                    }

	                }

	            }
	        }
	        return false;

	    }


	    static boolean upper_triangular(matrix mat) {
	        int i,j,flag=0;

	        for (i = 1; i < mat.r; i++) {
	            for (j = 0; j < i; j++) {
	                if (mat.matrix[i][j] != 0) {
	                    flag = 0;
	                    break;
	                }else
	                    flag = 1;
	            }
	        }
	        if(flag==1) {
	            return true;
	        }
	        return false;

	    }

	    static boolean Lower_triangular(matrix mat) {
	        int flag=0;

	        for (int i = 0; i < mat.r; i++) {
	            for (int j = i + 1; j < mat.c; j++) {
	                if (mat.matrix[i][j] != 0) {
	                    flag=0;
	                    break;
	                }else {
	                    flag=1;
	                }
	            }
	        }

	        if(flag==1) {
	            return true;
	        }
	        return false;
	    }

	    static int determinant(int mat[][],int n) {
	        int D = 0;

	        if (n == 1) {
	            return mat[0][0];
	        }
	        
	        int temp[][] = new int[n][n];
	        int sign = 1;

	        for (int f = 0; f < n; f++){
	            getCofactor(mat, temp, 0, f, n);
	            D += sign * mat[0][f]* determinant(temp, n - 1);
	            sign = -sign;
	        }

	        return D;
	    }

	    static boolean Singular(matrix mat) {

	        int D = determinant(mat.matrix,mat.r);

	        if(D==0) {
	            return true;
	        }
	        return false;

	    }

	    static void getCofactor(int mat[][], int temp[][], int p,int q, int n){
	        int i = 0, j = 0;

	        for (int row = 0; row < n; row++){
	            for (int col = 0; col < n; col++){
	                
	                    if (row != p && col != q){
	                        temp[i][j++] = mat[row][col];
	                        if (j == n - 1){
	                            j = 0;
	                            i++;
	                        }
	                    
	                }
	            }
	        }
	    }

	    static boolean Diagonal(matrix mat) {
	        int flag=0;

	        for (int i = 0; i < mat.r; i++) {
	            for (int j = 0; j < mat.c; j++) {
	                if ((i != j) && (mat.matrix[i][j] != 0)) {
	                    flag=0;
	                    break;
	                }else {
	                    flag=1;
	                }
	            }
	        }
	        if(flag==1) {
	            return true;
	        }
	        return false;
	    }

	    static boolean Scalar(matrix mat) {
	        int flag=1;
	        if(mat.r==mat.c) {
	            for (int i = 0; i < mat.r; i++) {
	                for (int j = 0; j < mat.c; j++) {
	                    if ((i != j) && (mat.matrix[i][j] != 0)) {
	                        flag=0;
	                        break;
	                    }
	                }
	            }


	            for (int i = 0; i < mat.r - 1; i++) {
	                if (mat.matrix[i][i] != mat.matrix[i + 1][i + 1]) {
	                    flag=0;
	                    break;
	                }else {
	                    flag=1;
	                }
	            }


	        }
	        if(flag==1){
	            return true;
	        }
	        return false;
	    }

	    static boolean Identity(matrix mat) {
	        int flag=0;
	        if(mat.r==mat.c) {
	            for (int row = 0; row < mat.r; row++){
	                for (int col = 0; col < mat.c; col++){
	                    if (row == col && mat.matrix[row][col] != 1) {
	                        flag=0;
	                        break;
	                    }else if (row != col && mat.matrix[row][col] != 0) {
	                        flag=0;
	                        break;
	                    }else {
	                        flag=1;
	                    }
	                }
	            }
	        }
	        if(flag==1) {
	            return true;
	        }
	        return false;

	    }

	    static boolean Singleton(matrix mat) {
	        if((mat.r==mat.c) && (mat.r==1)) {
	            return true;
	        }
	        return false;
	    }

	    static boolean Ones(matrix mat) {
	        int flag=1;

	        for(int i=0;i<mat.r;i++) {
	            for(int j=0;j<mat.c;j++) {
	                if(mat.matrix[i][j]!=1) {
	                    flag=0;
	                    break;
	                }
	            }
	        }
	        if(flag==1) {
	            return true;
	        }
	        return false;
	    }

	    static boolean Null(matrix mat) {
	        int flag=1;

	        for(int i=0;i<mat.r;i++) {
	            for(int j=0;j<mat.c;j++) {
	                if(mat.matrix[i][j]!=0) {
	                    flag=0;
	                    break;
	                }
	            }
	        }
	        if(flag==1) {
	            return true;
	        }
	        return false;
	    }

	    static int[][] add(int mat1[][],int mat2[][], int r, int c){
	        int i, j;
	        int C[][] = new int[r][c];

	        for (i = 0; i <r; i++)
	            for (j = 0; j <c; j++)
	                C[i][j] = mat1[i][j] + mat2[i][j];

	        return C;
	    }
	    

	    static int[][] sub(int mat1[][],int mat2[][], int r, int c){
	        int i, j;
	        int C[][] = new int[r][c];

	        for (i = 0; i <r; i++)
	            for (j = 0; j <c; j++)
	                C[i][j] = mat1[i][j] - mat2[i][j];

	        return C;
	    }

	    static int[][] multiplyMatrix(int row1, int col1, int[][] A, int row2, int col2, int[][] B){
	        int i, j, k;
	        int[][] C = new int[row1][col2];
	        if (row2 != col1) {
	            System.out.println( "\nMultiplication Not Possible");
	        }else {
	        	for (i = 0; i < row1; i++) {
		            for (j = 0; j < col2; j++) {
		                for (k = 0; k < row2; k++)
		                    C[i][j] += A[i][k] * B[k][j];
		            }
		        }
	        }
	        
	        return C;
	    }
	    
	    static float[][] multiplyMatrix2(int row1, int col1, int[][] A, int row2, int col2, float[][] B){
	        int i, j, k;
	        float[][] C = new float[row1][col2];
	        if (row2 == col1) {
	            System.out.println( "\nMultiplication Not Possible");
	        }else {
	        	for (i = 0; i < row1; i++) {
		            for (j = 0; j < col2; j++) {
		                for (k = 0; k < row2; k++)
		                    C[i][j] += A[i][k] * B[k][j];
		            }
		        }
	        }
	        
	        return C;
	    }
	    
	    static double[][] multiplyMatrix1(int row1, int col1, int[][] A, int row2, int col2, int[][] B){
	        int i, j, k;
	        double[][] C = new double[row1][col2];
	        if (row2 != col1) {
	            System.out.println( "\nMultiplication Not Possible");
	        }else {
	        	for (i = 0; i < row1; i++) {
		            for (j = 0; j < col2; j++) {
		                for (k = 0; k < row2; k++)
		                    C[i][j] += A[i][k] * B[k][j];
		            }
		        }
	        }
	        
	        return C;
	    }
	    
	    static int[][] element_multiply(int row1, int col1, int[][] A, int row2, int col2, int[][] B){
	        int i, j, k;
	        int[][] C = new int[row1][col2];
	        if (col2 != col1 && row1!=row2) {
	            System.out.println( "\nMultiplication Not Possible");
	        }else {
	        	for (i = 0; i < row1; i++) {
		            for (j = 0; j < row2; j++) {
		                C[i][j]=A[i][j]*B[i][j];
		        }
	         }
	       }
	        
	        return C;
	    }
	    
	    static float[][] division(int[][] arr,int r,int c, int div){
	    	float[][] C = new float[r][c];
			
	    	for(int i=0;i<r;i++) {
	    		for(int j=0;j<c;j++) {
	    			C[i][j]=arr[i][j]/div;
	    		}
	    	}
	    	
	    	return C;
	    }

	    static void adjoint(int A[][],int [][]adj,int N){
	        if (N == 1){
	            adj[0][0] = 1;
	            return;
	        }
	        int sign = 1;
	        int [][]temp = new int[N][N];

	        for (int i = 0; i < N; i++)
	        {
	            for (int j = 0; j < N; j++){
	                getCofactor(A, temp, i, j, N);
	                sign = ((i + j) % 2 == 0)? 1: -1;
	                adj[j][i] = (sign)*(determinant(temp, N-1));
	            }
	        }
	    }

	    static float[][] inverse(int[][] A, int N){
	        // Find determinant of A[][]
	    	float [][]inverse=new float[N][N];
	        int det = determinant(A, N);
	        int [][]adj = new int[N][N];
	        adjoint(A, adj,N);
	        if (det == 0){
	            System.out.print("Singular matrix, can't find its inverse");

	        }else {
	        	for (int i = 0; i < N; i++)
		            for (int j = 0; j < N; j++)
		                inverse[i][j] = adj[i][j]/(float)det;
	        }
	        return inverse;
	    }

	    static void print(int mat[][],int r , int c) {
	        for(int i=0;i<r;i++) {
	            for(int j=0;j<c;j++) {
	                System.out.print(mat[i][j]+" ");
	            }System.out.println();
	        }
	    }
	    static void print(float mat[][],int r , int c) {
	        for(int i=0;i<r;i++) {
	            for(int j=0;j<c;j++) {
	                System.out.print(mat[i][j]+" ");
	            }System.out.println();
	        }
	    }
	    
	    static void mean_row(int mat[][],int r,int c) {
	    	int sumRow;
	    	for(int i=0;i<r;i++){    
	            sumRow = 0;    
	            for(int j=0;j<c;j++){    
	              sumRow = sumRow + mat[i][j];    
	            }    
	            System.out.println("mean of " + (i+1) +" row: " + sumRow/r);    
	        }    
	    }
	    
	    static void mean_column(int mat[][],int r,int c) {
	    	int sumCol;
	    	 for(int i=0;i<c;i++){    
	             sumCol=0;    
	             for(int j=0;j<r;j++){    
	               sumCol=sumCol+mat[j][i];    
	             }    
	             System.out.println("mean of " + (i+1) +" column: " + sumCol/c);    
	         }    
	    }
	    
	    static void mean(int mat[][],int r,int c) {
	    	float average,sum=0;
	    	for(int i=0;i<r;i++){ 
	    		for(int j=0;j<c;j++){ 
	    			sum = sum + mat[i][j];
	        }
	    }
	    average=sum/(r*c);
	    System.out.println("AVERAGE of the elements of the matrix is "+average) ;
	    	
	    }
	    
	    // used this site for eigen value to get this i didnot fully understood the concept of eigen vectors
	    // https://stackoverflow.com/questions/43727943/how-to-solve-for-eigenvectors-of-a-2x2-matrix-using-java
	    public static double[] getBasis(int[][] matrix){

	        double a = matrix[0][0];
	        double b = matrix[0][1];
	        double c = matrix[1][0];
	        double d = matrix[1][1];

	        double eigenvalue1 = ((a+d) + Math.sqrt( Math.pow(a-d,2) + 4*b*c))/2;
	        double eigenvalue2 = ((a+d) - Math.sqrt( Math.pow(a-d,2) + 4*b*c))/2;

	        // store the basis in a 2 element array
	        double[] basis = new double[2];

	        for (double y = -1000; y <= 1000; y++) {
	            for (double x = -1000; x <= 1000; x++) {
	                if (((a-eigenvalue1)*x + b*y == 0) && (c*x + (d-eigenvalue1)*y == 0)) {
	                    System.out.println("Eigenvector1: (" + x + "," + y + ")");
	                    basis[0] = eigenvalue1;
	                }
	            }
	        }   

	        for (double y = -10; y <= 10; y++) {
	            for (double x = -10; x <= 10; x++) {
	                if (((a-eigenvalue2)*x + b*y == 0) && (c*x + (d-eigenvalue2)*y == 0)) {
	                    System.out.println("Eigenvector2: (" + x + "," + y + ")");
	                    basis[1] = eigenvalue2;
	                }
	            }
	        }

	        return basis;
	    }
	    
	    		    
	    static float[][] linear_eq(int[][] mat1, int[][] mat2,int n) {
	    	float[][] arr=new float[n][n];
			float c[][]=new float[n][n];
			c=inverse(mat1,n);
			arr=multiplyMatrix2(n,n,mat1,1,n,c);
	    	//arr=multiply(mat1,c);
	    	return arr;
	    }

	    public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        matrix mat = null;
	        int n;
	        int m;
	        String name = null;
	        Map<String, matrix> matrix_data = new HashMap<>();
	        System.out.println("--------------------------------------------------------------------------------------------");
	        System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\r\n"
	                + "2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\r\n"
	                + "3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\r\n"
	                + "4. Display all the matrix-type labels of a requested matrix.\r\n"
	                + "5. Perform addition, subtraction, multiplication & division.\r\n"
	                + "6. Perform element-wise operations.\r\n"
	                + "7. Transpose matrices.\r\n"
	                + "8. Inverse matrices.\r\n"
	                + "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\r\n"
	                + "10. Compute determinants.\r\n"
	                + "11. Use singleton matrices as scalars, if requested.\r\n"
	                + "12. Compute A+AT for a matrix A.\r\n"
	                + "13. Compute Eigen vectors and values.\r\n"
	                + "14. Solve sets of linear equations using matrices.\r\n"
	                + "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\r\n"
	                + "16. Quit");
	        System.out.println("---------------------------------------------------------------------------------------------");
	        System.out.println();
	        System.out.println("Choose Option");
	        n = sc.nextInt();

	        while(n!=16) {
	            if(n==1) {
	                System.out.println("Name of matrix");
	                sc.nextLine();
	                name=sc.nextLine();
	                System.out.println("Rows in matrix");
	                int r=sc.nextInt();
	                System.out.println("Coulumns in matrix");
	                int c=sc.nextInt();
	                int matrix[][]=new int[r+1][c+1];
	                System.out.println();
	                System.out.println("Elements in matrix");
	                
	                for(int i=0;i<r;i++) {
	                    for(int j=0;j<c;j++) {
	                        matrix[i][j]=sc.nextInt();
	                    }
	                }

	                mat=new matrix(r,c,matrix,name);
//	                mat.types.add(name);
	                matrix_data.put(name, mat);
	                labels(mat);
	                System.out.println("---------------------------------------------------------");
	                System.out.println("Choose new option");
	                n=sc.nextInt();
	                continue;
	            }
	            if(n==2) {
	            		System.out.println("Type of matrix you want to generate");
	            		sc.nextLine();
	            		System.out.println("1. Rectangular Matrix\r\n"
	            				+ "2. Row Matrix\r\n"
	            				+ "3. Column Matrix\r\n"
	            				+ "4. Square Matrix\r\n"
	            				+ "5. Symmetric Matrix\r\n"
	            				+ "6. Skew-symmetric Matrix\r\n"
	            				+ "7. Upper-triangular Matrix\r\n"
	            				+ "8. Lower-triangular Matrix\r\n"
	            				+ "9. Singular Matrix\r\n"
	            				+ "10. Diagonal Matrix\r\n"
	            				+ "11. Scalar Matrix\r\n"
	            				+ "12. Identity Matrix\r\n"
	            				+ "13. Singleton Matrix\r\n"
	            				+ "14. Ones Matrix\r\n"
	            				+ "15. Null Matrix");
	            		int s=sc.nextInt();
	            		if(s==4 || s==5 || s==9 ||s==10 ||s==11 || s==12 || s==7 || s==8 ) {
	            			int arr[][]= {{1,0,0},{0,1,0},{0,0,1}};
	            			for(int i=0;i<3;i++) {
	            				for(int j=0;j<3;j++) {
	            					System.out.print(arr[i][j]+" ");
	            				}
	            				System.out.println();
	            			}
	            			matrix_data.put(name, mat);
	            			System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	            		}
	            		
	            		if(s==1 || s==2) {
	            			int arr[]= {1,0,0};
	            			for(int j=0;j<3;j++) {
            					System.out.println(arr[j]+" ");
            				}
	            			System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	            		}
	            		if(s==3) {
	            			int arr[][]= {{1,0,0},{1,0,0},{1,0,0}};
	            			for(int i=0;i<3;i++) {
	            				for(int j=0;j<3;j++) {
	            					System.out.print(arr[i][j]+" ");
	            				}
	            				System.out.println();
	            			}
	            			System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	            		}
	            		if(s==15) {
	            			int arr[][]= {{0,0,0},{0,0,0},{0,0,0}};
	            			for(int i=0;i<3;i++) {
	            				for(int j=0;j<3;j++) {
	            					System.out.print(arr[i][j]+" ");
	            				}
	            				System.out.println();
	            			}
	            			System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	            		}
	            		if(s==13 || s==14) {
	            			int arr[]= {1};
	            			System.out.println(arr[0]);
	            			System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	            		}
	            		if(s==6) {
	            			int arr[][]= {{0,1,-2},{-1,0,3},{2,-3,0}};
	            			for(int i=0;i<3;i++) {
	            				for(int j=0;j<3;j++) {
	            					System.out.print(arr[i][j]+" ");
	            				}
	            				System.out.println();
	            			}
	            			System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	            		}else {
	            			System.out.println("Wrong option");
	            			System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	            		}
	            	 	
	            }
            if(n==3) {
	            	System.out.println("Type of matrix's whose element you want to change");
            		sc.nextLine();
            		matrix mat3=null;
 	                String m5=sc.nextLine();
 	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
 	                    if (entry.getKey().equals(m5)){
 	                        mat3 = entry.getValue();
 	                    }
          }
	                    System.out.println("Elemnts of the new matrix of same type");
 	                    int x=mat3.r;
 	                    int y=mat3.c;
 	                    int arr[][]=new int[x][y];
	                   for(int i=0;i<x;i++) {
 	                	   for(int j=0;j<y;j++) {
                    			arr[i][j]=mat3.matrix[i][j];
                    		}
                    	} 	                    
 	                   for(int i=0;i<x;i++) {
 	                	   for(int j=0;j<y;j++) {
                    			mat3.matrix[i][j]=sc.nextInt();
                    		}
                    	}
 	                ArrayList<String> q=new ArrayList<>();
 	                if(Rectangular(mat)) {
 	     	           q.add("Rectangular Matrix");
 	     	        }
 	     	        if(Row(mat3)) {
 	     	            q.add("Row Matrix");
 	     	        }
 	     	        if(Column(mat3)) {
 	     	            q.add("Column Matrix");
 	     	        }
 	     	        if(Square(mat3)) {
 	     	            q.add("Square Matrix");
 	     	        }
 	     	        if(Symmetric(mat3)) {
 	     	            q.add("Symmetric Matrix");
 	     	        }
 	     	        if(Skew(mat3)) {
 	     	            q.add("Skew-symmetric Matrix");
 	     	        }
 	     	        if(upper_triangular(mat3)) {
 	     	            q.add("Upper-Triangular Matrix");
 	     	        }
 	     	        if(Lower_triangular(mat3)) {
 	     	            q.add("Lower-Triangular Matrix");
 	     	        }
 	     	        if(Singular(mat3)) {
 	     	            q.add("Singular Matrix");
 	     	        }
 	     	        if(Diagonal(mat3)) {
 	     	            q.add("Diagonal Matrix");
 	     	        }
 	     	        if(Scalar(mat3)) {
 	     	            q.add("Scalar Matrix");
 	     	        }
 	     	        if(Identity(mat3)) {
	     	            q.add("Identity Matrix");
 	     	        }
 	     	        if(Singleton(mat3)) {
 	     	            q.add("Singleton Matrix");
 	     	        }
 	     	        if(Ones(mat3)) {
 	     	            q.add("Ones Matrix");
 	     	        }
 	     	        if(Null(mat3)) {
 	     	            q.add("Null Matrix");
 	     	        }
                if(q.equals(mat3.types)) {
 	                	  System.out.println("Changed");
 	                	  matrix_data.replace(name, mat,mat3);
 	                   }
 	                   else {
 	                	   mat3.matrix=arr;
 	                	   System.out.println("not changed as their types are not same to the original matrix");
 	                   }
                  
	            }

	            if(n==4) {
	            	
	                System.out.println("Choose matrix for which labels have to be shown");
	                System.out.println();
	                sc.nextLine();
	                String name1=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(name1)){
	                        mat.show(entry.getValue());
	                    }
	                }
	                System.out.println();
	                System.out.println("---------------------------------------------------------");
	                System.out.println("Choose new option");
	                n=sc.nextInt();
	                continue;
	            }

	            if(n==5) {
	                matrix mat1 = null,mat2 = null;
	                System.out.println("1. addition.\r\n"
	                		+ "2. subtraction.\r\n"
	                		+ "3. multiplication.\r\n"
	                		+ "4. division");
	                
	                System.out.println();
	                System.out.println("Choose operation");
	                m=sc.nextInt();
	                
	                System.out.println("name of matrix 1");
	                sc.nextLine();
	                String m1=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m1)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }if(m==1 || m==2 || m==3) {
	                System.out.println("Name of matrix 2");
	                String m2=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m2)){
	                        mat2 = entry.getValue();
	                        break;
	                    }
	                }
	                }
	               
	                if(m==1) {
	                	System.out.println();
	                    print(add(mat1.matrix,mat2.matrix, mat1.r, mat1.c),mat1.r, mat1.c);
	                    System.out.println("---------------------------------------------------------");
	                    System.out.println("Choose new option");
	                    n=sc.nextInt();
	                    continue;
	                }if(m==2) {
	                	System.out.println();
	                    print(sub(mat1.matrix,mat2.matrix, mat1.r, mat1.c),mat1.r, mat1.c);
	                    System.out.println("---------------------------------------------------------");
	                    System.out.println("Choose new option");
	                    n=sc.nextInt();
	                    continue;
	                }if(m==3) {
	                	System.out.println();
	                    print(multiplyMatrix(mat1.r, mat1.c,mat1.matrix,mat2.r, mat2.c,mat2.matrix),mat1.r,mat2.c);
	                    System.out.println("---------------------------------------------------------");
	                    System.out.println("Choose new option");
	                    n=sc.nextInt();
	                    continue;
	                }if(m==4) {
	                	System.out.println();
	                	System.out.println("The number to divide the matrix ");
	                	int k=sc.nextInt();
	                	System.out.println();
	                	print(division(mat1.matrix,mat1.c,mat1.r, k),mat1.r,mat1.c);
	                	System.out.println("---------------------------------------------------------");
	                	System.out.println("Choose new option");
	                	n=sc.nextInt();
	                    continue;
	                }else {
	                	System.out.println();
	                	System.out.println("Wrong input");
	                	System.out.println("---------------------------------------------------------");
	                }
	                
	            }

	            if(n==6) {
	            	
	            	matrix mat1 = null,mat2 = null;
	                System.out.println("1. Element wise addition.\r\n"
	                		+ "2. Element wise subtraction.\r\n"
	                		+ "3. Element wise multiplication.\r\n"
	                		+ "4. Element wise division");
	                
	                System.out.println();
	                System.out.println("Choose operation");
	                m=sc.nextInt();
	                
	                System.out.println("name of matrix 1");
	                sc.nextLine();
	                String m1=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m1)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }if(m==1 || m==2 || m==3) {
	                System.out.println("Name of matrix 2");
	                String m2=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m2)){
	                        mat2 = entry.getValue();
	                        break;
	                    }
	                }
	                }
	                
	                if(m==1) {
	                	System.out.println();
	                    print(add(mat1.matrix,mat2.matrix, mat1.r, mat1.c),mat1.r, mat1.c);
	                    System.out.println("---------------------------------------------------------");
	                    System.out.println("Choose new option");
	                    n=sc.nextInt();
	                    continue;
	                }if(m==2) {
	                	System.out.println();
	                    print(sub(mat1.matrix,mat2.matrix, mat1.r, mat1.c),mat1.r, mat1.c);
	                    System.out.println("---------------------------------------------------------");
	                    System.out.println("Choose new option");
	                    n=sc.nextInt();
	                    continue;
	                }if(m==3) {
	                	System.out.println();
	                    print(element_multiply(mat1.r, mat1.c,mat1.matrix,mat2.r, mat2.c,mat2.matrix),mat1.r,mat2.c);
	                    System.out.println("---------------------------------------------------------");
	                    System.out.println("Choose new option");
	                    n=sc.nextInt();
	                    continue;
	                }if(m==4) {
	                	System.out.println();
	                	System.out.println("The number to divide the matrix ");
	                	int k=sc.nextInt();
	                	System.out.println();
	                	print(division(mat1.matrix,mat1.c,mat1.r, k),mat1.r,mat1.c);
	                	System.out.println("---------------------------------------------------------");
	                	System.out.println("Choose new option");
	                	n=sc.nextInt();
	                    continue;
	                }else {
	                	System.out.println();
	                	System.out.println("Wrong input");
	                	System.out.println("---------------------------------------------------------");
	                }
	                
	                
	            	 System.out.println("---------------------------------------------------------");
		                System.out.println("Choose new option");
		                n=sc.nextInt();
		                continue;	
	            }

	            if(n==7) {
	                matrix mat1 = null;
	                System.out.println("Choose matrix to be transposed");
	                sc.nextLine();
	                String m3=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m3)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }
	                int trans[][]=transpose(mat1.matrix,mat.r,mat.c);
	                //print(trans,mat1.r,mat1.c);
	                for(int i=0;i<mat1.r;i++) {
	                	for(int j=0;j<mat1.c;j++) {
	                		System.out.print(trans[i][j]+" ");
	                	}System.out.println();
	                }
	                System.out.println("---------------------------------------------------------");
	                System.out.println("Choose new option");
	                n=sc.nextInt();
	                continue;

	            }
	            if(n==8) {
	            	 	matrix mat1 = null;
		                System.out.println("Choose matrix to be inversed");
		                sc.nextLine();
		                String m3=sc.nextLine();
		                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
		                    if (entry.getKey().equals(m3)){
		                        mat1 = entry.getValue();
		                        break;
		                    }
		                }
		                float[][] inver=inverse(mat1.matrix,mat.r);
		                float[][] ax=new float[mat.r][mat.r];
		                if(inver==ax) {
		                	System.out.println("Singular matrix, can't find its inverse");
		                }else {
		                	 print(inver,mat1.r,mat1.c);
		                }
		                System.out.println("---------------------------------------------------------");
		                System.out.println("Choose new option");
		                n=sc.nextInt();
		                continue;
	            }
	            if(n==9) {
	            	matrix mat1 = null;
	                System.out.println("Choose matrix to find mean");
	                sc.nextLine();
	                String m3=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m3)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }
	                
	            	System.out.println("1. Row wise mean.\r\n"
	            			+ "2. Column Wise mean.\r\n"
	            			+ "3. Mean of all elements.");
	            	int s=sc.nextInt();
	            	if(s==1) {
	            		mean_row(mat1.matrix,mat1.r,mat1.c);
	            		System.out.println("---------------------------------------------------------");
		                System.out.println("Choose new option");
		                n=sc.nextInt();
		                continue;	
	            	}
	            	if(s==2){
	            		mean_column(mat1.matrix,mat1.r,mat1.c);
	            		System.out.println("---------------------------------------------------------");
		                System.out.println("Choose new option");
		                n=sc.nextInt();
		                continue;	
	            	}
	            	if(s==3) {
	            		mean(mat1.matrix,mat1.r,mat1.c);
	            		System.out.println("---------------------------------------------------------");
		                System.out.println("Choose new option");
		                n=sc.nextInt();
		                continue;	
	            	}
	            	
	            	 
	            }
	            if(n==10) {
	            	matrix mat1 = null;
	                System.out.println("Choose matrix to be determinant");
	                sc.nextLine();
	                String m3=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m3)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }
	                System.out.println(determinant(mat1.matrix,mat1.r));
	                System.out.println("---------------------------------------------------------");
	                System.out.println("Choose new option");
	                n=sc.nextInt();
	                continue;
	            }
	            if(n==11) {
	            	matrix mat1 = null,mat2 = null;
	                System.out.println("Matrix to multiply to Singleton Matrix");	                
	                
	                sc.nextLine();
	                String m1=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m1)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }
	                System.out.println("Singleton matrix");
	                String m2=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m2)){
	                        mat2 = entry.getValue();
	                        break;
	                    }
	                
	                }
	                if(mat2.types.contains("Singleton Matrix") || mat2.types.contains("Singleton Matrix")) {
	                	int v=mat2.matrix[0][0];
	                	for(int i=0;i<mat1.r;i++) {
	                		for(int j=0;j<mat1.c;j++) {
	                			System.out.print(mat1.matrix[i][j]*v+" ");
	                		}System.out.println();
	                	}
	                	//print(multiplyMatrix(mat1.r, mat1.c,mat1.matrix,mat2.r, mat2.c,mat2.matrix),mat1.r,mat2.c);
	                	System.out.println("---------------------------------------------------------");
			            System.out.println("Choose new option");
			            n=sc.nextInt();
			            continue;	
	                }else {
	                	System.out.println("the matrix you inputed is not singleton matrix");
	                	System.out.println("---------------------------------------------------------");
			             System.out.println("Choose new option");
			             n=sc.nextInt();
			             continue;	
	                }
	            }
	            if(n==12) {
	            	matrix mat1 = null;
	                System.out.println("Choose matrix to be find A+AT for a matrix A");
	                sc.nextLine();
	                String m3=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m3)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }
	                int arr[][]=new int[mat1.r][mat.c];
	                arr=transpose(mat1.matrix,mat.r,mat.c);
	                System.out.println();
	                print(add(mat1.matrix,arr, mat1.r, mat1.c),mat1.r, mat1.c);
	                System.out.println("---------------------------------------------------------");
	                System.out.println("Choose new option");
	                n=sc.nextInt();
	                continue;	                
	            }
	            if(n==13) {
	            	matrix mat1 = null;
	                System.out.println("Choose matrix to find eigen vetor and values");
	                sc.nextLine();
	                String m3=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m3)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }
	            	double[] arr=new double[mat1.c];
	            	arr=getBasis(mat1.matrix);
	            	System.out.println();
	            	System.out.println("Bases");
	            	for(int i=0;i<arr.length;i++) {
	            		System.out.println(arr[i]);
	            	}
	            	
	            	 System.out.println("---------------------------------------------------------");
		                System.out.println("Choose new option");
		                n=sc.nextInt();
		                continue;	
	            }
	            if(n==14) {
	            	matrix mat1 = null;
	            	matrix mat2 = null;
	                System.out.println("matrix for solving linear equation");
	                sc.nextLine();
	                String m3=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m3)){
	                        mat1 = entry.getValue();
	                        break;
	                    }
	                }
	                if(!mat1.types.contains("Square Matrix")) {
	                	System.out.println("Was not a square matrix");
	                	 System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;
	                }else {
	                System.out.println("Name of matrix 2");
	                String m2=sc.nextLine();
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    if (entry.getKey().equals(m2)){
	                        mat2 = entry.getValue();
	                        break;
	                    }
	                }
	                }
	                if(!mat2.types.contains("Column Matrix")) {
	                	System.out.println("Was not a column matrix");
	                	 System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	                }else {
	                	float arr[][]=new float[mat.c][mat.c];
	                	arr=linear_eq(mat1.matrix,mat2.matrix,mat1.c);
	                	for(int i=0;i<mat.r;i++) {
	                		for(int j=1;j<2;j++) {
	                			System.out.print(arr[i][j]+" ");
	                		}System.out.println();
	                	}
	                	 System.out.println("---------------------------------------------------------");
			                System.out.println("Choose new option");
			                n=sc.nextInt();
			                continue;	
	                }
	             	
	            }
	            if(n==15) {
	            	
	            	System.out.println("Choose matrix type");
	            	System.out.println("1. Rectangular Matrix\r\n"
            				+ "2. Row Matrix\r\n"
            				+ "3. Column Matrix\r\n"
            				+ "4. Square Matrix\r\n"
            				+ "5. Symmetric Matrix\r\n"
            				+ "6. Skew-symmetric Matrix\r\n"
            				+ "7. Upper-triangular Matrix\r\n"
            				+ "8. Lower-triangular Matrix\r\n"
            				+ "9. Singular Matrix\r\n"
            				+ "10. Diagonal Matrix\r\n"
            				+ "11. Scalar Matrix\r\n"
            				+ "12. Identity Matrix\r\n"
            				+ "13. Singleton Matrix\r\n"
            				+ "14. Ones Matrix\r\n"
            				+ "15. Null Matrix");
	                sc.nextLine();
	                int e=sc.nextInt();
	                String value = null;
	                if(e==1) {
	                	value="Rectangular Matrix";
	                }if(e==2) {
	                	value="Row Matrix";
	                }if(e==3) {
	                	value="Column Matrix";
	                }if(e==4) {
	                	value="Square Matrix";
	                }if(e==5) {
	                	value="Symmetric Matrix";
	                }if(e==6) {
	                	value="Skew-symmetric Matrix";
	                }if(e==7) {
	                	value="Upper-triangular Matrix";
	                }if(e==8) {
	                	value="Lower-triangular Matrix";
	                }if(e==9) {
	                	value="Singular Matrix";
	                }if(e==10) {
	                	value="Diagonal Matrix";
	                }if(e==11) {
	                	value="Scalar Matrix";
	                }if(e==12) {
	                	value="Identity Matrix";
	                }if(e==13) {
	                	value="Singleton Matrix";
	                }if(e==14) {
	                	value="Ones Matrix";
	                }if(e==15) {
	                	value="Null Matrix";
	                }else {
	                	System.out.println("wrong i/p");
	                }
	                for(Map.Entry<String, matrix> entry: matrix_data.entrySet()){
	                    ArrayList<String> type = entry.getValue().types;
	                    for (String s : type) {
	                        if (s.equalsIgnoreCase(value)) {
	                            System.out.println(entry.getKey());
	                        }
	                    }
	                }
	                System.out.println("---------------------------------------------------------");
	                System.out.println("Choose new option");
	                n=sc.nextInt();
	                continue;
	            }
	            if(n==16) {
	            	System.out.println("----------------------------------------------------------");
	            	return;
	            }
	            else {
	            	 System.out.println("---------------------------------------------------------");
		                System.out.println("Choose new option");
		                n=sc.nextInt();
		                continue;	
	            }
	        }
	    }

	}



