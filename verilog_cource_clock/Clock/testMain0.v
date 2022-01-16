`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   20:01:32 04/02/2018
// Design Name:   MainClock
// Module Name:   F:/Clock/testMain0.v
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

module testMain0;

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
	wire LEDAlarm;
	wire LED0;
	wire LEDZ;
	wire [3:0] Choose;
	wire [6:0] HEX;

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
		.LEDAlarm(LEDAlarm), 
		.LED0(LED0), 
		.LEDZ(LEDZ), 
		.Choose(Choose), 
		.HEX(HEX)
	);

	initial begin
		// Initialize Inputs
		CP50 = 0;
		Ctrl24To12 = 0;
		nCR = 0;
		EN = 1;
		SwitchMHToS = 1;
		DisplayA = 0;
		AdjH = 0;
		AdjM = 0;
		
		#10;
		CP50=1;
		nCR=1;
		
		forever #10 CP50=~CP50;

	end
      
endmodule

