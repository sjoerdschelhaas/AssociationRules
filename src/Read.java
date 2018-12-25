import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Read
{

    ArrayList<String> ntrans;
    ArrayList<String> items;
    String filename;
    int nrow;

    public Read(ArrayList<String> ntrans, ArrayList<String> items, String filename, int nrow)
    {
        this.ntrans = ntrans;
        this.items = items;
        this.filename = filename;
        this.nrow = nrow;
    }


    public ArrayList<String> readItems()
    {
        //  ntrans = new ArrayList<int>();
        //  items = new ArrayList<String>();

        File file = new File(filename);

        try {
            Scanner inputStream = new Scanner(file);
            //while(inputStream.hasNext()){
            int i = 0;
            inputStream.nextLine();
            while(i < nrow){
                String data = inputStream.next();
                String[] values = data.split(",");
                items.add(values[1]);
                i++;
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return items;
    }


    public ArrayList<String> readTrans()
    {
        //  ntrans = new ArrayList<int>();
        //  items = new ArrayList<String>();

        File file = new File(filename);

        try {
            Scanner inputStream = new Scanner(file);
            //while(inputStream.hasNext()){
            int i = 0;
            inputStream.nextLine();
            while(i < nrow){
                String data = inputStream.next();
                String[] values = data.split(",");
                ntrans.add(values[0]);
                i++;
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ntrans;
    }
}
