import java.io.File;

public class main {

	public static void main(String[] args) {
		String caminhoArquivo = "cargadedados.csv";
		if (args.length > 0) {
			caminhoArquivo = args[0];
		}
		CarregadorDePessoas pessoas = new CarregadorDePessoas();
		pessoas.carregarCSV(new File(caminhoArquivo));

	}

}
