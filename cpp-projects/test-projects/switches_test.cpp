#include <iostream>
#include <cmath>
#include <chrono>
#include <ctime>
int main(){
    int month;
    std::string month_str;
    srand(time(NULL));
    month = rand() % 12 + 1;
    switch(month){
        case 1:
            month_str = "January";
            break;
        case 2:
            month_str = "February";
            break;
        case 3:
            month_str = "March";
            break;
        case 4:
            month_str = "April";
            break;
        case 5:
            month_str = "May";
            break;
        case 6:
            month_str = "June";
            break;
        case 7:
            month_str = "July";
            break;
        case 8:
            month_str = "August";
            break;
        case 9:
            month_str = "September";
            break;
        case 10:
            month_str = "October";
            break;
        case 11:
            month_str = "November";
            break;
        case 12:
            month_str = "December";
            break;
        default:
            month_str = "";
            break;
    }
    
    std::cout << "It is " << month_str;
    return 0;
}