public class Principal {

    public static void main(String[] args) {

        Data data1 = new Data();

        System.out.println("\n--- Dados da Data ---");
        System.out.println("Formato 1: " + data1.mostra1());
        System.out.println("Formato 2: " + data1.mostra2());

        if (data1.bissexto()) {
            System.out.println("Ano bissexto.");
        } else {
            System.out.println("Ano não bissexto.");
        }

        System.out.println("Dias transcorridos: "
                + data1.diasTranscorridos());

        System.out.println("\nData atual do sistema:");
        data1.apresentaDataAtual();

        System.out.println("\n--- Teste do construtor com parâmetros ---");

        Data data2 = new Data(25, 12, 2024);

        System.out.println("Formato 1: " + data2.mostra1());
        System.out.println("Formato 2: " + data2.mostra2());

        System.out.println("Dia: " + data2.retDia());
        System.out.println("Mês: " + data2.retMes());
        System.out.println("Ano: " + data2.retAno());
    }
}