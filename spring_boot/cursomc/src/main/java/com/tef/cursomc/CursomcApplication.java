package com.tef.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tef.cursomc.domain.Categoria;
import com.tef.cursomc.domain.Cidade;
import com.tef.cursomc.domain.Cliente;
import com.tef.cursomc.domain.Endereco;
import com.tef.cursomc.domain.Estado;
import com.tef.cursomc.domain.ItemPedido;
import com.tef.cursomc.domain.Pagamento;
import com.tef.cursomc.domain.PagamentoComBoleto;
import com.tef.cursomc.domain.PagamentoComCartao;
import com.tef.cursomc.domain.Pedido;
import com.tef.cursomc.domain.Produto;
import com.tef.cursomc.domain.enums.EstadoPagamento;
import com.tef.cursomc.domain.enums.TipoCliente;
import com.tef.cursomc.repositories.CategoriaRepository;
import com.tef.cursomc.repositories.CidadeRepository;
import com.tef.cursomc.repositories.ClienteRepository;
import com.tef.cursomc.repositories.EnderecoRepository;
import com.tef.cursomc.repositories.EstadoRepository;
import com.tef.cursomc.repositories.ItemPedidoRepository;
import com.tef.cursomc.repositories.PagamentoRepository;
import com.tef.cursomc.repositories.PedidoRepository;
import com.tef.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//	Criando o banco de dados Automaticamente
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Decoração");
		Categoria cat4 = new Categoria(null,"Cozinha");
		Categoria cat5 = new Categoria(null,"Perfumaria");
		Categoria cat6 = new Categoria(null,"Eletrônicos");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",150.00);
				
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		Estado est3 = new Estado(null,"Santa Catarina");
		
		Cidade c1 = new Cidade (null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c4 = new Cidade(null,"Campinas",est2);
		Cidade c3 = new Cidade(null,"Joinville",est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c4));
		est3.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3,c4));
		
		
		Cliente cli1 = new Cliente(null,"Maria","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("14981050203","14981498410"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 300", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Maro", "105", "Sala 800", "Centro", "38777012", cli1, c2);
	
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		//Mascara de formatação
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		Pedido ped1 = new Pedido(null,simpleDateFormat.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null, simpleDateFormat.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,simpleDateFormat.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedido().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	
		
	}
	
	
	

}
