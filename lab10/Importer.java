package lab10;

import java.util.List;

public class Importer {

    public List<Student> startImport(IStudentiImport strategie) {
        return strategie.doImport();
    }
}