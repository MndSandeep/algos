package com.opsmx.assesment;

import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.undertow.Undertow.Builder;

@Configuration
public class BaseConfiguration {
//		@Bean
//		public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
//			UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
//			factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
//				
//				@Override
//				public void customize(Builder builder) {
//					builder.addHttpListener(8080, "0.0.0.0");
//				}
//			});
//			return factory;
//		/*UndertowEmbeddedServletContainerFactory factory = 
//		new UndertowEmbeddedServletContainerFactory();
//					factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
//						@Override
//						public void customize(Builder builder) {
//							builder.addHttpListener(8080, "0.0.0.0");
//						    });
//					return factory;
//						}
//*/}
}