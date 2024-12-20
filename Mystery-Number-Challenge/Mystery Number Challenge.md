## Mystery Number Challenge

### Code
```cpp
#include <iostream>
#include <time.h>
using namespace std;

int main(){
    int guess, number, choice;
    while (choice){
        srand(time(0));
        number = rand() % 100 + 1;
        cout << "______________________________________________________________________" << endl;
        cout << "\nGuess the number between 1 to 100"<<endl;
        for (int i = 1; i != 0; i++){
            cin >> guess;
            if (guess == number){
                cout << "You guessed the correct number in " << i << " attempts";
                break;
            }else if (guess < number){
                cout << "Higher number please...\n";
            }else{
                cout << "Lower number please...\n";
            }
        }
        
        cout << "\n______________________________________________________________________" << endl;
        cout << "\nWant to play again (0/1): ";
        cin >> choice;
    }
}
```
