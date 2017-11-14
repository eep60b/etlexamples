package com.etlsolutions.examples.ldap.connection;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.ldap.InitialLdapContext;

/**
 * Example code for connection to LDAP servers.
 *
 * @author zc
 */
public class SimplestLdapConnection {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {

        final String ldapAdServer = "ldap://192.168.250.148:389";
        final String ldapUsername = "cn=admin,dc=etlsolutions,dc=com";
        final String ldapPassword = "huan0418";

        Properties env = new Properties();
        env.setProperty(Context.PROVIDER_URL, ldapAdServer);
        env.setProperty(Context.SECURITY_AUTHENTICATION, "simple");
        env.setProperty(Context.SECURITY_PRINCIPAL, ldapUsername);
        env.setProperty(Context.SECURITY_CREDENTIALS, ldapPassword);
        env.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        //The following is helpful in debugging errors
        env.put("com.sun.jndi.ldap.trace.ber", System.err);

        DirContext ctx = new InitialDirContext(env);
        InitialLdapContext idx = new InitialLdapContext(env, null);
    }
}
