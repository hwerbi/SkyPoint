
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.io.PrintWriter;
import java.util.Random;

public class Function
{
    private ConcurrentHashMap<Integer,List<Double>> cond = new ConcurrentHashMap<>();

    public Function() {super(); }

    public InputStream genere(int n , int m , long t[])
    {
        long startTime = System.currentTimeMillis();
        InputStream file= null;
        PrintWriter writer ;
        try {
            writer = new PrintWriter("/home/khouloud/Desktop/pfe/sequentiel/res");
            for(int i=0; i<n; i++) {
                String s=new String();
                for (int j=0; j<m;j++) {
                    Random rand = new Random();


                    double x = rand.nextInt(10);
                    //double d = (double) Math.round(x*1000) / 100;

                    s += x + " ";
                }
                writer.println(i+" "+s);

            }

            writer.close();
            file = new FileInputStream("/home/khouloud/Desktop/pfe/sequentiel/res");



        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        t[0] += elapsedTime;
        return  file;


    }

    public  ConcurrentHashMap<Integer,List<Double>> remplir (InputStream input , long tt[])
    {
        long startTime = System.currentTimeMillis();
        String ligne;

        try{
            InputStreamReader lecture=new InputStreamReader(input);
            BufferedReader buff=new BufferedReader(lecture);

            while ((ligne=buff.readLine())!=null){
                List<Double> l;
                String  t[] ;
                t= ligne.split(" ");
                l=remplirCord(t);
                int id=Integer.parseInt(t[0]);
                cond.put(id,l);

            }
            buff.close();
        }

        catch (Exception e){

            System.out.println(e.toString());
        }

        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        tt[0] += elapsedTime;
        return cond;
    }



public List<Double> remplirCord( String[] t)
{
    List<Double> l = new ArrayList<>();
    for(int i=1; i<t.length;i++)
    {

       l.add(Double.parseDouble(t[i]));

    }
    return l;
}


    public void afficheConc(ConcurrentHashMap<Integer,List<Double>>h)
    {

        System.out.println("Debut de la de ConcurrentHashMap : ");

        for(Integer k: h.keySet())
            System.out.println("nom: "+k + "  coordonnee : " + h.get(k));


    }
    public void affiche(List<Point> sky)
    {

        System.out.println("La liste des Skylines : ");
        sky.forEach((k) -> System.out.println(k));
    }



public int dominer(Point a, Point b,long  t[])
{
    long startTime = System.currentTimeMillis();
    List<Double> l1=a.getC();
    List<Double> l2=b.getC();

    int i=0;
    for(Double d: l1)
    {
        if(d>l2.get(i))
        {


            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            t[0] += elapsedTime;
            return -1;
        }
      else  i++;
    }

    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    t[0] += elapsedTime;
    return 1;
}



}

