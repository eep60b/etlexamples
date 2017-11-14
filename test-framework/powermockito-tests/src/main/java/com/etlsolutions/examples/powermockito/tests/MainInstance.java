/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.powermockito.tests;

import java.io.File;

/**
 *
 * @author zc
 */
public class MainInstance {

    public void arrayReturnOperation() {

        File[] files = new ArrayReturnMethods().getFiles();

        for (File file : files) {
            
            file.getAbsoluteFile();
        }
    }
}
