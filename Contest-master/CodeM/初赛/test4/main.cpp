#include <iostream>
#include <algorithm>
using namespace std;
int cmp( const void *a , const void *b )
{
  return *(double *)a < *(double *)b ? 1 : -1;
}
int main() {
  int i=0,j=0;
  int n,m,k,c;
  cin>> n >> m >> k >> c;
  int q[m];
  int sum=0;
  for(i=0;i<m;i++){
    cin>>q[i];
    sum=sum+q[i];
  }
  double Q[m];
  for(i=0;i<m;i++){
    Q[i]=(double)q[i]/sum;
  }


  double scoreSort[n];
  double score[n];

  int t,tag=-1;
  double min=0,max=0;
  for(i=0;i<n;i++){
    score[i]=0;
    for(j=0;j<m;j++){
      cin>>t;
      if(t!=-1){
        score[i]=score[i]+Q[j]*t;
      } else{
        tag=i;
        max=Q[j]*c;
      }
    }
    scoreSort[i]=score[i];
  }
  min=score[tag];
  max=score[tag]+max;

  qsort(scoreSort,n, sizeof(scoreSort[0]),cmp);



  //there has bugs to resolve!!!!

  double flag=scoreSort[k-1];
  int flag1=0;
  //single
  if(scoreSort[k-2]!=flag&&(k==n|(k<n&&scoreSort[k]!=flag))){
    flag1=1;
  }

  if(min>=flag|max<flag){
    for(i=0;i<n;i++){
      if(score[i]>flag){
        cout<<1;
      }else if(score[i]<flag){
        cout<<2;
      }else{
        if(flag1==1){
          cout<<1;
        }else{
          cout<<3;
        }
      }
      if(i<n-1){
        cout<<endl;
      }
    }
  }else{
    score[tag]=flag;
    for(i=0;i<n;i++){
      if(score[i]>flag){
        cout<<1;
      }else if(score[i]<flag){
        cout<<2;
      }else{
        cout<<3;
      }
      if(i<n-1){
        cout<<endl;
      }
    }
  }
  return 0;
}