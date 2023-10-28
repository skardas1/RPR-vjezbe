import java.util.List;
public class Racun {

    public static Double min(List<Double> lista)
    {
        Double min=lista.get(0);
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i)<=min)
                min=lista.get(i);
        }
        return min;
    }

    public static double max(List<Double> lista)
    {
        Double max=lista.get(0);
        for(int i=0;i<lista.size();i++)
        {
            if(lista.get(i)>=max)
                max=lista.get(i);
        }
        return max;
    }

    public static double mean(List<Double> lista)
    {
        double suma=0;
        for(int i=0;i<lista.size();i++)
            suma=suma+lista.get(i);
        return (double)suma/lista.size();
    }

    public static double standardnaDevijacija(List<Double> lista)
    {
        double p=Racun.mean(lista);
        double suma=0;
        for(int i=0;i<lista.size();i++)
        {
            suma=suma+ Math.pow(lista.get(i)-p,2);
        }
        return Math.sqrt(suma/lista.size());

    }

}
