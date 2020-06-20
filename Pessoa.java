import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	/*
	 * Foi utilizado string no cpf e rg, pois uma string nesses casos é mais leve na
	 * memória
	 */
	private String cpf;
	private String rg;
	private String nome;
	private Date dataDeNascimento;
	private String cidade;

	public Pessoa(String cpf, String rg, String nome, Date dataDeNascimento, String cidade) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatoData.format(dataDeNascimento);
		return "Pessoa [cpf=" + cpf + ", rg=" + rg + ", nome=" + nome + ", dataDeNascimento=" + dataFormatada
				+ ", cidade=" + cidade + "]";
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
