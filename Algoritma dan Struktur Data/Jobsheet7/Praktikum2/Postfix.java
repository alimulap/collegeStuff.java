package Praktikum2;

public class Postfix {
    int n;
    int top;
    char[] stack;

    Postfix(int total) {
        this.n = total;
        this.stack = new char[total];
        this.top = -1;
        this.push('(');
    }

    public void push(char e) {
        this.stack[++this.top] = e;
    }

    public char pop() {
        return this.stack[this.top--];
    }

    public boolean isOperand(char e) {
        return (e >= 'A' && e <= 'Z') ? true :
               (e >= 'a' && e <= 'z') ? true :
               (e >= '0' && e <= '9') ? true :
               (e == ' ' || e == '.') ? true :
               /* else */               false;
    }

    public boolean isOperator(char e) {
        return e == '^' ? true :
               e == '%' ? true :
               e == '/' ? true :
               e == '*' ? true :
               e == '-' ? true :
               e == '+' ? true :
               /* else */ false;
    }

    public int derajat(char e) {
        return e == '^' ? 3 :
               e == '%' ? 2 :
               e == '/' ? 2 :
               e == '*' ? 2 :
               e == '-' ? 1 :
               e == '+' ? 1 :
               /* else */ 0 ;
    }

    public String konversi(String from) {
        String to = "";
        char c;
        for (int i = 0; i < n; ++i) {
            c = from.charAt(i);
            if (this.isOperand(c))
                to = to + c;
            if (c == '(')
                this.push(c);
            if (c == ')') {
                while (this.stack[this.top] != '(')
                    to = to + this.pop();
                this.pop();
            }
            if (this.isOperator(c)) {
                while (this.derajat(this.stack[this.top]) >= this.derajat(c))
                    to = to + this.pop();
                this.push(c);
            }
        }
        return to;
    }
}
