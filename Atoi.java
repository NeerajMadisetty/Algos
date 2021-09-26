class Solution {
    public int myAtoi(String s) {
        
        if(s.length() == 0) return 0;
        int result = 0;
        boolean negative = false;
        boolean isNegative = false;
        int i=0;
        
        while(s.charAt(i) == ' '){
            i++;
            if(i == s.length()) return result;
        }
        
        if(s.charAt(i) == '-'){
            negative = true;
            isNegative = true;
            i++;
             if(i == s.length()) return result;
        }else if(s.charAt(i) == '+'){
            i++;
        }
        
        result = 0;
        
       // System.out.println("Max value: "+Integer.MAX_VALUE+" Min value: "+Integer.MIN_VALUE);
        
        for(int k=i; k<s.length(); k++){
            
            
            if(s.charAt(k) < '0' || s.charAt(k) > '9') break;
            
            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && s.charAt(k) > '7'))
      return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
                result = result*10 + (s.charAt(k)-'0');
        }
     
        return negative ? -result : result;
    }
}