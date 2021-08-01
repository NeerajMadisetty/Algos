class Solution {
    public int longestLine(int[][] mat) {
        
        if(mat.length == 0)  return 0;
        
        int m = mat.length;
        int n = mat[0].length;
        
        // int[][] horizontal = new int[m][n];
        // int[][] vertical = new int[m][n];
        // int[][] diagnol = new int[m][n];
        // int[][] anti_diagnol = new int[m][n];
        
        int[][] horizontal = Arrays.stream(mat).map(int[]::clone).toArray(int[][]::new);
        int[][] vertical = Arrays.stream(mat).map(int[]::clone).toArray(int[][]::new);
        int[][] diagnol = Arrays.stream(mat).map(int[]::clone).toArray(int[][]::new);
        int[][] anti_diagnol = Arrays.stream(mat).map(int[]::clone).toArray(int[][]::new);

        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    continue;
                }else{
                    if(j!=0){
                        horizontal[i][j] = 1+horizontal[i][j-1];
                        if(i!=0){
                            diagnol[i][j] = 1+diagnol[i-1][j-1];
                        }
                    }
                    if(i!=0){
                        vertical[i][j] = 1+vertical[i-1][j];
                        if(j<n-1)
                        anti_diagnol[i][j] = 1+ anti_diagnol[i-1][j+1];
                    }
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int local_max = Math.max(Math.max(horizontal[i][j],anti_diagnol[i][j]),Math.max(vertical[i][j],diagnol[i][j]));
                max = Math.max(max,local_max);
            }
        }
        
        return max;
    }
}
