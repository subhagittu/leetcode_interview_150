class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        nums.push(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            else if(Character.isDigit(s.charAt(i))){
                int t = 0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    t = t*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(!ops.isEmpty()&&(ops.peek()=='+'||ops.peek()=='-')){
                    char op = ops.pop();
                    int res = 0;
                    res = op=='+'?nums.pop()+t:nums.pop()-t;
                    nums.push(res);
                }
                else{
                    nums.push(t);
                }
            }
            else if(s.charAt(i)==')'){
                int t = nums.pop();
                ops.pop();
                if(!ops.isEmpty()&&(ops.peek()=='+'||ops.peek()=='-')){
                    char op = ops.pop();
                    int res = 0;
                    res = op=='+'?nums.pop()+t:nums.pop()-t;
                    nums.push(res);
                }
                else{
                    nums.push(t);
                }
            }
            else if(s.charAt(i)=='('){
                if(!Character.isDigit(s.charAt(i+1))){
                    nums.push(0);
                }
                ops.push('(');
            }
            else{
                ops.push(s.charAt(i));
            }
        }
        int res = 0;
        while(!nums.isEmpty()){
            res += nums.pop();
        }
        return res;
    }
}
