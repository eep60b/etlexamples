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
import com.etlsolutions.examples.database.jpa.hibernate.jndi.DbConnection;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.EntryPoint;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.SystemType;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.SystemProperties;
import java.util.ArrayList;
import java.util.List;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.LogEntry;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Dealer;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.System;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.IllegalOrphanException;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author zc
 */
public class SystemJpaController implements Serializable {

    public SystemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(System system) {
        if (system.getSystemPropertiesList() == null) {
            system.setSystemPropertiesList(new ArrayList<SystemProperties>());
        }
        if (system.getLogEntryList() == null) {
            system.setLogEntryList(new ArrayList<LogEntry>());
        }
        if (system.getDealerList() == null) {
            system.setDealerList(new ArrayList<Dealer>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DbConnection dbConnectionId = system.getDbConnectionId();
            if (dbConnectionId != null) {
                dbConnectionId = em.getReference(dbConnectionId.getClass(), dbConnectionId.getId());
                system.setDbConnectionId(dbConnectionId);
            }
            EntryPoint entryPointId = system.getEntryPointId();
            if (entryPointId != null) {
                entryPointId = em.getReference(entryPointId.getClass(), entryPointId.getId());
                system.setEntryPointId(entryPointId);
            }
            SystemType systemTypeId = system.getSystemTypeId();
            if (systemTypeId != null) {
                systemTypeId = em.getReference(systemTypeId.getClass(), systemTypeId.getId());
                system.setSystemTypeId(systemTypeId);
            }
            List<SystemProperties> attachedSystemPropertiesList = new ArrayList<SystemProperties>();
            for (SystemProperties systemPropertiesListSystemPropertiesToAttach : system.getSystemPropertiesList()) {
                systemPropertiesListSystemPropertiesToAttach = em.getReference(systemPropertiesListSystemPropertiesToAttach.getClass(), systemPropertiesListSystemPropertiesToAttach.getId());
                attachedSystemPropertiesList.add(systemPropertiesListSystemPropertiesToAttach);
            }
            system.setSystemPropertiesList(attachedSystemPropertiesList);
            List<LogEntry> attachedLogEntryList = new ArrayList<LogEntry>();
            for (LogEntry logEntryListLogEntryToAttach : system.getLogEntryList()) {
                logEntryListLogEntryToAttach = em.getReference(logEntryListLogEntryToAttach.getClass(), logEntryListLogEntryToAttach.getId());
                attachedLogEntryList.add(logEntryListLogEntryToAttach);
            }
            system.setLogEntryList(attachedLogEntryList);
            List<Dealer> attachedDealerList = new ArrayList<Dealer>();
            for (Dealer dealerListDealerToAttach : system.getDealerList()) {
                dealerListDealerToAttach = em.getReference(dealerListDealerToAttach.getClass(), dealerListDealerToAttach.getEtlId());
                attachedDealerList.add(dealerListDealerToAttach);
            }
            system.setDealerList(attachedDealerList);
            em.persist(system);
            if (dbConnectionId != null) {
                dbConnectionId.getSystemList().add(system);
                dbConnectionId = em.merge(dbConnectionId);
            }
            if (entryPointId != null) {
                entryPointId.getSystemList().add(system);
                entryPointId = em.merge(entryPointId);
            }
            if (systemTypeId != null) {
                systemTypeId.getSystemList().add(system);
                systemTypeId = em.merge(systemTypeId);
            }
            for (SystemProperties systemPropertiesListSystemProperties : system.getSystemPropertiesList()) {
                System oldSystemIdOfSystemPropertiesListSystemProperties = systemPropertiesListSystemProperties.getSystemId();
                systemPropertiesListSystemProperties.setSystemId(system);
                systemPropertiesListSystemProperties = em.merge(systemPropertiesListSystemProperties);
                if (oldSystemIdOfSystemPropertiesListSystemProperties != null) {
                    oldSystemIdOfSystemPropertiesListSystemProperties.getSystemPropertiesList().remove(systemPropertiesListSystemProperties);
                    oldSystemIdOfSystemPropertiesListSystemProperties = em.merge(oldSystemIdOfSystemPropertiesListSystemProperties);
                }
            }
            for (LogEntry logEntryListLogEntry : system.getLogEntryList()) {
                System oldSystemIdOfLogEntryListLogEntry = logEntryListLogEntry.getSystemId();
                logEntryListLogEntry.setSystemId(system);
                logEntryListLogEntry = em.merge(logEntryListLogEntry);
                if (oldSystemIdOfLogEntryListLogEntry != null) {
                    oldSystemIdOfLogEntryListLogEntry.getLogEntryList().remove(logEntryListLogEntry);
                    oldSystemIdOfLogEntryListLogEntry = em.merge(oldSystemIdOfLogEntryListLogEntry);
                }
            }
            for (Dealer dealerListDealer : system.getDealerList()) {
                System oldSystemIdOfDealerListDealer = dealerListDealer.getSystemId();
                dealerListDealer.setSystemId(system);
                dealerListDealer = em.merge(dealerListDealer);
                if (oldSystemIdOfDealerListDealer != null) {
                    oldSystemIdOfDealerListDealer.getDealerList().remove(dealerListDealer);
                    oldSystemIdOfDealerListDealer = em.merge(oldSystemIdOfDealerListDealer);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(System system) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            System persistentSystem = em.find(System.class, system.getId());
            DbConnection dbConnectionIdOld = persistentSystem.getDbConnectionId();
            DbConnection dbConnectionIdNew = system.getDbConnectionId();
            EntryPoint entryPointIdOld = persistentSystem.getEntryPointId();
            EntryPoint entryPointIdNew = system.getEntryPointId();
            SystemType systemTypeIdOld = persistentSystem.getSystemTypeId();
            SystemType systemTypeIdNew = system.getSystemTypeId();
            List<SystemProperties> systemPropertiesListOld = persistentSystem.getSystemPropertiesList();
            List<SystemProperties> systemPropertiesListNew = system.getSystemPropertiesList();
            List<LogEntry> logEntryListOld = persistentSystem.getLogEntryList();
            List<LogEntry> logEntryListNew = system.getLogEntryList();
            List<Dealer> dealerListOld = persistentSystem.getDealerList();
            List<Dealer> dealerListNew = system.getDealerList();
            List<String> illegalOrphanMessages = null;
            for (LogEntry logEntryListOldLogEntry : logEntryListOld) {
                if (!logEntryListNew.contains(logEntryListOldLogEntry)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LogEntry " + logEntryListOldLogEntry + " since its systemId field is not nullable.");
                }
            }
            for (Dealer dealerListOldDealer : dealerListOld) {
                if (!dealerListNew.contains(dealerListOldDealer)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Dealer " + dealerListOldDealer + " since its systemId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (dbConnectionIdNew != null) {
                dbConnectionIdNew = em.getReference(dbConnectionIdNew.getClass(), dbConnectionIdNew.getId());
                system.setDbConnectionId(dbConnectionIdNew);
            }
            if (entryPointIdNew != null) {
                entryPointIdNew = em.getReference(entryPointIdNew.getClass(), entryPointIdNew.getId());
                system.setEntryPointId(entryPointIdNew);
            }
            if (systemTypeIdNew != null) {
                systemTypeIdNew = em.getReference(systemTypeIdNew.getClass(), systemTypeIdNew.getId());
                system.setSystemTypeId(systemTypeIdNew);
            }
            List<SystemProperties> attachedSystemPropertiesListNew = new ArrayList<SystemProperties>();
            for (SystemProperties systemPropertiesListNewSystemPropertiesToAttach : systemPropertiesListNew) {
                systemPropertiesListNewSystemPropertiesToAttach = em.getReference(systemPropertiesListNewSystemPropertiesToAttach.getClass(), systemPropertiesListNewSystemPropertiesToAttach.getId());
                attachedSystemPropertiesListNew.add(systemPropertiesListNewSystemPropertiesToAttach);
            }
            systemPropertiesListNew = attachedSystemPropertiesListNew;
            system.setSystemPropertiesList(systemPropertiesListNew);
            List<LogEntry> attachedLogEntryListNew = new ArrayList<LogEntry>();
            for (LogEntry logEntryListNewLogEntryToAttach : logEntryListNew) {
                logEntryListNewLogEntryToAttach = em.getReference(logEntryListNewLogEntryToAttach.getClass(), logEntryListNewLogEntryToAttach.getId());
                attachedLogEntryListNew.add(logEntryListNewLogEntryToAttach);
            }
            logEntryListNew = attachedLogEntryListNew;
            system.setLogEntryList(logEntryListNew);
            List<Dealer> attachedDealerListNew = new ArrayList<Dealer>();
            for (Dealer dealerListNewDealerToAttach : dealerListNew) {
                dealerListNewDealerToAttach = em.getReference(dealerListNewDealerToAttach.getClass(), dealerListNewDealerToAttach.getEtlId());
                attachedDealerListNew.add(dealerListNewDealerToAttach);
            }
            dealerListNew = attachedDealerListNew;
            system.setDealerList(dealerListNew);
            system = em.merge(system);
            if (dbConnectionIdOld != null && !dbConnectionIdOld.equals(dbConnectionIdNew)) {
                dbConnectionIdOld.getSystemList().remove(system);
                dbConnectionIdOld = em.merge(dbConnectionIdOld);
            }
            if (dbConnectionIdNew != null && !dbConnectionIdNew.equals(dbConnectionIdOld)) {
                dbConnectionIdNew.getSystemList().add(system);
                dbConnectionIdNew = em.merge(dbConnectionIdNew);
            }
            if (entryPointIdOld != null && !entryPointIdOld.equals(entryPointIdNew)) {
                entryPointIdOld.getSystemList().remove(system);
                entryPointIdOld = em.merge(entryPointIdOld);
            }
            if (entryPointIdNew != null && !entryPointIdNew.equals(entryPointIdOld)) {
                entryPointIdNew.getSystemList().add(system);
                entryPointIdNew = em.merge(entryPointIdNew);
            }
            if (systemTypeIdOld != null && !systemTypeIdOld.equals(systemTypeIdNew)) {
                systemTypeIdOld.getSystemList().remove(system);
                systemTypeIdOld = em.merge(systemTypeIdOld);
            }
            if (systemTypeIdNew != null && !systemTypeIdNew.equals(systemTypeIdOld)) {
                systemTypeIdNew.getSystemList().add(system);
                systemTypeIdNew = em.merge(systemTypeIdNew);
            }
            for (SystemProperties systemPropertiesListOldSystemProperties : systemPropertiesListOld) {
                if (!systemPropertiesListNew.contains(systemPropertiesListOldSystemProperties)) {
                    systemPropertiesListOldSystemProperties.setSystemId(null);
                    systemPropertiesListOldSystemProperties = em.merge(systemPropertiesListOldSystemProperties);
                }
            }
            for (SystemProperties systemPropertiesListNewSystemProperties : systemPropertiesListNew) {
                if (!systemPropertiesListOld.contains(systemPropertiesListNewSystemProperties)) {
                    System oldSystemIdOfSystemPropertiesListNewSystemProperties = systemPropertiesListNewSystemProperties.getSystemId();
                    systemPropertiesListNewSystemProperties.setSystemId(system);
                    systemPropertiesListNewSystemProperties = em.merge(systemPropertiesListNewSystemProperties);
                    if (oldSystemIdOfSystemPropertiesListNewSystemProperties != null && !oldSystemIdOfSystemPropertiesListNewSystemProperties.equals(system)) {
                        oldSystemIdOfSystemPropertiesListNewSystemProperties.getSystemPropertiesList().remove(systemPropertiesListNewSystemProperties);
                        oldSystemIdOfSystemPropertiesListNewSystemProperties = em.merge(oldSystemIdOfSystemPropertiesListNewSystemProperties);
                    }
                }
            }
            for (LogEntry logEntryListNewLogEntry : logEntryListNew) {
                if (!logEntryListOld.contains(logEntryListNewLogEntry)) {
                    System oldSystemIdOfLogEntryListNewLogEntry = logEntryListNewLogEntry.getSystemId();
                    logEntryListNewLogEntry.setSystemId(system);
                    logEntryListNewLogEntry = em.merge(logEntryListNewLogEntry);
                    if (oldSystemIdOfLogEntryListNewLogEntry != null && !oldSystemIdOfLogEntryListNewLogEntry.equals(system)) {
                        oldSystemIdOfLogEntryListNewLogEntry.getLogEntryList().remove(logEntryListNewLogEntry);
                        oldSystemIdOfLogEntryListNewLogEntry = em.merge(oldSystemIdOfLogEntryListNewLogEntry);
                    }
                }
            }
            for (Dealer dealerListNewDealer : dealerListNew) {
                if (!dealerListOld.contains(dealerListNewDealer)) {
                    System oldSystemIdOfDealerListNewDealer = dealerListNewDealer.getSystemId();
                    dealerListNewDealer.setSystemId(system);
                    dealerListNewDealer = em.merge(dealerListNewDealer);
                    if (oldSystemIdOfDealerListNewDealer != null && !oldSystemIdOfDealerListNewDealer.equals(system)) {
                        oldSystemIdOfDealerListNewDealer.getDealerList().remove(dealerListNewDealer);
                        oldSystemIdOfDealerListNewDealer = em.merge(oldSystemIdOfDealerListNewDealer);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = system.getId();
                if (findSystem(id) == null) {
                    throw new NonexistentEntityException("The system with id " + id + " no longer exists.");
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
            System system;
            try {
                system = em.getReference(System.class, id);
                system.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The system with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<LogEntry> logEntryListOrphanCheck = system.getLogEntryList();
            for (LogEntry logEntryListOrphanCheckLogEntry : logEntryListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This System (" + system + ") cannot be destroyed since the LogEntry " + logEntryListOrphanCheckLogEntry + " in its logEntryList field has a non-nullable systemId field.");
            }
            List<Dealer> dealerListOrphanCheck = system.getDealerList();
            for (Dealer dealerListOrphanCheckDealer : dealerListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This System (" + system + ") cannot be destroyed since the Dealer " + dealerListOrphanCheckDealer + " in its dealerList field has a non-nullable systemId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            DbConnection dbConnectionId = system.getDbConnectionId();
            if (dbConnectionId != null) {
                dbConnectionId.getSystemList().remove(system);
                dbConnectionId = em.merge(dbConnectionId);
            }
            EntryPoint entryPointId = system.getEntryPointId();
            if (entryPointId != null) {
                entryPointId.getSystemList().remove(system);
                entryPointId = em.merge(entryPointId);
            }
            SystemType systemTypeId = system.getSystemTypeId();
            if (systemTypeId != null) {
                systemTypeId.getSystemList().remove(system);
                systemTypeId = em.merge(systemTypeId);
            }
            List<SystemProperties> systemPropertiesList = system.getSystemPropertiesList();
            for (SystemProperties systemPropertiesListSystemProperties : systemPropertiesList) {
                systemPropertiesListSystemProperties.setSystemId(null);
                systemPropertiesListSystemProperties = em.merge(systemPropertiesListSystemProperties);
            }
            em.remove(system);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<System> findSystemEntities() {
        return findSystemEntities(true, -1, -1);
    }

    public List<System> findSystemEntities(int maxResults, int firstResult) {
        return findSystemEntities(false, maxResults, firstResult);
    }

    private List<System> findSystemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(System.class));
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

    public System findSystem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(System.class, id);
        } finally {
            em.close();
        }
    }

    public int getSystemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<System> rt = cq.from(System.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
