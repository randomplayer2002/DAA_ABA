import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        int total_len = m * n;
        
        int matrix[] = new int[total_len + n];
        
        int row = 0, col, level = 0;
        
        for (int i = 0; i < m; i++) {
            
            row = i * 2 < m ? row + 1 : i * 2 == m ? i : row - 1;
            col = 0;
            
            for (int j = 0; j < n; j++) {
                
                col = j * 2 < n ? col + 1 : j * 2 == n ? j : col - 1;
                
                int nr = sc.nextInt();
                
                int new_row = i, new_col = j;
                
                level = Math.min(row, col) - 1;
                
                int rotations = r % ((2 * ((m + n) - 4 * level)) - (m > 2 && n >    2 ? 4 : 0));
                
                for (int k = 0; k < rotations; k++) {
                    
                    if (new_row == level) {
                        if (new_col > level ) {
                            new_col -= 1;
                        } else {
                            new_row += 1;
                        }
                    } else if (new_row == m - level - 1) {
                        if (new_col < n - level - 1) {
                            new_col += 1;
                        } else {
                            new_row -= 1;
                        }
                    } else if (new_col == level) {
                        if (new_row < m - 1) {
                            new_row += 1; 
                        } else {
                            new_col += 1;
                        }
                    } else if (new_col == n - level - 1) {
                        if (new_row > 0) {
                            new_row -= 1;
                        } else {
                            new_col -= 1;
                        }
                    }    
                }      
                
                matrix[new_row * n + new_col] = nr;
            }
            
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i * n + j] + " ");
            }
            System.out.println();
        }
        
    }
}
