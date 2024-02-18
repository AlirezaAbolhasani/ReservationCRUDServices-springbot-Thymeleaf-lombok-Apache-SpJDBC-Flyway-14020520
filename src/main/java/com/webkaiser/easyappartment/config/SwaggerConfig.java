package com.webkaiser.easyappartment.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


/**
 * *Developer: ALireza Abolhasani
 * 8/18/2023
 * 3:02 AM
 **/

@Configuration
@EnableSwagger2
@EnableWebMvc
//@Import(SpringDataRestConfiguration.class)
//@ConfigurationProperties("app.api")
//@ConditionalOnProperty(name="app.api.swagger.enable", havingValue = "true", matchIfMissing = false)
public class SwaggerConfig {

//    private String version;
//    private String title;
//    private String description;
//    private String basePackage;
//    private String contactName;
//    private String contactEmail;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
//                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
//                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
//                .apiInfo(apiInfo())
                ;
    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title(title)
//                .description(description)
//                .version(version)
//                .contact(new Contact(contactName, null, contactEmail))
//                .build();
//    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
