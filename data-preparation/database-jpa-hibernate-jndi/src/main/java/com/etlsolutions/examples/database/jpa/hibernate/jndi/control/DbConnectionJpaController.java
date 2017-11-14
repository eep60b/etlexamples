/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etlsolutions.examples.database.jpa.hibernate.jndi.control;

import com.etlsolutions.examples.database.jpa.hibernate.jndi.DbConnection;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.System;
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
public class DbConnectionJpaController implements Serializable {

    public DbConnectionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DbConnection dbConnection) {
        if (dbConnection.getSystemList() == null) {
            dbConnection.setSystemList(new ArrayList<System>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<System> attachedSystemList = new ArrayList<System>();
            for (System systemListSystemToAttach : dbConnection.getSystemList()) {
                systemListSystemToAttach = em.getReference(systemListSystemToAttach.getClass(), systemListSystemToAttach.getId());
                attachedSystemList.add(systemListSystemToAttach);
            }
            dbConnection.setSystemList(attachedSystemList);
            em.persist(dbConnection);
            for (System systemListSystem : dbConnection.getSystemList()) {
                DbConnection oldDbConnectionIdOfSystemListSystem = systemListSystem.getDbConnectionId();
                systemListSystem.setDbConnectionId(dbConnection);
                systemListSystem = em.merge(systemListSystem);
                if (oldDbConnectionIdOfSystemListSystem != null) {
                    oldDbConnectionIdOfSystemListSystem.getSystemList().remove(systemListSystem);
                    oldDbConnectionIdOfSystemListSystem = em.merge(oldDbConnectionIdOfSystemListSystem);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DbConnection dbConnection) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DbConnection persistentDbConnection = em.find(DbConnection.class, dbConnection.getId());
            List<System> systemListOld = persistentDbConnection.getSystemList();
            List<System> systemListNew = dbConnection.getSystemList();
            List<String> illegalOrphanMessages = null;
            for (System systemListOldSystem : systemListOld) {
                if (!systemListNew.contains(systemListOldSystem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain System " + systemListOldSystem + " since its dbConnectionId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<System> attachedSystemListNew = new ArrayList<System>();
            for (System systemListNewSystemToAttach : systemListNew) {
                systemListNewSystemToAttach = em.getReference(systemListNewSystemToAttach.getClass(), systemListNewSystemToAttach.getId());
                attachedSystemListNew.add(systemListNewSystemToAttach);
            }
            systemListNew = attachedSystemListNew;
            dbConnection.setSystemList(systemListNew);
            dbConnection = em.merge(dbConnection);
            for (System systemListNewSystem : systemListNew) {
                if (!systemListOld.contains(systemListNewSystem)) {
                    DbConnection oldDbConnectionIdOfSystemListNewSystem = systemListNewSystem.getDbConnectionId();
                    systemListNewSystem.setDbConnectionId(dbConnection);
                    systemListNewSystem = em.merge(systemListNewSystem);
                    if (oldDbConnectionIdOfSystemListNewSystem != null && !oldDbConnectionIdOfSystemListNewSystem.equals(dbConnection)) {
                        oldDbConnectionIdOfSystemListNewSystem.getSystemList().remove(systemListNewSystem);
                        oldDbConnectionIdOfSystemListNewSystem = em.merge(oldDbConnectionIdOfSystemListNewSystem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dbConnection.getId();
                if (findDbConnection(id) == null) {
                    throw new NonexistentEntityException("The dbConnection with id " + id + " no longer exists.");
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
            DbConnection dbConnection;
            try {
                dbConnection = em.getReference(DbConnection.class, id);
                dbConnection.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dbConnection with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<System> systemListOrphanCheck = dbConnection.getSystemList();
            for (System systemListOrphanCheckSystem : systemListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This DbConnection (" + dbConnection + ") cannot be destroyed since the System " + systemListOrphanCheckSystem + " in its systemList field has a non-nullable dbConnectionId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(dbConnection);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DbConnection> findDbConnectionEntities() {
        return findDbConnectionEntities(true, -1, -1);
    }

    public List<DbConnection> findDbConnectionEntities(int maxResults, int firstResult) {
        return findDbConnectionEntities(false, maxResults, firstResult);
    }

    private List<DbConnection> findDbConnectionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DbConnection.class));
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

    public DbConnection findDbConnection(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DbConnection.class, id);
        } finally {
            em.close();
        }
    }

    public int getDbConnectionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DbConnection> rt = cq.from(DbConnection.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
