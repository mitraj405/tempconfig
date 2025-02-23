package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SubTypeValidator {
    protected static final Set<String> DEFAULT_NO_DESER_CLASS_NAMES;
    private static final SubTypeValidator instance = new SubTypeValidator();
    protected Set<String> _cfgIllegalClassNames = DEFAULT_NO_DESER_CLASS_NAMES;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("org.apache.commons.collections.functors.InvokerTransformer");
        hashSet.add("org.apache.commons.collections.functors.InstantiateTransformer");
        hashSet.add("org.apache.commons.collections4.functors.InvokerTransformer");
        hashSet.add("org.apache.commons.collections4.functors.InstantiateTransformer");
        hashSet.add("org.codehaus.groovy.runtime.ConvertedClosure");
        lf.y(hashSet, "org.codehaus.groovy.runtime.MethodClosure", "org.springframework.beans.factory.ObjectFactory", "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl", "org.apache.xalan.xsltc.trax.TemplatesImpl");
        lf.y(hashSet, "com.sun.rowset.JdbcRowSetImpl", "java.util.logging.FileHandler", "java.rmi.server.UnicastRemoteObject", "org.springframework.beans.factory.config.PropertyPathFactoryBean");
        lf.y(hashSet, "org.springframework.aop.config.MethodLocatingFactoryBean", "org.springframework.beans.factory.config.BeanReferenceFactoryBean", "org.apache.tomcat.dbcp.dbcp2.BasicDataSource", "com.sun.org.apache.bcel.internal.util.ClassLoader");
        lf.y(hashSet, "org.hibernate.jmx.StatisticsService", "org.apache.ibatis.datasource.jndi.JndiDataSourceFactory", "org.apache.ibatis.parsing.XPathParser", "jodd.db.connection.DataSourceConnectionProvider");
        lf.y(hashSet, "oracle.jdbc.connector.OracleManagedConnectionFactory", "oracle.jdbc.rowset.OracleJDBCRowSet", "org.slf4j.ext.EventData", "flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor");
        lf.y(hashSet, "com.sun.deploy.security.ruleset.DRSHelper", "org.apache.axis2.jaxws.spi.handler.HandlerResolverImpl", "org.jboss.util.propertyeditor.DocumentEditor", "org.apache.openjpa.ee.RegistryManagedRuntime");
        lf.y(hashSet, "org.apache.openjpa.ee.JNDIManagedRuntime", "org.apache.openjpa.ee.WASRegistryManagedRuntime", "org.apache.axis2.transport.jms.JMSOutTransportInfo", "com.mysql.cj.jdbc.admin.MiniAdmin");
        lf.y(hashSet, "ch.qos.logback.core.db.DriverManagerConnectionSource", "org.jdom.transform.XSLTransformer", "org.jdom2.transform.XSLTransformer", "net.sf.ehcache.transaction.manager.DefaultTransactionManagerLookup");
        lf.y(hashSet, "net.sf.ehcache.hibernate.EhcacheJtaTransactionManagerLookup", "ch.qos.logback.core.db.JNDIConnectionSource", "com.zaxxer.hikari.HikariConfig", "com.zaxxer.hikari.HikariDataSource");
        lf.y(hashSet, "org.apache.cxf.jaxrs.provider.XSLTJaxbProvider", "org.apache.commons.configuration.JNDIConfiguration", "org.apache.commons.configuration2.JNDIConfiguration", "org.apache.xalan.lib.sql.JNDIConnectionPool");
        lf.y(hashSet, "com.sun.org.apache.xalan.internal.lib.sql.JNDIConnectionPool", "org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS", "org.apache.commons.dbcp.datasources.PerUserPoolDataSource", "org.apache.commons.dbcp.datasources.SharedPoolDataSource");
        lf.y(hashSet, "com.p6spy.engine.spy.P6DataSource", "org.apache.log4j.receivers.db.DriverManagerConnectionSource", "org.apache.log4j.receivers.db.JNDIConnectionSource", "net.sf.ehcache.transaction.manager.selector.GenericJndiSelector");
        lf.y(hashSet, "net.sf.ehcache.transaction.manager.selector.GlassfishSelector", "org.apache.xbean.propertyeditor.JndiConverter", "org.apache.hadoop.shaded.com.zaxxer.hikari.HikariConfig", "com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig");
        lf.y(hashSet, "br.com.anteros.dbcp.AnterosDBCPConfig", "br.com.anteros.dbcp.AnterosDBCPDataSource", "javax.swing.JEditorPane", "javax.swing.JTextPane");
        lf.y(hashSet, "org.apache.shiro.realm.jndi.JndiRealmFactory", "org.apache.shiro.jndi.JndiObjectFactory", "org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup", "org.apache.ignite.cache.jta.jndi.CacheJndiTmFactory");
        lf.y(hashSet, "org.quartz.utils.JNDIConnectionProvider", "org.apache.aries.transaction.jms.internal.XaPooledConnectionFactory", "org.apache.aries.transaction.jms.RecoverablePooledConnectionFactory", "com.caucho.config.types.ResourceRef");
        lf.y(hashSet, "org.aoju.bus.proxy.provider.RmiProvider", "org.aoju.bus.proxy.provider.remoting.RmiProvider", "org.apache.activemq.ActiveMQConnectionFactory", "org.apache.activemq.ActiveMQXAConnectionFactory");
        lf.y(hashSet, "org.apache.activemq.spring.ActiveMQConnectionFactory", "org.apache.activemq.spring.ActiveMQXAConnectionFactory", "org.apache.activemq.pool.JcaPooledConnectionFactory", "org.apache.activemq.pool.PooledConnectionFactory");
        lf.y(hashSet, "org.apache.activemq.pool.XaPooledConnectionFactory", "org.apache.activemq.jms.pool.XaPooledConnectionFactory", "org.apache.activemq.jms.pool.JcaPooledConnectionFactory", "org.apache.commons.proxy.provider.remoting.RmiProvider");
        lf.y(hashSet, "org.apache.commons.jelly.impl.Embedded", "oadd.org.apache.xalan.lib.sql.JNDIConnectionPool", "oadd.org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS", "oadd.org.apache.commons.dbcp.datasources.PerUserPoolDataSource");
        lf.y(hashSet, "oadd.org.apache.commons.dbcp.datasources.SharedPoolDataSource", "oracle.jms.AQjmsQueueConnectionFactory", "oracle.jms.AQjmsXATopicConnectionFactory", "oracle.jms.AQjmsTopicConnectionFactory");
        lf.y(hashSet, "oracle.jms.AQjmsXAQueueConnectionFactory", "oracle.jms.AQjmsXAConnectionFactory", "org.jsecurity.realm.jndi.JndiRealmFactory", "com.pastdev.httpcomponents.configuration.JndiConfiguration");
        lf.y(hashSet, "com.nqadmin.rowset.JdbcRowSetImpl", "org.arrah.framework.rdbms.UpdatableJdbcRowsetImpl", "org.apache.commons.dbcp2.datasources.PerUserPoolDataSource", "org.apache.commons.dbcp2.datasources.SharedPoolDataSource");
        lf.y(hashSet, "org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS", "com.newrelic.agent.deps.ch.qos.logback.core.db.JNDIConnectionSource", "com.newrelic.agent.deps.ch.qos.logback.core.db.DriverManagerConnectionSource", "org.apache.tomcat.dbcp.dbcp.cpdsadapter.DriverAdapterCPDS");
        lf.y(hashSet, "org.apache.tomcat.dbcp.dbcp.datasources.PerUserPoolDataSource", "org.apache.tomcat.dbcp.dbcp.datasources.SharedPoolDataSource", "org.apache.tomcat.dbcp.dbcp2.cpdsadapter.DriverAdapterCPDS", "org.apache.tomcat.dbcp.dbcp2.datasources.PerUserPoolDataSource");
        hashSet.add("org.apache.tomcat.dbcp.dbcp2.datasources.SharedPoolDataSource");
        hashSet.add("com.oracle.wls.shaded.org.apache.xalan.lib.sql.JNDIConnectionPool");
        hashSet.add("org.docx4j.org.apache.xalan.lib.sql.JNDIConnectionPool");
        DEFAULT_NO_DESER_CLASS_NAMES = Collections.unmodifiableSet(hashSet);
    }

    public static SubTypeValidator instance() {
        return instance;
    }

    public void validateSubType(DeserializationContext deserializationContext, JavaType javaType, BeanDescription beanDescription) throws JsonMappingException {
        Class rawClass = javaType.getRawClass();
        String name = rawClass.getName();
        if (!this._cfgIllegalClassNames.contains(name)) {
            if (!rawClass.isInterface()) {
                if (name.startsWith("org.springframework.")) {
                    while (rawClass != null && rawClass != Object.class) {
                        String simpleName = rawClass.getSimpleName();
                        if (!"AbstractPointcutAdvisor".equals(simpleName) && !"AbstractApplicationContext".equals(simpleName)) {
                            rawClass = rawClass.getSuperclass();
                        }
                    }
                    return;
                } else if (!name.startsWith("com.mchange.v2.c3p0.") || !name.endsWith("DataSource")) {
                    return;
                }
            } else {
                return;
            }
        }
        deserializationContext.reportBadTypeDefinition(beanDescription, "Illegal type (%s) to deserialize: prevented for security reasons", name);
    }
}
