import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    Scanner sc = new Scanner(System.in);

    public Data() {
        entraAno();
        entraMes();
        entraDia();
    }

    public Data(int d, int m, int a) {
        ano = a;
        mes = m;
        dia = d;
    }

    public void entraDia(int d) {
        dia = d;
    }

    public void entraMes(int m) {
        mes = m;
    }

    public void entraAno(int a) {
        ano = a;
    }

    public void entraAno() {
        do {
            try {
                System.out.print("Digite o ano: ");
                ano = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Ano inválido!");
                sc.nextLine();
            }
        } while (ano <= 0);
    }

    public void entraMes() {
        do {
            try {
                System.out.print("Digite o mês (1-12): ");
                mes = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Mês inválido!");
                sc.nextLine();
            }
        } while (mes < 1 || mes > 12);
    }

    public void entraDia() {

        int maxDias = diasNoMes(mes, ano);

        do {
            try {
                System.out.print("Digite o dia: ");
                dia = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Dia inválido!");
                sc.nextLine();
            }
        } while (dia < 1 || dia > maxDias);
    }

    public int retDia() {
        return dia;
    }

    public int retMes() {
        return mes;
    }

    public int retAno() {
        return ano;
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String mostra2() {

        String[] meses = {
                "janeiro",
                "fevereiro",
                "março",
                "abril",
                "maio",
                "junho",
                "julho",
                "agosto",
                "setembro",
                "outubro",
                "novembro",
                "dezembro"
        };

        return dia + "/" + meses[mes - 1] + "/" + ano;
    }

    public boolean bissexto() {

        return (ano % 400 == 0) ||
                (ano % 4 == 0 && ano % 100 != 0);
    }

    public int diasTranscorridos() {

        int total = dia;

        int[] diasMes = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        if (bissexto()) {
            diasMes[1] = 29;
        }

        for (int i = 0; i < mes - 1; i++) {
            total += diasMes[i];
        }

        return total;
    }

    public void apresentaDataAtual() {

        Date hoje = new Date();

        DateFormat df =
                DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(df.format(hoje));
    }

    private int diasNoMes(int mes, int ano) {

        switch (mes) {

            case 2:
                if ((ano % 400 == 0) ||
                        (ano % 4 == 0 && ano % 100 != 0))
                    return 29;
                return 28;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;

            default:
                return 31;
        }
    }
}