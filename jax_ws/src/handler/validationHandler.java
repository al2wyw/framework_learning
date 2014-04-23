package handler;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import javax.xml.namespace.QName;

import javax.xml.soap.*;

import javax.xml.ws.handler.MessageContext;

import javax.xml.ws.handler.soap.*;

import javax.xml.ws.soap.SOAPFaultException;

public class validationHandler implements SOAPHandler<SOAPMessageContext> {

	         public Set<QName> getHeaders() {

	                   // TODO Auto-generated method stub

	                   return null;

	         }

	         public void close(MessageContext context) {

	         }

	         public boolean handleFault(SOAPMessageContext context) {

	                   return false;

	         }

	         public boolean handleMessage(SOAPMessageContext context) {

	 

	                   HttpServletRequest request = (HttpServletRequest) context.get(MessageContext.SERVLET_REQUEST);

	                   //

	                   if (request != null) {

	                            System.out.println("Client IP：" + request.getRemoteAddr());

	                   } else {

	                            System.out.println("get client ip is null>>>>>>>>>");

	                   }

	 

	                   Boolean outbound = (Boolean) context

	                                     .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

	 

	                   if (!outbound.booleanValue()) {

	                            SOAPMessage soapMessage = context.getMessage();

	 

	                            try {

	                                     SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart()

	                                                        .getEnvelope();

	                                     SOAPHeader soapHeader = soapEnvelope.getHeader();

	 

	                                     if (soapHeader == null)

	                                               generateSoapFault(soapMessage, "No Message Header...");

	 

	                                     Iterator it = soapHeader

	                                                        .extractHeaderElements(SOAPConstants.URI_SOAP_1_2_ROLE_NEXT);

	 

	                                     if (it == null || !it.hasNext())

	                                               generateSoapFault(soapMessage,

	                                                                 "No Header block for role next");

	 

	                                     Node node = (Node) it.next();

	 

	                                     String value = node == null ? null : node.getValue();

	 

	                                     if (value == null)

	                                               generateSoapFault(soapMessage,

	                                                                 "No authation info in header blocks");

	 

	                                     String[] infos = value.split("&");

	 

	                                     return authValidate(infos[0], infos[1]);

	 

	                            } catch (SOAPException e) {

	                                     e.printStackTrace();

	                            }

	 

	                   }

	                   return false;

	         }

	         private boolean authValidate(String userName, String password) {

	                   if (userName == null || password == null) {

	                            return false;

	                   }

	 

	                   if ("admin".equals(userName) && "admin".equals(password)) {

	                            return true;

	                   }

	                   return false;

	         }

	 

	         private void generateSoapFault(SOAPMessage soapMessage, String reasion) {

	                   try {

	                            SOAPBody soapBody = soapMessage.getSOAPBody();

	                            SOAPFault soapFault = soapBody.getFault();

	 

	                            if (soapFault == null) {

	                                     soapFault = soapBody.addFault();

	                            }

	 

	                            soapFault.setFaultString(reasion);

	 

	                            throw new SOAPFaultException(soapFault);

	 

	                   } catch (SOAPException e) {

	                            // TODO Auto-generated catch block

	                            e.printStackTrace();

	                   }

	         }

	 

	}

