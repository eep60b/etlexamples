/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi.control;

import com.etlsolutions.examples.database.jpa.hibernate.jndi.AutolineHacking;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.LogEntry;
import java.util.ArrayList;
import java.util.List;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Dealer;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author zc
 */
public class AutolineHackingJpaController implements Serializable {

    public AutolineHackingJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AutolineHacking autolineHacking) {
        if (autolineHacking.getLogEntryList() == null) {
            autolineHacking.setLogEntryList(new ArrayList<LogEntry>());
        }
        if (autolineHacking.getDealerList() == null) {
            autolineHacking.setDealerList(new ArrayList<Dealer>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<LogEntry> attachedLogEntryList = new ArrayList<LogEntry>();
            for (LogEntry logEntryListLogEntryToAttach : autolineHacking.getLogEntryList()) {
                logEntryListLogEntryToAttach = em.getReference(logEntryListLogEntryToAttach.getClass(), logEntryListLogEntryToAttach.getId());
                attachedLogEntryList.add(logEntryListLogEntryToAttach);
            }
            autolineHacking.setLogEntryList(attachedLogEntryList);
            List<Dealer> attachedDealerList = new ArrayList<Dealer>();
            for (Dealer dealerListDealerToAttach : autolineHacking.getDealerList()) {
                dealerListDealerToAttach = em.getReference(dealerListDealerToAttach.getClass(), dealerListDealerToAttach.getEtlId());
                attachedDealerList.add(dealerListDealerToAttach);
            }
            autolineHacking.setDealerList(attachedDealerList);
            em.persist(autolineHacking);
            for (LogEntry logEntryListLogEntry : autolineHacking.getLogEntryList()) {
                AutolineHacking oldAutolinehackingIdOfLogEntryListLogEntry = logEntryListLogEntry.getAutolinehackingId();
                logEntryListLogEntry.setAutolinehackingId(autolineHacking);
                logEntryListLogEntry = em.merge(logEntryListLogEntry);
                if (oldAutolinehackingIdOfLogEntryListLogEntry != null) {
                    oldAutolinehackingIdOfLogEntryListLogEntry.getLogEntryList().remove(logEntryListLogEntry);
                    oldAutolinehackingIdOfLogEntryListLogEntry = em.merge(oldAutolinehackingIdOfLogEntryListLogEntry);
                }
            }
            for (Dealer dealerListDealer : autolineHacking.getDealerList()) {
                AutolineHacking oldAutolineHackingIdOfDealerListDealer = dealerListDealer.getAutolineHackingId();
                dealerListDealer.setAutolineHackingId(autolineHacking);
                dealerListDealer = em.merge(dealerListDealer);
                if (oldAutolineHackingIdOfDealerListDealer != null) {
                    oldAutolineHackingIdOfDealerListDealer.getDealerList().remove(dealerListDealer);
                    oldAutolineHackingIdOfDealerListDealer = em.merge(oldAutolineHackingIdOfDealerListDealer);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AutolineHacking autolineHacking) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AutolineHacking persistentAutolineHacking = em.find(AutolineHacking.class, autolineHacking.getId());
            List<LogEntry> logEntryListOld = persistentAutolineHacking.getLogEntryList();
            List<LogEntry> logEntryListNew = autolineHacking.getLogEntryList();
            List<Dealer> dealerListOld = persistentAutolineHacking.getDealerList();
            List<Dealer> dealerListNew = autolineHacking.getDealerList();
            List<LogEntry> attachedLogEntryListNew = new ArrayList<LogEntry>();
            for (LogEntry logEntryListNewLogEntryToAttach : logEntryListNew) {
                logEntryListNewLogEntryToAttach = em.getReference(logEntryListNewLogEntryToAttach.getClass(), logEntryListNewLogEntryToAttach.getId());
                attachedLogEntryListNew.add(logEntryListNewLogEntryToAttach);
            }
            logEntryListNew = attachedLogEntryListNew;
            autolineHacking.setLogEntryList(logEntryListNew);
            List<Dealer> attachedDealerListNew = new ArrayList<Dealer>();
            for (Dealer dealerListNewDealerToAttach : dealerListNew) {
                dealerListNewDealerToAttach = em.getReference(dealerListNewDealerToAttach.getClass(), dealerListNewDealerToAttach.getEtlId());
                attachedDealerListNew.add(dealerListNewDealerToAttach);
            }
            dealerListNew = attachedDealerListNew;
            autolineHacking.setDealerList(dealerListNew);
            autolineHacking = em.merge(autolineHacking);
            for (LogEntry logEntryListOldLogEntry : logEntryListOld) {
                if (!logEntryListNew.contains(logEntryListOldLogEntry)) {
                    logEntryListOldLogEntry.setAutolinehackingId(null);
                    logEntryListOldLogEntry = em.merge(logEntryListOldLogEntry);
                }
            }
            for (LogEntry logEntryListNewLogEntry : logEntryListNew) {
                if (!logEntryListOld.contains(logEntryListNewLogEntry)) {
                    AutolineHacking oldAutolinehackingIdOfLogEntryListNewLogEntry = logEntryListNewLogEntry.getAutolinehackingId();
                    logEntryListNewLogEntry.setAutolinehackingId(autolineHacking);
                    logEntryListNewLogEntry = em.merge(logEntryListNewLogEntry);
                    if (oldAutolinehackingIdOfLogEntryListNewLogEntry != null && !oldAutolinehackingIdOfLogEntryListNewLogEntry.equals(autolineHacking)) {
                        oldAutolinehackingIdOfLogEntryListNewLogEntry.getLogEntryList().remove(logEntryListNewLogEntry);
                        oldAutolinehackingIdOfLogEntryListNewLogEntry = em.merge(oldAutolinehackingIdOfLogEntryListNewLogEntry);
                    }
                }
            }
            for (Dealer dealerListOldDealer : dealerListOld) {
                if (!dealerListNew.contains(dealerListOldDealer)) {
                    dealerListOldDealer.setAutolineHackingId(null);
                    dealerListOldDealer = em.merge(dealerListOldDealer);
                }
            }
            for (Dealer dealerListNewDealer : dealerListNew) {
                if (!dealerListOld.contains(dealerListNewDealer)) {
                    AutolineHacking oldAutolineHackingIdOfDealerListNewDealer = dealerListNewDealer.getAutolineHackingId();
                    dealerListNewDealer.setAutolineHackingId(autolineHacking);
                    dealerListNewDealer = em.merge(dealerListNewDealer);
                    if (oldAutolineHackingIdOfDealerListNewDealer != null && !oldAutolineHackingIdOfDealerListNewDealer.equals(autolineHacking)) {
                        oldAutolineHackingIdOfDealerListNewDealer.getDealerList().remove(dealerListNewDealer);
                        oldAutolineHackingIdOfDealerListNewDealer = em.merge(oldAutolineHackingIdOfDealerListNewDealer);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = autolineHacking.getId();
                if (findAutolineHacking(id) == null) {
                    throw new NonexistentEntityException("The autolineHacking with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AutolineHacking autolineHacking;
            try {
                autolineHacking = em.getReference(AutolineHacking.class, id);
                autolineHacking.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autolineHacking with id " + id + " no longer exists.", enfe);
            }
            List<LogEntry> logEntryList = autolineHacking.getLogEntryList();
            for (LogEntry logEntryListLogEntry : logEntryList) {
                logEntryListLogEntry.setAutolinehackingId(null);
                logEntryListLogEntry = em.merge(logEntryListLogEntry);
            }
            List<Dealer> dealerList = autolineHacking.getDealerList();
            for (Dealer dealerListDealer : dealerList) {
                dealerListDealer.setAutolineHackingId(null);
                dealerListDealer = em.merge(dealerListDealer);
            }
            em.remove(autolineHacking);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AutolineHacking> findAutolineHackingEntities() {
        return findAutolineHackingEntities(true, -1, -1);
    }

    public List<AutolineHacking> findAutolineHackingEntities(int maxResults, int firstResult) {
        return findAutolineHackingEntities(false, maxResults, firstResult);
    }

    private List<AutolineHacking> findAutolineHackingEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AutolineHacking.class));
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

    public AutolineHacking findAutolineHacking(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AutolineHacking.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutolineHackingCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AutolineHacking> rt = cq.from(AutolineHacking.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
