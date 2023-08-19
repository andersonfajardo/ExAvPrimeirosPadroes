import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        RegistroDoTempoRepository repository = new RegistroDoTempoRepository();
        Consultas consultas = new Consultas(repository);
        consultas.carregaDados();
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(consultas.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        consultas.datasEmQueChouveuMaisDe(90)
            .forEach(System.out::println);

        Predicate<RegistroDoTempo> consultaPersonalizada = reg -> reg.getTempMinima() < 4;
        consultas.alteraConsultaPadrao(consultaPersonalizada);
    
        System.out.println("Datas em que a condição padrão se aplica:");
        consultas.diasEmQue().forEach(System.out::println);
    }
}
