package com.ifpb.view;

import java.time.Year;
import java.util.List;
import java.util.Scanner;
import com.ifpb.control.*;
import com.ifpb.model.*;

import java.time.LocalDate;

public class App {
    /*public static void main(String args[]){
        GerenciaFuncionario cadastro = new GerenciaFuncionario();
        Cardapio cardapio = new Cardapio();
        Scanner ler = new Scanner(System.in);
        while(true){
            System.out.println(":.:.:.:.:App Lanchonete v1.0:.:.:.:.:");
            System.out.println("-------------------------------------");
            System.out.println("1) Login de Funcionário.");
            System.out.println("2) Cadastrar Funcionário.");
            System.out.println("3) Encerrar programa.");
            System.out.println("> Digite o número da opção desejada: ");
            int opcao = ler.nextInt();
            System.out.println("-------------------------------------");
            if(opcao == 1){
                if(cadastro.list().size() == 0){
                    System.out.println("** Não é possível fazer login: não há usuários cadastrados. Por favor, realize o cadastro de um funcionário. **\n");
                }
                else{
                    System.out.println("> Login: ");
                    String login = ler.next();
                    System.out.println("> Senha: ");
                    String senha = ler.next();
                    Funcionario userLogin = cadastro.read(login);
                    if(userLogin != null && userLogin.verifyLogin(login, senha)){
                        System.out.println("** Login bem-sucedido! **\n");
                        while (true){
                            System.out.println("-------------------------------------");
                            System.out.println("**            Cardápio             **");
                            System.out.println("1) Adicionar item.");
                            System.out.println("2) Buscar item.");
                            System.out.println("3) Atualizar item.");
                            System.out.println("4) Remover item.\n");
                            System.out.println("5) Ver cardápio completo.\n");
                            System.out.println("0) Sair.");
                            System.out.println("> Digite o número da opção desejada: ");
                            int opcaoCardapio = ler.nextInt();
                            if (opcaoCardapio == 0){
                                break;
                            }
                            switch(opcaoCardapio){
                                case 1:
                                    System.out.println("-------------------------------------");
                                    System.out.println("> Por favor, preencha os campos abaixo: ");
                                    System.out.println("> Código do produto: ");
                                    int codigo = ler.nextInt();
                                    while(cardapio.read(codigo) != null){
                                        System.out.println("** Este código já está em uso, escolha outro código: ");
                                        codigo = ler.nextInt();
                                    }
                                    System.out.println("> Preço: ");
                                    double preco = Double.parseDouble(ler.next());
                                    System.out.println("> Nome do produto: ");
                                    String nome = ler.next();
                                    System.out.println("> Descrição do produto: ");
                                    String descricao = ler.next();
                                    System.out.println("> Escolha uma categoria: ");
                                    System.out.println("> Categorias:\n 1) Lanche\n 2) Bebida\n 3) Refeição\n 4) Sobremesa\n");
                                    int categoria = ler.nextInt();
                                    CategoriaProduto cp = null;
                                    while (cp == null) {
                                        switch (categoria) {
                                            case 1:
                                                cp = CategoriaProduto.LANCHE;
                                                break;
                                            case 2:
                                                cp = CategoriaProduto.BEBIDA;
                                                break;
                                            case 3:
                                                cp = CategoriaProduto.REFEICAO;
                                                break;
                                            case 4:
                                                cp = CategoriaProduto.SOBREMESA;
                                                break;
                                            default:
                                                System.out.println("** Opção inválida, tente novamente: ");
                                                categoria = ler.nextInt();
                                        }
                                    }
                                    Produto produto = new Produto(codigo, preco, nome, descricao, cp);
                                    cardapio.create(produto);
                                    System.out.println("** Produto cadastrado com sucesso! **\n");
                                    break;
                                case 2:
                                    System.out.println("-------------------------------------");
                                    if (cardapio.list().size() == 0){
                                        System.out.println("** Ainda não há produtos cadastrados! **");
                                    }
                                    else {
                                        System.out.println("> Digite o código do produto: ");
                                        int codBusca = ler.nextInt();
                                        if(cardapio.read(codBusca) == null){
                                            System.out.println("** Não existe nenhum produto relacionado ao código fornecido. **");
                                        }
                                        else {
                                            Produto produtoBuscado = cardapio.read(codBusca);
                                            System.out.println("| " + produtoBuscado.getCodigo() + " | " + produtoBuscado.getNome() + " | " + produtoBuscado.getDescricao() +
                                                    " | " + produtoBuscado.getCategoria() + " | " + produtoBuscado.getPreco() + " |");
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("-------------------------------------");
                                    if (cardapio.list().size() == 0){
                                        System.out.println("** Ainda não há produtos cadastrados! **");
                                    }
                                    else {
                                        System.out.println("> Digite o código do produto a ser atualizado: ");
                                        int codAtualizar = ler.nextInt();
                                        if(cardapio.read(codAtualizar) == null){
                                            System.out.println("** Não existe nenhum produto relacionado ao código fornecido. **");
                                        }
                                        else {
                                            Produto produtoAtualizado = cardapio.read(codAtualizar);
                                            System.out.println("> Por favor, digite nos campos que deseja atualizar (Digite '0' caso não deseje atualizar o campo): ");
                                            System.out.println("> Preço: ");
                                            double precoAtualizado = Double.parseDouble(ler.next());
                                            System.out.println("> Nome do produto: ");
                                            String nomeAtualizado = ler.next();
                                            System.out.println("> Descrição do produto: ");
                                            String descricaoAtualizada = ler.next();
                                            if (precoAtualizado != 0) {
                                                produtoAtualizado.setPreco(precoAtualizado);
                                            }
                                            if (!nomeAtualizado.equals("0")) {
                                                produtoAtualizado.setNome(nomeAtualizado);
                                            }
                                            if (!descricaoAtualizada.equals("0")) {
                                                produtoAtualizado.setDescricao(descricaoAtualizada);
                                            }
                                            if (cardapio.update(produtoAtualizado)) {
                                                cardapio.update(produtoAtualizado);
                                                System.out.println("** Produto atualizado com sucesso! **");
                                            } else {
                                                System.out.println("** Não foi possivel realizar a atualização. **");
                                            }
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("-------------------------------------");
                                    if (cardapio.list().size() == 0){
                                        System.out.println("** Ainda não há produtos cadastrados! **");
                                    }
                                    else {
                                        System.out.println("> Digite o código do produto a ser removido: ");
                                        int codRemocao = ler.nextInt();
                                        if(cardapio.read(codRemocao) == null){
                                            System.out.println("** Não existe nenhum produto relacionado ao código fornecido. **");
                                        }
                                        else {
                                            if (cardapio.read(codRemocao) != null) {
                                                cardapio.delete(cardapio.read(codRemocao));
                                                System.out.println("** Produto removido com sucesso! **");
                                            } else {
                                                System.out.println("** Não foi possível fazer a remoção, produto não encontrado. **");
                                            }
                                        }
                                    }
                                    break;
                                case 5:
                                    System.out.println("-------------------------------------");
                                    List<Produto> produtos = cardapio.list();
                                    if (produtos.size() == 0){
                                        System.out.println("** Ainda não há produtos cadastrados, portanto o cardápio está vazio! **");
                                    }
                                    else{
                                        for (Produto p: produtos) {
                                            System.out.println("| "+p.getCodigo()+" | "+p.getNome()+" | "+p.getDescricao()+" | "+p.getCategoria()+" | "+p.getPreco()+" |");
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                    else{
                        System.out.println("** Login ou senha inválidos. **\n");
                    }
                }
                System.out.println("-------------------------------------");
            }
            else if (opcao == 2){
                   System.out.println("> Por favor, preencha os campos abaixo:");
                   System.out.println("> Login: ");
                   String login = ler.next();
                   while(cadastro.searchUsername(login)){
                       System.out.println("** Este login já está em uso, escolha outro login: ");
                       login = ler.next();
                   }
                   System.out.println("> Senha: ");
                   String senha = ler.next();
                   System.out.println("> CPF: ");
                   String cpf = ler.next();
                   System.out.println("> Nome: ");
                   String nome = ler.next();
                   System.out.println("> Email: ");
                   String email = ler.next();
                   System.out.println("> Telefone: ");
                   String telefone = ler.next();
                   System.out.println("> Ano de nascimento (formato AAAA): ");
                   int ano = ler.nextInt();
                   while (ano > Year.now().getValue()){
                       System.out.println("** Ano inválido, tente novamente: ");
                       ano = ler.nextInt();
                   }
                   System.out.println("> Mês de nascimento (formato MM): ");
                   int mes = ler.nextInt();
                    while (mes < 1 || mes > 12){
                        System.out.println("** Mês inválido, tente novamente: ");
                        mes = ler.nextInt();
                    }
                   System.out.println("> Dia de nascimento (formato DD): ");
                   int dia = ler.nextInt();
                   while (dia < 1 || dia > 31){
                       System.out.println("** Dia inválido, tente novamente: ");
                       dia = ler.nextInt();
                   }
                   System.out.println("> Escolha um setor: ");
                   System.out.println("> Setores:\n 1) Atendimento\n 2) Cozinha\n 3) Caixa\n 4) Gerência\n");
                   int setor = ler.nextInt();
                   Setor s = null;
                   while (s == null) {
                       switch (setor) {
                           case 1:
                               s = Setor.ATENDIMENTO;
                               break;
                           case 2:
                               s = Setor.COZINHA;
                               break;
                           case 3:
                               s = Setor.CAIXA;
                               break;
                           case 4:
                               s = Setor.GERENCIA;
                               break;
                           default:
                               System.out.println("** Opção inválida, tente novamente: ");
                               setor = ler.nextInt();
                       }
                   }
                   Funcionario funcionario = new Funcionario(login, senha, cpf, nome, email, telefone, LocalDate.of(ano, mes, dia), s);
                   if (cadastro.create(funcionario)) {
                       cadastro.create(funcionario);
                       System.out.println("** Usuário cadastrado com sucesso! **\n");
                   }
                   else{
                       System.out.println("** Não foi possível cadastrar o usuário. **\n");
                   }
                }
            else{
                System.exit(0);
            }
        }
    }*/
}
