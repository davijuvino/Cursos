# SringBoot - devDojo


# injeção de dependência
  - Injeção de dependências (Dependency Injection - DI) é um tipo de inversão de controle (Inversion of Control - IoC) que dá nome ao processo de prover instâncias de classes que um objeto precisa para funcionar 
  
  - @Component: é um estereótipo genérico para qualquer componente gerenciado pelo Spring;
  - @Service faz anotações de classes na camada de serviço;
  - @Repository anota classes na camada de persistência, que atuará como um repositório de banco de dados;
  - @Autowired indica um ponto aonde a injeção automática deve ser aplicada. Esta pode ser usada em métodos, atributos e construtores


  - @Componente Podemos usar o @Component no aplicativo para marcar os beans como componentes gerenciados do Spring. O Spring apenas registra beans com @Component sem procurar por @Service e @Repository os quais são registrados no ApplicationContext porque são anotados com @Component

  - @Repositório O @Repository tem como objetivo criar beans para a parte de persistência, além de capturar exceções específicas de persistência e repeti-las novamente como uma das exceções não verificadas e unificadas do Spring.

  - @Service Marcamos beans com @Service para indicar que ele está mantendo a lógica de negócios. Não há outra especialidade, além do uso na camada de serviço. 


  - @SpringBootApplication utilizar-se de varias classes para configurar de inicializar uma aplicação.
   - Exemplo @component já está dentro desta classe.       


# Method RestFull

  - OPTIONS 	Retorna os verbos http de um resource e outras opções, como CORS, por exemplo.
  - GET	      Busca um resource
  - HEAD	    Busca apenas o header de um resource
  - PUT	      Atualiza um resource
  - POST	    Cria um resource
  - DELETE	  Remove um resource
  - PATCH	    Atualiza parcialmente um resource

  - Referencia: https://www.brunobrito.net.br/api-restful-boas-praticas/    
  - Referencia de implementação e pontos como Idempotent seção 8.1.2: https://datatracker.ietf.org/doc/html/rfc7231  

# MapStruct
  - Como simplificar mapeamento de DTOs em Java
  - Referencia: https://pt.linkedin.com/pulse/mapstruct-como-simplificar-mapeamento-de-dtos-em-java-de-souza-bueno

# ModelMapper
  - Referencia: https://www.alura.com.br/artigos/mapeando-objeto-para-objeto-com-modelmapper      


# RequestParam
  - Referencia: https://www.baeldung.com/spring-request-param  


# Exceções
  - Referencia: https://reflectoring.io/spring-boot-exception-handling/  


# @Transactional
  - Referencia: https://thorben-janssen.com/transactions-spring-data-jpa/


# Validação
  - Referencia: https://www.zup.com.br/blog/spring-validation-o-que-e

# Handler para validação de campos
  - Referencia: http://davifelipe.com.br/spring-boot-validation
  - Referencia: https://www.youtube.com/watch?v=tRb_OscShmc&list=PL62G310vn6nFBIxp6ZwGnm8xMcGE3VA5H&index=22
  - Referencia de retornos: https://www.javatips.net/api/org.springframework.validation.fielderror  