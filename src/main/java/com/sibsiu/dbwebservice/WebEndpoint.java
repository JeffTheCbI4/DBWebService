package com.sibsiu.dbwebservice;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import webservice.Data;
import webservice.MinusRequest;
import webservice.PlusRequest;
import webservice.TestGetDataRequest;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;



@Endpoint
public class WebEndpoint {
	private static final String NAMESPACE_URI = "http://webservice";
	private static final Logger LOG = LoggerFactory.getLogger("logger");

    @Autowired
    public WebEndpoint() {
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "plusRequest")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void plusMethod(@RequestPayload PlusRequest request) {
    	int answer = request.getA() + request.getB();
    	String sanswer = "" + answer;
    	LOG.info("A: "+request.getA());
    	LOG.info("B: "+request.getB());
    	LOG.info("Answer: " + sanswer);
    	LOG.info(request.getString());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "minusRequest")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void minusMethod(@RequestPayload MinusRequest request) {
    	int answer = request.getA() - request.getB();
    	String sanswer = "" + answer;
    	LOG.info(sanswer);
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "testGetDataRequest")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void testGetDataMethod(@RequestPayload TestGetDataRequest request) {
    	
//    	try {
//    		TestGetDataRequest test = new TestGetDataRequest();
//    		
//    		TestGetDataRequest.Data data1 = new TestGetDataRequest.Data();
//            data1.setId("1");
//            data1.setDate("Date1");
//            data1.setOrg("Org1");
//            data1.setLoc("Loc1");
//            data1.setStatus("Status1");
//            data1.setDesc("Desc1");
//
//            TestGetDataRequest.Data data2 = new TestGetDataRequest.Data();
//            data2.setId("2");
//            data2.setDate("Date2");
//            data2.setOrg("Org2");
//            data2.setLoc("Loc2");
//            data2.setStatus("Status2");
//            data2.setDesc("Desc2");
//    		
//    		test.getData().add(data1);
//    		test.getData().add(data2);
//        	JAXBContext context = JAXBContext.newInstance(TestGetDataRequest.class);
//    		StringWriter writer = new StringWriter();
//        	Marshaller m = context.createMarshaller();
//        	m.marshal(m, writer);
//        	LOG.info(writer.toString());
//    	}
//    	catch(Exception ex) {
//    		ex.printStackTrace();
//    	}
    	
    	
    	LOG.info("Получили сообщение: " + request.getData());
    	ArrayList<Data> list = (ArrayList<Data>) request.getData();
    	for (Data data : list) {
			String out = "";
			out += data.getId() + " ";
			out += data.getDate() + " ";
			out += data.getOrg() + " ";
			out += data.getLoc() + " ";
			out += data.getStatus() + " ";
			out += data.getDesc();
			LOG.info(out);
		}
	}
}
