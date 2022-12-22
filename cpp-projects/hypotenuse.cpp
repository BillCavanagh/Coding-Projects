#include <iostream>
#include <cmath>

int main(){
    // declare variables
    double a;
    double b;
    double c;
    // get user input
    std::cout << "side a: ";
    std::cin  >> a;
    std::cout << "side b: ";
    std::cin >> b;
    // calculation
    c = sqrt(pow(a,2) + pow(b,2));
    // output
    std::cout << "side c: " << c;
    return 0;
}