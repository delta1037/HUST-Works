`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   15:11:00 04/01/2018
// Design Name:   Counter6
// Module Name:   C:/Users/liubo/Desktop/Clock/testCounter6.v
// Project Name:  Clock
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: Counter6
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module testCounter6;

	// Inputs
	reg CP;
	reg nCR;
	reg EN;

	// Outputs
	wire [3:0] Q;

	// Instantiate the Unit Under Test (UUT)
	Counter6 uut (
		.CP(CP), 
		.nCR(nCR), 
		.EN(EN), 
		.Q(Q)
	);
	
	initial begin
		// Initialize Inputs
		CP = 0;
		nCR = 0;
		EN = 1;
		#100;
		nCR=1;
		forever #10 CP=~CP;
	end
endmodule

