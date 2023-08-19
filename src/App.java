public class App {
    public static void main(String[] args) {
        RegistroDoTempoRepository repository = new RegistroDoTempoRepository();
        Consultas consultas = new Consultas(repository);
        consultas.carregaDados();
        System.out.println("Dia em que mais choveu no ano de 1970: ");
        System.out.println(consultas.diaQueMaisChoveuNoAno(1970));
        System.out.println("Datas em que choveu mais de 80 milimetros");
        consultas.datasEmQueChouveuMaisDe(80)
            .forEach(System.out::println);
    }
}
