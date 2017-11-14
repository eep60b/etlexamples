/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.primefaces.datatable.custommodel;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.primefaces.component.datatable.DataTable;

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("javax.faces.component.UIViewRoot")
@PrepareForTest({JsfDelegator.class, FacesContext.class})
public final class DataTableHandlerTest
{

  private final String string01 = "aabb1";
  private final String string02 = "aabb1";
  private final String string03 = "aabb1";
  private final String string04 = "aabb1";
  private final String string05 = "aabb1";
  private final String string06 = "aabb1";    
  private final String string07 = "aabb1";
  private final String string08 = "aabb1";
  private final String string09 = "aabb1";
  private final String string10 = "aabb1";
  private final String string11 = "aabb1";
  private final String string12 = "aabb1";   
  private final String string13 = "aabb1";
  private final String string14 = "aabb1";
  private final String string15 = "aabb1";
  private final String string16 = "aabb1";
  private final String string17 = "aabb1";
  private final String string18 = "aabb1";   
  private final String string19 = "aabb1";
  private final String string20 = "aabb1";
  private final String string21 = "aabb1";
  private final String string22 = "aabb1";
  private final String string23 = "aabb1";
  private final String string24 = "aabb1";     
  private final List<String> strings = Arrays.asList(string01, string02, string03, string04, string05, string06, string07, string08, 
                                                     string09, string10, string11, string12, string13, string14, string15, string16, 
                                                     string17, string18, string19, string20, string21, string22, string23, string24);
  @Mock
  private FacesContext facesContext;
  
  @Mock
  private UIViewRoot uiViewRoot;
  
//  private final DataTable datatable = null;
  
//  private final JsfDelegator instance = new JsfDelegator();

  @Before
  public void setUp()
  {
   // UIViewRoot uiViewRoot = PowerMockito.mock(UIViewRoot.class);
   // DataTable datatable = Mockito.mock(DataTable.class);
    
    PowerMockito.mockStatic(FacesContext.class);
    Mockito.when(FacesContext.getCurrentInstance()).thenReturn(facesContext);
  //  Mockito.when(facesContext.getViewRoot()).thenReturn(uiViewRoot);
  //  Mockito.when(uiViewRoot.findComponent(":mainPanel:stringForm:stringList")).thenReturn(datatable);
   // Mockito.when(datatable.getRowCount()).thenReturn(24);
    
  }

  @Test
  public void testSelectStringInDataTable()
  {    
 //   Mockito.when(datatable.getPageCount()).thenReturn(3);
   // instance.selectStringInDataTable(string01, strings);
    
 //   Mockito.verify(datatable).setFirst(0);
  }
}