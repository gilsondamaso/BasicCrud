import Classes.Pessoa;
import Control.ControlPessoaArray;

public class App {
    public static void main(String[] args) throws Exception {
        
        Pessoa p1 = new Pessoa(10, "GILSON", 39 );
        Pessoa p2 = new Pessoa(11, "MIGUEL", 9 );
        Pessoa p3 = new Pessoa(12, "POLY", 37 );
        Pessoa p4 = new Pessoa(13, "POLY", 37 );
        Pessoa p5 = new Pessoa(14, "POLY", 37 );
        ControlPessoaArray ctrlPessoa = new ControlPessoaArray();
        
        ctrlPessoa.adicionarPessoaVazio(4, p1,p2,p3);
        //ctrlPessoa.adicionarPessoa(2,p1, p2);

        ctrlPessoa.atualizarPessoa(new Pessoa(12, "POLYANA", 38));

        ctrlPessoa.listarPessoa();
    }
}
