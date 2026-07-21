class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] feq = new int[2];
        boolean check = true;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                feq[0]++;
            else if (bills[i] == 10) {
                if (feq[0] > 0)
                    feq[0]--;
                else {
                    check = false;
                    break;
                }
                feq[1]++;
            } else {
                int temp = bills[i] - 5;
                while (temp != 0) {
                    if (temp >= 10 && feq[1] > 0) {
                        temp -= 10;
                        feq[1]--;
                    } else if (temp >= 5 && feq[0] > 0) {
                        temp -= 5;
                        feq[0]--;
                    } else {
                        check = false;
                        break;
                    }
                }
            }
        }
        return check ? true : false;
    }
}