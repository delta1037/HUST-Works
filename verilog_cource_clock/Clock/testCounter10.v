`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   15:16:52 04/01/2018
// Design Name:   Counter10
// Module Name:   C:/Users/liubo/Desktop/Clock/testCounter10.v
// Project Name:  Clock
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: Counter10
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module testCounter10;

	// Inputs
	reg CP;
	reg nCR;
	reg EN;

	// Outputs
	wire [3:0] Q;

	// Instantiate the Unit Under Test (UUT)
	Counter10 uut (
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
		#10;
		nCR = 1;
      forever #10 CP=~CP;
	end
      
endmodule

