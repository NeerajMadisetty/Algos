class Solution {
    public int[][] highFive(int[][] items) {
        
    Arrays.sort(items, new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        if(a[0] != b[0]){
            return a[0]-b[0];
        }else{
            return b[1]-a[1];
        }
     }
    });
    
    int students = 0;
    int studentId = -1;
        
    for(int i=0;i<items.length;i++){
        int currId = items[i][0];
        if(currId != studentId){
            students++;
            studentId = currId;
        }
    }
    
    int[][] result = new int[students][2];
      
    int total=0;
    int sum=0;
    int j=0;
    studentId = -1;
        
    for(int i=0;i<items.length;i++){
        int currId = items[i][0];
        if(currId != studentId){
            studentId = currId;
            sum = items[i][1];
            total = 1;
        }else{
            if(total >= 5) continue;
            else{
                sum+=items[i][1];
                total+=1;
                if(total == 5){
                    result[j][0] = studentId;
                    result[j][1] = sum/5;
                    j++;
                }
            }
        }
    }
    
    return result;
    }
}
