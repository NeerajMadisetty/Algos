class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int[] set = new int[isConnected.length];
        makeset(set);
        for(int i=0;i<isConnected.length;i++){
            for(int j=i+1;j<isConnected.length;j++){
                if(isConnected[i][j] == 1){
                    union(set,i,j);
                }
            }
        }
        
        HashSet<Integer> currSet = new HashSet<Integer>();
        
        for(int i=0 ;i<set.length;i++){
            currSet.add(set[i]);
        }
        
        return currSet.size();
       
    }
     void makeset(int[] set){
        for(int i=0;i<set.length;i++){
            set[i] = i;
        }
     }
    public void union(int[] set, int a, int b){
        int l = set[a];
        int k = set[b];
        
        for(int i=0;i<set.length;i++){
            if(set[i] == k){
                set[i] = l;
            }
            
        }
    }
        
    
}