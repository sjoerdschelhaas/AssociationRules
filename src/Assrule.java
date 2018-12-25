import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;


class Assrule
{
    public static void main(String[] args)
    {

        ArrayList<String> ntrans = new ArrayList<String>();
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> comb = new ArrayList<String>();
        ArrayList<String> candidates = new ArrayList<String>();
        ArrayList<String> next = new ArrayList<String>();
        ArrayList<ArrayList<String>> transactions = new ArrayList<ArrayList<String>>();

        Read test = new Read(ntrans, items,"C:/Users/sjoer/Documents/data.csv",16);
        items = test.readItems();
        ntrans = test.readTrans();
        candidates = candidates(items, ntrans, 34, 16);
        int r = 2;
        int n = candidates.size();
        comb = combinationUtil(candidates, data, 0,n-1, 0, 2,comb); //werkt niet!! fix die pup
        //System.out.println(comb);

        Assutils transyo = new Assutils(comb, ntrans, items, Assutils.transactions(ntrans,items));
        //System.out.println(transyo.transactions);
        transactions = transyo.transactions(ntrans,items);
        next = Assutils.confa(comb, transactions);

    } // main ends



    //read data and return the candidate items
    public static ArrayList<String> candidates(ArrayList<String> items, ArrayList<String> trans, double support, int nrow)
    {

        Map<String, Integer> occure = new HashMap<String, Integer>(); //item occurence
        for (String i : items) {
            Integer j = occure.get(i);
            occure.put(i, (j == null) ? 1 : j + 1);
        }
        // displaying the occurrence of elements in the arraylist
        ArrayList<String> finalItems = new ArrayList<String>(); //this will store the items that satisfy support
        double temp = (support / 100) * Integer.parseInt(trans.get(nrow - 1)); //support
        for (Map.Entry<String, Integer> val : occure.entrySet()) {
            if(val.getValue() > temp){
                finalItems.add(val.getKey());
            }
           /*System.out.println("Element " + val.getKey() + " "
                              + "occurs"
                              + ": " + val.getValue() + " times");*/ //this prints how many times each items occurs
        }
        return finalItems;
    }

    static ArrayList<String> combinationUtil(ArrayList<String> items, ArrayList<String> data, int start,
                                             int end, int index, int r, ArrayList<String> comb)
    {
        //ArrayList<String> comb = new ArrayList<String>();
        // Current combination is ready to be added
        if (index == r)
        {
            for (int j=0; j<r; j++)
            {
                comb.add(data.get(j));
            }
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data.add(index, items.get(i));
            combinationUtil(items, data, i+1, end, index+1, r, comb);
        }

        return comb;
    }
} //class ends
