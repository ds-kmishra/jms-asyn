package pd.workshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "pd.workshop")
@Import({MessageConfig.class})
public class AppConfig {
    // .... any extra config
}
