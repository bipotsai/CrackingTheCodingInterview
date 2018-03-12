package ctci.chapter8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StackOfBoxes {
    private class Box {
        int width;
        int height;
        int depth;

        public Box(int w, int h, int d) {
            this.width = w;
            this.height = h;
            this.depth = d;
        }
    }

    public static int getHighest(List<Box> boxList) {
        Collections.sort(boxList, (Box o1, Box o2) -> o2.height - o1.height);
        int[] stackMap = new int[boxList.size()];
        int maxHeight = 0;
        for (int i = 0; i < boxList.size(); i++) {
            maxHeight = Math.max(maxHeight, createStack(boxList, i, stackMap));
        }
        return maxHeight;
    }

    public static int createStack(List<Box> boxList, int index, int[] stackMap) {
        if (stackMap[index] > 0) {
            return stackMap[index];
        }


        int maxHeight = 0;
        for (int i = index + 1; i < boxList.size(); i++) {
            if (canBeAbove(boxList.get(i), boxList.get(index))) {
                maxHeight = Math.max(maxHeight, createStack(boxList, i, stackMap));
            }
        }
        maxHeight += boxList.get(index).height;
        stackMap[index] = maxHeight;
        return maxHeight;

    }

    public static boolean canBeAbove(Box b1, Box b2) {
        if (b1.height > b2.height && b1.width > b2.width && b1.depth > b2.depth) {
            return true;
        }
        return false;
    }


}
