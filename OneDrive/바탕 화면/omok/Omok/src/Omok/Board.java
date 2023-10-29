package Omok;

public class Board {
	int size;
    String[][] map;
    
    Board(int size) { // 19 * 19
        this.size = size;
        map = new String[size][size];
        
        for (int row = 0; row < size; row++) { // ��
          for (int col = 0; col < size; col++) { // ��
        	  	//   0    0~1
            	map[row][col] =  ".";
          	  }
            }
        }
    
    public void print() {
    	
    	// ���ο� 19
        for (int row = 0; row < size; row++) {
        	// ���ο� 19
            for (int col = 0; col < size; col++) {
            	
            	//�÷��� 0�϶� ���� ���̱� 
            	if (col == 0) {
            		
            		if (row < 10) {
            			System.out.print(" " + row);	
            		}else if(row >= 10) {
            			System.out.print(row);	
            		}
            		
            	}
            	System.out.print(" " + map[row][col]);
               
            }
     
            System.out.println();
        }
        	System.out.print("   A B C D E F G H I J K L M N O P Q R S");
    }
}