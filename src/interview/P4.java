package interview;

import java.util.ArrayList;
import java.util.Collections;

public class P4 {
    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        Collections.reverse(A);
        for (int i = 0; i < A.size(); i++) {
            int ele = A.get(i);
            if(ele!=9) {
                A.set(i, ele + 1);
                break;
            }
            else {
                if(i < A.size()-1){
                    A.set(i, 0);
                } else {
                    A.set(i, 0);
                    A.add(0);
                }
            }
        }
        Collections.reverse(A);
        int k = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                k++;
            } else{
                break;
            }
        }
        for (int i = 0; i < k; i++) {
            A.remove(0);
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(9);
        list.add(9);
        plusOne(list).forEach(e->{
            System.out.println(e);
        });

    }
}
