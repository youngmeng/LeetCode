/**
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */

public class Solution {
    public int divide(int dividend, int divisor) {
        //dividend = Integer.MIN_VALUE时，-dividend会溢出，所以用long
        long a = dividend >= 0 ? (long) dividend : -(long) dividend;
        //-(long)dividend 不要写为 (long) -dividend,否则dividend = -2147483648时，会导致错误
        long b = divisor >= 0 ? (long) divisor : -(long) divisor;

        //当dividend = Integer.MIN_VALUE、divisor = -1时，结果会溢出，所以选择long
        long res = 0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; i++, c <<= 1) {
                a -= c;
                res += 1 << i;
            }
        }

        //题目要求：如果超过Integer范围，输出最大值：测试案列(-2147483648, -1)
        return ((dividend ^ divisor) >>> 31) == 0 ? (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res) : -(int) res;
    }
}
