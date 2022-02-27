#include <string>
#include <iostream>

void find_list_max(const int array[], int array_size, int &max){
    max = INT32_MIN;
    int sum = 0;
    for(int idx = 0; idx < array_size; ++idx){
        if(sum < 0){
            // 舍弃前面的值
            sum = 0;
        }

        sum += array[idx];
        if(sum > max){
            // 获取到当前的最大值
            max = sum;
        }
    }
}

int main(){
    int array[] = {-2, -1, -3, 4, -1, 2, 1, -5, 4};
    int max = 0;
    find_list_max(array, sizeof(array)/sizeof(int), max);
    std::cout << "max num is : " << max << std::endl;
}
