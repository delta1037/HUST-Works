`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   13:46:14 04/01/2018
// Design Name:   MainClock
// Module Name:   C:/Users/liubo/Desktop/Clock/test1.v
// Project Name:  Clock
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: MainClock
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module test1;

	// Inputs
	reg CP50;
	reg Ctrl24To12;
	reg nCR;
	reg EN;
	reg SwitchMHToS;
	reg DisplayA;
	reg AdjH;
	reg AdjM;

	// Outputs
	wire [6:0] HEX0;
	wire [6:0] HEX1;
	wire [6:0] HEX2;
	wire [6:0] HEX3;
	wire LEDAlarm;
	wire LED0;

	// Instantiate the Unit Under Test (UUT)
	MainClock uut (
		.CP50(CP50), 
		.Ctrl24To12(Ctrl24To12), 
		.nCR(nCR), 
		.EN(EN), 
		.SwitchMHToS(SwitchMHToS), 
		.DisplayA(DisplayA), 
		.AdjH(AdjH), 
		.AdjM(AdjM), 
		.HEX0(HEX0), 
		.HEX1(HEX1), 
		.HEX2(HEX2), 
		.HEX3(HEX3), 
		.LEDAlarm(LEDAlarm), 
		.LED0(LED0)
	);

	
      
endmodule

