/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi.control;

import com.etlsolutions.examples.database.jpa.hibernate.jndi.EntryPoint;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Property;
import java.util.ArrayList;
import java.util.List;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Log;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.System;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.IllegalOrphanException;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.NonexistentEntityException;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.PreexistingEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author zc
 */
public class EntryPointJpaController implements Serializable {

    public EntryPointJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EntryPoint entryPoint) throws PreexistingEntityException, Exception {
        if (entryPoint.getPropertyList() == null) {
            entryPoint.setPropertyList(new ArrayList<Property>());
        }
        if (entryPoint.getLogList() == null) {
            entryPoint.setLogList(new ArrayList<Log>());
        }
        if (entryPoint.getSystemList() == null) {
            entryPoint.setSystemList(new ArrayList<System>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Property> attachedPropertyList = new ArrayList<Property>();
            for (Property propertyListPropertyToAttach : entryPoint.getPropertyList()) {
                propertyListPropertyToAttach = em.getReference(propertyListPropertyToAttach.getClass(), propertyListPropertyToAttach.getId());
                attachedPropertyList.add(propertyListPropertyToAttach);
            }
            entryPoint.setPropertyList(attachedPropertyList);
            List<Log> attachedLogList = new ArrayList<Log>();
            for (Log logListLogToAttach : entryPoint.getLogList()) {
                logListLogToAttach = em.getReference(logListLogToAttach.getClass(), logListLogToAttach.getId());
                attachedLogList.add(logListLogToAttach);
            }
            entryPoint.setLogList(attachedLogList);
            List<System> attachedSystemList = new ArrayList<System>();
            for (System systemListSystemToAttach : entryPoint.getSystemList()) {
                systemListSystemToAttach = em.getReference(systemListSystemToAttach.getClass(), systemListSystemToAttach.getId());
                attachedSystemList.add(systemListSystemToAttach);
            }
            entryPoint.setSystemList(attachedSystemList);
            em.persist(entryPoint);
            for (Property propertyListProperty : entryPoint.getPropertyList()) {
                propertyListProperty.getEntryPointList().add(entryPoint);
                propertyListProperty = em.merge(propertyListProperty);
            }
            for (Log logListLog : entryPoint.getLogList()) {
                EntryPoint oldEntryPointIdOfLogListLog = logListLog.getEntryPointId();
                logListLog.setEntryPointId(entryPoint);
                logListLog = em.merge(logListLog);
                if (oldEntryPointIdOfLogListLog != null) {
                    oldEntryPointIdOfLogListLog.getLogList().remove(logListLog);
                    oldEntryPointIdOfLogListLog = em.merge(oldEntryPointIdOfLogListLog);
                }
            }
            for (System systemListSystem : entryPoint.getSystemList()) {
                EntryPoint oldEntryPointIdOfSystemListSystem = systemListSystem.getEntryPointId();
                systemListSystem.setEntryPointId(entryPoint);
                systemListSystem = em.merge(systemListSystem);
                if (oldEntryPointIdOfSystemListSystem != null) {
                    oldEntryPointIdOfSystemListSystem.getSystemList().remove(systemListSystem);
                    oldEntryPointIdOfSystemListSystem = em.merge(oldEntryPointIdOfSystemListSystem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntryPoint(entryPoint.getId()) != null) {
                throw new PreexistingEntityException("EntryPoint " + entryPoint + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EntryPoint entryPoint) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EntryPoint persistentEntryPoint = em.find(EntryPoint.class, entryPoint.getId());
            List<Property> propertyListOld = persistentEntryPoint.getPropertyList();
            List<Property> propertyListNew = entryPoint.getPropertyList();
            List<Log> logListOld = persistentEntryPoint.getLogList();
            List<Log> logListNew = entryPoint.getLogList();
            List<System> systemListOld = persistentEntryPoint.getSystemList();
            List<System> systemListNew = entryPoint.getSystemList();
            List<String> illegalOrphanMessages = null;
            for (Log logListOldLog : logListOld) {
                if (!logListNew.contains(logListOldLog)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Log " + logListOldLog + " since its entryPointId field is not nullable.");
                }
            }
            for (System systemListOldSystem : systemListOld) {
                if (!systemListNew.contains(systemListOldSystem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain System " + systemListOldSystem + " since its entryPointId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Property> attachedPropertyListNew = new ArrayList<Property>();
            for (Property propertyListNewPropertyToAttach : propertyListNew) {
                propertyListNewPropertyToAttach = em.getReference(propertyListNewPropertyToAttach.getClass(), propertyListNewPropertyToAttach.getId());
                attachedPropertyListNew.add(propertyListNewPropertyToAttach);
            }
            propertyListNew = attachedPropertyListNew;
            entryPoint.setPropertyList(propertyListNew);
            List<Log> attachedLogListNew = new ArrayList<Log>();
            for (Log logListNewLogToAttach : logListNew) {
                logListNewLogToAttach = em.getReference(logListNewLogToAttach.getClass(), logListNewLogToAttach.getId());
                attachedLogListNew.add(logListNewLogToAttach);
            }
            logListNew = attachedLogListNew;
            entryPoint.setLogList(logListNew);
            List<System> attachedSystemListNew = new ArrayList<System>();
            for (System systemListNewSystemToAttach : systemListNew) {
                systemListNewSystemToAttach = em.getReference(systemListNewSystemToAttach.getClass(), systemListNewSystemToAttach.getId());
                attachedSystemListNew.add(systemListNewSystemToAttach);
            }
            systemListNew = attachedSystemListNew;
            entryPoint.setSystemList(systemListNew);
            entryPoint = em.merge(entryPoint);
            for (Property propertyListOldProperty : propertyListOld) {
                if (!propertyListNew.contains(propertyListOldProperty)) {
                    propertyListOldProperty.getEntryPointList().remove(entryPoint);
                    propertyListOldProperty = em.merge(propertyListOldProperty);
                }
            }
            for (Property propertyListNewProperty : propertyListNew) {
                if (!propertyListOld.contains(propertyListNewProperty)) {
                    propertyListNewProperty.getEntryPointList().add(entryPoint);
                    propertyListNewProperty = em.merge(propertyListNewProperty);
                }
            }
            for (Log logListNewLog : logListNew) {
                if (!logListOld.contains(logListNewLog)) {
                    EntryPoint oldEntryPointIdOfLogListNewLog = logListNewLog.getEntryPointId();
                    logListNewLog.setEntryPointId(entryPoint);
                    logListNewLog = em.merge(logListNewLog);
                    if (oldEntryPointIdOfLogListNewLog != null && !oldEntryPointIdOfLogListNewLog.equals(entryPoint)) {
                        oldEntryPointIdOfLogListNewLog.getLogList().remove(logListNewLog);
                        oldEntryPointIdOfLogListNewLog = em.merge(oldEntryPointIdOfLogListNewLog);
                    }
                }
            }
            for (System systemListNewSystem : systemListNew) {
                if (!systemListOld.contains(systemListNewSystem)) {
                    EntryPoint oldEntryPointIdOfSystemListNewSystem = systemListNewSystem.getEntryPointId();
                    systemListNewSystem.setEntryPointId(entryPoint);
                    systemListNewSystem = em.merge(systemListNewSystem);
                    if (oldEntryPointIdOfSystemListNewSystem != null && !oldEntryPointIdOfSystemListNewSystem.equals(entryPoint)) {
                        oldEntryPointIdOfSystemListNewSystem.getSystemList().remove(systemListNewSystem);
                        oldEntryPointIdOfSystemListNewSystem = em.merge(oldEntryPointIdOfSystemListNewSystem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = entryPoint.getId();
                if (findEntryPoint(id) == null) {
                    throw new NonexistentEntityException("The entryPoint with id " + id + " no longer exists.");
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
            EntryPoint entryPoint;
            try {
                entryPoint = em.getReference(EntryPoint.class, id);
                entryPoint.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entryPoint with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Log> logListOrphanCheck = entryPoint.getLogList();
            for (Log logListOrphanCheckLog : logListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EntryPoint (" + entryPoint + ") cannot be destroyed since the Log " + logListOrphanCheckLog + " in its logList field has a non-nullable entryPointId field.");
            }
            List<System> systemListOrphanCheck = entryPoint.getSystemList();
            for (System systemListOrphanCheckSystem : systemListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This EntryPoint (" + entryPoint + ") cannot be destroyed since the System " + systemListOrphanCheckSystem + " in its systemList field has a non-nullable entryPointId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Property> propertyList = entryPoint.getPropertyList();
            for (Property propertyListProperty : propertyList) {
                propertyListProperty.getEntryPointList().remove(entryPoint);
                propertyListProperty = em.merge(propertyListProperty);
            }
            em.remove(entryPoint);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EntryPoint> findEntryPointEntities() {
        return findEntryPointEntities(true, -1, -1);
    }

    public List<EntryPoint> findEntryPointEntities(int maxResults, int firstResult) {
        return findEntryPointEntities(false, maxResults, firstResult);
    }

    private List<EntryPoint> findEntryPointEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EntryPoint.class));
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

    public EntryPoint findEntryPoint(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EntryPoint.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntryPointCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EntryPoint> rt = cq.from(EntryPoint.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
