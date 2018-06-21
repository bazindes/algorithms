#include <iostream>
#include <cstdlib>

using namespace std;

unsigned int PRNG(){
    static unsigned int seed = 5323;
    seed = 8253729 * seed + 2396403;
    return seed % 32768;
}

int main(void){
    srand(5323);
    for(int i=0; i<=100; ++i){
        cout << rand() << "\t";
        if(i%5 == 0) cout << "\n";
    }
    return 0;
}