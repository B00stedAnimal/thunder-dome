/* Class: View
 * Autor: P. Rutschmann
 * Project: MasterMind
 */
public class View
{
	private Model model;
    
    public View(Model model)
    {
        this.model = model;
    }
    public void ask()
    {
        System.out.println("Bitte geben Sie die Ziffern ein: ");
    }
    
    public void expose ()
    {
        System.out.print("Die Lösung lautet: ");
        System.out.println(model.expose());
    }
    
    public void lose ()
    {
        System.out.println("Verloren :-(");
    }

    public void manual()
    {
        System.out.print(
                "Willkommen zum Mastermind" + "\n" +
                "Erraten Sie vier Ziffern von 1 bis 9" + "\n" +
                "...und deren richtige Position in der Reihe." + "\n" +
                "Sie müssen vier Ziffern eingeben," + "\n" +
                "...getrennt durch ein Leerzeichen. zBsp 4 1 2 3" + "\n" +
                "\n" +
                "Der Computer bewertet Ihren Lösungsvorschlag:" + "\n" +
                "0: Ziffer korrekt, Positon falsch" + "\n" +
                "1: Ziffer und Position korrekt." + "\n" +
                "\n" +
                "Sie haben 10 Versuche, danach endet das Spiel." + "\n" +
                "Viel Glück!" + "\n"
                );
    }
    
    public void result()
    {
        System.out.println("Resultat: " + model.getResult());
    }
    
    public void win ()
    {
        System.out.println("Gewonnen :-)");
    }
}
