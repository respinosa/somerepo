package com.re.study.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.re.study.entity.User;

@Service
public class UserDaoServiceImpl implements UserDaoService {
	
	@PersistenceContext(unitName = "crud")
	private EntityManager entityManager;

	@Override
	public List<User> getUserList() {
		
			final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			final CriteriaQuery<User> userQuery = builder.createQuery(User.class);
			final Root<User> root = userQuery.from(User.class);
			userQuery.select(root);
			final TypedQuery<User> typedQuery = entityManager.createQuery(userQuery);
			return typedQuery.getResultList();
	
	}

}
