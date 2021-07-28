package com.jtmc.apps.reforma.infrastructure.jetty;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.Sets;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.jtmc.apps.reforma.api.filter.CorsFilter;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountApi;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountApiImpl;
import com.jtmc.apps.reforma.api.v1.catalogcountenum.CatalogCountEnumApi;
import com.jtmc.apps.reforma.api.v1.catalogcountenum.CatalogCountEnumApiImpl;
import com.jtmc.apps.reforma.api.v1.excelimport.ExcelImportApi;
import com.jtmc.apps.reforma.api.v1.excelimport.ExcelImportApiImpl;
import com.jtmc.apps.reforma.api.v1.exception.ExcelImportGenericExceptionMapper;
import com.jtmc.apps.reforma.api.v1.exception.RepositoryGenericExceptionMapper;
import com.jtmc.apps.reforma.api.v1.exception.RuntimeGenericExceptionMapper;
import com.jtmc.apps.reforma.api.v1.healthcheck.HealthcheckApi;
import com.jtmc.apps.reforma.api.v1.healthcheck.HealthcheckImpl;
import com.jtmc.apps.reforma.api.v1.persona.PersonaApi;
import com.jtmc.apps.reforma.api.v1.persona.PersonaApiImpl;
import com.jtmc.apps.reforma.api.v1.service.ServiceApi;
import com.jtmc.apps.reforma.api.v1.service.ServiceApiImpl;
import com.jtmc.apps.reforma.infrastructure.GuiceApplication;
import com.jtmc.apps.reforma.infrastructure.ServerModule;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class Launcher {
    private static Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {
            startJettyServer();
    }

    private static class JettyLauncherModule extends AbstractModule {

        @Override
        protected void configure() {
            install(new ServerModule());
            bind(HealthcheckApi.class).to(HealthcheckImpl.class);
            bind(CatalogCountApi.class).to(CatalogCountApiImpl.class);
            bind(ExcelImportApi.class).to(ExcelImportApiImpl.class);
            bind(PersonaApi.class).to(PersonaApiImpl.class);
            bind(ServiceApi.class).to(ServiceApiImpl.class);
            bind(CatalogCountEnumApi.class).to(CatalogCountEnumApiImpl.class);
        }
    }

    private static class CatalogCountsApplication extends GuiceApplication {
        @Override
        protected Set<Module> modules() {
            return Sets.newHashSet(new JettyLauncherModule());
        }

        @Override
        protected Set<Object> serviceInstances(Injector injector) {

            return Sets.newHashSet(
                    injector.getInstance(CorsFilter.class),
                    injector.getInstance(HealthcheckApi.class),
                    injector.getInstance(CatalogCountApi.class),
                    injector.getInstance(ExcelImportApi.class),
                    injector.getInstance(PersonaApi.class),
                    injector.getInstance(ServiceApi.class),
                    injector.getInstance(CatalogCountEnumApi.class),
                    injector.getInstance(JacksonJsonProvider.class),
                    injector.getInstance(RuntimeGenericExceptionMapper.class),
                    injector.getInstance(RepositoryGenericExceptionMapper.class),
                    injector.getInstance(ExcelImportGenericExceptionMapper.class)
            );
        }
    }

    private static void startJettyServer() {

        HandlerCollection handlers = new HandlerCollection();

        //servletContextHandler
        ServletHolder servletHolder = new ServletHolder(
                new CXFNonSpringJaxrsServlet(new CatalogCountsApplication()));
        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(servletHolder, "/cc-service/api/*");

        handlers.addHandler(servletContextHandler);


        Server jettyServer = new Server();
        ServerConnector serverConnector = new ServerConnector(jettyServer);
        serverConnector.setPort(8080);
        jettyServer.addConnector(serverConnector);

        jettyServer.setHandler(handlers);


        try {
            jettyServer.start();
            jettyServer.join();
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
        } finally {
            jettyServer.destroy();
        }
    }
}
