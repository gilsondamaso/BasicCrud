package Control;

import Classes.Pessoa;

public class ControlPessoaArray {
    private Pessoa[] pessoas;

    public Pessoa[] getPessoas(){
        return pessoas;
    }

    public void setPessoas(Pessoa[] pessoas){
        this.pessoas = pessoas;
    }
    
    public Boolean vetorVazio() {
		if (this.pessoas.length == 0) { 
			System.out.println("Array Vazio!!!");
			return true;
		} else {
			return false;
		}
	}
    public void adicionarPessoaVazio(Integer n, Pessoa... p) {
		if (n == 0) {
			System.out.println("Adicao invalida!!!");
		} else {
			this.pessoas = new Pessoa[n];
			int i = 0;
			for (Pessoa x : p) {
				if (i > (this.pessoas.length - 1)) {
					throw new ArrayIndexOutOfBoundsException("Numero de registros excede o tamanho do Array!!!");
				} else {
					this.pessoas[i] = new Pessoa(x.getId(), x.getNome(), x.getIdade());
					i++;
				}
			} 
		}
	}

	public void adicionarPessoa(Integer n, Pessoa... p) {
		if (this.pessoas.length == 0) {
			System.out.println("Necessario criar o Array primeiro!!!");
		} else {
			int i = 0;
			while ((i < this.pessoas.length) && (this.pessoas[i] != null)) {
				i++;
			}
			if (i > (this.pessoas.length - 1)) {
				System.out.println("Array cheio!!!");
			} else {
				if ((this.pessoas.length - i) < n) {
					System.out.println("Numero de registros excede o tamanho do Array!!!");
				} else {
					for (Pessoa x : p) {
						this.pessoas[i] = new Pessoa(x.getId(), x.getNome(), x.getIdade());
						i++;
					}
				}
			}
		}
	}

	public void listarPessoa() {

		if (!vetorVazio()) {
			for (int i = 0; i < this.pessoas.length; i++) {
				if (pessoas[i] != null) {
				System.out.println(i + " : " + pessoas[i]);
				} else {
				System.out.println(i + " : Espaco vazio");
				}
			}
		}
	}

	public void atualizarPessoa(Pessoa p) {
		int achado = 0;
		if (!vetorVazio()) {
			for (int i = 0; i < this.pessoas.length; i++) {
				if ((this.pessoas[i] != null) && (this.pessoas[i].getId().equals(p.getId()))) {
					this.pessoas[i] = p;
					achado++;
				}
			}
		}
		if (achado == 0) {
			System.out.println("Pessoa nao encontrada!!!");
		}
	}

	public void removerPessoa(Pessoa p) {
		int achado = 0;
		if (!vetorVazio()) {
			for (int i = 0; i < this.pessoas.length; i++) {
				if ((this.pessoas[i] != null) && (this.pessoas[i].getId().equals(p.getId()))) {
					achado++;
					for (int j = i; j < this.pessoas.length; j++) {
						if (this.pessoas[j] != null)
						pessoas[j] = pessoas[j + 1];
					}
				}
			}
		}
		if (achado == 0) {
			System.out.println("Pessoa nao encontrada!!!");
		}
	}

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa(10, "P1", 30);
		Pessoa p2 = new Pessoa(11, "P2", 31);
		Pessoa p3 = new Pessoa(12, "P3", 32);

		ControlPessoaArray cp = new ControlPessoaArray();
		// cp.adicionarPessoaVazio(10, p1, p2, p3);
		cp.adicionarPessoaVazio(10, p1, p2, p3);
		cp.adicionarPessoa(2, p1, p2);
	// cp.removerPessoa(new Pessoa(12, null, null));
	 cp.atualizarPessoa(new Pessoa(12, "atualizou", 50));
		cp.listarPessoa();
	}
}
