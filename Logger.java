import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Logger {
    private String logFileName;
    private BufferedWriter out;

    public Logger(){
        logFileName = "GameOutput" + System.currentTimeMillis() +".txt";
    }

    public void startLogger ()
    {
        try
        {
            out = new BufferedWriter (new OutputStreamWriter (new FileOutputStream (new File (logFileName), true)));
        }
        catch (IOException fileException)
        {
            System.out.println ("Error in log file!");
        }
    }

    public void endLogger ()
    {
        try
        {
            out.close ();
        }
        catch (IOException fileException)
        {
            System.out.println ("Error in log file!");
        }
    }

    public void logMessage (String message)
    {
        try
        {
            out.write (message + "\n");
        }
        catch (IOException fileException)
        {
            System.out.println ("Error in log file!");
        }
    }

}
