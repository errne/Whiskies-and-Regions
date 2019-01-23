package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findDistilleriesByRegion(String region){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Distillery.class);
        cr.add(Restrictions.eq("region", region));
        results = cr.list();
        return results;
    }

    @Transactional
    public List<Whisky> findDistilleryWithWhiskiesAged(Long id, Integer age){
        List<Whisky> results = null;

        Session session = entityManager.unwrap(Session.class);

        Criteria cr = session.createCriteria(Distillery.class);
        cr.createAlias("whiskies", "whiskyAlias");
        cr.add(Restrictions.eq("whiskyAlias.age", age));
        results = cr.list();
        return results;
    }

}
