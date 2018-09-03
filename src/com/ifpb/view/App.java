package com.ifpb.view;

import java.util.Scanner;
import com.ifpb.control.*;
import com.ifpb.model.*;

import java.time.LocalDate;

public class App {
    public static void main(String args[]){
        CadastroFuncionario cadastro = new CadastroFuncionario();
        Scanner ler = new Scanner(System.in);
        while(true){
            System.out.println("App Lanchonete v1.0");
            System.out.println("------------------------------------");
            System.out.println("1 - Login de Usuário");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("Digite o número da opçao desejada: ");
            int opcao = ler.nextInt();
            System.out.println("------------------------------------");
            if(opcao == 1){
                if(cadastro.list().size() == 0){
                    System.out.println("Não é possível fazer login: não há usuários cadastrados. Por favor, realize o cadastro de um funcionário.");
                }
                else{
                    System.out.println("Login: ");
                    String login = ler.next();
                    System.out.println("Senha: ");
                    String senha = ler.next();
                    Funcionario userLogin = cadastro.read(login);
                    if(userLogin != null && userLogin.verifyLogin(login, senha)){
                        System.out.println("Login bem-sucedido!");
                    }
                    else{
                        System.out.println("Login ou senha inválidos...");
                    }
                }
                System.out.println("------------------------------------");
            }
            else{
               System.out.println("Por favor, preencha os campos abaixo:");
               System.out.println("Login: ");
               String login = ler.next();
               System.out.println("Senha: ");
               String senha = ler.next();
               System.out.println("CPF: ");
               String cpf = ler.next();
               System.out.println("Nome: ");
               String nome = ler.next();
               System.out.println("Email: ");
               String email = ler.next();
               System.out.println("Telefone: ");
               String telefone = ler.next();
               System.out.println("Data de nascimento - Ano: ");
               int ano = ler.nextInt();
               System.out.println("Data de nascimento - Mês: ");
               int mes = ler.nextInt();
               System.out.println("Data de nascimento - Dia: ");
               int dia = ler.nextInt();
               System.out.println("Setor (1 - Atendimento, 2 - Cozinha, 3 - Caixa ou 4 - Gerência): ");
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
                           System.out.println("Opção inválida, tente novamente: ");
                           setor = ler.nextInt();
                   }
               }
               Funcionario funcionario1 = new Funcionario(login, senha, cpf, nome, email, telefone, LocalDate.of(ano, mes, dia), s);
               cadastro.create(funcionario1);
               System.out.println("Usuário cadastrado com sucesso!");
            }
        }
    }
}
