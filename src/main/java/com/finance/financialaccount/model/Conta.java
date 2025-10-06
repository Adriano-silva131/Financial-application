    package com.finance.financialaccount.model;

    import jakarta.persistence.*;
    import jakarta.validation.constraints.NotBlank;

    import java.math.BigDecimal;

@Entity
@Table(name = "contas")
public class Conta {

    public Conta () {

    }

    Conta(String nome, BigDecimal saldoConta, BigDecimal saldoCredito, Usuario usuario) {
        this.nome = nome;
        this.saldoConta = saldoConta;
        this.saldoCredito = saldoCredito;
        this.usuario = usuario;
    }

    public Conta(Usuario usuario, String nome) {
        this.usuario = usuario;
        this.nome = nome;
        calcularSaldoInicial();
    }

    void calcularSaldoInicial() {
        this.saldoConta = BigDecimal.ZERO;
        this.saldoCredito = BigDecimal.ZERO;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_conta", nullable = false)
    private String nome;

    @Column(name = "saldo_conta")
    private BigDecimal saldoConta;

    @Column(name = "saldo_credito")
    private BigDecimal saldoCredito;

    @Version
    private Long version;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(BigDecimal saldoConta) {
        this.saldoConta = saldoConta;
    }

    public BigDecimal getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(BigDecimal saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
