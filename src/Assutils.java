import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Assutils
{
    ArrayList<String> comb;
    ArrayList<String> ntrans;
    ArrayList<String> items;
    ArrayList<ArrayList<String>> transactions;

    public Assutils(ArrayList<String> comb, ArrayList<String> ntrans, ArrayList<String> items, ArrayList<ArrayList<String>> transactions)
    {
        this.comb = comb;
        this.ntrans = ntrans;
        this.items = items;
        this.transactions = transactions;
    }

    public static ArrayList<Integer> which(ArrayList<String> arr, String value)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int size = arr.size();
        int c = 0;
        for(int i = 0; i < size; i++){
            if(arr.get(i).equals(value)){
                c++;
                res.add(i);
            }
        }
        return(res);
    }

    public static ArrayList<ArrayList<String>> transactions(ArrayList<String> ntrans, ArrayList<String> items)
    {
        ArrayList<ArrayList<String>> transactions = new ArrayList<ArrayList<String>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        //ArrayList<String> temp2 = new ArrayList<String>();
        int nrow = ntrans.size();
        int n = Integer.parseInt(ntrans.get(nrow - 1));
        for(int i = 1; i < n + 1; i++){
            ArrayList<String> temp2 = new ArrayList<String>();
            temp = which(ntrans, Integer.toString(i));
            //System.out.println(temp);
            //System.out.println(temp.size());
            for(int j = 0; j < temp.size(); j++){
                temp2.add(items.get(temp.get(j).intValue()));
            }
            transactions.add(temp2);
        }
        //System.out.println(transactions.size());
        //System.out.println(transactions);
        return transactions;
    }

    public static ArrayList<String> confa(ArrayList<String> comb, ArrayList<ArrayList<String>> transactions)
    {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> temp = new ArrayList<String>();
        int size = transactions.size();
        for(int i = 0; i < size; i++)
        {
            temp = transactions.get(i);
            for(int j = 0; j < comb.size() - 1; j++)
            {
                if(temp.contains(comb.get(j)) && temp.contains(comb.get(j+1)))
                {
                    String s;
                    s = comb.get(j) + comb.get(j+1);
                    res.add(s);
                }
            }
        }
        return res;
    }
}
