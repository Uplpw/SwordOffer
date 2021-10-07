package com.java.offer.chapter3.twenty;

/**
 * @Author lpw
 * @Date 2021/9/27 16:01
 * @Description 剑指offer：判断一个字符串是否表示数值
 */
public class NumberStrings {
    // 解法1：分情况讨论
    public static boolean isNumber(String s) {
        // 无效数据
        if (s == null || s.length() == 0) {
            return false;
        }
        // 标记是否遇到数位、小数点、‘e’或'E'
        boolean isNum = false, isDot = false, ise_or_E = false;

        // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        s = s.trim();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 判断当前字符是否为 0~9 的数位
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                isNum = true;
            } else if (s.charAt(i) == '.') {
                // 遇到小数点
                if (isDot || ise_or_E) {
                    // 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                    return false;
                }
                // 标记已经遇到小数点
                isDot = true;
            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                // 遇到‘e’或'E'
                if (!isNum || ise_or_E) {
                    // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                    return false;
                }
                // 标记已经遇到‘e’或'E'
                ise_or_E = true;
                // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
                isNum = false;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                // 其它情况均为不合法字符
                return false;
            }
        }
        return isNum;
    }

    // 解法2：剑指offer
    static int index;

    public boolean isNumberByOffer(String s) {
        // 无效数据
        if (s == null || s.length() == 0) {
            return false;
        }
        index = 0;
        //字符串开始有空格，可以返回true
        while (index < s.length() && s.charAt(index) == ' ')
            ++index;
        boolean numeric = scanInteger(s);
        // 如果出现'.'，接下来是数字的小数部分
        if (index < s.length() && s.charAt(index) == '.') {
            ++index;
            // 下面一行代码用||的原因：
            // 1. 小数可以没有整数部分，例如.123等于0.123；
            // 2. 小数点后面可以没有数字，例如233.等于233.0；
            // 3. 当然小数点前面和后面可以有数字，例如233.666
            numeric = scanUnsignedInteger(s) || numeric;
        }
        // 如果出现'e'或者'E'，接下来跟着的是数字的指数部分
        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            ++index;
            // 下面一行代码用&&的原因：
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            numeric = numeric && scanInteger(s);
        }
        //字符串结尾有空格，可以返回true
        while (index < s.length() && s.charAt(index) == ' ')
            ++index;
        // 最后看是否所有部分都符合，如1a3只会检测第一部分是整数然后是a就不会继续检测了，index!=size，所以返回false
        return numeric && index == s.length();
    }

    public static boolean scanInteger(String s) {
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-'))
            ++index;
        return scanUnsignedInteger(s);
    }

    public static boolean scanUnsignedInteger(String s) {
        int before = index;
        while (index < s.length() && index != s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9')
            index++;
        return index > before;
    }


    public static void main(String[] args) {
        System.out.println(isNumber("+100"));
        System.out.println(isNumber("5e2"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("3.1416"));
        System.out.println(isNumber("-1E-16"));
        System.out.println(isNumber("+.6"));
        System.out.println(isNumber("6."));
        System.out.println(isNumber("12e"));
        System.out.println(isNumber("1a3.14"));
        System.out.println(isNumber("1.2.3"));
        System.out.println(isNumber("+-5"));
        System.out.println(isNumber("12e+5.4"));
        System.out.println(isNumber(".+12e+5.4"));
        System.out.println(isNumber("1.+12"));
        System.out.println(isNumber(" "));
        System.out.println(isNumber(". 1"));
        System.out.println(isNumber("4e+"));
        System.out.println(isNumber("1.."));
        System.out.println(isNumber("46.e3"));
    }
}
