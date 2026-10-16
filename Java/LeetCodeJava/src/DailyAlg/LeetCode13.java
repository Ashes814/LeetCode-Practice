package DailyAlg;

public class LeetCode13 {
    public static void main(String[] args) {
        System.out.println("Hello Java!");
        System.out.println(new LeetCode13().romanToInt("LVIII"));
    }

    int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    sum += 100;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;  
            }
            if (i > 0) {
                char pre = s.charAt(i - 1);
                if ((c == 'V' || c == 'X') && pre == 'I') {
                    sum -= 2;
                } else if ((c == 'L' || c == 'C') && pre == 'X') {
                    sum -= 20;
                } else if ((c == 'D' || c == 'M') && pre == 'C') {
                    sum -= 200;
                }
            }
        }
        return sum;

        
    }
}