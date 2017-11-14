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
import com.etlsolutions.examples.database.jpa.hibernate.jndi.DateExclusions;
import java.util.ArrayList;
import java.util.List;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.DateInclusions;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Dealer;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.Schedule;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.IllegalOrphanException;
import com.etlsolutions.examples.database.jpa.hibernate.jndi.control.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author zc
 */
public class ScheduleJpaController implements Serializable {

    public ScheduleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Schedule schedule) {
        if (schedule.getDateExclusionsList() == null) {
            schedule.setDateExclusionsList(new ArrayList<DateExclusions>());
        }
        if (schedule.getDateInclusionsList() == null) {
            schedule.setDateInclusionsList(new ArrayList<DateInclusions>());
        }
        if (schedule.getDealerList() == null) {
            schedule.setDealerList(new ArrayList<Dealer>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<DateExclusions> attachedDateExclusionsList = new ArrayList<DateExclusions>();
            for (DateExclusions dateExclusionsListDateExclusionsToAttach : schedule.getDateExclusionsList()) {
                dateExclusionsListDateExclusionsToAttach = em.getReference(dateExclusionsListDateExclusionsToAttach.getClass(), dateExclusionsListDateExclusionsToAttach.getDateExclusionsPK());
                attachedDateExclusionsList.add(dateExclusionsListDateExclusionsToAttach);
            }
            schedule.setDateExclusionsList(attachedDateExclusionsList);
            List<DateInclusions> attachedDateInclusionsList = new ArrayList<DateInclusions>();
            for (DateInclusions dateInclusionsListDateInclusionsToAttach : schedule.getDateInclusionsList()) {
                dateInclusionsListDateInclusionsToAttach = em.getReference(dateInclusionsListDateInclusionsToAttach.getClass(), dateInclusionsListDateInclusionsToAttach.getDateInclusionsPK());
                attachedDateInclusionsList.add(dateInclusionsListDateInclusionsToAttach);
            }
            schedule.setDateInclusionsList(attachedDateInclusionsList);
            List<Dealer> attachedDealerList = new ArrayList<Dealer>();
            for (Dealer dealerListDealerToAttach : schedule.getDealerList()) {
                dealerListDealerToAttach = em.getReference(dealerListDealerToAttach.getClass(), dealerListDealerToAttach.getEtlId());
                attachedDealerList.add(dealerListDealerToAttach);
            }
            schedule.setDealerList(attachedDealerList);
            em.persist(schedule);
            for (DateExclusions dateExclusionsListDateExclusions : schedule.getDateExclusionsList()) {
                Schedule oldScheduleOfDateExclusionsListDateExclusions = dateExclusionsListDateExclusions.getSchedule();
                dateExclusionsListDateExclusions.setSchedule(schedule);
                dateExclusionsListDateExclusions = em.merge(dateExclusionsListDateExclusions);
                if (oldScheduleOfDateExclusionsListDateExclusions != null) {
                    oldScheduleOfDateExclusionsListDateExclusions.getDateExclusionsList().remove(dateExclusionsListDateExclusions);
                    oldScheduleOfDateExclusionsListDateExclusions = em.merge(oldScheduleOfDateExclusionsListDateExclusions);
                }
            }
            for (DateInclusions dateInclusionsListDateInclusions : schedule.getDateInclusionsList()) {
                Schedule oldScheduleOfDateInclusionsListDateInclusions = dateInclusionsListDateInclusions.getSchedule();
                dateInclusionsListDateInclusions.setSchedule(schedule);
                dateInclusionsListDateInclusions = em.merge(dateInclusionsListDateInclusions);
                if (oldScheduleOfDateInclusionsListDateInclusions != null) {
                    oldScheduleOfDateInclusionsListDateInclusions.getDateInclusionsList().remove(dateInclusionsListDateInclusions);
                    oldScheduleOfDateInclusionsListDateInclusions = em.merge(oldScheduleOfDateInclusionsListDateInclusions);
                }
            }
            for (Dealer dealerListDealer : schedule.getDealerList()) {
                Schedule oldScheduleIdOfDealerListDealer = dealerListDealer.getScheduleId();
                dealerListDealer.setScheduleId(schedule);
                dealerListDealer = em.merge(dealerListDealer);
                if (oldScheduleIdOfDealerListDealer != null) {
                    oldScheduleIdOfDealerListDealer.getDealerList().remove(dealerListDealer);
                    oldScheduleIdOfDealerListDealer = em.merge(oldScheduleIdOfDealerListDealer);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Schedule schedule) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Schedule persistentSchedule = em.find(Schedule.class, schedule.getId());
            List<DateExclusions> dateExclusionsListOld = persistentSchedule.getDateExclusionsList();
            List<DateExclusions> dateExclusionsListNew = schedule.getDateExclusionsList();
            List<DateInclusions> dateInclusionsListOld = persistentSchedule.getDateInclusionsList();
            List<DateInclusions> dateInclusionsListNew = schedule.getDateInclusionsList();
            List<Dealer> dealerListOld = persistentSchedule.getDealerList();
            List<Dealer> dealerListNew = schedule.getDealerList();
            List<String> illegalOrphanMessages = null;
            for (DateExclusions dateExclusionsListOldDateExclusions : dateExclusionsListOld) {
                if (!dateExclusionsListNew.contains(dateExclusionsListOldDateExclusions)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DateExclusions " + dateExclusionsListOldDateExclusions + " since its schedule field is not nullable.");
                }
            }
            for (DateInclusions dateInclusionsListOldDateInclusions : dateInclusionsListOld) {
                if (!dateInclusionsListNew.contains(dateInclusionsListOldDateInclusions)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DateInclusions " + dateInclusionsListOldDateInclusions + " since its schedule field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<DateExclusions> attachedDateExclusionsListNew = new ArrayList<DateExclusions>();
            for (DateExclusions dateExclusionsListNewDateExclusionsToAttach : dateExclusionsListNew) {
                dateExclusionsListNewDateExclusionsToAttach = em.getReference(dateExclusionsListNewDateExclusionsToAttach.getClass(), dateExclusionsListNewDateExclusionsToAttach.getDateExclusionsPK());
                attachedDateExclusionsListNew.add(dateExclusionsListNewDateExclusionsToAttach);
            }
            dateExclusionsListNew = attachedDateExclusionsListNew;
            schedule.setDateExclusionsList(dateExclusionsListNew);
            List<DateInclusions> attachedDateInclusionsListNew = new ArrayList<DateInclusions>();
            for (DateInclusions dateInclusionsListNewDateInclusionsToAttach : dateInclusionsListNew) {
                dateInclusionsListNewDateInclusionsToAttach = em.getReference(dateInclusionsListNewDateInclusionsToAttach.getClass(), dateInclusionsListNewDateInclusionsToAttach.getDateInclusionsPK());
                attachedDateInclusionsListNew.add(dateInclusionsListNewDateInclusionsToAttach);
            }
            dateInclusionsListNew = attachedDateInclusionsListNew;
            schedule.setDateInclusionsList(dateInclusionsListNew);
            List<Dealer> attachedDealerListNew = new ArrayList<Dealer>();
            for (Dealer dealerListNewDealerToAttach : dealerListNew) {
                dealerListNewDealerToAttach = em.getReference(dealerListNewDealerToAttach.getClass(), dealerListNewDealerToAttach.getEtlId());
                attachedDealerListNew.add(dealerListNewDealerToAttach);
            }
            dealerListNew = attachedDealerListNew;
            schedule.setDealerList(dealerListNew);
            schedule = em.merge(schedule);
            for (DateExclusions dateExclusionsListNewDateExclusions : dateExclusionsListNew) {
                if (!dateExclusionsListOld.contains(dateExclusionsListNewDateExclusions)) {
                    Schedule oldScheduleOfDateExclusionsListNewDateExclusions = dateExclusionsListNewDateExclusions.getSchedule();
                    dateExclusionsListNewDateExclusions.setSchedule(schedule);
                    dateExclusionsListNewDateExclusions = em.merge(dateExclusionsListNewDateExclusions);
                    if (oldScheduleOfDateExclusionsListNewDateExclusions != null && !oldScheduleOfDateExclusionsListNewDateExclusions.equals(schedule)) {
                        oldScheduleOfDateExclusionsListNewDateExclusions.getDateExclusionsList().remove(dateExclusionsListNewDateExclusions);
                        oldScheduleOfDateExclusionsListNewDateExclusions = em.merge(oldScheduleOfDateExclusionsListNewDateExclusions);
                    }
                }
            }
            for (DateInclusions dateInclusionsListNewDateInclusions : dateInclusionsListNew) {
                if (!dateInclusionsListOld.contains(dateInclusionsListNewDateInclusions)) {
                    Schedule oldScheduleOfDateInclusionsListNewDateInclusions = dateInclusionsListNewDateInclusions.getSchedule();
                    dateInclusionsListNewDateInclusions.setSchedule(schedule);
                    dateInclusionsListNewDateInclusions = em.merge(dateInclusionsListNewDateInclusions);
                    if (oldScheduleOfDateInclusionsListNewDateInclusions != null && !oldScheduleOfDateInclusionsListNewDateInclusions.equals(schedule)) {
                        oldScheduleOfDateInclusionsListNewDateInclusions.getDateInclusionsList().remove(dateInclusionsListNewDateInclusions);
                        oldScheduleOfDateInclusionsListNewDateInclusions = em.merge(oldScheduleOfDateInclusionsListNewDateInclusions);
                    }
                }
            }
            for (Dealer dealerListOldDealer : dealerListOld) {
                if (!dealerListNew.contains(dealerListOldDealer)) {
                    dealerListOldDealer.setScheduleId(null);
                    dealerListOldDealer = em.merge(dealerListOldDealer);
                }
            }
            for (Dealer dealerListNewDealer : dealerListNew) {
                if (!dealerListOld.contains(dealerListNewDealer)) {
                    Schedule oldScheduleIdOfDealerListNewDealer = dealerListNewDealer.getScheduleId();
                    dealerListNewDealer.setScheduleId(schedule);
                    dealerListNewDealer = em.merge(dealerListNewDealer);
                    if (oldScheduleIdOfDealerListNewDealer != null && !oldScheduleIdOfDealerListNewDealer.equals(schedule)) {
                        oldScheduleIdOfDealerListNewDealer.getDealerList().remove(dealerListNewDealer);
                        oldScheduleIdOfDealerListNewDealer = em.merge(oldScheduleIdOfDealerListNewDealer);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = schedule.getId();
                if (findSchedule(id) == null) {
                    throw new NonexistentEntityException("The schedule with id " + id + " no longer exists.");
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
            Schedule schedule;
            try {
                schedule = em.getReference(Schedule.class, id);
                schedule.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The schedule with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DateExclusions> dateExclusionsListOrphanCheck = schedule.getDateExclusionsList();
            for (DateExclusions dateExclusionsListOrphanCheckDateExclusions : dateExclusionsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Schedule (" + schedule + ") cannot be destroyed since the DateExclusions " + dateExclusionsListOrphanCheckDateExclusions + " in its dateExclusionsList field has a non-nullable schedule field.");
            }
            List<DateInclusions> dateInclusionsListOrphanCheck = schedule.getDateInclusionsList();
            for (DateInclusions dateInclusionsListOrphanCheckDateInclusions : dateInclusionsListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Schedule (" + schedule + ") cannot be destroyed since the DateInclusions " + dateInclusionsListOrphanCheckDateInclusions + " in its dateInclusionsList field has a non-nullable schedule field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Dealer> dealerList = schedule.getDealerList();
            for (Dealer dealerListDealer : dealerList) {
                dealerListDealer.setScheduleId(null);
                dealerListDealer = em.merge(dealerListDealer);
            }
            em.remove(schedule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Schedule> findScheduleEntities() {
        return findScheduleEntities(true, -1, -1);
    }

    public List<Schedule> findScheduleEntities(int maxResults, int firstResult) {
        return findScheduleEntities(false, maxResults, firstResult);
    }

    private List<Schedule> findScheduleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Schedule.class));
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

    public Schedule findSchedule(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Schedule.class, id);
        } finally {
            em.close();
        }
    }

    public int getScheduleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Schedule> rt = cq.from(Schedule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
