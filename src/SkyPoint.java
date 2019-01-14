import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SkyPoint {
    public List<Point> getSky() {
        return sky;
    }

    private List<Point> sky= new ArrayList<>();

    Function f =new Function();

    Point min,p;
    int indice;

    long t3[]={0};

    ConcurrentHashMap<Integer,List<Double>> h2;

    List<Point> execute (ConcurrentHashMap<Integer,List<Double>> elements,List<Double> pt_refr )
    {
       while (!elements.isEmpty()) {

            Min m = new Min();
            min = m.getMinDegSim(elements, pt_refr);
            elements.remove(min.getId());
            sky.add(min);

            h2=elements;

            h2.forEach((c,v)->{
                Point p =new Point(c,v);
                indice=f.dominer(min,p,t3);

                if(indice==1)
                {
                    elements.remove(c);
                }

            });

        }



        return sky; }

}
