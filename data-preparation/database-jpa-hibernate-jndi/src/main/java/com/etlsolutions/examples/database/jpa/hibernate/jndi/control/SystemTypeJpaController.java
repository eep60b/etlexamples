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
import com.etlsolutions.examples.database.jpa.hibernate.jndi.TransformGroup;
import java.util.ArrayList;
import java.util.List;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.System;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.SystemType;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.IllegalOrphanException;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author zc
 */
public class SystemTypeJpaController implements Serializable {

    public SystemTypeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SystemType systemType) {
        if (systemType.getTransformGroupList() == null) {
            systemType.setTransformGroupList(new ArrayList<TransformGroup>());
        }
        if (systemType.getSystemList() == null) {
            systemType.setSystemList(new ArrayList<System>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<TransformGroup> attachedTransformGroupList = new ArrayList<TransformGroup>();
            for (TransformGroup transformGroupListTransformGroupToAttach : systemType.getTransformGroupList()) {
                transformGroupListTransformGroupToAttach = em.getReference(transformGroupListTransformGroupToAttach.getClass(), transformGroupListTransformGroupToAttach.getTransformGroupPK());
                attachedTransformGroupList.add(transformGroupListTransformGroupToAttach);
            }
            systemType.setTransformGroupList(attachedTransformGroupList);
            List<System> attachedSystemList = new ArrayList<System>();
            for (System systemListSystemToAttach : systemType.getSystemList()) {
                systemListSystemToAttach = em.getReference(systemListSystemToAttach.getClass(), systemListSystemToAttach.getId());
                attachedSystemList.add(systemListSystemToAttach);
            }
            systemType.setSystemList(attachedSystemList);
            em.persist(systemType);
            for (TransformGroup transformGroupListTransformGroup : systemType.getTransformGroupList()) {
                SystemType oldSystemTypeOfTransformGroupListTransformGroup = transformGroupListTransformGroup.getSystemType();
                transformGroupListTransformGroup.setSystemType(systemType);
                transformGroupListTransformGroup = em.merge(transformGroupListTransformGroup);
                if (oldSystemTypeOfTransformGroupListTransformGroup != null) {
                    oldSystemTypeOfTransformGroupListTransformGroup.getTransformGroupList().remove(transformGroupListTransformGroup);
                    oldSystemTypeOfTransformGroupListTransformGroup = em.merge(oldSystemTypeOfTransformGroupListTransformGroup);
                }
            }
            for (System systemListSystem : systemType.getSystemList()) {
                SystemType oldSystemTypeIdOfSystemListSystem = systemListSystem.getSystemTypeId();
                systemListSystem.setSystemTypeId(systemType);
                systemListSystem = em.merge(systemListSystem);
                if (oldSystemTypeIdOfSystemListSystem != null) {
                    oldSystemTypeIdOfSystemListSystem.getSystemList().remove(systemListSystem);
                    oldSystemTypeIdOfSystemListSystem = em.merge(oldSystemTypeIdOfSystemListSystem);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SystemType systemType) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SystemType persistentSystemType = em.find(SystemType.class, systemType.getId());
            List<TransformGroup> transformGroupListOld = persistentSystemType.getTransformGroupList();
            List<TransformGroup> transformGroupListNew = systemType.getTransformGroupList();
            List<System> systemListOld = persistentSystemType.getSystemList();
            List<System> systemListNew = systemType.getSystemList();
            List<String> illegalOrphanMessages = null;
            for (TransformGroup transformGroupListOldTransformGroup : transformGroupListOld) {
                if (!transformGroupListNew.contains(transformGroupListOldTransformGroup)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TransformGroup " + transformGroupListOldTransformGroup + " since its systemType field is not nullable.");
                }
            }
            for (System systemListOldSystem : systemListOld) {
                if (!systemListNew.contains(systemListOldSystem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain System " + systemListOldSystem + " since its systemTypeId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<TransformGroup> attachedTransformGroupListNew = new ArrayList<TransformGroup>();
            for (TransformGroup transformGroupListNewTransformGroupToAttach : transformGroupListNew) {
                transformGroupListNewTransformGroupToAttach = em.getReference(transformGroupListNewTransformGroupToAttach.getClass(), transformGroupListNewTransformGroupToAttach.getTransformGroupPK());
                attachedTransformGroupListNew.add(transformGroupListNewTransformGroupToAttach);
            }
            transformGroupListNew = attachedTransformGroupListNew;
            systemType.setTransformGroupList(transformGroupListNew);
            List<System> attachedSystemListNew = new ArrayList<System>();
            for (System systemListNewSystemToAttach : systemListNew) {
                systemListNewSystemToAttach = em.getReference(systemListNewSystemToAttach.getClass(), systemListNewSystemToAttach.getId());
                attachedSystemListNew.add(systemListNewSystemToAttach);
            }
            systemListNew = attachedSystemListNew;
            systemType.setSystemList(systemListNew);
            systemType = em.merge(systemType);
            for (TransformGroup transformGroupListNewTransformGroup : transformGroupListNew) {
                if (!transformGroupListOld.contains(transformGroupListNewTransformGroup)) {
                    SystemType oldSystemTypeOfTransformGroupListNewTransformGroup = transformGroupListNewTransformGroup.getSystemType();
                    transformGroupListNewTransformGroup.setSystemType(systemType);
                    transformGroupListNewTransformGroup = em.merge(transformGroupListNewTransformGroup);
                    if (oldSystemTypeOfTransformGroupListNewTransformGroup != null && !oldSystemTypeOfTransformGroupListNewTransformGroup.equals(systemType)) {
                        oldSystemTypeOfTransformGroupListNewTransformGroup.getTransformGroupList().remove(transformGroupListNewTransformGroup);
                        oldSystemTypeOfTransformGroupListNewTransformGroup = em.merge(oldSystemTypeOfTransformGroupListNewTransformGroup);
                    }
                }
            }
            for (System systemListNewSystem : systemListNew) {
                if (!systemListOld.contains(systemListNewSystem)) {
                    SystemType oldSystemTypeIdOfSystemListNewSystem = systemListNewSystem.getSystemTypeId();
                    systemListNewSystem.setSystemTypeId(systemType);
                    systemListNewSystem = em.merge(systemListNewSystem);
                    if (oldSystemTypeIdOfSystemListNewSystem != null && !oldSystemTypeIdOfSystemListNewSystem.equals(systemType)) {
                        oldSystemTypeIdOfSystemListNewSystem.getSystemList().remove(systemListNewSystem);
                        oldSystemTypeIdOfSystemListNewSystem = em.merge(oldSystemTypeIdOfSystemListNewSystem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = systemType.getId();
                if (findSystemType(id) == null) {
                    throw new NonexistentEntityException("The systemType with id " + id + " no longer exists.");
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
            SystemType systemType;
            try {
                systemType = em.getReference(SystemType.class, id);
                systemType.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The systemType with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<TransformGroup> transformGroupListOrphanCheck = systemType.getTransformGroupList();
            for (TransformGroup transformGroupListOrphanCheckTransformGroup : transformGroupListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SystemType (" + systemType + ") cannot be destroyed since the TransformGroup " + transformGroupListOrphanCheckTransformGroup + " in its transformGroupList field has a non-nullable systemType field.");
            }
            List<System> systemListOrphanCheck = systemType.getSystemList();
            for (System systemListOrphanCheckSystem : systemListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This SystemType (" + systemType + ") cannot be destroyed since the System " + systemListOrphanCheckSystem + " in its systemList field has a non-nullable systemTypeId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(systemType);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SystemType> findSystemTypeEntities() {
        return findSystemTypeEntities(true, -1, -1);
    }

    public List<SystemType> findSystemTypeEntities(int maxResults, int firstResult) {
        return findSystemTypeEntities(false, maxResults, firstResult);
    }

    private List<SystemType> findSystemTypeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SystemType.class));
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

    public SystemType findSystemType(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SystemType.class, id);
        } finally {
            em.close();
        }
    }

    public int getSystemTypeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SystemType> rt = cq.from(SystemType.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
