import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CarregadorDePessoas {

	private SimpleDateFormat formatoData;
	private ArrayList<Pessoa> pessoas;
	private AVLTree<String> cpfs;
	private AVLTree<String> names;
	private AVLTree<Date> dates;

	public CarregadorDePessoas() {
		this.pessoas = new ArrayList<Pessoa>();
		this.formatoData = new SimpleDateFormat("dd/MM/yyyy");
		this.cpfs = new AVLTree<String>();
		this.names = new AVLTree<String>();
		this.dates = new AVLTree<Date>();
	}

	public ArrayList<Pessoa> carregarCSV(File arquivoCSV) {

		try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
			String linha = "";
			int index = 0;
			while ((linha = br.readLine()) != null) {
				String[] colunas = linha.split(";");
				Date dataNascimento = formatoData.parse(colunas[3]);
				Pessoa pessoaLinha = new Pessoa(colunas[0], colunas[1], colunas[2], dataNascimento, colunas[4]);
				pessoas.add(pessoaLinha);
				cpfs.insert(pessoaLinha.getCpf(), index);
				names.insert(tratarNome(pessoaLinha.getNome()), index);
				dates.insert(pessoaLinha.getDataDeNascimento(), index);
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Arquivo Inválido.");
		}

		return pessoas;
	}

	private String tratarNome(String nome) {
		return nome.toLowerCase().trim();
	}
	
	public void imprimirArvoreCPFs() {
		cpfs.printTree();
	}
	
	public void imprimirArvoreDatas() {
		dates.printTree();
	}
	
	public void imprimirArvoreNomes() {
		names.printTree();
	}
	
	public void buscarPorDatas(Date inferior, Date superior) {
		ArrayList<Integer> indexes = this.dates.searchInterval(inferior, superior);
		for (Integer index : indexes) {
			System.out.println(pessoas.get(index));
		}
	}

	public void buscarPorCPF(String cpf) {
		int index = this.cpfs.search(cpf);
		if (index == -1) {
			System.out.println("Nenhuma pessoa encontrada com este CPF.");
			return;
		}
		System.out.println(pessoas.get(index));
	}
	
	public void buscarPorNome(String nome) {
		int index = this.names.search(tratarNome(nome));
		if (index == -1) {
			System.out.println("Nenhuma pessoa encontrada com este nome.");
			return;
		}
		System.out.println(pessoas.get(index));
	}
}