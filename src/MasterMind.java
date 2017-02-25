/* Class: MasterMind
 * Autor: P. Rutschmann
 * Project: MasterMind
 */
public class MasterMind
{
    public static void main(String[] args)
    {
		Model myModel = new Model();
        View myView = new View(myModel);
        Control myControl = new Control(myModel, myView);
        
        myControl.play();
	}
}
