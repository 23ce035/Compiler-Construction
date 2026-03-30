#include <iostream>
#include <stack>
#include <vector>
#include <sstream>
#include <cctype>
using namespace std;

struct Quad {
    string op, arg1, arg2, result;
};

int precedence(char op) {
    if (op == '+' || op == '-') return 1;
    if (op == '*' || op == '/') return 2;
    return 0;
}

// Convert infix to postfix
vector<string> infixToPostfix(string expr) {
    stack<char> st;
    vector<string> output;

    for (int i = 0; i < expr.length(); i++) {
        if (expr[i] == ' ') continue;

        // Operand (number)
        if (isdigit(expr[i])) {
            string num;
            while (i < expr.length() && (isdigit(expr[i]) || expr[i] == '.')) {
                num += expr[i];
                i++;
            }
            i--;
            output.push_back(num);
        }
        // Opening bracket
        else if (expr[i] == '(') {
            st.push(expr[i]);
        }
        // Closing bracket
        else if (expr[i] == ')') {
            while (!st.empty() && st.top() != '(') {
                output.push_back(string(1, st.top()));
                st.pop();
            }
            st.pop(); // remove '('
        }
        // Operator
        else {
            while (!st.empty() && precedence(st.top()) >= precedence(expr[i])) {
                output.push_back(string(1, st.top()));
                st.pop();
            }
            st.push(expr[i]);
        }
    }

    while (!st.empty()) {
        output.push_back(string(1, st.top()));
        st.pop();
    }

    return output;
}

// Generate quadruples
vector<Quad> generateQuadruples(vector<string> postfix) {
    stack<string> st;
    vector<Quad> quads;
    int tempCount = 1;

    for (string token : postfix) {
        // If operator
        if (token == "+" || token == "-" || token == "*" || token == "/") {
            string op2 = st.top(); st.pop();
            string op1 = st.top(); st.pop();

            string temp = "t" + to_string(tempCount++);

            quads.push_back({token, op1, op2, temp});
            st.push(temp);
        } else {
            st.push(token);
        }
    }

    return quads;
}

int main() {
    string expr;
    cout << "Enter expression: ";
    getline(cin, expr);

    vector<string> postfix = infixToPostfix(expr);
    vector<Quad> quads = generateQuadruples(postfix);

    cout << "\nQuadruple Table:\n";
    cout << "Operator\tOperand1\tOperand2\tResult\n";

    for (auto q : quads) {
        cout << q.op << "\t\t" << q.arg1 << "\t\t" << q.arg2 << "\t\t" << q.result << endl;
    }

    return 0;
}