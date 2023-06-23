import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Carro> listCarros = new ArrayList<>();

        List<Cor> listCores = new ArrayList<>();

        listCores.add(new Cor("Preto"));
        listCores.add(new Cor("Branco"));
        listCores.add(new Cor("Prata"));
        listCores.add(new Cor("Vermelho"));
        listCores.add(new Cor("Azul"));

        List<TipoCombustível> listTipoCombustivel = new ArrayList<>();

        listTipoCombustivel.add(new TipoCombustível("Gasolina"));
        listTipoCombustivel.add(new TipoCombustível("Diesel"));
        listTipoCombustivel.add(new TipoCombustível("Álcool"));

        Menu(listCarros, listCores, listTipoCombustivel);
    }

    static void Menu(List listCarros, List listCores, List listTipoCombustivel) {
        int op = Opcao();

        while (op != 6) {
            if (op == 1) {
                Cadastrar(listCarros, listCores, listTipoCombustivel);
            } else if (op == 2) {
                Listar(listCarros, listCores, listTipoCombustivel);
            } else if (op == 3) {
                Deletar(listCarros, listCores, listTipoCombustivel);
            } else if (op == 4) {
                AddCor(listCarros, listCores, listTipoCombustivel);
            } else if (op == 5) {
                AddCombustivel(listCarros, listCores, listTipoCombustivel);
            } else if (op == 6) {
                System.out.println("Execução encerrada!");
                System.exit(0);
            } else {
                System.out.printf("\nOpção inválida!\n");
                op = Opcao();
            }
        }

        System.out.println("Execução encerrada!");
        System.exit(0);
    }

    public static int Opcao() {
        Scanner scanner = new Scanner(System.in);

        Integer op = 0;

        while (true) {
            System.out.printf("\n----------OPÇÕES----------\n1 - Cadastrar Carro\n2 - Listar Carros\n3 - Deletar Cadastro\n4 - Cadastrar Cor\n5 - Cadastrar Combustível\n6 - Encerrar Execução\n\nDigite sua opção --> ");

            try {
                op = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.printf("\nNúmero inválido!\n");
            }
        }

        return op;
    }

    static void Cadastrar(List listCarros, List listCores, List listTipoCombustivel) {
        Scanner scanner = new Scanner(System.in);

        List<Cor> listaCores = listCores;
        List<TipoCombustível> listaTipos = listTipoCombustivel;

        System.out.printf("\n----------CORES----------\n");
        listaCores.forEach(cor -> {
            System.out.printf("Código.....: %d\nCor........: %s\n\n", cor.getId(), cor.getNmCor());
        });

        System.out.println("----------COMBUSTÍVEIS----------");
        listaTipos.forEach(tipoCombustível -> {
            System.out.printf("Código..........: %d\nCombustível.....: %s\n\n", tipoCombustível.getId(), tipoCombustível.getNmCombustivel());
        });

        Integer cor = 0;

        while (true) {
            System.out.print("Digite o código da cor do carro --> ");

            try {
                cor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.printf("\nNúmero inválido!\n\n");
            }
        }

        if (cor > listCores.size() || cor < 0) {
            while (cor > listCores.size() || cor < 0) {
                System.out.printf("\nCor inválida!\n");
                while (true) {
                    System.out.print("\nDigite o código da cor do carro --> ");

                    try {
                        cor = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nNúmero inválido!");
                    }
                }
            }
        }

        Integer tipoCombustível = 0;

        while (true) {
            System.out.printf("\nDigite o código do combustível do carro --> ");

            try {
                tipoCombustível = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.printf("\nNúmero inválido!\n");
            }
        }

        if (tipoCombustível > listTipoCombustivel.size() || tipoCombustível < 0) {
            while (tipoCombustível > listTipoCombustivel.size() || tipoCombustível < 0) {
                System.out.printf("\nCombustível inválido!\n");
                while (true) {
                    System.out.printf("\nDigite o código do combustível do carro --> ");

                    try {
                        tipoCombustível = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nNúmero inválido!");
                    }
                }
            }
        }

        String modelo = "";

        while (modelo.isEmpty() || modelo.isBlank() || modelo == null) {
            System.out.printf("\nDigite o modelo do carro --> ");
            modelo = scanner.nextLine();
            if (modelo.isEmpty() || modelo.isBlank() || modelo == null) {
                System.out.printf("\nModelo inválido!\n");
            }
        }

        Integer potencia = 0;

        while (true) {
            System.out.printf("\nDigite a potência do carro --> ");

            try {
                potencia = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.printf("\nNúmero inválido!\n");
            }
        }

        Salvar(listCores, listTipoCombustivel, listCarros, cor, tipoCombustível, modelo, potencia);
    }

    static void Salvar(List listCores, List listTipoCombustivel, List listCarros, Integer cor, Integer tipoCombustível, String modelo, Integer potencia) {
        Scanner scanner = new Scanner(System.in);

        List<Cor> listaCores = listCores;
        List<TipoCombustível> listaTipos = listTipoCombustivel;

        String nmCor = listaCores.get(cor - 1).getNmCor();
        String nmCombustivel = listaTipos.get(tipoCombustível - 1).getNmCombustivel();

        System.out.printf("\nModelo: %s\nCor: %s\nTipo de Combustível: %s\nPotência: %d\n", modelo, nmCor, nmCombustivel, potencia);

        Integer op = 0;

        while (true) {
            System.out.printf("\n----------DESEJA SALVAR O CADASTRO----------\n1 - Sim\n2 - Não\n\nDigite sua opção --> ");

            try {
                op = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.printf("\nNúmero inválido!\n");
            }
        }

        if ((!op.equals(1)) && (!op.equals(2))) {
            while ((!op.equals(1)) && (!op.equals(2))) {
                System.out.printf("\nOpção inválida!\n");
                while (true) {
                    System.out.printf("\n----------DESEJA SALVAR O CADASTRO----------\n1 - Sim\n2 - Não\n\nDigite sua opção --> ");

                    try {
                        op = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nNúmero inválido!");
                    }
                }
                break;
            }
        }

        if (op == 1) {
            listCarros.add(new Carro(nmCor, nmCombustivel, modelo, potencia));
            System.out.println("\nCadastro salvo com sucesso!");
            Menu(listCarros, listCores, listTipoCombustivel);
        } else {
            System.out.println("\nCadastro excluído com sucesso!");
            Menu(listCarros, listCores, listTipoCombustivel);
        }
    }

    static void Listar(List listCarros, List listCores, List listTipoCombustivel) {
        if (listCarros.size() > 0) {
            System.out.printf("\n----------CARROS CADASTRADOS----------\n");
            listCarros.forEach(carro -> {
                System.out.println(carro);
            });
        } else {
            System.out.printf("\nAinda não há carros cadastrados.\n");
        }
        Menu(listCarros, listCores, listTipoCombustivel);
    }

    static void Deletar(List listCarros, List listCores, List listTipoCombustivel) {
        Scanner scanner = new Scanner(System.in);

        List<Carro> listaCarros = listCarros;

        if (listCarros.size() > 0) {
            Integer op = 0;

            while (true) {
                System.out.printf("\nDigite o identificador do cadastro que deseja excluir --> ");

                try {
                    op = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.printf("\nNúmero inválido!\n");
                }
            }

            if (listCarros.size() >= op) {
                Object obj = listCarros.get(op - 1);
                listCarros.remove(obj);

                Integer finalOp = op;

                listaCarros.forEach(carro -> {
                    if (carro.getId() > finalOp) {
                        carro.setId(carro.getId() - 1);
                    }
                    carro.setUltimoId(listaCarros.size());
                });

                System.out.printf("\nCadastro removido com sucesso!\n");
            } else {
                System.out.printf("\nO cadastro em questão não existe!\n");
            }
        } else {
            System.out.printf("\nAinda não há carros cadastrados.\n");
        }
        Menu(listCarros, listCores, listTipoCombustivel);
    }

    static void AddCor(List listCarros, List listCores, List listTipoCombustivel) {
        Scanner scanner = new Scanner(System.in);

        List<Cor> listaObjCores = listCores;
        List<String> listaStringCores = new ArrayList<String>();
        String cor = "";

        System.out.printf("\n----------CORES----------\n");
        listaObjCores.forEach(cores -> {
            System.out.printf("Cor........: %s\n", cores.getNmCor());
            listaStringCores.add(cores.getNmCor());
        });

        while (cor.isEmpty() || cor.isBlank() || cor == null) {
            System.out.printf("\nDigite a cor --> ");
            cor = scanner.nextLine();
            if (cor.isEmpty() || cor.isBlank() || cor == null) {
                System.out.printf("\nCor inválida!\n");
            }
        }

        cor = capitalize(cor);

        if (listaStringCores.contains(cor)) {
            System.out.printf("\nCor já cadastrada!\n");
        } else {
            Object obj = new Cor(cor);
            listCores.add(obj);
            System.out.printf("\nCor cadastrada com sucesso!\n");
        }

        Menu(listCarros, listCores, listTipoCombustivel);
    }

    static void AddCombustivel(List listCarros, List listCores, List listTipoCombustivel) {
        Scanner scanner = new Scanner(System.in);

        List<TipoCombustível> listaObjCombustiveis = listTipoCombustivel;
        List<String> listaStringCombustiveis = new ArrayList<String>();
        String combustivel = "";

        System.out.printf("\n----------COMBUSTÍVEIS----------\n");
        listaObjCombustiveis.forEach(combustiveis -> {
            System.out.printf("Combustível........: %s\n", combustiveis.getNmCombustivel());
            listaStringCombustiveis.add(combustiveis.getNmCombustivel());
        });

        while (combustivel.isEmpty() || combustivel.isBlank() || combustivel == null) {
            System.out.printf("\nDigite o combustível --> ");
            combustivel = scanner.nextLine();
            if (combustivel.isEmpty() || combustivel.isBlank() || combustivel == null) {
                System.out.printf("\nCombustível inválido!\n");
            }
        }

        combustivel = capitalize(combustivel);

        if (listaStringCombustiveis.contains(combustivel)) {
            System.out.printf("\nCombustível já cadastrado!\n");
        } else {
            Object obj = new TipoCombustível(combustivel);
            listTipoCombustivel.add(obj);
            System.out.printf("\nCombustível cadastrado com sucesso!\n");
        }

        Menu(listCarros, listCores, listTipoCombustivel);
    }

    public static String capitalize(String str) {
        if (str == null || str.length() <= 1) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
