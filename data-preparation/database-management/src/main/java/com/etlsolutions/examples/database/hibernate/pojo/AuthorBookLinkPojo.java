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
package com.etlsolutions.examples.database.hibernate.pojo;

import com.etlsolutions.examples.utility.ConstrainableUtilities;
import com.etlsolutions.examples.data.api.AuthorBookLink;
import com.etlsolutions.examples.data.api.identifiable.IdentifiableAuthorBookLink;
import java.io.Serializable;
import java.util.Objects;
import org.hibernate.proxy.HibernateProxy;

/**
 * The AuthorBookLinkPojo class represents an entry in the AUGHOR_BOOK_LINK
 * table of the database.
 *
 * @author Zhipeng Chang
 *
 * @since 1.0.0
 *
 * @version 1.0.0
 */
public class AuthorBookLinkPojo implements Serializable, IdentifiableAuthorBookLink {

    private static final long serialVersionUID = 466493046297379855L;
    
    private AuthorPojo authorPojo;
    private BookPojo bookPojo;

    public AuthorBookLinkPojo() {
    }
    
    /**
     * Construct an object using the specified POJOs.
     *
     * @param authorPojo
     * @param bookPojo
     */
    public AuthorBookLinkPojo(AuthorPojo authorPojo, BookPojo bookPojo) {
        this.authorPojo = authorPojo;
        this.bookPojo = bookPojo;
    }

    @Override
    public int getAuthorId() {
        return authorPojo == null ? 0 : authorPojo.getId();
    }

    @Override
    public int getBookId() {
        return bookPojo == null ? 0 : bookPojo.getId();
    }

    @Override
    public AuthorPojo getAuthor() {
        return authorPojo;
    }

    @Override
    public BookPojo getBook() {
        return bookPojo;
    }

    @Override
    public boolean hasSameConstraint(AuthorBookLink authorBookLink) {
        
        if(this == authorBookLink) {
            return true;
        }
        
        if(authorBookLink == null) {
            return false;
        }        
        
        
        if(this instanceof HibernateProxy) {
            return authorBookLink.hasSameConstraint((AuthorBookLink)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation());
        }

        if(authorBookLink instanceof HibernateProxy) {
            return hasSameConstraint(((AuthorBookLink)(((HibernateProxy)authorBookLink).getHibernateLazyInitializer().getImplementation())));
        }         
        
        if(!ConstrainableUtilities.hasSameConstraint(authorPojo, authorBookLink.getAuthor())) {
            
            return false;
        }

        return ConstrainableUtilities.hasSameConstraint(bookPojo, authorBookLink.getBook());
    }
    
    @Override
    public boolean hasSameParameters(AuthorBookLink authorBookLink) {
        
        if(this == authorBookLink) {
            return true;
        }
        
        if(authorBookLink == null) {
            return false;
        }        
        
        if(this instanceof HibernateProxy) {
            return authorBookLink.hasSameParameters((AuthorBookLink)((HibernateProxy) this).getHibernateLazyInitializer().getImplementation());
        }

        if(authorBookLink instanceof HibernateProxy) {
            return hasSameParameters(((AuthorBookLink)(((HibernateProxy)authorBookLink).getHibernateLazyInitializer().getImplementation())));
        }             

        return ConstrainableUtilities.hasSameParameters(authorPojo, authorBookLink.getAuthor()) && ConstrainableUtilities.hasSameParameters(bookPojo, authorBookLink.getBook());
    }

    @Override
    public int hashCode() {

        if(this instanceof HibernateProxy) {
            return ((HibernateProxy) this).getHibernateLazyInitializer().getImplementation().hashCode();
        }
        
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.authorPojo);
        hash = 17 * hash + Objects.hashCode(this.bookPojo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(this == obj) {
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
        
        final AuthorBookLinkPojo other = (AuthorBookLinkPojo) obj;

        return Objects.equals(this.authorPojo, other.authorPojo) && Objects.equals(this.bookPojo, other.bookPojo);
    }
}
