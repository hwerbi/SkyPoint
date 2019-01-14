import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MainTest
{
    public static void main(String[] a)
    {


        ConcurrentHashMap<Integer,List<Double>> elements;
        InputStream data  ;
        SkyPoint s= new SkyPoint();
        Function f= new Function();

        List<Double> pt_ref;
        long t1[]={0};
        long t2[]={0};

        try {
            // utiliser des données générés aleatoirement
            //int nombreattribut=50;
            //int nombreligne=4;
            ///data= f.genere(nombreligne,nombreattribut ,t1);

            // utiliser un fichier de puis la ligne de commande
            data= new FileInputStream(a[0]);
            elements=f.remplir(data,t2);







            int nb_ligne= elements.size();
            int nb_attribut= elements.get(1).size();

            //calculer le point référence + le temps d'éxecution
            Reference r= new Reference(nb_attribut);

            long startTime0 = System.currentTimeMillis();
            pt_ref=r.pointReference(elements);
            long stopTime0 = System.currentTimeMillis();
            long elapsedTime0 = stopTime0 - startTime0;

            //calculer les motifs skyline + le temps d'éxecution
            long startTime = System.currentTimeMillis();
            s.execute(elements,pt_ref);
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;


            System.out.println(" la recherche de point reference dure : "+elapsedTime0 +" ms");
            System.out.println();
            System.out.println(" l'execution de SkyPoint dure : "+elapsedTime +" ms");
            System.out.println();

            System.out.println("le nombre de point skyline : " + s.getSky().size());
            System.out.println();
            System.out.println(" Nombre de ligne : "+nb_ligne+ " Nombre d'attribut : "+nb_attribut);
            f.affiche(s.getSky());

        }
        catch (Exception e){
            System.out.println(e.toString());
        }




    }

}
