import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String[] args) {
		String caminhoArquivo = "cargadedados.csv";
		if (args.length > 0) {
			caminhoArquivo = args[0];
		}
		CarregadorDePessoas pessoas = new CarregadorDePessoas();
		pessoas.carregarCSV(new File(caminhoArquivo));

		Teclado leitor = new Teclado();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		boolean continuar = true;
		System.out.println("Bem vindo ao consultor de pessoas!");

		do {
			System.out.println("\nDigite o número da opção que deseja:\n" + "1 - Consultar pessoa pelo CPF;\n"
					+ "2 - Consultar pessoas pelo nome completo;\n"
					+ "3 - Consultar pessoas por intervalo de datas de nascimento;\n"
					+ "4 - Imprimir arvore de CPFs;\n"
					+ "5 - Imprimir arvore de Datas;\n"
					+ "6 - Imprimir arvore de Nomes;\n"
					+ "7 - Sair do sistema;\n");
			int pos = leitor.leInt();

			switch (pos) {
			case 1:
				String cpfBusca = leitor.leString("Digite o CPF: ");
				pessoas.buscarPorCPF(cpfBusca);
				break;
			// Consulta pelo nome completo
			case 2:
				String nomeBusca = leitor.leString("Digite o nome completo: ");
				pessoas.buscarPorNome(nomeBusca);
				break;
			// Consulta por intervalo de datas de nascimento
			case 3:
				System.out.println("As datas precisam ser digitadas no formato DD/MM/AAAA");
				String dataInferior = leitor.leString("Digite a data inferior:");
				String dataSuperior = leitor.leString("Digite a data superior:");
				try {
				Date inferior = formatoData.parse(dataInferior);
				Date superior = formatoData.parse(dataSuperior);
				if (inferior.compareTo(superior) <= 0) {
					pessoas.buscarPorDatas(inferior, superior);
				} else {
					System.out.println("Data inferior não pode ser maior que a superior.");
				}
				} catch (ParseException e) {
					System.out.println("Formato de data invalido.");
				}
				break;
			case 4:
				pessoas.imprimirArvoreCPFs();
				break;
			case 5:
				pessoas.imprimirArvoreDatas();
				break;
			case 6:
				pessoas.imprimirArvoreNomes();
				break;
			case 7:
				continuar = false;
				System.out.println("Volte sempre!");
				break;
			}

		} while (continuar);

	}

}
