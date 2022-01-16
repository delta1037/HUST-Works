`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer: 
// 
// Create Date:    19:02:55 04/02/2018 
// Design Name: 
// Module Name:    Zhengdian 
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
module Zhengdian(
	input EN,CP1,nCR,
	output reg LEDZ
    );
	 
	 always@(CP1 or nCR)begin
		if(~nCR) LEDZ=0;
		else if (~EN) LEDZ=LEDZ;
		else LEDZ=~LEDZ;
	end

endmodule
