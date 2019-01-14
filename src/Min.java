import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Min
{
    Point pt;
    double min=Double.MAX_VALUE;
    Double s=0.0;


    public  Point getMinDegSim(ConcurrentHashMap<Integer,List<Double>> elements, List<Double> pr)
    {


        for(Integer k: elements.keySet())
        {

            int i=0;
            List<Double> l =elements.get(k);
            if(l.size()!=0)
            {
                for(Double d: l)
                {
                    s+=d-pr.get(i);  i++;
                }


                if(s/pr.size()<min)
                {

                    min = s / pr.size();
                    pt=new Point(k,elements.get(k));

                }

            }
            s=0.0;
        }

        return pt;


    }

}