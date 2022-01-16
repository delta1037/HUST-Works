#include <iostream>
#include <iomanip>
using namespace std;
int main() {
  int m,n,t;
  int a[100];
  double manCut=0;
  double total=0;
  cin >> n >> m;
  for(int i=0;i<n;i++){
    cin >> a[i] >> t;
    total=total+a[i];
    if(t==1){
      manCut=manCut+a[i]*0.8;
    } else{
      manCut=manCut+a[i];
    }
  }
  int man,cut;
  double min=total;
  for(int i=0;i<m;i++){
    cin>> man >> cut;
    if(total>=man&&(min>total-cut)){
      min=total-cut;
    }
  }
  if(min>manCut){
    cout<<fixed<<setprecision(2)<<manCut;
  } else{
    cout<<fixed<<setprecision(2)<<min;
  }

  return 0;
}