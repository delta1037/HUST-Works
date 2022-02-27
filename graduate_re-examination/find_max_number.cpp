#include <iostream>
#include <string>

bool find_max_number(const std::string &s, double &max_number){
    max_number = INT64_MIN;
    bool find_val = false;
    for(int idx = 0; idx < s.size(); ++idx){
        // 判断是否是负数
        bool negative = false;
        if(s[idx] == '-' || (s[idx] >= '0' && s[idx] <= '9')){
            if(s[idx] == '-'){
                // 记录负数标志
                negative = true;
                idx++;
            }
            if(idx >= s.size() || !(s[idx] >= '0' && s[idx] <= '9')){
                // 处理完负号就没了，或者负数后面不是数字
                continue;
            }

            // 如果包含小数需要包含的内容
            bool is_double = false;
            int double_bits = 1;
            int val_double = 0;
            // 整数部分记录
            int val_int = 0;
            while(s[idx] == '.' || (s[idx] >= '0' && s[idx] <= '9')){
                if(is_double && s[idx] == '.'){
                    // 连续的小数点则需要中断处理
                    break;
                }
                if(s[idx] == '.'){
                    // 如果包含了小数点就切换状态
                    idx++;
                    is_double = true;
                    continue;
                }

                if(is_double){
                    // 处理小数部分
                    double_bits = double_bits * 10;
                    val_double = val_double * 10 + s[idx] - '0';
                }else{
                    // 处理整数部分
                    val_int = val_int * 10 + s[idx] - '0';
                }
                idx++;
            }

            // 获取最大值
            double t_val = double(val_int) + double(val_double)/double_bits;
            if(negative){
                t_val = -t_val;
            }
            std::cout << "find number:" << t_val << std::endl;
            max_number = max_number > t_val? max_number:t_val;
            find_val = true;
        }
    }
    return find_val;
}

int main() {
    std::cout << "input a string:";
    std::string s = "a123b345.6x8761y76t";
    //std::cin >> s;
    double max_number;
    bool ret = find_max_number(s, max_number);
    if(ret){
        std::cout << "max number is : " << max_number << std::endl;
    }else{
        std::cout << "no number in str" << std::endl;
    }
    return 0;
}
