package com.protom.mytime.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mm = new ModelMapper();
	    mm.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mm;
	}

}
