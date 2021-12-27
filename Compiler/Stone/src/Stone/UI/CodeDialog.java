package Stone.UI;

import javax.swing.*;
import java.io.*;

/** 
 * A Dialog to write code.
 */

public class CodeDialog extends Reader{
    
    private String buffer = null;
    private int pos = 0;

    public static Reader file() throws FileNotFoundException {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return new BufferedReader(new FileReader(chooser.getSelectedFile()));
        } else {
            throw new FileNotFoundException("no file specified");
        }
    }
    
}
