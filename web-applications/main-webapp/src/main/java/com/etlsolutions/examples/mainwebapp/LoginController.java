/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.etlsolutions.examples.mainwebapp;

import com.etlsolutions.examples.mainwebapp.entity.Customer;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The LoginController class controls the login page.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
//TODO: Implementation. Add tests. Add Java docs. Add annotations.
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID =  117364517293029347L;   
    
    @EJB
    private com.etlsolutions.examples.mainwebapp.facade.CustomerFacade ejbFacade;

    @NotNull
    private String username;

    @NotNull
    @Size(min = 8, max = 40, message = "The password length should be between 8 and 40.")
    private String password;

    private boolean success;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        
        Customer customer = ejbFacade.findByUsername(username);
        
        success = customer != null && customer.getPassword().equals(password);
        return "done";
    }

    public String nextPage() {
        if(success) {
            return "pages/start.xhtml";
        }
        return "pages/failed.xhtml";
    }
}
