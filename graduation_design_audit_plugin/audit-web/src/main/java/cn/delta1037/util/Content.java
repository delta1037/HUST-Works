package cn.delta1037.util;

public class Content {
    public static String getDefaultContent(){
        return "NULL";
    }

    public static String Parser(String format, String[] args){
        StringBuilder ret = new StringBuilder();

        int argsSize = args.length;
        int argIndex = 0;
        for(int i = 0; i < format.length(); ++i){
            if(i + 2 < format.length() &&
                    format.charAt(i) == '%'
                    && format.charAt(i+1) == '{'
                    && format.charAt(i+2) == '}'){
                ret.append(GetIndexArgs(args, argIndex));
                ++argIndex;
                i += 2;
            } else {
                ret.append(format.charAt(i));
            }
        }
        return ret.toString();
    }

    private static String GetIndexArgs(String[] args, int index){
        if(index < args.length){
            return args[index];
        }else{
            return "";
        }
    }
}
