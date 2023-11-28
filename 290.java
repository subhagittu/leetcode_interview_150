class Solution {

    static boolean helper(String pattern, String str){
        int n = pattern.length();
        String arr[] = str.split(" ");

        if(n!=arr.length) return false;

        HashMap<Character,String> hp = new HashMap<>();

        for(int i=0; i<n; i++){
            char ch = pattern.charAt(i);
            String s = arr[i];

            if(!hp.containsKey(ch)){
                if(hp.containsValue(s)) return false;
                else{
                    hp.put(ch,s);
                }
            }else{
                if(s.compareTo(hp.get(ch))!=0) return false;
            }
        }

        return true;
    }
    public boolean wordPattern(String pattern, String str) {
        return helper(pattern,str);
    }
}
