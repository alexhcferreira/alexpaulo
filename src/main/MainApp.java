package main;

import dao.*;
import model.*;
import util.InputUtil;

import java.time.LocalDate;

public class MainApp {

    public static void main(String[] args) {
        PessoaDAO pessoaDAO = new PessoaDAO();
        EscolaDAO escolaDAO = new EscolaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CursoDAO cursoDAO = new CursoDAO();
        TurmaDAO turmaDAO = new TurmaDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO();
        VidaAcademicaDAO vidaAcademicaDAO = new VidaAcademicaDAO();
        RegistroProfessorDAO registroProfessorDAO = new RegistroProfessorDAO();
        RegistroDescricaoDAO registroDescricaoDAO = new RegistroDescricaoDAO();

        int opcao;
        do {
            System.out.println("\n========= MENU PRINCIPAL =========");
            System.out.println("1. CRUD Pessoa");
            System.out.println("2. CRUD Escola");
            System.out.println("3. CRUD Usuario");
            System.out.println("4. CRUD Curso");
            System.out.println("5. CRUD Turma");
            System.out.println("6. CRUD Aluno");
            System.out.println("7. CRUD AlunoTurma");
            System.out.println("8. CRUD Vida Academica");
            System.out.println("9. CRUD Registro Professor");
            System.out.println("10. CRUD RegistroDescricao");
            System.out.println("0. Sair");
            opcao = InputUtil.lerInt("Escolha uma opção");

            switch (opcao) {
                case 1:
                    int opPessoa;
                    do {
                        System.out.println("\n--- CRUD DE PESSOAS ---");
                        System.out.println("1. Cadastrar Pessoa");
                        System.out.println("2. Listar Pessoas");
                        System.out.println("3. Buscar Pessoa por ID");
                        System.out.println("4. Atualizar Pessoa");
                        System.out.println("5. Remover Pessoa");
                        System.out.println("0. Voltar ao menu principal");
                        opPessoa = InputUtil.lerInt("Opção");

                        if (opPessoa == 1) {
                            String nome = InputUtil.lerString("Nome");
                            LocalDate nascimento = InputUtil.lerData("Data de Nascimento");
                            String telefone = InputUtil.lerString("Telefone");
                            String login = InputUtil.lerString("Login");
                            String senha = InputUtil.lerString("Senha");
                            Pessoa nova = new Pessoa(nome, nascimento, telefone, login, senha);
                            pessoaDAO.adicionar(nova);
                            System.out.println("Pessoa cadastrada com sucesso.");
                        } else if (opPessoa == 2) {
                            for (Pessoa p : pessoaDAO.listarTodos()) {
                                System.out.println("ID: " + p.getId());
                                System.out.println("Nome: " + p.getNome());
                                System.out.println("Nascimento: " + p.getNascimento());
                                System.out.println("Telefone: " + p.getTelefone());
                                System.out.println("Data de Criação: " + p.getDataCriacao());
                                System.out.println("Última Modificação: " + p.getDataModificacao());
                                System.out.println("-------------------------------------");
                            }

                        } else if (opPessoa == 3) {
                            Pessoa p = pessoaDAO.buscarPorId(InputUtil.lerInt("ID"));
                            if (p != null) {
                                System.out.println("ID: " + p.getId());
                                System.out.println("Nome: " + p.getNome());
                                System.out.println("Nascimento: " + p.getNascimento());
                                System.out.println("Telefone: " + p.getTelefone());
                                System.out.println("Login: " + p.getLogin());
                            } else {
                                System.out.println("Pessoa não encontrada.");
                            }
                        } else if (opPessoa == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            Pessoa p = pessoaDAO.buscarPorId(id);
                            if (p != null) {
                                p.setNome(InputUtil.lerString("Novo nome"));
                                p.setNascimento(InputUtil.lerData("Nova data nascimento"));
                                p.setTelefone(InputUtil.lerString("Novo telefone"));
                                p.setLogin(InputUtil.lerString("Novo login"));
                                p.setSenha(InputUtil.lerString("Nova senha"));
                                pessoaDAO.atualizar(p);
                                System.out.println("Pessoa atualizada.");
                            } else {
                                System.out.println("Pessoa não encontrada.");
                            }
                        } else if (opPessoa == 5) {
                            if (pessoaDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Pessoa removida.");
                            } else {
                                System.out.println("Pessoa não encontrada.");
                            }
                        }
                    } while (opPessoa != 0);
                    break;

                case 2:
                    int opEscola;
                    do {
                        System.out.println("\n--- CRUD DE ESCOLAS ---");
                        System.out.println("1. Cadastrar Escola");
                        System.out.println("2. Listar Escolas");
                        System.out.println("3. Buscar Escola por ID");
                        System.out.println("4. Atualizar Escola");
                        System.out.println("5. Remover Escola");
                        System.out.println("0. Voltar ao menu principal");
                        opEscola = InputUtil.lerInt("Opção");

                        if (opEscola == 1) {
                            int id = InputUtil.lerInt("ID");
                            String nome = InputUtil.lerString("Nome");
                            String cidade = InputUtil.lerString("Cidade");
                            String telefone = InputUtil.lerString("Telefone");
                            Escola nova = new Escola(id, nome, cidade, telefone);
                            escolaDAO.adicionar(nova);
                            System.out.println("Escola cadastrada com sucesso.");
                        } else if (opEscola == 2) {
                            for (Escola e : escolaDAO.listarTodos()) {
                                System.out.println("ID: " + e.getId() + " | Nome: " + e.getNome());
                            }
                        } else if (opEscola == 3) {
                            Escola e = escolaDAO.buscarPorId(InputUtil.lerInt("ID"));
                            if (e != null) {
                                System.out.println("ID: " + e.getId());
                                System.out.println("Nome: " + e.getNome());
                                System.out.println("Cidade: " + e.getCidade());
                                System.out.println("Telefone: " + e.getTelefone());
                            } else {
                                System.out.println("Escola não encontrada.");
                            }
                        } else if (opEscola == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            Escola e = escolaDAO.buscarPorId(id);
                            if (e != null) {
                                e.setNome(InputUtil.lerString("Novo nome"));
                                e.setCidade(InputUtil.lerString("Nova cidade"));
                                e.setTelefone(InputUtil.lerString("Novo telefone"));
                                escolaDAO.atualizar(e);
                                System.out.println("Escola atualizada.");
                            } else {
                                System.out.println("Escola não encontrada.");
                            }
                        } else if (opEscola == 5) {
                            if (escolaDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Escola removida.");
                            } else {
                                System.out.println("Escola não encontrada.");
                            }
                        }
                    } while (opEscola != 0);
                    break;

                case 3:
                    // CRUD Usuario
                    int opUsuario;
                    do {
                        System.out.println("\n--- CRUDD DE USUÁRIOS ---");
                        System.out.println("1. Cadastrar");
                        System.out.println("2. Listar");
                        System.out.println("3. Buscar por ID");
                        System.out.println("4. Atualizar");
                        System.out.println("5. Remover");
                        System.out.println("0. Voltar");
                        opUsuario = InputUtil.lerInt("Opção");

                        if (opUsuario == 1) {
                            int id = InputUtil.lerInt("ID");
                            int pessoaId = InputUtil.lerInt("ID da Pessoa");
                            int escolaId = InputUtil.lerInt("ID da Escola");
                            String tipo = InputUtil.lerString("Tipo (adm_geral, adm_escola, funcionario, professor)");
                            Pessoa pessoa = pessoaDAO.buscarPorId(pessoaId);
                            Escola escola = escolaDAO.buscarPorId(escolaId);
                            Usuario u = new Usuario(id, pessoa, escola, tipo);
                            usuarioDAO.adicionar(u);
                        } else if (opUsuario == 2) {
                            for (Usuario u : usuarioDAO.listarTodos()) {
                                System.out.println("ID: " + u.getId() + " | Pessoa: " + (u.getPessoa() != null ? u.getPessoa().getNome() : "") + " | Tipo: " + u.getTipo());
                            }
                        } else if (opUsuario == 3) {
                            Usuario u = usuarioDAO.buscarPorId(InputUtil.lerInt("ID"));
                            System.out.println(u != null ? u.getTipo() : "Não encontrado");
                        } else if (opUsuario == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            Usuario u = usuarioDAO.buscarPorId(id);
                            if (u != null) {
                                int pessoaId = InputUtil.lerInt("ID da nova Pessoa");
                                int escolaId = InputUtil.lerInt("ID da nova Escola");
                                u.setPessoa(pessoaDAO.buscarPorId(pessoaId));
                                u.setEscola(escolaDAO.buscarPorId(escolaId));
                                u.setTipo(InputUtil.lerString("Novo tipo"));
                                usuarioDAO.atualizar(u);
                            }
                        } else if (opUsuario == 5) {
                            usuarioDAO.remover(InputUtil.lerInt("ID para remover"));
                        }
                    } while (opUsuario != 0);
                    break;
                case 4:
                    // CRUD Curso
                    int opCurso;
                    do {
                        System.out.println("\n--- CRUD DE CURSOS ---");
                        System.out.println("1. Cadastrar");
                        System.out.println("2. Listar");
                        System.out.println("3. Buscar por ID");
                        System.out.println("4. Atualizar");
                        System.out.println("5. Remover");
                        System.out.println("0. Voltar");
                        opCurso = InputUtil.lerInt("Opção");

                        if (opCurso == 1) {
                            int id = InputUtil.lerInt("ID");
                            String nome = InputUtil.lerString("Nome");
                            String sigla = InputUtil.lerString("Sigla");
                            String tipo = InputUtil.lerString("Tipo");
                            Curso c = new Curso(id, nome, sigla, tipo);
                            cursoDAO.adicionar(c);
                        } else if (opCurso == 2) {
                            for (Curso c : cursoDAO.listarTodos()) {
                                System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome());
                            }
                        } else if (opCurso == 3) {
                            Curso c = cursoDAO.buscarPorId(InputUtil.lerInt("ID"));
                            System.out.println(c != null ? c.getNome() : "Não encontrado");
                        } else if (opCurso == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            Curso c = cursoDAO.buscarPorId(id);
                            if (c != null) {
                                c.setNome(InputUtil.lerString("Novo nome"));
                                c.setSigla(InputUtil.lerString("Nova sigla"));
                                c.setTipo(InputUtil.lerString("Novo tipo"));
                                cursoDAO.atualizar(c);
                            }
                        } else if (opCurso == 5) {
                            cursoDAO.remover(InputUtil.lerInt("ID para remover"));
                        }
                    } while (opCurso != 0);
                    break;
                case 5:
                    int opTurma;
                    do {
                        System.out.println("\n--- CRUD DE TURMAS ---");
                        System.out.println("1. Cadastrar Turma");
                        System.out.println("2. Listar Turmas");
                        System.out.println("3. Buscar Turma por ID");
                        System.out.println("4. Atualizar Turma");
                        System.out.println("5. Remover Turma");
                        System.out.println("0. Voltar ao menu principal");
                        opTurma = InputUtil.lerInt("Opção");

                        if (opTurma == 1) {
                            int id = InputUtil.lerInt("ID");
                            String nome = InputUtil.lerString("Nome");
                            int cursoId = InputUtil.lerInt("ID do Curso");
                            int escolaId = InputUtil.lerInt("ID da Escola");
                            String periodo = InputUtil.lerString("Período (ex: 2025-1)");
                            String status = InputUtil.lerString("Status (ativo/inativo)");

                            Curso curso = cursoDAO.buscarPorId(cursoId);
                            Escola escola = escolaDAO.buscarPorId(escolaId);
                            Turma nova = new Turma(id, nome, curso, escola, periodo, status);
                            turmaDAO.adicionar(nova);
                            System.out.println("Turma cadastrada com sucesso.");
                        } else if (opTurma == 2) {
                            for (Turma t : turmaDAO.listarTodos()) {
                                System.out.println("ID: " + t.getId() + " | Nome: " + t.getNome());
                            }
                        } else if (opTurma == 3) {
                            Turma t = turmaDAO.buscarPorId(InputUtil.lerInt("ID"));
                            if (t != null) {
                                System.out.println("ID: " + t.getId());
                                System.out.println("Nome: " + t.getNome());
                                System.out.println("Curso: " + (t.getCurso() != null ? t.getCurso().getNome() : ""));
                                System.out.println("Escola: " + (t.getEscola() != null ? t.getEscola().getNome() : ""));
                                System.out.println("Período: " + t.getPeriodo());
                                System.out.println("Status: " + t.getStatus());
                            } else {
                                System.out.println("Turma não encontrada.");
                            }
                        } else if (opTurma == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            Turma t = turmaDAO.buscarPorId(id);
                            if (t != null) {
                                t.setNome(InputUtil.lerString("Novo nome"));
                                t.setCurso(cursoDAO.buscarPorId(InputUtil.lerInt("Novo ID do Curso")));
                                t.setEscola(escolaDAO.buscarPorId(InputUtil.lerInt("Novo ID da Escola")));
                                t.setPeriodo(InputUtil.lerString("Novo período"));
                                t.setStatus(InputUtil.lerString("Novo status"));
                                turmaDAO.atualizar(t);
                                System.out.println("Turma atualizada.");
                            } else {
                                System.out.println("Turma não encontrada.");
                            }
                        } else if (opTurma == 5) {
                            if (turmaDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Turma removida.");
                            } else {
                                System.out.println("Turma não encontrada.");
                            }
                        }
                    } while (opTurma != 0);
                    break;

                case 6:
                    int opAluno;
                    do {
                        System.out.println("\n--- CRUD DE ALUNOS ---");
                        System.out.println("1. Cadastrar Aluno");
                        System.out.println("2. Listar Alunos");
                        System.out.println("3. Buscar Aluno por ID");
                        System.out.println("4. Atualizar Aluno");
                        System.out.println("5. Remover Aluno");
                        System.out.println("0. Voltar ao menu principal");
                        opAluno = InputUtil.lerInt("Opção");

                        if (opAluno == 1) {
                            int id = InputUtil.lerInt("ID");
                            String cpf = InputUtil.lerString("CPF");
                            String nome = InputUtil.lerString("Nome");
                            LocalDate nascimento = InputUtil.lerData("Nascimento");
                            String telefone = InputUtil.lerString("Telefone");
                            String email = InputUtil.lerString("Email");
                            Aluno novo = new Aluno(id, cpf, nome, nascimento, telefone, email);
                            alunoDAO.adicionar(novo);
                            System.out.println("Aluno cadastrado com sucesso.");
                        } else if (opAluno == 2) {
                            for (Aluno a : alunoDAO.listarTodos()) {
                                System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome());
                            }
                        } else if (opAluno == 3) {
                            Aluno a = alunoDAO.buscarPorId(InputUtil.lerInt("ID"));
                            if (a != null) {
                                System.out.println("ID: " + a.getId());
                                System.out.println("Nome: " + a.getNome());
                                System.out.println("CPF: " + a.getCpf());
                                System.out.println("Nascimento: " + a.getNascimento());
                                System.out.println("Telefone: " + a.getTelefone());
                                System.out.println("Email: " + a.getEmail());
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                        } else if (opAluno == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            Aluno a = alunoDAO.buscarPorId(id);
                            if (a != null) {
                                a.setCpf(InputUtil.lerString("Novo CPF"));
                                a.setNome(InputUtil.lerString("Novo nome"));
                                a.setNascimento(InputUtil.lerData("Nova data de nascimento"));
                                a.setTelefone(InputUtil.lerString("Novo telefone"));
                                a.setEmail(InputUtil.lerString("Novo email"));
                                alunoDAO.atualizar(a);
                                System.out.println("Aluno atualizado.");
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                        } else if (opAluno == 5) {
                            if (alunoDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Aluno removido.");
                            } else {
                                System.out.println("Aluno não encontrado.");
                            }
                        }
                    } while (opAluno != 0);
                    break;

                case 7:
                    int opAlunoTurma;
                    do {
                        System.out.println("\n--- CRUD DE ALUNO X TURMA ---");
                        System.out.println("1. Cadastrar Vínculo");
                        System.out.println("2. Listar Vínculos");
                        System.out.println("3. Buscar Vínculo por ID");
                        System.out.println("4. Atualizar Vínculo");
                        System.out.println("5. Remover Vínculo");
                        System.out.println("0. Voltar ao menu principal");
                        opAlunoTurma = InputUtil.lerInt("Opção");

                        if (opAlunoTurma == 1) {
                            int id = InputUtil.lerInt("ID do vínculo");
                            int alunoId = InputUtil.lerInt("ID do Aluno");
                            int turmaId = InputUtil.lerInt("ID da Turma");

                            Aluno aluno = alunoDAO.buscarPorId(alunoId);
                            Turma turma = turmaDAO.buscarPorId(turmaId);

                            AlunoTurma at = new AlunoTurma(id, aluno, turma);
                            alunoTurmaDAO.adicionar(at);
                            System.out.println("Vínculo criado com sucesso.");
                        } else if (opAlunoTurma == 2) {
                            for (AlunoTurma at : alunoTurmaDAO.listarTodos()) {
                                System.out.println("ID: " + at.getId()
                                        + " | Aluno: " + (at.getAluno() != null ? at.getAluno().getNome() : "")
                                        + " | Turma: " + (at.getTurma() != null ? at.getTurma().getNome() : ""));
                            }
                        } else if (opAlunoTurma == 3) {
                            AlunoTurma at = alunoTurmaDAO.buscarPorId(InputUtil.lerInt("ID do vínculo"));
                            if (at != null) {
                                System.out.println("ID: " + at.getId());
                                System.out.println("Aluno: " + (at.getAluno() != null ? at.getAluno().getNome() : ""));
                                System.out.println("Turma: " + (at.getTurma() != null ? at.getTurma().getNome() : ""));
                            } else {
                                System.out.println("Vínculo não encontrado.");
                            }
                        } else if (opAlunoTurma == 4) {
                            int id = InputUtil.lerInt("ID do vínculo para atualizar");
                            AlunoTurma at = alunoTurmaDAO.buscarPorId(id);
                            if (at != null) {
                                at.setAluno(alunoDAO.buscarPorId(InputUtil.lerInt("Novo ID do Aluno")));
                                at.setTurma(turmaDAO.buscarPorId(InputUtil.lerInt("Novo ID da Turma")));
                                alunoTurmaDAO.atualizar(at);
                                System.out.println("Vínculo atualizado.");
                            } else {
                                System.out.println("Vínculo não encontrado.");
                            }
                        } else if (opAlunoTurma == 5) {
                            if (alunoTurmaDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Vínculo removido.");
                            } else {
                                System.out.println("Vínculo não encontrado.");
                            }
                        }
                    } while (opAlunoTurma != 0);
                    break;

                case 8:
                    int opVida;
                    do {
                        System.out.println("\n--- CRUD DE VIDA ACADÊMICA ---");
                        System.out.println("1. Registrar Ocorrência");
                        System.out.println("2. Listar Ocorrências");
                        System.out.println("3. Buscar Ocorrência por ID");
                        System.out.println("4. Atualizar Ocorrência");
                        System.out.println("5. Remover Ocorrência");
                        System.out.println("0. Voltar ao menu principal");
                        opVida = InputUtil.lerInt("Opção");

                        if (opVida == 1) {
                            int id = InputUtil.lerInt("ID");
                            String tipo = InputUtil.lerString("Tipo (observação, mérito, advertência, etc)");
                            String descricao = InputUtil.lerString("Descrição");
                            VidaAcademica v = new VidaAcademica(id, tipo, descricao);
                            vidaAcademicaDAO.adicionar(v);
                            System.out.println("Ocorrência registrada.");
                        } else if (opVida == 2) {
                            for (VidaAcademica v : vidaAcademicaDAO.listarTodos()) {
                                System.out.println("ID: " + v.getId() + " | Tipo: " + v.getTipo());
                            }
                        } else if (opVida == 3) {
                            VidaAcademica v = vidaAcademicaDAO.buscarPorId(InputUtil.lerInt("ID"));
                            if (v != null) {
                                System.out.println("ID: " + v.getId());
                                System.out.println("Tipo: " + v.getTipo());
                                System.out.println("Descrição: " + v.getDescricao());
                            } else {
                                System.out.println("Ocorrência não encontrada.");
                            }
                        } else if (opVida == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            VidaAcademica v = vidaAcademicaDAO.buscarPorId(id);
                            if (v != null) {
                                v.setTipo(InputUtil.lerString("Novo tipo"));
                                v.setDescricao(InputUtil.lerString("Nova descrição"));
                                vidaAcademicaDAO.atualizar(v);
                                System.out.println("Ocorrência atualizada.");
                            } else {
                                System.out.println("Ocorrência não encontrada.");
                            }
                        } else if (opVida == 5) {
                            if (vidaAcademicaDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Ocorrência removida.");
                            } else {
                                System.out.println("Ocorrência não encontrada.");
                            }
                        }
                    } while (opVida != 0);
                    break;

                case 9:
                    int opRegistro;
                    do {
                        System.out.println("\n--- CRUD DE REGISTRO DO PROFESSOR ---");
                        System.out.println("1. Cadastrar Registro");
                        System.out.println("2. Listar Registros");
                        System.out.println("3. Buscar Registro por ID");
                        System.out.println("4. Atualizar Registro");
                        System.out.println("5. Remover Registro");
                        System.out.println("0. Voltar ao menu principal");
                        opRegistro = InputUtil.lerInt("Opção");

                        if (opRegistro == 1) {
                            int id = InputUtil.lerInt("ID");
                            int professorId = InputUtil.lerInt("ID do Professor (Pessoa)");
                            String disciplina = InputUtil.lerString("Disciplina");
                            String periodo = InputUtil.lerString("Período");
                            int turmaId = InputUtil.lerInt("ID da Turma");
                            String revisao = InputUtil.lerString("Revisão Geral da Turma");

                            Pessoa professor = pessoaDAO.buscarPorId(professorId);
                            Turma turma = turmaDAO.buscarPorId(turmaId);
                            RegistroProfessor r = new RegistroProfessor(id, professor, disciplina, periodo, turma, revisao);
                            registroProfessorDAO.adicionar(r);
                            System.out.println("Registro cadastrado.");
                        } else if (opRegistro == 2) {
                            for (RegistroProfessor r : registroProfessorDAO.listarTodos()) {
                                System.out.println("ID: " + r.getId() + " | Professor: " + (r.getProfessor() != null ? r.getProfessor().getNome() : "") + " | Disciplina: " + r.getDisciplina());
                            }
                        } else if (opRegistro == 3) {
                            RegistroProfessor r = registroProfessorDAO.buscarPorId(InputUtil.lerInt("ID"));
                            if (r != null) {
                                System.out.println("ID: " + r.getId());
                                System.out.println("Professor: " + (r.getProfessor() != null ? r.getProfessor().getNome() : ""));
                                System.out.println("Disciplina: " + r.getDisciplina());
                                System.out.println("Período: " + r.getPeriodo());
                                System.out.println("Turma: " + (r.getTurma() != null ? r.getTurma().getNome() : ""));
                                System.out.println("Revisão: " + r.getRevisaoGeralTurma());
                            } else {
                                System.out.println("Registro não encontrado.");
                            }
                        } else if (opRegistro == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            RegistroProfessor r = registroProfessorDAO.buscarPorId(id);
                            if (r != null) {
                                r.setProfessor(pessoaDAO.buscarPorId(InputUtil.lerInt("Novo ID do Professor")));
                                r.setDisciplina(InputUtil.lerString("Nova disciplina"));
                                r.setPeriodo(InputUtil.lerString("Novo período"));
                                r.setTurma(turmaDAO.buscarPorId(InputUtil.lerInt("Novo ID da Turma")));
                                r.setRevisaoGeralTurma(InputUtil.lerString("Nova revisão"));
                                registroProfessorDAO.atualizar(r);
                                System.out.println("Registro atualizado.");
                            } else {
                                System.out.println("Registro não encontrado.");
                            }
                        } else if (opRegistro == 5) {
                            if (registroProfessorDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Registro removido.");
                            } else {
                                System.out.println("Registro não encontrado.");
                            }
                        }
                    } while (opRegistro != 0);
                    break;

                case 10:
                    int opDesc;
                    do {
                        System.out.println("\n--- CRUD DE OBSERVAÇÕES DO PROFESSOR ---");
                        System.out.println("1. Cadastrar Observação");
                        System.out.println("2. Listar Observações");
                        System.out.println("3. Buscar Observação por ID");
                        System.out.println("4. Atualizar Observação");
                        System.out.println("5. Remover Observação");
                        System.out.println("0. Voltar ao menu principal");
                        opDesc = InputUtil.lerInt("Opção");

                        if (opDesc == 1) {
                            int id = InputUtil.lerInt("ID");
                            int registroId = InputUtil.lerInt("ID do Registro Professor");
                            int alunoId = InputUtil.lerInt("ID do Aluno");
                            String obs = InputUtil.lerString("Observação");

                            RegistroProfessor reg = registroProfessorDAO.buscarPorId(registroId);
                            Aluno aluno = alunoDAO.buscarPorId(alunoId);
                            RegistroDescricao rd = new RegistroDescricao(id, reg, aluno, obs);
                            registroDescricaoDAO.adicionar(rd);
                            System.out.println("Observação cadastrada.");
                        } else if (opDesc == 2) {
                            for (RegistroDescricao rd : registroDescricaoDAO.listarTodos()) {
                                System.out.println("ID: " + rd.getId()
                                        + " | Aluno: " + (rd.getAluno() != null ? rd.getAluno().getNome() : "")
                                        + " | Obs: " + rd.getObservacao());
                            }
                        } else if (opDesc == 3) {
                            RegistroDescricao rd = registroDescricaoDAO.buscarPorId(InputUtil.lerInt("ID"));
                            if (rd != null) {
                                System.out.println("ID: " + rd.getId());
                                System.out.println("Aluno: " + (rd.getAluno() != null ? rd.getAluno().getNome() : ""));
                                System.out.println("Registro: " + (rd.getRegistro() != null ? rd.getRegistro().getDisciplina() : ""));
                                System.out.println("Observação: " + rd.getObservacao());
                            } else {
                                System.out.println("Observação não encontrada.");
                            }
                        } else if (opDesc == 4) {
                            int id = InputUtil.lerInt("ID para atualizar");
                            RegistroDescricao rd = registroDescricaoDAO.buscarPorId(id);
                            if (rd != null) {
                                rd.setRegistro(registroProfessorDAO.buscarPorId(InputUtil.lerInt("Novo ID do Registro")));
                                rd.setAluno(alunoDAO.buscarPorId(InputUtil.lerInt("Novo ID do Aluno")));
                                rd.setObservacao(InputUtil.lerString("Nova observação"));
                                registroDescricaoDAO.atualizar(rd);
                                System.out.println("Observação atualizada.");
                            } else {
                                System.out.println("Observação não encontrada.");
                            }
                        } else if (opDesc == 5) {
                            if (registroDescricaoDAO.remover(InputUtil.lerInt("ID para remover"))) {
                                System.out.println("Observação removida.");
                            } else {
                                System.out.println("Observação não encontrada.");
                            }
                        }
                    } while (opDesc != 0);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
