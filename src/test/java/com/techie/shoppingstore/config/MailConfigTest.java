package com.techie.shoppingstore.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MailConfigTest {
    /**
     * Method under test: {@link MailConfig#canEqual(Object)}
     */
    @Test
    public void testCanEqual() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   org.mockito.exceptions.base.MockitoException:
        //   Cannot mock/spy int
        //   Mockito cannot mock/spy because :
        //    - primitive type
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:194)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:176)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:146)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:133)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:286)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:174)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:691)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:528)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:275)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   See https://diff.blue/R026 to resolve this issue.

        assertFalse((new MailConfig()).canEqual("Other"));
    }

    /**
     * Method under test: {@link MailConfig#canEqual(Object)}
     */
    @Test
    public void testCanEqual2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R026 Failed to create Spring context.
        //   Attempt to initialize test context failed with
        //   org.mockito.exceptions.base.MockitoException:
        //   Cannot mock/spy int
        //   Mockito cannot mock/spy because :
        //    - primitive type
        //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:157)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:194)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:176)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:146)
        //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:133)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:286)
        //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:174)
        //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:691)
        //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:528)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:128)
        //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:275)
        //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:243)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
        //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117)
        //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108)
        //   See https://diff.blue/R026 to resolve this issue.

        MailConfig mailConfig = new MailConfig();

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertTrue(mailConfig.canEqual(mailConfig1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link MailConfig}
     *   <li>{@link MailConfig#setHost(String)}
     *   <li>{@link MailConfig#setPassword(String)}
     *   <li>{@link MailConfig#setPort(int)}
     *   <li>{@link MailConfig#setUsername(String)}
     * </ul>
     */
    @Test
    public void testConstructor() {
        MailConfig actualMailConfig = new MailConfig();
        actualMailConfig.setHost("localhost");
        actualMailConfig.setPassword("iloveyou");
        actualMailConfig.setPort(8080);
        actualMailConfig.setUsername("janedoe");
        assertEquals("localhost", actualMailConfig.getHost());
        assertEquals("iloveyou", actualMailConfig.getPassword());
        assertEquals(8080, actualMailConfig.getPort());
        assertEquals("janedoe", actualMailConfig.getUsername());
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");
        assertNotEquals(mailConfig, null);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals2() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");
        assertNotEquals(mailConfig, "Different type to MailConfig");
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals3() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");
        assertEquals(mailConfig, mailConfig);
        int expectedHashCodeResult = mailConfig.hashCode();
        assertEquals(expectedHashCodeResult, mailConfig.hashCode());
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals4() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertEquals(mailConfig, mailConfig1);
        int expectedHashCodeResult = mailConfig.hashCode();
        assertEquals(expectedHashCodeResult, mailConfig1.hashCode());
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals5() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("janedoe");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertNotEquals(mailConfig, mailConfig1);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals6() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost(null);
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertNotEquals(mailConfig, mailConfig1);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals7() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("localhost");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertNotEquals(mailConfig, mailConfig1);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals8() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword(null);
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertNotEquals(mailConfig, mailConfig1);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals9() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(1);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertNotEquals(mailConfig, mailConfig1);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals10() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("localhost");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertNotEquals(mailConfig, mailConfig1);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals11() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername(null);

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertNotEquals(mailConfig, mailConfig1);
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals12() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost(null);
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost(null);
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertEquals(mailConfig, mailConfig1);
        int expectedHashCodeResult = mailConfig.hashCode();
        assertEquals(expectedHashCodeResult, mailConfig1.hashCode());
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals13() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword(null);
        mailConfig.setPort(8080);
        mailConfig.setUsername("janedoe");

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword(null);
        mailConfig1.setPort(8080);
        mailConfig1.setUsername("janedoe");
        assertEquals(mailConfig, mailConfig1);
        int expectedHashCodeResult = mailConfig.hashCode();
        assertEquals(expectedHashCodeResult, mailConfig1.hashCode());
    }

    /**
     * Method under test: {@link MailConfig#equals(Object)}
     */
    @Test
    public void testEquals14() {
        MailConfig mailConfig = new MailConfig();
        mailConfig.setHost("localhost");
        mailConfig.setPassword("iloveyou");
        mailConfig.setPort(8080);
        mailConfig.setUsername(null);

        MailConfig mailConfig1 = new MailConfig();
        mailConfig1.setHost("localhost");
        mailConfig1.setPassword("iloveyou");
        mailConfig1.setPort(8080);
        mailConfig1.setUsername(null);
        assertEquals(mailConfig, mailConfig1);
        int expectedHashCodeResult = mailConfig.hashCode();
        assertEquals(expectedHashCodeResult, mailConfig1.hashCode());
    }
}

