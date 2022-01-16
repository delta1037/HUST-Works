`timescale 1ns / 1ps
module MainClock(
	input CP50, //时钟信号
	input Ctrl24To12, //24小时到12小时进制转换
	input nCR,EN, //清零和使能信号
	input SwitchMHToS,DisplayA, //切换显示秒和显示小时和分钟的信号
	input AdjH,AdjM, //调节小时与分钟信号
	
	output LEDAlarm,LED0,LEDZ, //闹钟灯，下午灯，整点报时灯
	output [3:0] Choose, //输出选择信号
	output [6:0] HEX //输出信号
    );


wire [6:0] HEX0,HEX1,HEX2,HEX3;
wire CP1;
wire CP1000;
wire [7:0] Hour,Minutes,Second;
wire [7:0] AHour,AMinutes;
supply1 vdd;


//分配模块
Divider50MHz U0(.CLK_50M(CP50),
					 .nCLR(nCR),
					 .CLK_1HzOut(CP1));
defparam U0.N=25,
		 U0.CLK_Freq=50000000,//输入频率50MHz
		 U0.OUT_Freq=1;		 //输出频率1Hz
		 
////////////计时功能///////////
//秒
Counter10 S0(CP1,nCR,EN,Second[3:0]);
Counter6  S1((Second[3:0]==4'h0),nCR,EN,Second[7:4]);

//分钟
Counter10 M0(CP1,nCR,MinL_EN,Minutes[3:0]);
Counter6  M1(CP1,nCR,MinH_EN,Minutes[7:4]);
//分钟使能信号
assign MinL_EN=(AdjM&&(DisplayA==0))? 1:(Second==8'h59);
assign MinH_EN=(((AdjM&&(DisplayA==0))&&(Minutes[3:0]==4'h0))||((Minutes[3:0]==4'h0)&&(Second==8'h00)));

//小时
Counter24 H0(Hour[7:4],Hour[3:0],CP1,nCR,Hour_EN,Ctrl24To12);
//小时使能信号
assign Hour_EN=(AdjH&&!DisplayA)? vdd:((Minutes==8'h00)&&(Second==8'h00));




///////////////整点报时模块/////////////////////////
Zhengdian Z0((Second>=8'h00&&Second<Hour&&Minutes==8'h00),CP1,nCR,LEDZ);




///////////////闹钟模块////////////////////////////
//闹钟灯亮信号
Alarm Al(((AHour==Hour)&&(AMinutes==Minutes)),CP1,nCR,LEDAlarm);

//闹钟分钟
Counter10 AM0(CP1,nCR,AMinL_EN,AMinutes[3:0]);
Counter6  AM1(CP1,nCR,AMinH_EN,AMinutes[7:4]);
//闹钟分钟使能信号
assign AMinL_EN=(AdjM&&DisplayA)? vdd:0;
assign AMinH_EN=((AdjM&&DisplayA)&&(Minutes[3:0]==4'h9));
//闹钟小时信号
Counter24 AH0(AHour[7:4],AHour[3:0],CP1,nCR,AHour_EN,Ctrl24To12,LED0);
//闹钟小时使能信号
assign AHour_EN=(AdjH&&DisplayA)? vdd:(Minutes==8'h59);



//////////////////显示控制模块////////////////////////
DisplayControl D(Hour,Minutes,Second,AHour,AMinutes,SwitchMHToS,DisplayA,CP1,HEX0,HEX1,HEX2,HEX3);
//Hour,Minutes,Second,AHour,AMinutes,----显示选项
//SwitchMHToS,DisplayA,CP1-----------------显示条件
//HEX0,HEX1,HEX2,HEX3--------------------显示输出



//////////////////刷新控制模块/////////////////////////
Divider1000 Di0(.CLK_50M(CP50),
					 .nCLR(nCR),
					 .CLK_1HzOut(CP1000));
defparam Di0.N=25,
		 Di0.CLK_Freq=50000000,//输入频率50MHz
		 Di0.OUT_Freq=100;	//输出频率100Hz	 
//刷新控制
Refresh R0(CP1000,HEX,Choose,HEX0,HEX1,HEX2,HEX3,nCR);

endmodule
