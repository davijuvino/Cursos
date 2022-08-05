# SringBoot - devDojo

# Tutorias:
  - https://github.com/joshlong/spring-boot

  
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


# Paginação
  - Referencia: https://www.baeldung.com/rest-api-pagination-in-spring  


# WebMvcConfigurer
  - Configuração global para sobrescrever a quantidade de paginas de retorno e determinar o tamanho

# Sorting, Log SQL
  - Determinando ordem nas paginações desc asc e por pelo campo    

# RestTemplate
 - Referencia: https://www.baeldung.com/rest-template  
 - Referencia: https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
 - https://www.section.io/engineering-education/spring-boot-rest-template/
 - https://jsonplaceholder.typicode.com/

# Sonarqube
 - https://www.youtube.com/watch?v=TNEHX51L9Do
 - https://www.sonarqube.org/
 - https://www.baeldung.com/sonarqube-jacoco-code-coverage
 - https://www.youtube.com/watch?v=zM2DOalHxHY
 - https://www.linkedin.com/pulse/sonarqube-jacoco-configuration-springboot-maven-santosh-kumar-kar
 - https://github.com/SonarSource/sonar-scanning-examples/tree/master/sonarqube-scanner-maven/maven-basic


# Tests
 - https://www.vogella.com/tutorials/JUnit/article.html
 - https://junit.org/junit5/docs/snapshot/user-guide/ 
 - https://github.com/spring-projects/spring-boot/blob/main/spring-boot-project/spring-boot/src/test/java/org/springframework/boot/SpringApplicationTests.java
 - https://thepracticaldeveloper.com/guide-spring-boot-controller-tests/
 - https://github.com/ehizman/bedspaces/tree/main/src/test/java
 - https://reflectoring.io/clean-unit-tests-with-mockito/
 - https://dimitr.im/unit-testing-spring-boot
 - https://programmingtechie.com/2020/10/16/spring-boot-testing-tutorial-unit-testing-with-junit-5-and-mockito/
 
 - SPRING: https://www.tabnine.com/code/java/classes/org.springframework.security.provisioning.InMemoryUserDetailsManager
 - Exemplos: https://www.tabnine.com/code/java

# Tests:
  - @DataJpaTest
  - @Mockito  - https://www.youtube.com/watch?v=fiinSp8CxZs



# SpringSecurity
  - exemplos:
    - Spring REST + Spring Security Example - Mkyong.com - https://mkyong.com/spring-boot/spring-rest-spring-security-example/
    - Integration Testing of Spring MVC Applications: Security - https://www.petrikainulainen.net/programming/spring-framework/integration-testing-of-spring-mvc-applications-security/
    - Spring Security Add Roles to User Examples - https://www.codejava.net/frameworks/spring-boot/spring-security-add-roles-to-user-examples
    - Spring Security JUnit Testing - https://blog.shailendra.dev/spring-security-junit-testing
    - https://github.com/ishailendra/tutorials/tree/master/spring-security-modules
    - Securing a Rest API with Spring Security - OctoPerf - https://octoperf.com/blog/2018/03/08/securing-rest-api-spring-security/#application-bootstrap
    - https://www.programcreek.com/java-api-examples/?api=org.springframework.security.test.context.support.WithMockUser
 - Tests:
    - https://www.tabnine.com/web/assistant/code/rs/5c788f4a49efcb00016f1c5d#L151 
    
# Spring Security - Autenticação em memória
  
  # WebSecurityConfigurerAdapter deprecated
   - Referencia: https://cursos.alura.com.br/forum/topico-websecurityconfigureradapter-deprecated-222772
   - Agora podemos adotar configuração baseada em componentes
   - https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

  # CSRF Token
   - https://portswigger.net/web-security/csrf/tokens
   - AUTOMATIZANDO O TOKEN NO POSTMAN

  # @PreAuthori
   - https://www.baeldung.com/spring-security-method-security

  # @AuthenticationPrincipal
   - Recuperar o usuario autenticado na aplicação e logar com a pagina padrão do sprinboot

  # Autenticação com usuário no banco de dados
   - UseDetails
   - Exemplos de inclusão de registro: https://www.baeldung.com/role-and-privilege-for-spring-security-registration
   - Exemplos de collection authorities https://www.javatips.net/api/org.springframework.security.core.authority.simplegrantedauthority
   - Exemplos https://www.javadevjournal.com/spring-security/spring-security-roles-and-permissions/
   - https://www.toptal.com/spring/spring-security-tut orial
   - Exemplo Role: https://javatechonline.com/how-to-implement-security-in-spring-boot-using-userdetailsservice/
   - Exemplos: https://morioh.com/p/588debc132f2
   - Exemplos: https://javatechonline.com/
   - Exemplos git: https://github.com/orgs/Java-Techie-jt/repositories
   - Exemplo Simples: https://progressivecoder.com/implementing-spring-boot-security-using-userdetailsservice/
   - Exemplos: https://www.javatips.net/
   - Exemplo: migração https://www.appsdeveloperblog.com/migrating-from-deprecated-websecurityconfigureradapter/








# Erros1:
  - (OBJETO DTO SEM O CAMPO ID) cannot deserialize from Object value (no delegate- or property-based Creator in Java  
# Soluções:
  - https://exerror.com/no-creators-like-default-construct-exist-cannot-deserialize-from-object-value-no-delegate-or-property-based-creator/ 


# Erros2:
  - Action:
  - Relying upon circular references is discouraged and they are prohibited by default.  
# Solução:
  - spring.main.allow-circular-references=true
  
# LABORATORIO/LAB01  
