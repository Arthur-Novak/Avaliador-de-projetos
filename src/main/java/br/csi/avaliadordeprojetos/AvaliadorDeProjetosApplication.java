package br.csi.avaliadordeprojetos;

import br.csi.avaliadordeprojetos.model.aluno.Aluno;
import br.csi.avaliadordeprojetos.model.aluno.AlunoRepository;
import br.csi.avaliadordeprojetos.model.aluno.Endereco;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                title = "API AVALIADOR DE PROJETOS",
                version = "1.0",
                description = "documentação da API AVALIADOR DE PROJETOS",
                contact = @Contact(name = "Suporte", email = "suporte@gmail.com")

        )

)










@SpringBootApplication
public class AvaliadorDeProjetosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvaliadorDeProjetosApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(AlunoRepository repository) {
//        return (args) -> {
//            Endereco en = new Endereco("1345", "Medianeira", "97010340", "11", "Santa Maria", "RS");
//
//            repository.save(new Aluno("jose", "189344", "jose@gmail", en));
//        };
//    }

}
