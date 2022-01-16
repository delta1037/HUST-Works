#include <iostream>
#include<algorithm>

using namespace std;
struct person{
  int x;
  int y;
  int z;
  string time;
};
bool compare(person t1,person t2){
  return t1.time < t2.time;
}
int main() {

  int n,m,k;
  int i=0;
  int xt,yt,zt;
  string time;
  cin>>n>>m>>k;
  vector<vector<int>> board(n,vector<int>(m,0));
  vector<vector<int>> result(n,vector<int>(m,0));
  int maxnum=-1;
  int maxi=-1;
  int lightnum=-1;

  person son[k];

  for(i=0;i<k;i++){
    cin>>xt>>yt>>zt>>time;
    son[i].x=xt;
    son[i].y=yt;
    son[i].z=zt;
    son[i].time=time;
  }

  sort(son,son+k,compare);

  for(i=0;i<k;i++){
    if(son[i].z==0){
      if(board[son[i].x-1][son[i].y-1]==0){
        lightnum++;
        if(lightnum>=maxnum){
          maxnum=lightnum;
          maxi=i;
        }
      }
      board[son[i].x-1][son[i].y-1]++;
    }else{
      board[son[i].x-1][son[i].y-1]--;
      if(board[son[i].x-1][son[i].y-1]==0){
        lightnum--;
      }
    }
  }

  for(i=0;i<maxi+1;i++){
    if(son[i].z==0){
      result[son[i].x-1][son[i].y-1]++;
    }else{
      result[son[i].x-1][son[i].y-1]--;
    }
  }

  for(i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(result[i][j]==0){
        cout<<'0';
      }else{
        cout<<'1';
      }
    }
    cout<<endl;
  }
  return 0;
}