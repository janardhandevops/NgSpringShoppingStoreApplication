package com.techie.shoppingstore.service;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;

import org.elasticsearch.client.Response;
import org.junit.Ignore;
import org.junit.Test;
import org.yaml.snakeyaml.DumperOptions;

public class ResponseSerializerTest {
    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSerialize() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ResponseSerializer.serialize(ResponseSerializer.java:19)
        //   In order to prevent serialize(Response, JsonGenerator, SerializerProvider)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   serialize(Response, JsonGenerator, SerializerProvider).
        //   See https://diff.blue/R013 to resolve this issue.

        ResponseSerializer responseSerializer = new ResponseSerializer();
        JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(
                new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(mock(JsonGenerator.class))))));
        responseSerializer.serialize(null, gen, new DefaultSerializerProvider.Impl());
    }

    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSerialize2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.techie.shoppingstore.service.ResponseSerializer.serialize(ResponseSerializer.java:19)
        //   In order to prevent serialize(Response, JsonGenerator, SerializerProvider)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   serialize(Response, JsonGenerator, SerializerProvider).
        //   See https://diff.blue/R013 to resolve this issue.

        ResponseSerializer responseSerializer = new ResponseSerializer();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        doNothing().when(jsonGenerator).setCurrentValue((Object) any());

        JsonGeneratorDelegate jsonGeneratorDelegate = new JsonGeneratorDelegate(jsonGenerator);
        jsonGeneratorDelegate.setCurrentValue("42");
        JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
                new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(jsonGeneratorDelegate))));
        responseSerializer.serialize(null, gen, new DefaultSerializerProvider.Impl());
    }

    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSerialize3() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalStateException: Content has not been provided
        //       at org.apache.http.util.Asserts.check(Asserts.java:34)
        //       at org.apache.http.entity.BasicHttpEntity.getContent(BasicHttpEntity.java:75)
        //       at com.techie.shoppingstore.service.ResponseSerializer.serialize(ResponseSerializer.java:19)
        //   In order to prevent serialize(Response, JsonGenerator, SerializerProvider)
        //   from throwing IllegalStateException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   serialize(Response, JsonGenerator, SerializerProvider).
        //   See https://diff.blue/R013 to resolve this issue.

        ResponseSerializer responseSerializer = new ResponseSerializer();
        Response response = mock(Response.class);
        when(response.getEntity()).thenReturn(new BasicHttpEntity());
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        doNothing().when(jsonGenerator).setCurrentValue((Object) any());

        JsonGeneratorDelegate jsonGeneratorDelegate = new JsonGeneratorDelegate(jsonGenerator);
        jsonGeneratorDelegate.setCurrentValue("42");
        JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
                new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(jsonGeneratorDelegate))));
        responseSerializer.serialize(response, gen, new DefaultSerializerProvider.Impl());
    }

    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
//    @Test
//    public void testSerialize4() throws IOException {
//        ResponseSerializer responseSerializer = new ResponseSerializer();
//        Response response = mock(Response.class);
//        when(response.getEntity()).thenReturn(new UrlEncodedFormEntity((List<? extends NameValuePair>) new ArrayList<>()));
//        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
//        doNothing().when(jsonGenerator).writeRaw((String) any());
//        doNothing().when(jsonGenerator).setCurrentValue((Object) any());
//
//        JsonGeneratorDelegate jsonGeneratorDelegate = new JsonGeneratorDelegate(jsonGenerator);
//        jsonGeneratorDelegate.setCurrentValue("42");
//        JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
//                new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(jsonGeneratorDelegate))));
//        responseSerializer.serialize(response, gen, new DefaultSerializerProvider.Impl());
//        verify(response).getEntity();
//        verify(jsonGenerator).writeRaw((String) any());
//        verify(jsonGenerator).setCurrentValue((Object) any());
//    }

    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
    @Test
    public void testSerialize5() throws IOException {
        ResponseSerializer responseSerializer = new ResponseSerializer();

        ArrayList<NameValuePair> nameValuePairList = new ArrayList<>();
        nameValuePairList.add(new BasicHeader("https://example.org/example", "https://example.org/example"));
        Response response = mock(Response.class);
        when(response.getEntity()).thenReturn(new UrlEncodedFormEntity((List<? extends NameValuePair>) nameValuePairList));
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        doNothing().when(jsonGenerator).writeRaw((String) any());
        doNothing().when(jsonGenerator).setCurrentValue((Object) any());

        JsonGeneratorDelegate jsonGeneratorDelegate = new JsonGeneratorDelegate(jsonGenerator);
        jsonGeneratorDelegate.setCurrentValue("42");
        JsonGeneratorDelegate gen = new JsonGeneratorDelegate(
                new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(jsonGeneratorDelegate))));
        responseSerializer.serialize(response, gen, new DefaultSerializerProvider.Impl());
        verify(response).getEntity();
        verify(jsonGenerator).writeRaw((String) any());
        verify(jsonGenerator).setCurrentValue((Object) any());
    }

    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
//    @Test
//    @Ignore("TODO: Complete this test")
//    public void testSerialize6() throws IOException {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException
//        //       at com.fasterxml.jackson.core.util.JsonGeneratorDelegate.writeRaw(JsonGeneratorDelegate.java:274)
//        //       at com.fasterxml.jackson.core.util.JsonGeneratorDelegate.writeRaw(JsonGeneratorDelegate.java:274)
//        //       at com.fasterxml.jackson.core.util.JsonGeneratorDelegate.writeRaw(JsonGeneratorDelegate.java:274)
//        //       at com.techie.shoppingstore.service.ResponseSerializer.serialize(ResponseSerializer.java:20)
//        //   In order to prevent serialize(Response, JsonGenerator, SerializerProvider)
//        //   from throwing NullPointerException, add constructors or factory
//        //   methods that make it easier to construct fully initialized objects used in
//        //   serialize(Response, JsonGenerator, SerializerProvider).
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        ResponseSerializer responseSerializer = new ResponseSerializer();
//        Response response = mock(Response.class);
//        when(response.getEntity()).thenReturn(new UrlEncodedFormEntity((List<? extends NameValuePair>) new ArrayList<>()));
//        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
//        doNothing().when(jsonGenerator).writeRaw((String) any());
//        doNothing().when(jsonGenerator).setCurrentValue((Object) any());
//        (new JsonGeneratorDelegate(jsonGenerator)).setCurrentValue("42");
//        JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(null)));
//        responseSerializer.serialize(response, gen, new DefaultSerializerProvider.Impl());
//    }

    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
//    @Test
//    @Ignore("TODO: Complete this test")
//    public void testSerialize7() throws IOException {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.NullPointerException
//        //       at com.techie.shoppingstore.service.ResponseSerializer.serialize(ResponseSerializer.java:20)
//        //   In order to prevent serialize(Response, JsonGenerator, SerializerProvider)
//        //   from throwing NullPointerException, add constructors or factory
//        //   methods that make it easier to construct fully initialized objects used in
//        //   serialize(Response, JsonGenerator, SerializerProvider).
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        ResponseSerializer responseSerializer = new ResponseSerializer();
//        Response response = mock(Response.class);
//        when(response.getEntity()).thenReturn(new UrlEncodedFormEntity((List<? extends NameValuePair>) new ArrayList<>()));
//        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
//        doNothing().when(jsonGenerator).writeRaw((String) any());
//        doNothing().when(jsonGenerator).setCurrentValue((Object) any());
//
//        JsonGeneratorDelegate jsonGeneratorDelegate = new JsonGeneratorDelegate(jsonGenerator);
//        jsonGeneratorDelegate.setCurrentValue("42");
//        new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(jsonGeneratorDelegate)));
//        responseSerializer.serialize(response, null, new DefaultSerializerProvider.Impl());
//    }

    /**
     * Method under test: {@link ResponseSerializer#serialize(Response, JsonGenerator, com.fasterxml.jackson.databind.SerializerProvider)}
     */
//    @Test
//    @Ignore("TODO: Complete this test")
//    public void testSerialize8() throws IOException {
//        // TODO: Complete this test.
//        //   Reason: R013 No inputs found that don't throw a trivial exception.
//        //   Diffblue Cover tried to run the arrange/act section, but the method under
//        //   test threw
//        //   java.lang.UnsupportedOperationException: Operation not supported by generator of type com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
//        //       at com.fasterxml.jackson.core.JsonGenerator._reportUnsupportedOperation(JsonGenerator.java:1967)
//        //       at com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.writeRaw(YAMLGenerator.java:590)
//        //       at com.fasterxml.jackson.core.util.JsonGeneratorDelegate.writeRaw(JsonGeneratorDelegate.java:274)
//        //       at com.fasterxml.jackson.core.util.JsonGeneratorDelegate.writeRaw(JsonGeneratorDelegate.java:274)
//        //       at com.fasterxml.jackson.core.util.JsonGeneratorDelegate.writeRaw(JsonGeneratorDelegate.java:274)
//        //       at com.techie.shoppingstore.service.ResponseSerializer.serialize(ResponseSerializer.java:20)
//        //   In order to prevent serialize(Response, JsonGenerator, SerializerProvider)
//        //   from throwing UnsupportedOperationException, add constructors or factory
//        //   methods that make it easier to construct fully initialized objects used in
//        //   serialize(Response, JsonGenerator, SerializerProvider).
//        //   See https://diff.blue/R013 to resolve this issue.
//
//        ResponseSerializer responseSerializer = new ResponseSerializer();
//        Response response = mock(Response.class);
//        when(response.getEntity()).thenReturn(new UrlEncodedFormEntity((List<? extends NameValuePair>) new ArrayList<>()));
//        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
//        doNothing().when(jsonGenerator).writeRaw((String) any());
//        doNothing().when(jsonGenerator).setCurrentValue((Object) any());
//        (new JsonGeneratorDelegate(jsonGenerator)).setCurrentValue("42");
//        IOContext ctxt = new IOContext(new BufferRecycler(), "Source Ref", true);
//
//        ObjectMapper codec = new ObjectMapper();
//        JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(new JsonGeneratorDelegate(
//                new YAMLGenerator(ctxt, 1, 1, codec, new StringWriter(), DumperOptions.Version.V1_0))));
//        responseSerializer.serialize(response, gen, new DefaultSerializerProvider.Impl());
//    }
}

