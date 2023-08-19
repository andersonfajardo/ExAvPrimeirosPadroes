import java.util.Comparator;
import java.util.List;

public class Consultas {
    private RegistroDoTempoRepository registros;

    public Consultas(RegistroDoTempoRepository repository) {
        this.registros = repository;
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
    
}
