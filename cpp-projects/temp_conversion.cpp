#include <iostream>

int main(){
    double temp;
    char unit;

    std::cout << "-----Temperature Conversion-----\n" << "F = Fahrenheit\n" << "C = Celsius\n" << "-------------------------------- \n";
    std::cout << "Unit to convert to: \n";
    std::cin >> unit;
    if (unit == 'F' || unit == 'f'){
        std::cout << "Enter the temperature in Celsius: \n";
        std::cin >> temp;
        temp = (1.8 * temp) + 32.0;
        std::cout << "Temperature: " << temp << "F\n";
    }
    else if (unit == 'C' || unit == 'c'){
        std::cout << "Enter the temperature in Fahrenheit: \n";
        std::cin >> temp;
        temp = (temp - 32) / 1.8;
        std::cout << "Temperature: " << temp << "C\n";
    }
    return 0;
}