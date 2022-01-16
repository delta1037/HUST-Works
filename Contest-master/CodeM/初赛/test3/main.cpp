#include <iostream>
#include <iomanip>
using namespace std;
int main() {
  double nums[16][16];
  double score[16];
  double score1[16];
  double score2[16];
  double score3[16];
  double t;
  int i=0,j=0;
  for(i=0;i<16;i++){
    for(j=0;j<16;j++){
      cin>>nums[i][j];
    }
  }

  for(i=0;i<16;i=i+2){
    score[i]=nums[i][i+1];
    score[i+1]=nums[i+1][i];
  }

  score1[0]=score[0]*(score[2]*nums[0][2]+score[3]*nums[0][3]);
  score1[1]=score[1]*(score[2]*nums[1][2]+score[3]*nums[1][3]);
  score1[2]=score[2]*(score[0]*nums[2][0]+score[1]*nums[2][1]);
  score1[3]=score[3]*(score[0]*nums[3][0]+score[1]*nums[3][1]);

  score1[4]=score[4]*(score[6]*nums[4][6]+score[7]*nums[4][7]);
  score1[5]=score[5]*(score[6]*nums[5][6]+score[7]*nums[5][7]);
  score1[6]=score[6]*(score[4]*nums[6][4]+score[5]*nums[6][5]);
  score1[7]=score[7]*(score[4]*nums[7][4]+score[5]*nums[7][5]);

  score1[8]=score[8]*(score[10]*nums[8][10]+score[11]*nums[8][11]);
  score1[9]=score[9]*(score[10]*nums[9][10]+score[11]*nums[9][11]);
  score1[10]=score[10]*(score[8]*nums[10][8]+score[9]*nums[10][9]);
  score1[11]=score[11]*(score[8]*nums[11][8]+score[9]*nums[11][9]);

  score1[12]=score[12]*(score[14]*nums[12][14]+score[15]*nums[12][15]);
  score1[13]=score[13]*(score[14]*nums[13][14]+score[15]*nums[13][15]);
  score1[14]=score[14]*(score[12]*nums[14][12]+score[13]*nums[14][13]);
  score1[15]=score[15]*(score[12]*nums[15][12]+score[13]*nums[15][13]);

  for(j=0;j<4;j++){
    t=0;
    for(int k=4;k<8;k++){
      t=t+score1[k]*nums[j][k];
    }
    score2[j]=score1[j]*t;
  }
  for(j=4;j<8;j++){
    t=0;
    for(int k=0;k<4;k++){
      t=t+score1[k]*nums[j][k];
    }
    score2[j]=score1[j]*t;
  }

  for(j=8;j<12;j++){
    t=0;
    for(int k=12;k<16;k++){
      t=t+score1[k]*nums[j][k];
    }
    score2[j]=score1[j]*t;
  }
  for(j=12;j<16;j++){
    t=0;
    for(int k=8;k<12;k++){
      t=t+score1[k]*nums[j][k];
    }
    score2[j]=score1[j]*t;
  }

  for(j=0;j<8;j++){
    t=0;
    for(int k=8;k<16;k++){
      t=t+score2[k]*nums[j][k];
    }
    score3[j]=score2[j]*t;
  }

  for(j=8;j<16;j++){
    t=0;
    for(int k=0;k<8;k++){
      t=t+score2[k]*nums[j][k];
    }
    score3[j]=score2[j]*t;
  }

  for(i=0;i<16;i++){
    i==0? cout<<"":cout<<" ";
    cout<<fixed<<setprecision(10)<<score3[i];
  }
  return 0;

  // 0.0080193239 0.1871963989 0.0797523190 0.123 385 9685
  // 0.0836167329 0.0438390981 0.0079035829 0.0604644891
  // 0.0237087902 0.0050549016 0.1149551151 0.0679247259
  // 0.0511307364 0.0395744604 0.0800843771 0.0233889799
}