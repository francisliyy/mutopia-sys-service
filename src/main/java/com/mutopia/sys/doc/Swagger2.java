/**
 * <p>Title: Swagger2</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
	
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                .apis(RequestHandlerSelectors.basePackage("com.mutopia.sys"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
    	Contact contact=new Contact("Yingxin Li","","liyx8610@gmail.com");
        return new ApiInfoBuilder()
                 // 文档标题
                .title("妙天业务平台-系统管理服务-API说明文档")
                // 文档描述
                .description("Mutopia System Management Service API")
                .contact(contact)
                .version("v1.0")
                .build();
    }

}
