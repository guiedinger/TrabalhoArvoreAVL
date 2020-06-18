import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CarregadorDePessoas {

	private SimpleDateFormat formatoData;

	public CarregadorDePessoas() {
		this.formatoData = new SimpleDateFormat("dd/MM/yyyy");
	}

	public ArrayList<Pessoa> carregarCSV(File arquivoCSV) {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String[] colunas = linha.split(";");
				Date dataNascimento = formatoData.parse(colunas[3]);
				Pessoa pessoaLinha = new Pessoa(colunas[0], colunas[1], colunas[2], dataNascimento, colunas[4]);
				pessoas.add(pessoaLinha);
				System.out.println(pessoaLinha);
			}
		} catch (Exception e) {
			System.out.println("Arquivo Inválido.");
		}
		
		return pessoas;
	}
}
