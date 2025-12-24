#include <stdio.h>
#include <stdbool.h>

int main() {
    printf("Enter a String : \n");

    char input[50];
    scanf("%s", input);

    bool valid = false;

    for (int i = 0; input[i] != '\0'; i++) {
        if (input[i] == 'b' && input[i + 1] == 'b') {
            if(input[i + 2] == 'a' || input[i + 2] != '\0') {
                valid = false;
            } else {
                valid = true;
            }
            break;
        }
    }

    if (valid) {
        printf("Valid string\n");
    } else {
        printf("Invalid string\n");
    }

    return 0;
}
