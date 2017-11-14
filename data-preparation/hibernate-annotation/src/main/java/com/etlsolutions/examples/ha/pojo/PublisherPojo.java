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
package com.etlsolutions.examples.ha.pojo;
// Generated 10-Nov-2015 10:41:48 by Hibernate Tools 4.3.1

import com.etlsolutions.examples.data.api.Address;
import com.etlsolutions.examples.data.api.Book;
import com.etlsolutions.examples.data.api.Publisher;
import com.etlsolutions.examples.data.spi.PublisherSpi;
import com.etlsolutions.examples.ha.control.QueryNames;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.proxy.HibernateProxy;

/**
 * The PublisherPojo class is generated automatically then modified manually.
 *
 * @author Zhipeng Chang
 * 
 * @since 1.0.0
 * 
 * @version 1.0.0 - generated by NetBeans.
 * @version 1.0.1 - Add the implementation of PublisherSpi.
 * @version 1.1.0 - Override the equal and hashCode methods.
 */
@Entity
@Table(name = "publisher", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "publisher_name"))
@NamedQueries({
        @NamedQuery(name = QueryNames.findPublishers, query = "from PublisherPojo")
})
public class PublisherPojo implements Serializable, PublisherSpi<AddressPojo> {

    private static final long serialVersionUID = 319131310482543224L;   
    
    @Id
    @Column(name = "publisher_id", unique = true, nullable = false)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressPojo address;
    
    @Column(name = "publisher_name", unique = true, nullable = false, length = 100)
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publisher")
    private Set<Book> books = new HashSet<>(100);

    public PublisherPojo() {
    }

    public PublisherPojo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PublisherPojo(int id, AddressPojo address, String name, Set<Book> books) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.books = books;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public AddressPojo getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(AddressPojo address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

   @Override
    public int hashCode() {
        
        if(this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }
        
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.address);
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
             
        if(this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().equals(obj);
        }

        if(obj instanceof HibernateProxy) {
            return equals(((HibernateProxy)obj).getHibernateLazyInitializer().getImplementation());
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final PublisherPojo other = (PublisherPojo) obj;
        
        if (this.id != other.id) {
            return false;
        }
        
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        
        return Objects.equals(this.name, other.name);
    }


    @Override
    public boolean hasSameConstraint(Publisher publisher) {

        if (this == publisher) {
            return true;
        }

        if (publisher == null) {
            return false;
        }
        
 
        if(this instanceof HibernateProxy) {
            return ((PublisherPojo)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()).hasSameConstraint(publisher);
        }

        if(publisher instanceof HibernateProxy) {
            return hasSameConstraint(((PublisherPojo)(((HibernateProxy)publisher).getHibernateLazyInitializer().getImplementation())));
        }       

        return Objects.equals(getName(), publisher.getName());
    }

    @Override
    public boolean hasSameParameters(Publisher publisher) {

        if (this == publisher) {
            return true;
        }

        if (publisher == null) {
            return false;
        }
        
        if(this instanceof HibernateProxy) {
            return ((PublisherPojo)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation()).hasSameParameters(publisher);
        }

        if(publisher instanceof HibernateProxy) {
            return hasSameParameters(((PublisherPojo)(((HibernateProxy)publisher).getHibernateLazyInitializer().getImplementation())));
        }       

        Address a = publisher.getAddress();
        
        if(address != a && (address != null && !address.hasSameParameters(a))) {
            return false;
        }
        
        return Objects.equals(getName(), publisher.getName());
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }        
}
