#include <iostream>

using namespace std;
int main() {
  int m,n,k;
  int a,b;
  cin>> n >> m >> k ;
  n=n-m;
  long max=INT64_MIN;
  int t=0;
  for(int i=0;i<k;i++){
    cin>> a >> b;
    if(a*m+b*n>=max){
      max=a*m+b*n;
      t=i;
    }
  }
  for(int i=0;i<k;i++){
    i==0? cout<<"":cout<<" ";
    i==t? cout<<m+n:cout<<0;
  }
  return 0;
}