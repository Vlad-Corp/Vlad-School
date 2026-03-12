# Vlad School
A [VladSchool](https://github.com/Vlad-Corp/Vlad-School) é uma escola tecnológica diferenciada para mentes ousadas que querem entender como o poder, o dinheiro e a informação realmente circulam no mundo. Aqui, os alunos estudam programação avançada, sistemas financeiros obscuros e estratégias pouco convencionais. Nossos cursos exploram os bastidores da tecnologia e da economia, indo muito além do que escolas comuns ensinam. Discrição, inteligência e criatividade são qualidades essenciais para quem estuda aqui. Na VladSchool, aprender significa descobrir como manipular o jogo — sem nunca aparecer no tabuleiro.

A VladSchool é patrocinada pela VladBet, pertencente a empresa multibilionária [VladCorp](https://github.com/Nicolas25vlad/Landing-Page-VladCorp.).

## Diferencias
- Layout responsivo
- Mensagem de aprovação/reprovação baseada na média
- Histórico de observações
- Recuperação de senha
- Dashboard para professores

## Integrantes
Os incríveis desenvolvedores do projeto:
-[Davi Liu](https://github.com/Davi-O-Belo)
-[Julia Watanabe](https://github.com/juwata)
-[Lucas Cayres](https://github.com/Lucas-Cayres-Porto)
-[Nicolas Vlad](https://github.com/Nicolas25vlad)
-[Verena Marostica](https://github.com/Verena1302)

----

# Sistema
O sistema da escola foi projetado para suprir as necessidades dos alunos e professores, além de oferecer uma visão ampla para o administrador.

## Funcionamento

### Alunos
Os alunos poderão ver suas notas e médias do semestre, além de vizualizar as observações, tanto positivas quanto negativas, dos professores.

### Professores
Os professores tem direito de lançar notas, fazer observações, editar e excluir as informações lançadas. Ele também terá acesso a um dashboard que contém quantas notas ainda não foram lançadas, a porcentagem de aprovação, ranking de melhores alunos, alunos em estado crítico e aprovação por turma e semestre.

### Administrador
O Administrador pode ver e editar, notas, observações, e informações pessoais dos alunos e professores, como matrícula, nome, email e senha. O Adm. também tem acesso ao dashboard, mas como o professor, ele só pode vizualizar o dashboard.

## Estrutura
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
