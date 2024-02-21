package cgg.springboot.rest.validation.springbootrestvalidation.config;

// import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
  name = "scheme1",
  type = SecuritySchemeType.HTTP,
  bearerFormat = "JWT",
  scheme = "bearer"
)
@OpenAPIDefinition(
  info = @Info(
    title = "Blog API",
    description = "A sample Blog Application",
    version = "v0.0.1",
    license = @License(name = "Apache 2.0", url = "www.cgg.gov.in")
  ),
  externalDocs = @ExternalDocumentation(
    description = "Blog application Documentation description",
    url = "www.cgg.gov.in"
  )
)
public class SwaggerConfig {
  //   @Bean
  //   OpenAPI BlogAppOpenAPI() {
  //     String schemeName = "bearerScheme";
  //     return new OpenAPI()
  //       .addSecurityItem(new SecurityRequirement().addList(schemeName))
  //       .components(
  //         new Components()
  //           .addSecuritySchemes(
  //             "basicScheme",
  //             new SecurityScheme()
  //               .type(SecurityScheme.Type.HTTP)
  //               .bearerFormat("JWT")
  //               .scheme("bearer")
  //           )
  //       )
  //       .info(
  //         new Info()
  //           .title("BlogApplication API")
  //           .description("Blog application")
  //           .version("v0.0.1")
  //           .license(new License().name("Apache 2.0").url("www.cgg.gov.in"))
  //       )
  //       .externalDocs(
  //         new ExternalDocumentation()
  //           .description("Blog application Documentation")
  //           .url("www.cgg.gov.in")
  //       );
  //   }
}
