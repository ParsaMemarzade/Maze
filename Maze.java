package maze;
public class Maze{
	static byte[][] board;
	static void randomFill(byte[][] a){
		for(int i=0; i<a.length; i++)
			for(int j=0; j<a[0].length; j++)
				a[i][j]=(Math.random()<.8?(byte)0:(byte)1);
		a[0][0]=a[a.length-1][a[0].length-1]=0;
	}
	static void printMatrix(byte[][] a){
		for(int i=0; i<a.length; i++){
			for(int j=0; j<a[0].length; j++){
				System.out.print(a[i][j]==0?".":"X");
			}
			System.out.println();
		}	
                      System.out.println("*****************");
	}
	static void printWay(String path){
	           String[][] way1=new String[4][6];
                              int a=0,b=0;
                               String[] way;
                               way=path.split(" ");
                               for(int i=0;i<way1.length;i++)
                                   for(int j=0;j<way1[0].length;j++){
                                    way1[i][j]=" ";   
                                   }
                                       for(int i=0;i<way.length;i++){
                                           if(way[i].equals("D")){
                                                        way1[a][b]="v";
                                                              a+=1;
                                           }
                                           if(way[i].equals("U")){
                                                      way1[a][b]="^";
                                                             a-=1; 
                                           }
                                           if(way[i].equals("R")){
                                                      way1[a][b]=">";
                                                            b+=1;
                                           }
                                           if(way[i].equals("L")){
                                                      way1[a][b]="<";
                                                             b-=1;
                                           }
                                       }
                               for(int i=0;i<way1.length;i++){
                                   for(int j=0;j<way1[0].length;j++){
                                                       System.out.print(way1[i][j]);
                                                   }         
                                                                          System.out.println();
                                                                }
                                                                                   System.out.println("*****************");
                                                                                  }
                               
	
	static boolean available(int i, int j,byte a[][]){
		if(i>=0 && i<board.length && j>=0 && j<board[0].length && a[i][j]==0)
			return true;
		                       return false;
	}
	static void printPath(String path){
                             System.out.print(path);				
	}
	static boolean search(int i, int j,byte[][] a,String path){
		boolean b=false;
                                     byte[][] arr=new byte[4][6];
                                   
                                     for(int x=0;x<arr.length;x++){
                                         for(int y=0;y<arr[0].length;y++){
                                             arr[x][y]=a[x][y];
                                         }
                                     } 
                                     
		if(available(i,j,arr)){
			arr[i][j]=(byte)2;
                                                         
			if(i==arr.length-1 && j==arr[0].length-1){
				arr[i][j]=(byte)7;
                                                                             
				b=true;
                                                                            printPath(path+"\n");
                                                                             printWay(path);
                                                                                      
                                                                                     }
			else{
				                    b=search(i+1,j,arr,path+" D");  
					b=search(i,j+1,arr,path+" R");
					b=search(i-1,j,arr,path+" U");
					b=search(i,j-1,arr,path+" L");
					
                                                            }
	 	}
                                              
		return b;
	}
	public static void main(String args[]){
		board = new byte[4][6];
		randomFill(board);
		printMatrix(board);
		search(0,0,board,"");
	                   
		
	}
}