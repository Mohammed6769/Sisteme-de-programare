package lab6;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AplicatieCuBursaTest {

    AplicatieCuBursa appCuBursa = new AplicatieCuBursa();

    @Test
    void sortTest1() {
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);

        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursier a = sortata.get(i);
            StudentBursier b = sortata.get(i + 1);

            boolean ok =
                    a.getFormatieDeStudiu().compareTo(b.getFormatieDeStudiu()) < 0
                            || (a.getFormatieDeStudiu().compareTo(b.getFormatieDeStudiu()) == 0
                            && a.getNume().compareTo(b.getNume()) < 0)
                            || (a.getFormatieDeStudiu().compareTo(b.getFormatieDeStudiu()) == 0
                            && a.getNume().compareTo(b.getNume()) == 0
                            && a.getPrenume().compareTo(b.getPrenume()) < 0)
                            || (a.getFormatieDeStudiu().compareTo(b.getFormatieDeStudiu()) == 0
                            && a.getNume().compareTo(b.getNume()) == 0
                            && a.getPrenume().compareTo(b.getPrenume()) == 0
                            && a.getNota() < b.getNota())
                            || (a.getFormatieDeStudiu().compareTo(b.getFormatieDeStudiu()) == 0
                            && a.getNume().compareTo(b.getNume()) == 0
                            && a.getPrenume().compareTo(b.getPrenume()) == 0
                            && a.getNota() == b.getNota()
                            && a.getCuantumBursa() <= b.getCuantumBursa());

            assertTrue(ok);
        }
    }
}
