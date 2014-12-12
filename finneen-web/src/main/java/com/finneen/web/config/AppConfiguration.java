package com.finneen.web.config;

import com.finneen.web.business.admin.AdminConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yaofeng on 2014/12/10.
 */
@Configuration
@Import(value = {AdminConfiguration.class, ShiroConfiguration.class})
public class AppConfiguration {
}
