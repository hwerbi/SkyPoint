import java.util.List;

public class Point

{
    private Integer id;
    private List<Double> c;


    public Integer getId() {
        return id;
    }





    public Point(Integer id, List<Double> c) {
        this.id = id;
        this.c = c;
    }



    public List<Double> getC() { return c; }


    public String toString()
    {
        return id+" : "+c.toString();
    }


}
