package bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import entidades.Jogo;

@ManagedBean
@ApplicationScoped
public class JogoBean {
	private List<Jogo> jogos = new ArrayList<Jogo>();
    private Jogo jogo = new Jogo();
    private int idIncremento = 1;

    public void salvar() {
        Random random = new Random();
    
        jogo.setId(idIncremento++);
        jogo.setData(new Date());
        int numeroSecreto = random.nextInt(5) + 1;
        jogo.setNumeroSecreto(numeroSecreto);
        
        gerarResultado();
        insert(jogo);
        jogo = new Jogo(); 
    }
    
    public void gerarResultado() {
        if (jogo.getNumeroAposta() != null && jogo.getNumeroAposta().equals(jogo.getNumeroSecreto())) {
        	jogo.setResultado("acertou");
            } else {
                jogo.setResultado("não acertou");
            }
    }
    
    public void insert(Jogo jogo) {
    	jogos.add(jogo);
    }
    
    public void excluir(Jogo jogo) {
        jogos.remove(jogo);
    }

    public List<Jogo> getJogos() {
        return jogos;
    }
   
    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
