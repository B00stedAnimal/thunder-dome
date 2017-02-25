/* Class: Control
 * Autor: P. Rutschmann
 * Project: MasterMind
 */
import java.util.regex.Pattern;
public class Control
{
    private Model model;
    private View view;
    
    public Control (Model model, View view)
    {
        this.model = model;
        this.view = view;
    }
    
    public void play ()
    {
        Boolean ende = false;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        view.manual();
        model.prepare();
        //view.expose();
        
        while (model.isAttemptAvailable() && (ende != true))
        {
           view.ask();
           
           String eingabe = scanner.nextLine();
           String[] segs = eingabe.split( Pattern.quote( " " ) );
           model.inkrementAttempts();
               
           if ((segs.length < model.getAnzahl()) || (segs[0].charAt(0) == 'e'))
           {
               ende = true;
           }
           else
           {
               int[] trial = new int[model.getAnzahl()];
               for (int cnt = 0; cnt < model.getAnzahl();++cnt)
               {
                   trial[cnt] = Integer.parseInt(segs[cnt]);
               }
               model.resetResult();
               if (model.check(trial)== model.getAnzahl())
               {
                   ende = true;
               }  
           }
           
           view.result();
        }
        scanner.close();
        if (model.isAttemptAvailable())
        {
            view.win();
        }
        else
        {
            view.lose();
        }
    }
}
