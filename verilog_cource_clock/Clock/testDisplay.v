`timescale 1ns / 1ps

////////////////////////////////////////////////////////////////////////////////
// Company: 
// Engineer:
//
// Create Date:   14:30:40 04/01/2018
// Design Name:   DisplayControl
// Module Name:   C:/Users/liubo/Desktop/Clock/testDisplay.v
// Project Name:  Clock
// Target Device:  
// Tool versions:  
// Description: 
//
// Verilog Test Fixture created by ISE for module: DisplayControl
//
// Dependencies:
// 
// Revision:
// Revision 0.01 - File Created
// Additional Comments:
// 
////////////////////////////////////////////////////////////////////////////////

module testDisplay;

	// Inputs
	reg [7:0] Hour;
	reg [7:0] Minutes;
	reg [7:0] Second;
	reg [7:0] AHour;
	reg [7:0] AMinutes;
	reg SwitchMHToS;
	reg DisplayA;
	reg CP1;

	// Outputs
	wire [6:0] HEX0;
	wire [6:0] HEX1;
	wire [6:0] HEX2;
	wire [6:0] HEX3;

	// Instantiate the Unit Under Test (UUT)
	DisplayControl uut (
		.Hour(Hour), 
		.Minutes(Minutes), 
		.Second(Second), 
		.AHour(AHour), 
		.AMinutes(AMinutes), 
		.SwitchMHToS(SwitchMHToS), 
		.DisplayA(DisplayA), 
		.CP1(CP1), 
		.HEX0(HEX0), 
		.HEX1(HEX1), 
		.HEX2(HEX2), 
		.HEX3(HEX3)
	);

	initial begin
		// Initialize Inputs
		Hour = 8'b10010001;
		Minutes = 8'b01010001;
		Second = 8'b10010001;
		AHour = 8'b00110001;
		AMinutes = 8'b01010001;
		SwitchMHToS = 0;
		DisplayA = 0;
		CP1=0;
		#10;
		forever #10 CP1=~CP1;
		
	end
      
endmodule

