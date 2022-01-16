`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
module Alarm(
    EN,CP1,nCR,LEDAlarm
    );
	 input CP1,nCR,EN;
    output reg LEDAlarm;
always@(CP1)begin
    //Alarm one Minute
	 if(~nCR)begin
		LEDAlarm=0;
	 end else if(EN==1)begin
		LEDAlarm=~LEDAlarm;
	 end
end
endmodule
