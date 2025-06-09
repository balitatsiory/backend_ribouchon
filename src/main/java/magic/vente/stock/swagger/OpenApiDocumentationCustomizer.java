package magic.vente.stock.swagger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static magic.vente.stock.fixtures.ItemResponseFixture.itemRetrieveResponse;
import static magic.vente.stock.fixtures.ItemResponseFixture.itemRetrieveResponseRetrieveManyResponse;


@OpenAPIDefinition(
        info = @Info(
                title = "Magic Vente Stock API Documentation",
                version = "0.0.1"
        )
)
@Configuration
public class OpenApiDocumentationCustomizer {

    @Bean
    public OpenAPI openAPI(ServletContext servletContext){
        Server server = new Server().url(servletContext.getContextPath());
        return new OpenAPI().addServersItem(server);
    }

    @Bean
    public OpenApiCustomizer itemResponseDocumentationCustomizer() {
        ObjectMapper objectMapper = new ObjectMapper();
        return openApi -> {
            try {
                openApi.getPaths().get("/items")
                        .getGet()
                        .getResponses()
                        .get("200")
                        .getContent()
                        .computeIfAbsent("application/json", key -> new io.swagger.v3.oas.models.media.MediaType())
                        .addExamples("SUCCESS",new Example().value(
                                objectMapper.writeValueAsString(
                                        itemRetrieveResponseRetrieveManyResponse
                                )));

                openApi.getPaths().get("/items/dailyItem")
                        .getGet()
                        .getResponses()
                        .get("200")
                        .getContent()
                        .computeIfAbsent("application/json", key -> new io.swagger.v3.oas.models.media.MediaType())
                        .addExamples("SUCCESS", new Example().value(
                                objectMapper.writeValueAsString(
                                        itemRetrieveResponse
                                        )));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };
    }
}