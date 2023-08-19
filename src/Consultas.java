import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Consultas {
    private RegistroDoTempoRepository registros;
    private Predicate<RegistroDoTempo> consultaPadrao;

    public Consultas(RegistroDoTempoRepository repository) {
        this.registros = repository;
        this.consultaPadrao = reg -> true; //defini o predicated como padrão - retorna todos
    }

    public void carregaDados(){
        registros.carregaDados();
 }            
      public List<String> datasEmQueChouveuMaisDe(double milimetros){
        List<RegistroDoTempo> repository = registros.buscarTodos();
        
        return repository
            .stream()
            .filter(r->r.getPrecipitacao() > milimetros)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
            .toList();
    }

   /*  public String diaQueMaisChoveuNoAno(int ano){
        private List<RegistroDoTempo> repository = registros.buscarTodos();
        RegistroDoTempo registro = repository
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }*/

    public String diaQueMaisChoveuNoAno(int ano) {
        List<RegistroDoTempo> repository = registros.buscarTodos();
    
        RegistroDoTempo registro = repository
            .stream()
            .filter(reg -> reg.getAno() == ano)
            .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
            .orElseThrow(IllegalArgumentException::new);
    
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }
    
     public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta) {
        this.consultaPadrao = consulta;
    }

    public List<String> diasEmQue() {
        List<RegistroDoTempo> registrosFiltrados = registros.buscarTodos()
            .stream()
            .filter(consultaPadrao) // Usa a condição padrão ou a condição personalizada definida
            .collect(Collectors.toList());

        return registrosFiltrados
            .stream()
            .map(reg -> reg.getDia() + "/" + reg.getMes() + "/" + reg.getAno())
            .collect(Collectors.toList());
    }

}
