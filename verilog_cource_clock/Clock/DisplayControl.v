`timescale 1ns / 1ps
//////////////////////////////////////////////////////////////////////////////////
module DisplayControl(
    Hour,Minutes,Second,AHour,AMinutes,
    SwitchMHToS,DisplayA,CP1,HEX0,HEX1,HEX2,HEX3
    );
	 
input [7:0] Hour,Minutes,Second,AHour,AMinutes;
input CP1,SwitchMHToS,DisplayA;
output reg [6:0] HEX0,HEX1,HEX2,HEX3;


//待选择�
//reg iDIG,oSEG;

always@(CP1 or SwitchMHToS or DisplayA)begin
    if (DisplayA==1)begin //Display alarm
        //iDIG=AHour[7:4];
        case(AHour[7:4])    //gfedcba
			4'h1:HEX3=7'b1111001;//1
			4'h2:HEX3=7'b0100100;//2
			4'h3:HEX3=7'b0110000;//3
			4'h4:HEX3=7'b0011001;//4
			
			4'h5:HEX3=7'b0010010;//5
			4'h6:HEX3=7'b0000010;//6
			4'h7:HEX3=7'b1111000;//7
			4'h8:HEX3=7'b0000000;//8
			
			4'h9:HEX3=7'b0011000;//9
			4'h0:HEX3=7'b1000000;//0
			4'hf:HEX3=7'b1111111;//a
		endcase
        //HEX3=oSEG;

        //iDIG=AHour[3:0];
        case(AHour[3:0])    //gfedcba
			4'h1:HEX2=7'b1111001;//1
			4'h2:HEX2=7'b0100100;//2
			4'h3:HEX2=7'b0110000;//3
			4'h4:HEX2=7'b0011001;//4
			
			4'h5:HEX2=7'b0010010;//5
			4'h6:HEX2=7'b0000010;//6
			4'h7:HEX2=7'b1111000;//7
			4'h8:HEX2=7'b0000000;//8
			
			4'h9:HEX2=7'b0011000;//9
			4'h0:HEX2=7'b1000000;//0
			4'hf:HEX2=7'b1111111;//a
		endcase
        //HEX2=oSEG;

        //iDIG=AMinutes[7:4];
        case(AMinutes[7:4])    //gfedcba
			4'h1:HEX1=7'b1111001;//1
			4'h2:HEX1=7'b0100100;//2
			4'h3:HEX1=7'b0110000;//3
			4'h4:HEX1=7'b0011001;//4
			
			4'h5:HEX1=7'b0010010;//5
			4'h6:HEX1=7'b0000010;//6
			4'h7:HEX1=7'b1111000;//7
			4'h8:HEX1=7'b0000000;//8
			
			4'h9:HEX1=7'b0011000;//9
			4'h0:HEX1=7'b1000000;//0
			4'hf:HEX1=7'b1111111;//a
		endcase
        //HEX1=oSEG;

        //iDIG=AMinutes[3:0];
        case(AMinutes[3:0])    //gfedcba
			4'h1:HEX0=7'b1111001;//1
			4'h2:HEX0=7'b0100100;//2
			4'h3:HEX0=7'b0110000;//3
			4'h4:HEX0=7'b0011001;//4
			
			4'h5:HEX0=7'b0010010;//5
			4'h6:HEX0=7'b0000010;//6
			4'h7:HEX0=7'b1111000;//7
			4'h8:HEX0=7'b0000000;//8
			
			4'h9:HEX0=7'b0011000;//9
			4'h0:HEX0=7'b1000000;//0
			4'hf:HEX0=7'b1111111;//a
		endcase
        //HEX0=oSEG;

    end else if(SwitchMHToS==1)begin  //display second
		  case(Minutes[7:4])    //gfedcba
			4'h1:HEX3=7'b1111001;//1
			4'h2:HEX3=7'b0100100;//2
			4'h3:HEX3=7'b0110000;//3
			4'h4:HEX3=7'b0011001;//4
			
			4'h5:HEX3=7'b0010010;//5
			4'h6:HEX3=7'b0000010;//6
			4'h7:HEX3=7'b1111000;//7
			4'h8:HEX3=7'b0000000;//8
			
			4'h9:HEX3=7'b0011000;//9
			4'h0:HEX3=7'b1000000;//0
			4'hf:HEX3=7'b1111111;//a
		  endcase
		  case(Minutes[3:0])    //gfedcba
			4'h1:HEX2=7'b1111001;//1
			4'h2:HEX2=7'b0100100;//2
			4'h3:HEX2=7'b0110000;//3
			4'h4:HEX2=7'b0011001;//4
			
			4'h5:HEX2=7'b0010010;//5
			4'h6:HEX2=7'b0000010;//6
			4'h7:HEX2=7'b1111000;//7
			4'h8:HEX2=7'b0000000;//8
			
			4'h9:HEX2=7'b0011000;//9
			4'h0:HEX2=7'b1000000;//0
			4'hf:HEX2=7'b1111111;//a
		endcase
        //iDIG=Second[7:4];
        case(Second[7:4])    //gfedcba
			4'h1:HEX1=7'b1111001;//1
			4'h2:HEX1=7'b0100100;//2
			4'h3:HEX1=7'b0110000;//3
			4'h4:HEX1=7'b0011001;//4
			
			4'h5:HEX1=7'b0010010;//5
			4'h6:HEX1=7'b0000010;//6
			4'h7:HEX1=7'b1111000;//7
			4'h8:HEX1=7'b0000000;//8
			
			4'h9:HEX1=7'b0011000;//9
			4'h0:HEX1=7'b1000000;//0
			4'hf:HEX1=7'b1111111;//a
		endcase
        //HEX1<=oSEG;

        //iDIG=Second[3:0];
        case(Second[3:0])    //gfedcba
			4'h1:HEX0=7'b1111001;//1
			4'h2:HEX0=7'b0100100;//2
			4'h3:HEX0=7'b0110000;//3
			4'h4:HEX0=7'b0011001;//4
			
			4'h5:HEX0=7'b0010010;//5
			4'h6:HEX0=7'b0000010;//6
			4'h7:HEX0=7'b1111000;//7
			4'h8:HEX0=7'b0000000;//8
			
			4'h9:HEX0=7'b0011000;//9
			4'h0:HEX0=7'b1000000;//0
			4'hf:HEX0=7'b1111111;//a
		endcase
        //HEX0<=oSEG;

        //HEX2=7'b1111111;
        //HEX3=7'b1111111;

    end else begin //Display hour and minutes
        //iDIG<=Hour[7:4];
        case(Hour[7:4])    //gfedcba
			4'h1:HEX3=7'b1111001;//1
			4'h2:HEX3=7'b0100100;//2
			4'h3:HEX3=7'b0110000;//3
			4'h4:HEX3=7'b0011001;//4
			
			4'h5:HEX3=7'b0010010;//5
			4'h6:HEX3=7'b0000010;//6
			4'h7:HEX3=7'b1111000;//7
			4'h8:HEX3=7'b0000000;//8
			
			4'h9:HEX3=7'b0011000;//9
			4'h0:HEX3=7'b1000000;//0
			4'hf:HEX3=7'b1111111;//a
		endcase
        //HEX3<=oSEG;

        //iDIG<=Hour[3:0];
        case(Hour[3:0])    //gfedcba
			4'h1:HEX2=7'b1111001;//1
			4'h2:HEX2=7'b0100100;//2
			4'h3:HEX2=7'b0110000;//3
			4'h4:HEX2=7'b0011001;//4
			
			4'h5:HEX2=7'b0010010;//5
			4'h6:HEX2=7'b0000010;//6
			4'h7:HEX2=7'b1111000;//7
			4'h8:HEX2=7'b0000000;//8
			
			4'h9:HEX2=7'b0011000;//9
			4'h0:HEX2=7'b1000000;//0
			4'hf:HEX2=7'b1111111;//a
		endcase
        //HEX2<=oSEG;

        //iDIG<=Minutes[7:4];
        case(Minutes[7:4])    //gfedcba
			4'h1:HEX1=7'b1111001;//1
			4'h2:HEX1=7'b0100100;//2
			4'h3:HEX1=7'b0110000;//3
			4'h4:HEX1=7'b0011001;//4
			
			4'h5:HEX1=7'b0010010;//5
			4'h6:HEX1=7'b0000010;//6
			4'h7:HEX1=7'b1111000;//7
			4'h8:HEX1=7'b0000000;//8
			
			4'h9:HEX1=7'b0011000;//9
			4'h0:HEX1=7'b1000000;//0
			4'hf:HEX1=7'b1111111;//a
		endcase
        //HEX1<=oSEG;

        //iDIG<=Minutes[3:0];
        case(Minutes[3:0])    //gfedcba
			4'h1:HEX0=7'b1111001;//1
			4'h2:HEX0=7'b0100100;//2
			4'h3:HEX0=7'b0110000;//3
			4'h4:HEX0=7'b0011001;//4
			
			4'h5:HEX0=7'b0010010;//5
			4'h6:HEX0=7'b0000010;//6
			4'h7:HEX0=7'b1111000;//7
			4'h8:HEX0=7'b0000000;//8
			
			4'h9:HEX0=7'b0011000;//9
			4'h0:HEX0=7'b1000000;//0
			4'hf:HEX0=7'b1111111;//a
		endcase
        //HEX0<=oSEG;
    end
	 end

endmodule