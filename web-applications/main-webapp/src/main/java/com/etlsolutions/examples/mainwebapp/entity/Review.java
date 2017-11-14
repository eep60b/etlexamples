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
package com.etlsolutions.examples.mainwebapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Zhipeng
 */
@Entity
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByReviewId", query = "SELECT r FROM Review r WHERE r.reviewId = :reviewId"),
    @NamedQuery(name = "Review.findByReviewRanking", query = "SELECT r FROM Review r WHERE r.reviewRanking = :reviewRanking"),
    @NamedQuery(name = "Review.findByReviewText", query = "SELECT r FROM Review r WHERE r.reviewText = :reviewText")})
public class Review implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "review_id")
    private Integer reviewId;
    @Column(name = "review_ranking")
    private Integer reviewRanking;
    @Column(name = "review_text")
    private String reviewText;
    @JoinColumn(name = "item_common_detail_id", referencedColumnName = "item_common_detail_id")
    @ManyToOne
    private ItemCommonDetail itemCommonDetailId;
    @JoinColumn(name = "reviewer_id", referencedColumnName = "reviewer_id")
    @ManyToOne
    private Reviewer reviewerId;

    public Review() {
    }

    public Review(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getReviewRanking() {
        return reviewRanking;
    }

    public void setReviewRanking(Integer reviewRanking) {
        this.reviewRanking = reviewRanking;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public ItemCommonDetail getItemCommonDetailId() {
        return itemCommonDetailId;
    }

    public void setItemCommonDetailId(ItemCommonDetail itemCommonDetailId) {
        this.itemCommonDetailId = itemCommonDetailId;
    }

    public Reviewer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Reviewer reviewerId) {
        this.reviewerId = reviewerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.etlsolutions.examples.mainwebapp.entity.Review[ reviewId=" + reviewId + " ]";
    }
    
}
