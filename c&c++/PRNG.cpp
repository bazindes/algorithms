#include <iostream>

using namespace std;

unsigned int PRNG(){
    static unsigned int seed = 5323;
    seed = 8253729 * seed + 2396403;
    return seed % 32768;
}

int main(void){
    for(int i=0; i<=100; ++i){
        cout << PRNG() << "\t";
        if(i%5 == 0) cout << "\n";
    }
    return 0;
}