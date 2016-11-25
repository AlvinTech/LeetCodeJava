import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alvin on 16/11/24.
 */
/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
* */
public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        List<Integer> list = new ArrayList<>();
        for (int i =0 ; i < coins.length; i++){
            list.add(coins[i]);
        }
        Collections.sort(list);
        int result = change(list,amount,coins.length-1,0,Integer.MAX_VALUE);
        return result == Integer.MAX_VALUE ? -1: result;
    }

    private int change(List<Integer>coins, int amount , int index ,int preCount,int minCount){
        if (index < 0 )
            return minCount;
        int coin = coins.get(index);
        int count = amount / coin;
        if(amount % coin == 0) {
            return count+preCount;
        }
        if(preCount+ count > minCount){
            return minCount;
        }
        for (int j = count; j >=0;  j--){
            int rest = amount - coin * j;
            int restCount = change(coins,rest,index-1,preCount+j,minCount);
            if(restCount != Integer.MAX_VALUE && minCount > restCount){
                minCount = restCount;
            }
        }
        return minCount;
    }

    public static void main(String[] args) {
        int[] coins ={186,419,83,408};
        int amount = 6249;
        System.out.println(new Coin_Change().coinChange(coins,amount));
        System.out.println("===========");

       // cal();
    }

    private static  void cal(){
        int i,j,k,m;
        for(i=0; i < 20; i++)
            for(j=0; j < 20; j++)
                for(k=0; k < 20; k++)
                    for(m=0; m < 20; m++){
                    if((i +j +k + m )==20 && i*419 + j * 408+ k* 186 + m * 83 == 6249){
                        System.out.println(i);
                        System.out.println(j);
                        System.out.println(k);
                        System.out.println(m);
                    }
                }
    }
}


/**
 notice: 首先排序，优先选择大面额货币，
 但是，并不是每次选择最多大面额就是最优解，注意这种情况
 基于上面的情况，所以需要遍历所有的解空间。
 但是需要选择合理的终止条件，因为解空间会很大，全部遍历会照成超时。
 * */
