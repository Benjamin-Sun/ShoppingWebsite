package ssm.configuation;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("ssm")
@EnableTransactionManagement
@Import(RepositoryConfig.class)
public class ApplicationContext {

    @Bean
    public PropertyPlaceholderConfigurer getTestPpc() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("db.properties"));
        return ppc;
    }
}
