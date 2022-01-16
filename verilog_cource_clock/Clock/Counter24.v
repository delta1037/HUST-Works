`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
module Counter24(
   output reg [3:0] CntH,CntL,
	input CP,nCR,EN,ctrl,
	output reg LED0
    );
	
	always@(posedge CP or negedge nCR)begin
		if(~nCR) begin {CntH,CntL}<=8'h00;LED0=0;end
		else if(~EN) {CntH,CntL}<={CntH,CntL};
		else if((CntH>2)||(CntL>9)||((CntH==2)&&(CntL>=3)))begin //出错处理
			{CntH,CntL}<=8'h00;
		end
		else if((CntH==2)&&(CntL<3))begin //20-23
			CntH<=CntH;
			CntL<=CntL+1'b1;
			if((ctrl==1)&&(CntL>1))begin
				LED0=1;
				CntH<=4'b0001;
				CntL<=CntL-2'b10;
			end else if((ctrl==1)&&CntL<2)begin
				LED0=1;
				CntH<=4'b0000;
				CntL<=CntL+4'b1000;
			end
		end
		else if(CntL==9)begin //进位
			CntH<=CntH+1'b1;
			CntL<=4'b0000;
			if((ctrl==1)&&CntH==1&&CntL>1)begin
				LED0=1;
				CntH<=4'b0000;
				CntL<=CntL-2'b10;
			end
		end
		else begin  //一般的计数
			CntH<=CntH;
			CntL<=CntL+1'b1;
			if((ctrl==1)&&CntH==1&&CntL>1)begin
				LED0=1;
				CntH<=4'b0000;
				CntL<=CntL-2'b10;
			end
		end
	end
endmodule
