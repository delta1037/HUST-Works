`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    18:59:12 03/19/2018 
// Design Name: 
// Module Name:    Counter10 
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
module Counter10(
	input CP,
	input nCR,
	input EN,
	output reg [3:0] Q
    );
	
	always@(posedge CP or negedge nCR)begin
		if(~nCR) Q<=4'b0000;
		else if(~EN) Q<=Q;
		else if(Q==4'b1001) Q<=4'b0000;
		else Q<=Q+1'b1;
	end
endmodule
