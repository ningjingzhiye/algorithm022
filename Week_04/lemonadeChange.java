public class Solution {

    /**
     *  使用five和ten来分别记录手头收到的5美元和10美元钞票的张数
     *  如果收到的是5元，则++five；如果收到的是10元，消耗一张5元，判断--five是否大于0；
     *  如果是20元，使用贪心算法，先判断手里是否有10元，有的话消耗一张10元和一张5元，不够的话就消耗3张5元
     */
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length < 1) {
            return true;
        }
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                ++five;
            } else if (bills[i] == 10) {
                if (--five < 0) {
                    return false;
                }
                ++ten;
            } else {
                if (ten > 0) {
                    if (--ten < 0 || --five < 0) {
                        return false;
                    }
                } else {
                    five -= 3;
                    if (five < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
