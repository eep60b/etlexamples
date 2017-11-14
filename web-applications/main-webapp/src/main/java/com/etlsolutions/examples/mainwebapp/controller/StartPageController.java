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
package com.etlsolutions.examples.mainwebapp.controller;

import com.etlsolutions.examples.data.general.NameComparator;
import com.etlsolutions.examples.mainwebapp.entity.Book;
import com.etlsolutions.examples.mainwebapp.entity.Category;
import com.etlsolutions.examples.mainwebapp.facade.CategoryFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * The StartPageController class provide the necessary methods for the
 * start.xhtml page to display.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 *
 */
//TODO: add tests, java doc and annotations.
@Named(value = "startPageController")
@ViewScoped
public class StartPageController implements Serializable {

    private static final long serialVersionUID = 48334377985314509L;

    @Inject
    private CategoryFacade categoryFacade;

    private Category selectedCategory;
    private final List<Category> categories = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        categories.addAll(categoryFacade.findAll());
        Collections.sort(categories, new NameComparator());

        if (categories.isEmpty()) {
            return;
        }
        selectedCategory = categories.get(0);
        selectedCategory.getItemCommonDetailCollection().stream().map((item) -> item.getBook()).filter((book) -> (book != null)).forEach((book) -> {
            books.add(book);
        });
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Category getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(Category selectedCategory) {
        this.selectedCategory = selectedCategory;
        books.clear();
        if (selectedCategory != null) {
            selectedCategory.getItemCommonDetailCollection().stream().map((item) -> item.getBook()).filter((book) -> (book != null)).forEach((book) -> {
                books.add(book);
            });
        }
    }
}
