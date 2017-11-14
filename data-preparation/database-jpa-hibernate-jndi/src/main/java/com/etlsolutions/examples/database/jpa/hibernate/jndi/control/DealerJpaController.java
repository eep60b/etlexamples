/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi.control;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.AutolineHacking;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Dealer;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Schedule;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.System;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.ElementMappingGroup;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.IllegalOrphanException;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author zc
 */
public class DealerJpaController implements Serializable {

    public DealerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dealer dealer) {
        if (dealer.getElementMappingGroupList() == null) {
            dealer.setElementMappingGroupList(new ArrayList<ElementMappingGroup>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AutolineHacking autolineHackingId = dealer.getAutolineHackingId();
            if (autolineHackingId != null) {
                autolineHackingId = em.getReference(autolineHackingId.getClass(), autolineHackingId.getId());
                dealer.setAutolineHackingId(autolineHackingId);
            }
            Schedule scheduleId = dealer.getScheduleId();
            if (scheduleId != null) {
                scheduleId = em.getReference(scheduleId.getClass(), scheduleId.getId());
                dealer.setScheduleId(scheduleId);
            }
            System systemId = dealer.getSystemId();
            if (systemId != null) {
                systemId = em.getReference(systemId.getClass(), systemId.getId());
                dealer.setSystemId(systemId);
            }
            List<ElementMappingGroup> attachedElementMappingGroupList = new ArrayList<ElementMappingGroup>();
            for (ElementMappingGroup elementMappingGroupListElementMappingGroupToAttach : dealer.getElementMappingGroupList()) {
                elementMappingGroupListElementMappingGroupToAttach = em.getReference(elementMappingGroupListElementMappingGroupToAttach.getClass(), elementMappingGroupListElementMappingGroupToAttach.getElementMappingGroupPK());
                attachedElementMappingGroupList.add(elementMappingGroupListElementMappingGroupToAttach);
            }
            dealer.setElementMappingGroupList(attachedElementMappingGroupList);
            em.persist(dealer);
            if (autolineHackingId != null) {
                autolineHackingId.getDealerList().add(dealer);
                autolineHackingId = em.merge(autolineHackingId);
            }
            if (scheduleId != null) {
                scheduleId.getDealerList().add(dealer);
                scheduleId = em.merge(scheduleId);
            }
            if (systemId != null) {
                systemId.getDealerList().add(dealer);
                systemId = em.merge(systemId);
            }
            for (ElementMappingGroup elementMappingGroupListElementMappingGroup : dealer.getElementMappingGroupList()) {
                Dealer oldDealerOfElementMappingGroupListElementMappingGroup = elementMappingGroupListElementMappingGroup.getDealer();
                elementMappingGroupListElementMappingGroup.setDealer(dealer);
                elementMappingGroupListElementMappingGroup = em.merge(elementMappingGroupListElementMappingGroup);
                if (oldDealerOfElementMappingGroupListElementMappingGroup != null) {
                    oldDealerOfElementMappingGroupListElementMappingGroup.getElementMappingGroupList().remove(elementMappingGroupListElementMappingGroup);
                    oldDealerOfElementMappingGroupListElementMappingGroup = em.merge(oldDealerOfElementMappingGroupListElementMappingGroup);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dealer dealer) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dealer persistentDealer = em.find(Dealer.class, dealer.getEtlId());
            AutolineHacking autolineHackingIdOld = persistentDealer.getAutolineHackingId();
            AutolineHacking autolineHackingIdNew = dealer.getAutolineHackingId();
            Schedule scheduleIdOld = persistentDealer.getScheduleId();
            Schedule scheduleIdNew = dealer.getScheduleId();
            System systemIdOld = persistentDealer.getSystemId();
            System systemIdNew = dealer.getSystemId();
            List<ElementMappingGroup> elementMappingGroupListOld = persistentDealer.getElementMappingGroupList();
            List<ElementMappingGroup> elementMappingGroupListNew = dealer.getElementMappingGroupList();
            List<String> illegalOrphanMessages = null;
            for (ElementMappingGroup elementMappingGroupListOldElementMappingGroup : elementMappingGroupListOld) {
                if (!elementMappingGroupListNew.contains(elementMappingGroupListOldElementMappingGroup)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ElementMappingGroup " + elementMappingGroupListOldElementMappingGroup + " since its dealer field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (autolineHackingIdNew != null) {
                autolineHackingIdNew = em.getReference(autolineHackingIdNew.getClass(), autolineHackingIdNew.getId());
                dealer.setAutolineHackingId(autolineHackingIdNew);
            }
            if (scheduleIdNew != null) {
                scheduleIdNew = em.getReference(scheduleIdNew.getClass(), scheduleIdNew.getId());
                dealer.setScheduleId(scheduleIdNew);
            }
            if (systemIdNew != null) {
                systemIdNew = em.getReference(systemIdNew.getClass(), systemIdNew.getId());
                dealer.setSystemId(systemIdNew);
            }
            List<ElementMappingGroup> attachedElementMappingGroupListNew = new ArrayList<ElementMappingGroup>();
            for (ElementMappingGroup elementMappingGroupListNewElementMappingGroupToAttach : elementMappingGroupListNew) {
                elementMappingGroupListNewElementMappingGroupToAttach = em.getReference(elementMappingGroupListNewElementMappingGroupToAttach.getClass(), elementMappingGroupListNewElementMappingGroupToAttach.getElementMappingGroupPK());
                attachedElementMappingGroupListNew.add(elementMappingGroupListNewElementMappingGroupToAttach);
            }
            elementMappingGroupListNew = attachedElementMappingGroupListNew;
            dealer.setElementMappingGroupList(elementMappingGroupListNew);
            dealer = em.merge(dealer);
            if (autolineHackingIdOld != null && !autolineHackingIdOld.equals(autolineHackingIdNew)) {
                autolineHackingIdOld.getDealerList().remove(dealer);
                autolineHackingIdOld = em.merge(autolineHackingIdOld);
            }
            if (autolineHackingIdNew != null && !autolineHackingIdNew.equals(autolineHackingIdOld)) {
                autolineHackingIdNew.getDealerList().add(dealer);
                autolineHackingIdNew = em.merge(autolineHackingIdNew);
            }
            if (scheduleIdOld != null && !scheduleIdOld.equals(scheduleIdNew)) {
                scheduleIdOld.getDealerList().remove(dealer);
                scheduleIdOld = em.merge(scheduleIdOld);
            }
            if (scheduleIdNew != null && !scheduleIdNew.equals(scheduleIdOld)) {
                scheduleIdNew.getDealerList().add(dealer);
                scheduleIdNew = em.merge(scheduleIdNew);
            }
            if (systemIdOld != null && !systemIdOld.equals(systemIdNew)) {
                systemIdOld.getDealerList().remove(dealer);
                systemIdOld = em.merge(systemIdOld);
            }
            if (systemIdNew != null && !systemIdNew.equals(systemIdOld)) {
                systemIdNew.getDealerList().add(dealer);
                systemIdNew = em.merge(systemIdNew);
            }
            for (ElementMappingGroup elementMappingGroupListNewElementMappingGroup : elementMappingGroupListNew) {
                if (!elementMappingGroupListOld.contains(elementMappingGroupListNewElementMappingGroup)) {
                    Dealer oldDealerOfElementMappingGroupListNewElementMappingGroup = elementMappingGroupListNewElementMappingGroup.getDealer();
                    elementMappingGroupListNewElementMappingGroup.setDealer(dealer);
                    elementMappingGroupListNewElementMappingGroup = em.merge(elementMappingGroupListNewElementMappingGroup);
                    if (oldDealerOfElementMappingGroupListNewElementMappingGroup != null && !oldDealerOfElementMappingGroupListNewElementMappingGroup.equals(dealer)) {
                        oldDealerOfElementMappingGroupListNewElementMappingGroup.getElementMappingGroupList().remove(elementMappingGroupListNewElementMappingGroup);
                        oldDealerOfElementMappingGroupListNewElementMappingGroup = em.merge(oldDealerOfElementMappingGroupListNewElementMappingGroup);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dealer.getEtlId();
                if (findDealer(id) == null) {
                    throw new NonexistentEntityException("The dealer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dealer dealer;
            try {
                dealer = em.getReference(Dealer.class, id);
                dealer.getEtlId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dealer with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<ElementMappingGroup> elementMappingGroupListOrphanCheck = dealer.getElementMappingGroupList();
            for (ElementMappingGroup elementMappingGroupListOrphanCheckElementMappingGroup : elementMappingGroupListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dealer (" + dealer + ") cannot be destroyed since the ElementMappingGroup " + elementMappingGroupListOrphanCheckElementMappingGroup + " in its elementMappingGroupList field has a non-nullable dealer field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            AutolineHacking autolineHackingId = dealer.getAutolineHackingId();
            if (autolineHackingId != null) {
                autolineHackingId.getDealerList().remove(dealer);
                autolineHackingId = em.merge(autolineHackingId);
            }
            Schedule scheduleId = dealer.getScheduleId();
            if (scheduleId != null) {
                scheduleId.getDealerList().remove(dealer);
                scheduleId = em.merge(scheduleId);
            }
            System systemId = dealer.getSystemId();
            if (systemId != null) {
                systemId.getDealerList().remove(dealer);
                systemId = em.merge(systemId);
            }
            em.remove(dealer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dealer> findDealerEntities() {
        return findDealerEntities(true, -1, -1);
    }

    public List<Dealer> findDealerEntities(int maxResults, int firstResult) {
        return findDealerEntities(false, maxResults, firstResult);
    }

    private List<Dealer> findDealerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dealer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Dealer findDealer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dealer.class, id);
        } finally {
            em.close();
        }
    }

    public int getDealerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dealer> rt = cq.from(Dealer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
