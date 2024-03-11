class Solution {
public:
 int dp[10005];
 int fn( vector<int>&a,int k){
  int ans=INT_MAX;
  if(dp[k]!=-1)return dp[k]; 
  if(k==0)return 0;
  for(auto &i:a){
     if(k>=i) ans=min(ans+0LL,fn(a,k-i)+1LL);
    //   ans=min(ans,fn(a,k));
  }
  return dp[k]=ans;
  }
    int coinChange(vector<int>& a, int k) {
        sort(a.begin(),a.end());
        memset(dp,-1,sizeof(dp));
      return fn(a,k)==INT_MAX ? -1:fn(a,k);
    
    }
};
