package com.jtmc.apps.reforma.infrastructure.jetty;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import com.google.common.collect.Sets;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.jtmc.apps.reforma.api.filter.CorsFilter;
import com.jtmc.apps.reforma.api.filter.JwtRequiredFilter;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import com.jtmc.apps.reforma.api.v1.branch.BranchApi;
import com.jtmc.apps.reforma.api.v1.branch.BranchApiImpl;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountApi;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountApiImpl;
import com.jtmc.apps.reforma.api.v1.catalogcountenum.CatalogCountEnumApi;
import com.jtmc.apps.reforma.api.v1.catalogcountenum.CatalogCountEnumApiImpl;
import com.jtmc.apps.reforma.api.v1.excelimport.ExcelImportApi;
import com.jtmc.apps.reforma.api.v1.excelimport.ExcelImportApiImpl;
import com.jtmc.apps.reforma.api.v1.exception.ExcelImportGenericExceptionMapper;
import com.jtmc.apps.reforma.api.v1.exception.ImplementationGenericExceptionMapper;
import com.jtmc.apps.reforma.api.v1.exception.RepositoryGenericExceptionMapper;
import com.jtmc.apps.reforma.api.v1.exception.RuntimeGenericExceptionMapper;
import com.jtmc.apps.reforma.api.v1.healthcheck.HealthcheckApi;
import com.jtmc.apps.reforma.api.v1.healthcheck.HealthcheckImpl;
import com.jtmc.apps.reforma.api.v1.login.LoginApi;
import com.jtmc.apps.reforma.api.v1.login.LoginApiImpl;
import com.jtmc.apps.reforma.api.v1.period.PeriodApi;
import com.jtmc.apps.reforma.api.v1.period.PeriodApiImpl;
import com.jtmc.apps.reforma.api.v1.periodconfirm.PeriodConfirmApi;
import com.jtmc.apps.reforma.api.v1.periodconfirm.PeriodConfirmApiImpl;
import com.jtmc.apps.reforma.api.v1.persona.PersonaApi;
import com.jtmc.apps.reforma.api.v1.persona.PersonaApiImpl;
import com.jtmc.apps.reforma.api.v1.personadetails.PersonaDetailsApi;
import com.jtmc.apps.reforma.api.v1.personadetails.PersonaDetailsApiImpl;
import com.jtmc.apps.reforma.api.v1.report.ReportApi;
import com.jtmc.apps.reforma.api.v1.report.ReportApiImpl;
import com.jtmc.apps.reforma.api.v1.timezone.TimeZoneApi;
import com.jtmc.apps.reforma.api.v1.timezone.TimeZoneApiImpl;
import com.jtmc.apps.reforma.api.v1.user.UserApi;
import com.jtmc.apps.reforma.api.v1.user.UserApiImpl;
import com.jtmc.apps.reforma.guice.CCMybatisModule;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.infrastructure.GuiceApplication;
import com.jtmc.apps.reforma.infrastructure.ServerModule;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
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
            install(new CCMybatisModule());

            bind(JwtUserClaim.class).asEagerSingleton();
            bind(UserImpl.class).asEagerSingleton();
            bind(HealthcheckApi.class).to(HealthcheckImpl.class);
            bind(CatalogCountApi.class).to(CatalogCountApiImpl.class);
            bind(ExcelImportApi.class).to(ExcelImportApiImpl.class);
            bind(CatalogCountEnumApi.class).to(CatalogCountEnumApiImpl.class);
//            bind(AuditReportApi.class).to(AuditReportApiImpl.class);
            bind(LoginApi.class).to(LoginApiImpl.class);
            bind(UserApi.class).to(UserApiImpl.class);
            bind(PeriodConfirmApi.class).to(PeriodConfirmApiImpl.class);
            bind(PeriodApi.class).to(PeriodApiImpl.class);
            bind(BranchApi.class).to(BranchApiImpl.class);
            bind(PersonaApi.class).to(PersonaApiImpl.class);
            bind(PersonaDetailsApi.class).to(PersonaDetailsApiImpl.class);
            bind(ReportApi.class).to(ReportApiImpl.class);
            bind(TimeZoneApi.class).to(TimeZoneApiImpl.class);
            bind(com.jtmc.apps.reforma.api.v2.catalogcount.CatalogCountApi.class).to(com.jtmc.apps.reforma.api.v2.catalogcount.CatalogCountApiImpl.class);

            Properties myProperties = new Properties();
            myProperties.setProperty("key", System.getenv("key"));
            myProperties.setProperty("deadLineDay", System.getenv("CC_SERVICE_DEADLINE_DAY"));
            myProperties.setProperty("defaultExpiration", System.getenv("CC_SERVICE_DEFAULT_EXPIRATION_SECS"));
            Names.bindProperties(binder(), myProperties);
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
                    injector.getInstance(JwtRequiredFilter.class),
                    injector.getInstance(HealthcheckApi.class),
                    injector.getInstance(CatalogCountApi.class),
                    injector.getInstance(ExcelImportApi.class),
                    injector.getInstance(CatalogCountEnumApi.class),
//                    injector.getInstance(AuditReportApi.class),
                    injector.getInstance(LoginApi.class),
                    injector.getInstance(UserApi.class),
                    injector.getInstance(PeriodConfirmApi.class),
                    injector.getInstance(PeriodApi.class),
                    injector.getInstance(BranchApi.class),
                    injector.getInstance(PersonaApi.class),
                    injector.getInstance(PersonaDetailsApi.class),
                    injector.getInstance(ReportApi.class),
                    injector.getInstance(TimeZoneApi.class),
                    injector.getInstance(JacksonJsonProvider.class),
                    injector.getInstance(RuntimeGenericExceptionMapper.class),
                    injector.getInstance(RepositoryGenericExceptionMapper.class),
                    injector.getInstance(ExcelImportGenericExceptionMapper.class),
                    injector.getInstance(ImplementationGenericExceptionMapper.class),
                    injector.getInstance(com.jtmc.apps.reforma.api.v2.catalogcount.CatalogCountApi.class)
            );
        }
    }

    private static void startJettyServer() {

        ServletHolder servletHolder = new ServletHolder(
                new CXFNonSpringJaxrsServlet(new CatalogCountsApplication()));

        ServletContextHandler servletContextHandler = new ServletContextHandler();
        servletContextHandler.setContextPath("/");
        servletContextHandler.addServlet(servletHolder, "/cc-service/api/*");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(servletContextHandler);

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
