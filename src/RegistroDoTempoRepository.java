import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RegistroDoTempoRepository{

    private List<RegistroDoTempo> registros;
    private String nArq;

    public RegistroDoTempoRepository(){
        registros = new LinkedList<>();
        this.nArq = "poa_temps.txt";

    }

}