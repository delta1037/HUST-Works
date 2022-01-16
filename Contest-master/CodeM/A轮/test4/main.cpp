#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;
int test4(){
  double r,x1,y1,x2,y2;
  cin>>r;
  cin>>x1>>y1;
  cin>>x2>>y2;
  double dis1=sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
  double r1=sqrt(x1*x1+y1*y1);
  double r2=sqrt(x2*x2+y2*y2);
  double nx1,nx2,ny1,ny2;

  nx1=-r1*x1/r;
  ny1=-r1*y1/r;

  nx2=-r2*x2/r;
  ny2=-r2*y2/r;

  double dis2=r-r1+sqrt((x1-nx2)*(x1-nx2)+(y1-ny2)*(y1-ny2));
  double dis3=r-r2+sqrt((nx1-x2)*(nx1-x2)+(ny1-y2)*(ny1-y2));

  if(dis1>dis2){
    if(dis2<dis3){
      cout<<fixed<<setprecision(12)<<dis2;
    }else{
      cout<<fixed<<setprecision(12)<<dis3;
    }
  }else{
    if(dis1>dis3){
      cout<<fixed<<setprecision(12)<<dis3;
    }else{
      cout<<fixed<<setprecision(12)<<dis1;
    }
  }
  return 0;
}
int main() {
  double r,x1,y1,x2,y2;
  cin>>r;
  cin>>x1>>y1;
  cin>>x2>>y2;
  double dis1=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
  double min=dis1;
  double dis=dis1;
  double i=0;
  double i1;
  while(i<3.2){
    dis=x1*x1+x2*x2+y1*y1+y2*y2+2*r*r+2*r*cos(i)*(x2-x1)+2*r*sin(i)*(y2-y1);
    if(dis<min){
      min=dis;
      i1=i;
    }
    i+=0.1;
  }
  i=i1-0.1;
  while(i<i1+0.1){
    dis=x1*x1+x2*x2+y1*y1+y2*y2+2*r*r+2*r*cos(i)*(x2-x1)+2*r*sin(i)*(y2-y1);
    if(dis<min){
      min=dis;
      i1=i;
    }
    i+=0.01;
  }
  i=i1-0.01;
  while(i<i1+0.01){
    dis=x1*x1+x2*x2+y1*y1+y2*y2+2*r*r+2*r*cos(i)*(x2-x1)+2*r*sin(i)*(y2-y1);
    if(dis<min){
      min=dis;
      i1=i;
    }
    i+=0.00000001;
  }
  cout<<fixed<<setprecision(12)<<min;
}