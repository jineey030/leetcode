class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        String[] arr = str.split("");

        for(int i=0; i<arr.length; i++){
            if(!arr[i].equals(arr[arr.length-1-i])){
                return false;
            }
        }

        return true;
    }
}
