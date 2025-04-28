class Solution {
    public boolean solution(int x) {
        int xSum = 0;
        String xStr = Integer.toString(x);
        
        for(int i = 0; i < xStr.length(); i++) {
            xSum += Character.getNumericValue(xStr.charAt(i));
        }
        return (x % xSum == 0 ? true : false);
    }
}