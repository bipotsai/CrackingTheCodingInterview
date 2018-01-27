package ctci.chapter8;

import java.util.ArrayList;

public class PowerSet {
    static ArrayList<ArrayList<Integer>> subSets = new ArrayList<>();

    public static void findSubSet(ArrayList<Integer> origianlList, int index,  ArrayList<Integer> currentList ){
        if(index >= origianlList.size()){
            subSets.add(currentList);
            return;
        }

        ArrayList<Integer> newLeftList = new ArrayList<>();
        ArrayList<Integer> newRightList = new ArrayList<>();
        newLeftList.addAll(currentList);
        newRightList.addAll(currentList);
        int num = origianlList.get(index);
        newLeftList.add(num);
        findSubSet(origianlList, index+1, newLeftList);
        findSubSet(origianlList, index+1, newRightList);
    }

    public static void main(String[] args) {
        ArrayList<Integer> origianlList = new ArrayList<>();
        origianlList.add(1);
        origianlList.add(2);
        origianlList.add(3);
        origianlList.add(4);
        origianlList.add(5);
        PowerSet.findSubSet(origianlList, 0, new ArrayList<>());
        System.out.printf("count %d \n", PowerSet.subSets.size());
        for(ArrayList<Integer> subList : PowerSet.subSets){
            for(int n : subList){
                System.out.printf("%d ", n);
            }
            System.out.printf("\n");

        }
    }
}
