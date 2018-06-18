package Models;

import interfaces.InterfaceManipulable;
import DAO.UsuarioDAO;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class Usuario implements InterfaceManipulable {
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private Carteira carteira;
    private Perfil perfil;
    private boolean ativo;
    
    public Usuario(){
        
    }
    
    public Usuario(int idMatricula, String nome, String login, String senha, Carteira carteira, Perfil perfil, boolean ativo) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.carteira = carteira;
        this.perfil = perfil;
        this.ativo = ativo;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setLogin(String login){
        if(login != null){
            this.login = login;
        }
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }
    
    
    public Carteira getCarteira() {
        return carteira;
    }
    
    public void setCarteira(Carteira carteira) {
        if (carteira != null) {
            this.carteira = carteira;
        }
    }
    
    public Perfil getPerfil() {
        return perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        if (perfil != null) {
            this.perfil = perfil;
        }
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @Override
    public void save() throws SQLException, ClassNotFoundException {
        if (this.carteira != null && this.nome != null && this.perfil != null && this.login != null && this.senha != null) {
            if (this.id == 0) {
                UsuarioDAO.getInstancia().save(this);
            } else {
                this.update();
            }
        }
    }
    
    @Override
    public void update() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            UsuarioDAO.getInstancia().update(this);
        }
    }
    
    @Override
    public void find(int codigo) throws SQLException, ClassNotFoundException {
        if (codigo > 0) {
            this.id = codigo;
            
            UsuarioDAO.getInstancia().find(this);
        }
    }
    
    @Override
    public void delete() throws SQLException, ClassNotFoundException {
        if (this.id > 0) {
            UsuarioDAO.getInstancia().delete(this);
        }
    }
    
}
