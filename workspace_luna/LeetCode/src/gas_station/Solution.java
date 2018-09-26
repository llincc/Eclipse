package gas_station;

/*��Ŀ����

There are N gas stations along a circular route, where the amount of gas at station i isgas[i].

You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note: 
The solution is guaranteed to be unique.*/
public class Solution {
/*	��start������ ��������㹻�� ����һֱ����� end++��  ����������ʱ��
	start�����  ���� start == end��ʱ������н�һ���ǵ�ǰ start����λ��*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        
        while(start>end){
        	if(sum>=0){
        		sum += gas[end]-cost[end];
        		++end;
        	}
        	else{
        		--start;
        		sum += gas[start]-cost[start];
        	}
        }
        return sum>=0? start:-1;
    }
}
