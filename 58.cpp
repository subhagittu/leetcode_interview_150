class Solution {
public:
      int lengthOfLastWord(string s) {
        int c=0;
        for(int i=s.size()-1;i>=0;i--) {
            if(s[i]==' ' && c==0)
            continue;
            else if(s[i]!=' ')
            c++;
            else
            break;
        }
        return c;
    }
};
