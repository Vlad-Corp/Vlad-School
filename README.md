# **VladSchool**
A VladSchool é uma escola tecnológica diferenciada para mentes ousadas que querem entender como o poder, o dinheiro e a informação realmente circulam no mundo. Aqui, os alunos estudam programação avançada, sistemas financeiros obscuros e estratégias pouco convencionais. Nossos cursos exploram os bastidores da tecnologia e da economia, indo muito além do que escolas comuns ensinam. Discrição, inteligência e criatividade são qualidades essenciais para quem estuda aqui. Na VladSchool, aprender significa descobrir como manipular o jogo — sem nunca aparecer no tabuleiro.

A VladSchool é patrocinada pela VladBet, pertencente a empresa multibilionária VladCorp.


Repositório: github.com/Vlad-Corp/Vlad-School
Figma: figma.com/design/wK8pxeAciYXFXg31MyGbKJ/VladSchool
(há duas páginas no Figma: o Design System e as Páginas)


## Integrantes
- [Davi Liu](https://github.com/Davi-O-Belo)
- [Julia Watanabe](https://github.com/juwata)
- [Lucas Cayres](https://github.com/Lucas-Cayres-Porto)
- [Nicolas Vlad](https://github.com/Nicolas25vlad)
- [Verena Marostica](https://github.com/Verena1302)

## Diferencias
- Layout responsivo
- Mensagem de aprovação/reprovação baseada na média
- Histórico de observações
- Recuperação de senha
- Dashboard para professores

## Linguagens
- HTML: front-end
- CSS: estilização
- JavaScript: conexão do back com front
- Java: classes e objetos/conexão com banco
- MongoDB: banco de dados


----

# Sistema
- O sistema da escola foi projetado para suprir as necessidades dos alunos e professores, além de oferecer uma visão ampla para o administrador.
- o projeto está dividido em duas partes, front-end e back-end
- o design e paleta foram inspirados nos produtos da VladCorp


# Funcionamento
### Alunos
- ver notas
- ver observações

### Professores
- adicionar notas
- editar notas
- adicionar observações
- editar observações
- excluir as suas observações
- ver dashboard

### Administrador
- adicionar notas
- editar notas
- adicionar professores
- editar professores
- excluir professores
- adicionar observações
- editar observações
- excluir as suas observações
- ver dashboard


# Estrutura
```
├── 📁 Back-End
│   ├── 📁 .mvn
│   ├── 📁 .smarttomcat
│   ├── 📁 src
│   │   └── 📁 main
│   │       ├── 📁 JavaScript
│   │       │   ├── 📁 code
│   │       │   │   ├── 📁 adm
│   │       │   │   │   ├── 📄 Adm.js
│   │       │   │   │   ├── 📄 ConnectionAdm.js
│   │       │   │   │   └── 📄 teste.js
│   │       │   │   ├── 📁 aluno
│   │       │   │   │   ├── 📄 Aluno.js
│   │       │   │   │   ├── 📄 ConecctionAluno.js
│   │       │   │   │   ├── 📄 Notas.js
│   │       │   │   │   ├── 📄 NotasMostrar.js
│   │       │   │   │   ├── 📄 Observacoes.js
│   │       │   │   │   ├── 📄 Usuario.js
│   │       │   │   │   ├── 📄 stud.js
│   │       │   │   │   └── 📄 teste.js
│   │       │   │   ├── 📁 disciplina
│   │       │   │   │   ├── 📄 ConnectionDisciplina.js
│   │       │   │   │   ├── 📄 Disciplina.js
│   │       │   │   │   ├── 📄 Disciplinas.js
│   │       │   │   │   └── 📄 testeDs.js
│   │       │   │   ├── 📁 html
│   │       │   │   │   ├── 📁 dashboard
│   │       │   │   │   │   ├── 🎨 dashboard.css
│   │       │   │   │   │   ├── 🌐 dashboard.html
│   │       │   │   │   │   ├── 📄 dashboard.js
│   │       │   │   │   │   └── 📄 renderAluno.js
│   │       │   │   │   └── 📁 email
│   │       │   │   │       ├── 🎨 codigo.css
│   │       │   │   │       ├── 🌐 codigo.html
│   │       │   │   │       ├── 📄 codigo.js
│   │       │   │   │       ├── 🎨 enviarEmail.css
│   │       │   │   │       ├── 🌐 enviarEmail.html
│   │       │   │   │       ├── 📄 enviarEmail.js
│   │       │   │   │       ├── 🎨 novaSenha.css
│   │       │   │   │       ├── 🌐 novaSenha.html
│   │       │   │   │       └── 📄 novaSenha.js
│   │       │   │   └── 📁 professor
│   │       │   │       ├── 📄 ConecctionProfessor.js
│   │       │   │       ├── 📄 Professor.js
│   │       │   │       ├── 📄 Usuario.js
│   │       │   │       ├── 📄 teste.js
│   │       │   │       └── 📄 teste2.js
│   │       │   └── ⚙️ temp.json
│   │       ├── 📁 java
│   │       │   ├── 📁 conexao
│   │       │   │   └── ☕ Conectar.java
│   │       │   ├── 📁 controller
│   │       │   │   ├── 📁 adm
│   │       │   │   │   ├── ☕ AtualizarAdm.java
│   │       │   │   │   ├── ☕ EmailAdm.java
│   │       │   │   │   ├── ☕ ExibirAdm.java
│   │       │   │   │   ├── ☕ LogarAdm.java
│   │       │   │   │   └── ☕ RecuperarAdm.java
│   │       │   │   ├── 📁 aluno
│   │       │   │   │   ├── ☕ AtualizarAluno.java
│   │       │   │   │   ├── ☕ CriarAluno.java
│   │       │   │   │   ├── ☕ DeletarAluno.java
│   │       │   │   │   ├── ☕ EmailAluno.java
│   │       │   │   │   ├── ☕ ExibirAluno.java
│   │       │   │   │   ├── ☕ LogarAluno.java
│   │       │   │   │   └── ☕ RecuperarAluno.java
│   │       │   │   ├── 📁 disciplina
│   │       │   │   │   ├── ☕ AtualizarDisciplina.java
│   │       │   │   │   ├── ☕ CriarDisciplina.java
│   │       │   │   │   ├── ☕ DeletarDisciplina.java
│   │       │   │   │   └── ☕ ExibirDisciplina.java
│   │       │   │   └── 📁 professor
│   │       │   │       ├── ☕ AtualizarProfessor.java
│   │       │   │       ├── ☕ CriarProfessor.java
│   │       │   │       ├── ☕ DeletarProfessor.java
│   │       │   │       ├── ☕ EmailProfessor.java
│   │       │   │       ├── ☕ EnviarObservacaoProfessor.java
│   │       │   │       ├── ☕ ExibirProfessor.java
│   │       │   │       ├── ☕ LogarProfessor.java
│   │       │   │       └── ☕ RecuperarProfessor.java
│   │       │   ├── 📁 dao
│   │       │   │   ├── ☕ AdmDAO.java
│   │       │   │   ├── ☕ AlunosDAO.java
│   │       │   │   ├── ☕ DisciplinaDAO.java
│   │       │   │   ├── ☕ ProfessorDAO.java
│   │       │   │   └── ☕ UsuariosDAO.java
│   │       │   ├── 📁 filters
│   │       │   │   └── ☕ CorsFilter.java
│   │       │   ├── 📁 model
│   │       │   │   ├── ☕ Adm.java
│   │       │   │   ├── ☕ Aluno.java
│   │       │   │   ├── ☕ Disciplinas.java
│   │       │   │   ├── ☕ Notas.java
│   │       │   │   ├── ☕ Observacoes.java
│   │       │   │   ├── ☕ Professor.java
│   │       │   │   └── ☕ Usuario.java
│   │       │   ├── 📁 testes
│   │       │   │   ├── ☕ Teste.java
│   │       │   │   ├── ☕ TesteAlterar.java
│   │       │   │   ├── ☕ TesteBusca.java
│   │       │   │   └── ☕ TesteConexao.java
│   │       │   └── 📁 util
│   │       │       ├── ☕ Email.java
│   │       │       ├── ☕ Env.java
│   │       │       ├── ☕ ExceptionHandler.java
│   │       │       └── ☕ JsonLoader.java
│   │       ├── 📁 mongoDB
│   │       │   ├── ⚙️ collectionDisciplina.json
│   │       │   └── ⚙️ collectionUsuarios.json
│   │       ├── 📁 resources/
│   │       └── 📁 webapp
│   │           ├── 📁 WEB-INF
│   │           │   └── ⚙️ web.xml
│   │           └── 📄 index.jsp
│   ├── ⚙️ .gitignore
│   ├── 📄 LICENSE
│   ├── 📄 mvnw
│   ├── 📄 mvnw.cmd
│   └── ⚙️ pom.xml
├── 📁 Front-End
│   ├── 📁 assets
│   │   ├── 📁 icons/...
│   │   └── 📁 images/...
│   ├── 📁 pages
│   │   ├── 📁 adm
│   │   │   ├── 🌐 choose.html
│   │   │   ├── 🌐 chooseNotas.html
│   │   │   ├── 🌐 chooseObservations.html
│   │   │   ├── 🌐 dashboard.html
│   │   │   ├── 🌐 grade.html
│   │   │   ├── 🌐 observations.html
│   │   │   ├── 🌐 pre-obs.html
│   │   │   ├── 🌐 prof.html
│   │   │   ├── 🌐 students.html
│   │   │   └── 🌐 teachers.html
│   │   ├── 📁 html
│   │   │   ├── 📁 dashboard
│   │   │   │   ├── 🎨 dashboard.css
│   │   │   │   ├── 🌐 dashboard.html
│   │   │   │   ├── 📄 dashboard.js
│   │   │   │   └── 📄 renderAluno.js
│   │   │   └── 📁 email
│   │   │       ├── 🎨 codigo.css
│   │   │       ├── 🌐 codigo.html
│   │   │       ├── 📄 codigo.js
│   │   │       ├── 🎨 enviarEmail.css
│   │   │       ├── 🌐 enviarEmail.html
│   │   │       ├── 📄 enviarEmail.js
│   │   │       ├── 🎨 novaSenha.css
│   │   │       ├── 🌐 novaSenha.html
│   │   │       └── 📄 novaSenha.js
│   │   ├── 📁 prof
│   │   │   ├── 🌐 choose.html
│   │   │   ├── 🌐 chooseNotas.html
│   │   │   ├── 🌐 chooseObservations.html
│   │   │   ├── 🌐 dashboard.html
│   │   │   ├── 🌐 grade.html
│   │   │   ├── 🌐 observations.html
│   │   │   └── 🌐 pre-obs.html
│   │   ├── 📁 stud
│   │   │   ├── 🌐 grade.html
│   │   │   └── 🌐 observations.html
│   │   ├── 🌐 codigo.html
│   │   ├── 🌐 dashboard.html
│   │   ├── 🌐 enviarEmail.html
│   │   ├── 🌐 login.html
│   │   ├── 🌐 novaSenha.html
│   │   ├── 🌐 signup.html
│   │   ├── 🌐 terms.html
│   │   └── 🌐 welcome.html
│   ├── 📁 scripts
│   │   ├── 📁 adm
│   │   │   ├── 📄 dicipline.js
│   │   │   ├── 📄 students.js
│   │   │   └── 📄 teachers.js
│   │   ├── 📁 code
│   │   │   ├── 📁 adm
│   │   │   │   └── 📄 ConecctionAdm.js
│   │   │   ├── 📁 aluno
│   │   │   │   ├── 📄 ConecctionAluno.js
│   │   │   │   └── 📄 teste.js
│   │   │   ├── 📁 disciplina
│   │   │   │   ├── 📄 ConnectionDisciplina.js
│   │   │   │   └── 📄 testeDs.js
│   │   │   ├── 📁 model
│   │   │   │   ├── 📄 Adm.js
│   │   │   │   ├── 📄 Aluno.js
│   │   │   │   ├── 📄 AlunoAdm.js
│   │   │   │   ├── 📄 Disciplina.js
│   │   │   │   ├── 📄 Notas.js
│   │   │   │   ├── 📄 NotasMostrar.js
│   │   │   │   ├── 📄 Observacoes.js
│   │   │   │   ├── 📄 Professor.js
│   │   │   │   └── 📄 Usuario.js
│   │   │   └── 📁 professor
│   │   │       └── 📄 ConecctionProfessor.js
│   │   ├── 📁 nota
│   │   │   └── 📄 editarNota.js
│   │   ├── 📁 observations
│   │   │   ├── 📄 addObservation.js
│   │   │   ├── 📄 editObservation.js
│   │   │   ├── 📄 excludeObsevation.js
│   │   │   └── 📄 observations.js
│   │   ├── 📁 prof
│   │   │   ├── 📄 addProf.js
│   │   │   ├── 📄 chooseProf.js
│   │   │   └── 📄 editProf.js
│   │   ├── 📁 students
│   │   │   ├── 📄 adicionarStudent.js
│   │   │   └── 📄 chooseStudents.js
│   │   ├── 📄 choose.js
│   │   ├── 📄 codigo.js
│   │   ├── 📄 dashboard.js
│   │   ├── 📄 enviarEmail.js
│   │   ├── 📄 forms.js
│   │   ├── 📄 grade.js
│   │   ├── 📄 novaSenha.js
│   │   ├── 📄 popup.js
│   │   ├── 📄 renderAluno.js
│   │   ├── 📄 signup.js
│   │   └── 📄 welcome.js
│   ├── 📁 styles
│   │   ├── 📁 area/...
│   │   ├── 🎨 ...
│   ├── 📄 LICENSE
│   ├── 📝 README.md
│   └── 🌐 index.html
├── 📄 LICENSE
└── 📝 README.md
```

---

# Página de termos

Termos de Uso — VladSchool

Bem-vindo(a) à VladSchool, uma instituição tecnológica que opera alguns passos à frente das universidades comuns — e vários passos à frente das autoridades acadêmicas tradicionais.

Ao criar uma conta, você concorda com os termos abaixo e aceita que está ingressando em um ambiente onde discrição, inteligência e lealdade não são apenas qualidades desejáveis. São requisitos.

1. Aceitação Irrevogável
Ao se registrar na VladSchool, você confirma que leu estes termos e aceita todas as condições estabelecidas.
Caso não concorde, recomendamos fortemente que esqueça imediatamente que esta plataforma existe.

2. Natureza da Instituição
A VladSchool é dedicada ao ensino avançado de tecnologia, estratégia e sistemas econômicos complexos.
Nossos cursos analisam estruturas de poder, fluxos financeiros obscuros e arquiteturas digitais que a maioria das instituições prefere não mencionar.
Para nossos alunos, no entanto, entender o mundo como ele realmente funciona é parte da formação.

3. Identidade do Aluno
A VladSchool aceita qualquer identidade fornecida no cadastro.
Nome verdadeiro, pseudônimo ou algo que soe como um codinome internacional são igualmente aceitos.
Apenas recomendamos que você não esqueça quem decidiu ser aqui dentro.

4. Sigilo Absoluto
Tudo que acontece dentro da VladSchool é estritamente confidencial.

Isso inclui:
- disciplinas e conteúdos ensinados
- algoritmos desenvolvidos em aula
- projetos estratégicos conduzidos por alunos
- a própria existência de certas áreas acadêmicas

Divulgação externa dessas informações será considerada uma quebra grave de confiança institucional.
A VladSchool possui métodos extremamente eficientes para lidar com esse tipo de problema.

5. Desempenho Acadêmico
A VladSchool não forma alunos medianos.

Espera-se que cada estudante demonstre:
- raciocínio estratégico
- discrição
- capacidade de operar sob pressão

Falhar ocasionalmente faz parte do processo de aprendizagem.

Falhar repetidamente em disciplinas fundamentais — como Lavagem de Dinheiro ou Programação Orientada a Apostas — indica falta de preparo para permanecer em um ambiente como este.

Nesses casos, a instituição poderá encerrar permanentemente o vínculo acadêmico do aluno e remover qualquer registro associado à sua participação.

6. Segurança da Plataforma
Tentativas de invadir os sistemas da VladSchool serão analisadas com atenção.

Se a execução for impressionante, talvez você receba uma proposta de trabalho.

Se não for, sua conta será encerrada antes mesmo que você perceba.

7. Remoção de Registros
A VladSchool reserva-se o direito de apagar contas, projetos, registros acadêmicos ou qualquer evidência digital relacionada a um aluno.
Em algumas situações, é como se o aluno nunca tivesse estudado aqui.

8. Atualizações dos Termos
Estes termos podem ser alterados a qualquer momento para acompanhar mudanças tecnológicas, econômicas ou estratégicas.
Os alunos ativos serão informados — se necessário.

9. Declaração Final
Ao criar uma conta na VladSchool, você reconhece que está entrando em uma instituição que valoriza três coisas acima de tudo:

**inteligência, discrição e resultados.**

Aqui, conhecimento abre portas. Algumas delas, honestamente, nunca deveriam ter sido abertas. 🖤
