# SringBoot - devDojo


# injeção de dependência
  - Injeção de dependências (Dependency Injection - DI) é um tipo de inversão de controle (Inversion of Control - IoC) que dá nome ao processo de prover instâncias de classes que um objeto precisa para funcionar 
  
  - @Component: é um estereótipo genérico para qualquer componente gerenciado pelo Spring;
  - @Service faz anotações de classes na camada de serviço;
  - @Repository anota classes na camada de persistência, que atuará como um repositório de banco de dados;
  - @Autowired indica um ponto aonde a injeção automática deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores


@Componente
    Podemos usar o @Component no aplicativo para marcar os beans como componentes gerenciados do Spring. O Spring apenas registra beans com @Component sem procurar por @Service e @Repository os quais são registrados no ApplicationContext porque são anotados com @Component

@Repositório
    O @Repository tem como objetivo criar beans para a parte de persistência, além de capturar exceções específicas de persistência e repeti-las novamente como uma das exceções não verificadas e unificadas do Spring.

@Service
    Marcamos beans com @Service para indicar que ele está mantendo a lógica de negócios. Não há outra especialidade, além do uso na camada de serviço. 


@SpringBootApplication utilizar-se de varias classes para configurar de inicializar uma aplicação.
   - Exemplo @component já está dentro desta classe.       
