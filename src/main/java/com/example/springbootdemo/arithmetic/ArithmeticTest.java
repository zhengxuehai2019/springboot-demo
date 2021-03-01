package com.example.springbootdemo.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticTest {
    /**
     * 两数之和
     * 利用map存储数据的值以及下标，然后利用目标和的值减当前遍历的值等于另外一个值算出下标。
     */
    public int[] getSum(int[] arr,int target){
        Map<Integer,Integer> hashTable = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(hashTable.containsKey(target - arr[i])){
                return new int[]{hashTable.get(target - arr[i]),i};
            }
            hashTable.put(arr[i],i);
        }
        return new int[0];
    }

    /**
     * 链表两数之和
     * @param l1
     * @param l2
     * @return
     */
    public ListNode getListNodeSum(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            // 记录当前两个ListNode的值
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            // 当前位的和
            int sum = x + y + carry;
            // 当前位晋升的值
            carry = sum / 10;
            // 当前位真正的值
            sum = sum % 10;
            // 下一个ListNode
            cur.next = new ListNode(sum);
            // 当前ListNode指向下一个
            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        //最后一位是否有晋位，有的话创建下一个ListNode
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    /**
     * 数字反转
     * @param x
     */
    public int reverse(int x){
        int res = 0;
        while(x != 0){
            // 获取当前数字
            int cur = x % 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && cur > 7)){
                return 0;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && res < -8)){
                return 0;
            }
            res = res * 10 + cur;
        }
        return res;
    }

    /**
     * 回文数
     * @param n
     */
    public static boolean isHuiWen(int n){
        int s = 1;
        while (n / s >= 10){
            s *= 10;
        }
        while(n > 0){
            int left = n / s;
            int right = n % 10;
            if(left != right) return false;
            n = (n % s) / 10;
            s /= 100;
        }
        return false;
    }
    public static boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        // 获取第一位数的 除数
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            // 用 % 去掉高位数，用 / 去掉个位数
            x = (x % div) / 10;
            // 这样的话就少了两位 所以div要 / 100 减去两个0
            div /= 100;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirNode = new ListNode(3);
        head.val = 1;
        head.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirNode;
        getNodeVal(head);

        isHuiWen(12321);



    }
    public static void getNodeVal(ListNode listNode){
        System.out.println("secondNode 的值为：" + listNode.next.next.val);
    }
}
