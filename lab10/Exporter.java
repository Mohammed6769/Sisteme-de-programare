package lab10;

import java.util.List;

public class Exporter {

    public void startExport(IStudentiExport strategie, List<Student> studenti) {
        strategie.doExport(studenti);
    }
}