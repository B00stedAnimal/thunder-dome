/* Class: Model
 * Autor: P. Rutschmann
 * Project: MasterMind
 */
public class Model
{
    private int[] ziffern;
    private int anzahl;
    private int minimum;
    private int maximum;
    private int versuch;
    private int maximaleAnzahlVersuche;
    private String result;
    
    public Model()
    {
        anzahl = 4;
        minimum = 1;
        maximum = 6+1;
        ziffern = new int[anzahl];
        maximaleAnzahlVersuche = 11;
        result="";
    }
    
    public int check(int[] trial)
    {
        int[] mytrial = trial.clone();
        int[] myziffern = ziffern.clone();
        int correct = 0;
        
        // zuerst checken ob 'Ziffer und Platz richtig'
        for (int cnt = 0; cnt < anzahl; ++cnt)
        {
            if (mytrial[cnt] == myziffern[cnt])
            {
                result = result + "1 ";
                mytrial[cnt]= 0;
                myziffern[cnt]=0;
                ++correct;
            }
        }

        // dann checken ob Ziffer richtig aber Platz nicht
        for (int cnt = 0; cnt < anzahl; ++cnt)
        {
            if (mytrial[cnt] != 0)
            {
                for (int cnt2 = 0; cnt2 < anzahl; ++cnt2)
                {
                    if (myziffern[cnt2] != 0)
                    {
                        if (mytrial[cnt] == myziffern[cnt2])
                        {
                            result = result + "0 ";
                            mytrial[cnt]= 0;
                            myziffern[cnt2]= 0;
                        }                        
                    }
                }
            }
        }
        return correct;
    }
  
    public String expose()
    {
        String ret = "";
        if(ziffern != null)
        {
            for (int cnt = 0; cnt < anzahl; ++cnt)
            {
                ret = ret + ziffern[cnt] + " ";
            }
        }
        return ret;
    }
    
    public int getAnzahl()
    {
        return anzahl;
    }
    
    public String getResult()
    {
        return result;
    }
    
    public Boolean isAttemptAvailable()
    {
        return (versuch < maximaleAnzahlVersuche);
    }
    
    public void inkrementAttempts()
    {
        ++versuch;
    }
    
    public void prepare()
    {
        for (int cnt = 0; cnt < anzahl; ++cnt)
        {
            ziffern[cnt] = (int)((Math.random()) * (maximum-minimum) + minimum);
        }
    }
    
    public void resetResult()
    {
        result = "";
    }
}
