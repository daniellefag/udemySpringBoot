package com.cursoudemy.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cursoudemy.cursomc.domain.Categoria;
import com.cursoudemy.cursomc.domain.Cidade;
import com.cursoudemy.cursomc.domain.Cliente;
import com.cursoudemy.cursomc.domain.Endereco;
import com.cursoudemy.cursomc.domain.Estado;
import com.cursoudemy.cursomc.domain.ItemPedido;
import com.cursoudemy.cursomc.domain.Pagamento;
import com.cursoudemy.cursomc.domain.PagamentoComBoleto;
import com.cursoudemy.cursomc.domain.PagamentoComCartao;
import com.cursoudemy.cursomc.domain.Pedido;
import com.cursoudemy.cursomc.domain.Produto;
import com.cursoudemy.cursomc.domain.enums.StatusPagamento;
import com.cursoudemy.cursomc.domain.enums.TipoCliente;
import com.cursoudemy.cursomc.repositories.CategoriaRepository;
import com.cursoudemy.cursomc.repositories.CidadeRepository;
import com.cursoudemy.cursomc.repositories.ClienteRepository;
import com.cursoudemy.cursomc.repositories.EnderecoRepository;
import com.cursoudemy.cursomc.repositories.EstadoRepository;
import com.cursoudemy.cursomc.repositories.ItemPedidoRepository;
import com.cursoudemy.cursomc.repositories.PagamentoRepository;
import com.cursoudemy.cursomc.repositories.PedidoRepository;
import com.cursoudemy.cursomc.repositories.ProdutoRepository;

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

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1 , est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12345678912", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12345678", "45784578"));
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "12345678", cli1, c1 );
		Endereco end2 = new Endereco(null, "Avenida Matos", "600", "Sala 800", "Centro", "12345678", cli1, c2 );
		
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1 , end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:30"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2020 13:10"), cli1, end2);
		
		Pagamento pag1 = new PagamentoComCartao(null, StatusPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComBoleto(null, StatusPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pag2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
		ItemPedido item1 = new ItemPedido(ped1, p1, 1, 2000.00, 0.00);
		ItemPedido item2 = new ItemPedido(ped1, p3, 2, 80.00, 0.00);
		ItemPedido item3 = new ItemPedido(ped2, p2, 1, 800.00, 100.00);
		
		ped1.getItens().addAll(Arrays.asList(item1, item2));
		ped2.getItens().addAll(Arrays.asList(item3));
		
		p1.getItens().addAll(Arrays.asList(item1));
		p2.getItens().addAll(Arrays.asList(item3));
		p3.getItens().addAll(Arrays.asList(item2));
		
		itemPedidoRepository.saveAll(Arrays.asList(item1,item2,item3));
	}

}
