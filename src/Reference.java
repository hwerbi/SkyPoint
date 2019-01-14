import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Reference
{
   private List<Double> reference;

       public Reference(int x)
       {
           reference=new ArrayList<>();
           for( int i=0;i<x; i++)
           {
               reference.add(i,Double.MAX_VALUE);
           }
       }

    public List<Double> pointReference(ConcurrentHashMap<Integer, List<Double>> elements) {

        for (Integer e : elements.keySet()) {

            List<Double> list=elements.get(e);
            if(!list.isEmpty())
            {int i=0;
            for(Double x:list)
            {
                if (x<reference.get(i)) {
                    reference.remove(i);
                    reference.add(i, x);
                }
                i++;
            }}

        }

        return reference;
    }
}