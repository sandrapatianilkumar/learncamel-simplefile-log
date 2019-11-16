package com.learncamel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamelLogging {
    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("file:data/input?noop=true")
                            .process(new Processor() {
                                public void process(Exchange exchange) throws Exception {

                                }
                            })
//                            .to("log:?level=INFO&showBody=true&showHeader=true")
                            .to("log:INFO?showBody=true&showHeaders=true")
                            .to("file:data/output");
                }
            });
            context.start();
            Thread.sleep(5000);
            context.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

