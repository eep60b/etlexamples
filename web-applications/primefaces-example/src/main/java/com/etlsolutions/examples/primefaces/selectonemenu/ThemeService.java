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
package com.etlsolutions.examples.primefaces.selectonemenu;

import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author zc
 */
@ManagedBean(name="themeService", eager = true)
@ApplicationScoped
public class ThemeService {
     
    private List<Theme> themes;
     
    @PostConstruct
    public void init() {
        themes = Arrays.asList(
        new Theme(0, "fterdark\n10:00pm", "afterdark\naaa"),
        new Theme(1, "Afternoon\n4:00pm", "afternoon"),
        new Theme(2, "Afterwork\rOK", "afterwork"),
        new Theme(3, "Aristo\fda", "aristo"),
        new Theme(4, "Black-tie\fCool", "black-Tie"),
        new Theme(5, "Blitzer", "blitzer"),
        new Theme(6, "Bluesky", "bluesky"),
        new Theme(7, "Bootstrap", "bootstrap"),
        new Theme(8, "Casablanca", "casablanca"),
        new Theme(9, "Cupertino", "cupertino"),
        new Theme(10, "Cruze", "cruze"),
        new Theme(11, "Dark-Hive", "dark-hive"),
        new Theme(12, "Delta", "delta"),
        new Theme(13, "Dot-Luv", "dot-luv"),
        new Theme(14, "Eggplant", "eggplant"),
        new Theme(15, "Excite-Bike", "excite-bike"),
        new Theme(16, "Flick", "flick"),
        new Theme(17, "Glass-X", "glass-x"),
        new Theme(18, "Home", "home"),
        new Theme(19, "Hot-Sneaks", "hot-sneaks"),
        new Theme(20, "Humanity", "humanity"),
        new Theme(21, "Le-Frog", "le-frog"),
        new Theme(22, "Midnight", "midnight"),
        new Theme(23, "Mint-Choc", "mint-choc"),
        new Theme(24, "Overcast", "overcast"),
        new Theme(25, "Pepper-Grinder", "pepper-grinder"),
        new Theme(26, "Redmond", "redmond"),
        new Theme(27, "Rocket", "rocket"),
        new Theme(28, "Sam", "sam"),
        new Theme(29, "Smoothness", "smoothness"),
        new Theme(30, "South-Street", "south-street"),
        new Theme(31, "Start", "start"),
        new Theme(32, "Sunny", "sunny"),
        new Theme(33, "Swanky-Purse", "swanky-purse"),
        new Theme(34, "Trontastic", "trontastic"),
        new Theme(35, "UI-Darkness", "ui-darkness"),
        new Theme(36, "UI-Lightness", "ui-lightness"),
        new Theme(37, "Vader", "vader"));
    }
     
    public List<Theme> getThemes() {
        return themes;
    } 
}