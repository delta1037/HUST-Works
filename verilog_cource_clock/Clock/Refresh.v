`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    19:19:59 04/02/2018 
// Design Name: 
// Module Name:    Refresh 
// Project Name: 
// Target Devices: 
// Tool versions: 
// Description: 
//
// Dependencies: 
//
// Revision: 
// Revision 0.01 - File Created
// Additional Comments: 
//
//////////////////////////////////////////////////////////////////////////////////
module Refresh(
	CP50,HEX,Choose,HEX0,HEX1,HEX2,HEX3,nCR
    );
	 
	 input CP50,nCR;
	 input [6:0] HEX0,HEX1,HEX2,HEX3;
	 output reg [3:0] Choose;
	 output reg [6:0] HEX;
	 //reg A;
	 
	 reg [3:0] ChooseS=4'b1110;
	 
	 always@(CP50 or nCR)begin
	 if(~nCR) ChooseS=4'b1110;
		else begin
		
		case(ChooseS)
			4'b1110: begin ChooseS=4'b1101;Choose<=4'b1101;HEX<=HEX1;end
			4'b1101: begin ChooseS=4'b1011;Choose<=4'b1011;HEX<=HEX2;end
			4'b1011: begin ChooseS=4'b0111;Choose<=4'b0111;HEX<=HEX3;end
			4'b0111: begin ChooseS=4'b1110;Choose<=4'b1110;HEX<=HEX0;end
			//default: begin ChooseS<=4'b1110;Choose<=4'b1110;HEX=HEX0;end
		endcase
		
		end
	 end
endmodule
