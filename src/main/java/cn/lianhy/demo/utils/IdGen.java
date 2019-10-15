package cn.lianhy.demo.utils;

import org.springframework.util.IdGenerator;

import java.util.Random;
import java.util.UUID;

public class IdGen implements IdGenerator {

    //根据长度获取随机字母加数字
    public static String getCharAndNumr(int length) {
        if (length >= 3) {
            String val = "";
            Random random = new Random();
            // t0、t1、t2用来标识大小写和数字是否在产生的随机数中出现
            int t0 = 0;
            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < length; i++) {
                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
                // 产生的是字母
                if ("char".equalsIgnoreCase(charOrNum)) // 字符串
                {
                    // int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    // //取得大写字母还是小写字母
                    int choice = 0;
                    if (random.nextInt(2) % 2 == 0) {
                        choice = 65;
                        t0 = 1;
                    } else {
                        choice = 97;
                        t1 = 1;
                    }
                    val += (char) (choice + random.nextInt(26));
                }
                // 产生的是数字
                else if ("num".equalsIgnoreCase(charOrNum)) // 数字
                {
                    val += String.valueOf(random.nextInt(10));
                    t2 = 1;
                }
            }
            // 用于判断是是否包括大写字母、小写字母、数字
            if (t0 == 0 || t1 == 0 || t2 == 0) {
                val = getCharAndNumr(length); // 不满足则递归调用该方法
                return val;
            }

            else
                return val;

        } else {

            return null;
        }
    }

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.print(getCharAndNumr(4));
    }

    @Override
    public UUID generateId() {
        return null;
    }
}
